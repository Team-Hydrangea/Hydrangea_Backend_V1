package com.su.hydrangea.domain.region.quartz.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

public class CovidResponse {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CovidInformation {
        private Body body;

        private Head head;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Body {

        private List<Item> items;

        private Integer numOfRows;

        private Integer pageNo;

        private Integer totalCount;

    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Head {

        private int resultCode;

        private String resultMsg;

    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Item {

        @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:SS")
        private LocalDateTime createDt;

        @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:SS")
        private LocalDateTime updateDt;

        private Integer deathCnt;

        private Integer defCnt;

        private String gubun;

        private String gubunCn;

        private String gubunEn;

        private Integer incDec;

        private Integer isolClearCnt;

        private Integer localOccCnt;

        private Integer overFlowCnt;

        private Integer qurRate;

        private Integer seq;

        private String stdDay;

    }

}
