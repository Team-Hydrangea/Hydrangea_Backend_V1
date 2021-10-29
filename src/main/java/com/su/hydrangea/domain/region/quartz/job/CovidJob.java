package com.su.hydrangea.domain.region.quartz.job;

import com.su.hydrangea.domain.region.entity.RegionInfo;
import com.su.hydrangea.domain.region.outbound.PopulationClient;
import com.su.hydrangea.domain.region.outbound.RegionCovidClient;
import com.su.hydrangea.domain.region.outbound.VaccinateCovidClient;
import com.su.hydrangea.domain.region.quartz.payload.CovidResponse;
import com.su.hydrangea.domain.region.quartz.payload.PopulationResponse;
import com.su.hydrangea.domain.region.quartz.payload.VaccinateResponse;
import com.su.hydrangea.domain.region.repository.RegionInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CovidJob {

    private static final Integer NUM_OF_ROWS = 10000;
    private static final String TOTAL_NAME = "합계";
    private static final String FOREIGN_NAME = "검역";

    private final RegionCovidClient regionCovidClient;
    private final VaccinateCovidClient vaccinateCovidClient;
    private final RegionInfoRepository regionInfoRepository;
    private final PopulationClient populationClient;

    @Value("${openapi.secret}")
    private String secretKey;

    @Scheduled(cron = "0 0 3 * * ?")
    public void execute() {
        regionInfoRepository.deleteAll();
        LocalDate now = LocalDate.now().minusDays(1);
        var vaccinateResponse = vaccinateCovidClient.getCovidResponse();
        var covidResponse = regionCovidClient.getCovidCount(secretKey, NUM_OF_ROWS, now, now);
        var populationResponse = populationClient.getPopulation();

        List<RegionInfo> regionInfos = new ArrayList<>();

        for (CovidResponse.Item item : covidResponse.getBody().getItems()) {

            if (isForeignOrTotal(item.getGubun())) {
                continue;
            }
            Long population = getPopulation(populationResponse, item.getGubun());
            RegionInfo regionInfo = buildRegion(item, getVaccinateCaseCount(vaccinateResponse, item.getGubun()), population);
            regionInfos.add(regionInfo);

        }

        regionInfoRepository.saveAll(regionInfos);

    }

    private RegionInfo buildRegion(CovidResponse.Item item, Integer vaccinateCount, Long population) {
        return RegionInfo.builder()
                .name(convertToFull(item.getGubun()))
                .confirmCaseCount(item.getDefCnt())
                .vaccinateCaseCount(vaccinateCount)
                .deadCaseCount(item.getDeathCnt())
                .population(population)
                .build();
    }

    private boolean isForeignOrTotal(String gubun) {
        return gubun.equals(FOREIGN_NAME) || gubun.equals(TOTAL_NAME);
    }

    private Integer getVaccinateCaseCount(VaccinateResponse.VaccinateInformation information, String gubun) {
        return information.getBody().getItems().stream()
                .filter(item -> convertToFull(gubun).equals(item.getCityName()))
                .findFirst().get()
                .getFirstTot();
    }

    private Long getPopulation(PopulationResponse.PopulationInformation information, String gubun) {
        return information.getInformationList().stream()
                .filter(item -> convertToFull(gubun).equals(item.getCityName()))
                .findFirst().get()
                .getPopulation();
    }

    private String convertToFull(String gubun) {
        return switch (gubun) {
            case "경남" -> "경상남도";
            case "경북" -> "경상북도";
            case "충북" -> "충청북도";
            case "충남" -> "충청남도";
            case "전북" -> "전라북도";
            case "전남" -> "전라남도";
            case "서울" -> "서울특별시";
            case "대전" -> "대전광역시";
            case "부산" -> "부산광역시";
            case "세종" -> "세종특별자치시";
            case "울산" -> "울산광역시";
            case "대구" -> "대구광역시";
            case "인천" -> "인천광역시";
            case "경기" -> "경기도";
            case "강원" -> "강원도";
            case "제주" -> "제주특별자치도";
            case "광주" -> "광주광역시";
        };
    }

}
