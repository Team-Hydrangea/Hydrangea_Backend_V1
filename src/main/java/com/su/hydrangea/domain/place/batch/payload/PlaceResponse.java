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

        @XmlElementWrapper(name = "items")
        @XmlElement(name = "item")
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

        @XmlElement
        private String firstimage;

        @XmlElement
        private Double mapx;

        @XmlElement
        private Double mapy;

        @XmlElement
        private String tel;

    }

}
