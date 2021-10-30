package com.su.hydrangea.domain.place.batch.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDateTime;
import java.util.List;

public class PlaceResponse {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @XmlRootElement(name = "response")
    public static class PlaceInformation {

        @XmlElement
        private Body body;

    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Body {

        @XmlElementWrapper
        @XmlElement
        private List<Item> items;

        @XmlElement
        private Integer pageNo;

    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Item {

        @XmlElement
        private String title;

        @DateTimeFormat(pattern = "yyyyMMddhhmmss")
        private LocalDateTime createdtime;

        @DateTimeFormat(pattern = "yyyyMMddhhmms")
        private LocalDateTime modifiedtime;

        @XmlElement
        private String firstimage;

        @XmlElement
        private Double mapX;

        @XmlElement
        private Double mapY;

        @XmlElement
        private String addr1;

        @XmlElement
        private String addr2;

        @XmlElement
        private String tel;

    }

}
