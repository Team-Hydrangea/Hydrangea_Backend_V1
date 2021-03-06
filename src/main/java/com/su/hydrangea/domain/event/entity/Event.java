package com.su.hydrangea.domain.event.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "event")
public class Event {

    private String id;

    private Double latitude;

    private Double longitude;

    private String image;

    private String name;

    private String startDate;

    private String endDate;

    private String address;

    private String detailAddress;

}
