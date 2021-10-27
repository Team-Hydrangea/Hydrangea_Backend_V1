package com.su.hydrangea.domain.region.quartz.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

public class VaccinateResponse {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class VaccinateInformation {

        private Body body;

    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Body {

        @DateTimeFormat(pattern = "yyyy.MM.dd hh:MM:ss")
        private LocalDateTime dateTime;

        private List<Item> items;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Item {

        private String sidoNm;

        private Integer firstCnt;

        private Integer firstTot;

        private Integer secondCnt;

        private Integer secondTot;

        private Integer thirdCnt;

        private Integer thirdTot;

    }

}
