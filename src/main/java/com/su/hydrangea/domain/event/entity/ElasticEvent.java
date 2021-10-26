package com.su.hydrangea.domain.event.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "event")
public class ElasticEvent {

    private String id;

    @GeoPointField
    private GeoPoint location;

    private String image;

    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

}
