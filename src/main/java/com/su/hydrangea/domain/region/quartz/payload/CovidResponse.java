package com.su.hydrangea.domain.region.quartz.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

public class CovidResponse {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @XmlRootElement(name = "response")
    public static class CovidInformation {
        @XmlElement(name = "body")
        private Body body;

    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @XmlRootElement(name = "body")
    public static class Body {

        @XmlElementWrapper
        @XmlElement(name = "item")
        private List<Item> items;

        private Integer pageNo;

    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @XmlRootElement(name = "item")
    public static class Item {

        @XmlElement(name = "updateDt")
        private String updateDt;

        @XmlElement(name = "createDt")
        private String createDt;

        @XmlElement(name = "deathCnt")
        private Integer deathCnt;

        @XmlElement(name = "defCnt")
        private Integer defCnt;

        @XmlElement(name = "gubun")
        private String gubun;

    }

}
