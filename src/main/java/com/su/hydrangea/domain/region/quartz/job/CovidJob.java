package com.su.hydrangea.domain.region.quartz.job;

import com.su.hydrangea.domain.region.entity.RegionInfo;
import com.su.hydrangea.domain.region.entity.RegionInfoRepository;
import com.su.hydrangea.domain.region.entity.id.RegionInfoId;
import com.su.hydrangea.domain.region.quartz.outbound.RegionCovidInformation;
import com.su.hydrangea.domain.region.quartz.outbound.VaccinateCovidInformation;
import com.su.hydrangea.domain.region.quartz.payload.CovidResponse;
import com.su.hydrangea.domain.region.quartz.payload.VaccinateResponse;
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

    private final RegionCovidInformation regionCovidInformation;
    private final VaccinateCovidInformation vaccinateCovidInformation;
    private final RegionInfoRepository regionInfoRepository;

    @Value("${openapi.secret}")
    private String secretKey;

    @Override
    public void execute(JobExecutionContext context) {
        LocalDate now = LocalDate.now();
        var response = regionCovidInformation.getCovidCount(secretKey, NUM_OF_ROWS, now, now);

        List<RegionInfo> regionInfos = new ArrayList<>();

        for (CovidResponse.Item item : response.getBody().getItems()) {

            if (isForeignOrTotal(item.getGubun())) {
                continue;
            }

            var vaccinateResponse = vaccinateCovidInformation.getCovidResponse();
            RegionInfo regionInfo = buildRegion(item, getVaccinateCaseCount(vaccinateResponse, item.getGubun()));
            regionInfos.add(regionInfo);

        }

        regionInfoRepository.saveAll(regionInfos);

    }

    private RegionInfo buildRegion(CovidResponse.Item item, Integer vaccinateCount) {
        RegionInfoId id = new RegionInfoId(item.getUpdateDt().toLocalDate(), item.getGubun());

        return RegionInfo.builder()
                .id(id)
                .confirmCaseCount(item.getDefCnt())
                .vaccinateCaseCount(vaccinateCount)
                .deadCaseCount(item.getDeathCnt())
                .population(item.getQurRate())
                .build();
    }

    private boolean isForeignOrTotal(String gubun) {
        return gubun.equals(FOREIGN_NAME) || gubun.equals(TOTAL_NAME);
    }

    private Integer getVaccinateCaseCount(VaccinateResponse.VaccinateInformation information, String gubun) {
        return information.getBody().getItems().stream()
                .filter(item -> item.getSidoNm().startsWith(gubun))
                .findFirst().get()
                .getFirstTot();
    }

}
