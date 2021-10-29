package com.su.hydrangea.domain.event.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "event")
public class Event {

    private String id;

    private double latitude;

    private double longitude;

    private String image;

    private String name;

    private LocalDate startDate;

    private LocalDate endDate;

}
