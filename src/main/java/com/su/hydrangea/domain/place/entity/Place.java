package com.su.hydrangea.domain.place.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Id;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "place")
public class Place {

    @Id
    private String id;

    private String title;

    private String number;

    private String image;

    private double latitude;

    private double longitude;

}