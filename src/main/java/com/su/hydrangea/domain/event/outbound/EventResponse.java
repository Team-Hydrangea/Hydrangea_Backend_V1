package com.su.hydrangea.domain.event.outbound;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.List;

public class EventResponse {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @XmlRootElement(name = "response")
    public static class EventInfo {
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

    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Item {

        @XmlElement(name = "mapx")
        private Double longitude;

        @XmlElement(name = "mapy")
        private Double latitude;

        @XmlElement(name = "title")
        private String name;

        @XmlElement(name = "firstimage")
        private String image;

        @XmlElement(name = "eventenddate")
        private String endDate;

        @XmlElement(name = "eventstartdate")
        private String startDate;

    }
}
