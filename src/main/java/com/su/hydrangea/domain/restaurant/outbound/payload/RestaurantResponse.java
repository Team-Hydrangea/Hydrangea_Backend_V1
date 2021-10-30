package com.su.hydrangea.domain.restaurant.outbound.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

public class RestaurantResponse {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @XmlRootElement(name = "SafetyRestrntInfo")
    public static class RestaurantInformation {

        @XmlElement(name = "row")
        private List<Row> row;

    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Row {

        @XmlElement(name = "REFINE_WGS84_LOGT")
        private Double longitude;

        @XmlElement(name = "REFINE_WGS84_LAT")
        private Double latitude;

        @XmlElement(name = "BIZPLC_NM")
        private String name;

        @XmlElement(name = "TELNO")
        private String number;

    }


}
