package com.su.hydrangea.domain.place.batch.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class PlaceResponse {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PlaceInformation {

        private Body body;

        private Header header;

    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Header {

        private Integer resultCode;

        private Integer resultMsg;

    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Body {

        private List<Item> items;

        private Integer numOfRows;

        private Integer totalCount;

        private Integer pageNo;

    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Item {

        private Integer areacode;

        private Integer contentid;

        private Integer contenttypeid;

        private Integer mlevel;

        private Integer readcount;

        private Integer sigungucode;

        private String title;

        @DateTimeFormat(pattern = "yyyyMMddhhmmSS")
        private LocalDateTime createdtime;

        @DateTimeFormat(pattern = "yyyyMMddhhmmSS")
        private LocalDateTime modifiedtime;

        private String firstimage;

        private String firstimage2;

        private BigDecimal mapX;

        private BigDecimal mapY;

        private String cat1;

        private String cat2;

        private String cat3;

        private String addr1;

        private String addr2;

        private String tel;

        private Integer booktour;

        private Integer zipcode;

    }

}
