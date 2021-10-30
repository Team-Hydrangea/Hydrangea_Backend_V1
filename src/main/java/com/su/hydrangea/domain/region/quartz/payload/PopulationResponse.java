package com.su.hydrangea.domain.region.quartz.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public class PopulationResponse {

    @Getter
    @AllArgsConstructor
    public static class PopulationInformation {
        private List<CityPopulationInformation> informationList;
    }

    @Getter
    @AllArgsConstructor
    public static class CityPopulationInformation {

        private String cityName;

        private Long population;

    }

}
