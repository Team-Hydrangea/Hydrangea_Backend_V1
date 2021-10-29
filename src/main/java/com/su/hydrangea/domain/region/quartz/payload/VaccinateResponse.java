package com.su.hydrangea.domain.region.quartz.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

public class VaccinateResponse {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @XmlRootElement(name = "response")
    public static class VaccinateInformation {

        @XmlElement(name = "body")
        private Body body;

    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Body {

        @XmlElementWrapper
        @XmlElement(name = "item")
        private List<Item> items;

    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Item {

        @XmlElement(name = "sidoNm")
        private String sidoNm;

        @XmlElement(name = "firstTot")
        private Integer firstTot;

    }

}
