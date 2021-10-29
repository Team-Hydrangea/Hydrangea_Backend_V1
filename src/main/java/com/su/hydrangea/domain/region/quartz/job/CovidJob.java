package com.su.hydrangea.domain.region.quartz.job;

import com.su.hydrangea.domain.region.entity.RegionInfo;
import com.su.hydrangea.domain.region.entity.id.RegionInfoId;
import com.su.hydrangea.domain.region.outbound.RegionCovidClient;
import com.su.hydrangea.domain.region.outbound.VaccinateCovidClient;
import com.su.hydrangea.domain.region.quartz.payload.CovidResponse;
import com.su.hydrangea.domain.region.quartz.payload.VaccinateResponse;
import com.su.hydrangea.domain.region.repository.RegionInfoRepository;
import lombok.RequiredArgsConstructor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CovidJob implements Job {

    private static final Integer NUM_OF_ROWS = 10000;
    private static final String TOTAL_NAME = "합계";
    private static final String FOREIGN_NAME = "검역";

    private final RegionCovidClient regionCovidClient;
    private final VaccinateCovidClient vaccinateCovidClient;
    private final RegionInfoRepository regionInfoRepository;

    @Value("${openapi.secret}")
    private String secretKey;

    @Override
    public void execute(JobExecutionContext context) {
        LocalDate now = LocalDate.now();
        var vaccinateResponse = vaccinateCovidClient.getCovidResponse();
        var response = regionCovidClient.getCovidCount(secretKey, NUM_OF_ROWS, now, now);

        List<RegionInfo> regionInfos = new ArrayList<>();

        for (CovidResponse.Item item : response.getBody().getItems()) {

            if (isForeignOrTotal(item.getGubun())) {
                continue;
            }

            RegionInfo regionInfo = buildRegion(item, getVaccinateCaseCount(vaccinateResponse, item.getGubun()));
            regionInfos.add(regionInfo);

        }

        regionInfoRepository.saveAll(regionInfos);

    }

    private RegionInfo buildRegion(CovidResponse.Item item, Integer vaccinateCount) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String date = item.getUpdateDt().equals("null") ? item.getCreateDt().substring(0, 10) : item.getUpdateDt().substring(0, 10);
        LocalDate updateDt = LocalDate.parse(date, formatter);

        RegionInfoId id = new RegionInfoId(updateDt, item.getGubun());

        return RegionInfo.builder()
                .id(id)
                .confirmCaseCount(item.getDefCnt())
                .vaccinateCaseCount(vaccinateCount)
                .deadCaseCount(item.getDeathCnt())
                .population(10)
                .build();
    }

    private boolean isForeignOrTotal(String gubun) {
        return gubun.equals(FOREIGN_NAME) || gubun.equals(TOTAL_NAME);
    }

    private Integer getVaccinateCaseCount(VaccinateResponse.VaccinateInformation information, String gubun) {
        return information.getBody().getItems().stream()
                .filter(item -> sidoIsSame(gubun, item.getSidoNm()))
                .findFirst().get()
                .getFirstTot();
    }

    private boolean sidoIsSame(String gubun, String sido) {
        return switch (gubun) {
            case "경남" -> sido.equals("경상남도");
            case "경북" -> sido.equals("경상북도");
            case "충북" -> sido.equals("충청북도");
            case "충남" -> sido.equals("충청남도");
            case "전북" -> sido.equals("전라북도");
            case "전남" -> sido.equals("전라남도");
            default -> sido.startsWith(gubun);
        };
    }

}
