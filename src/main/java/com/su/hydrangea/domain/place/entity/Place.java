package com.su.hydrangea.domain.place.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "place")
public class Place {

    @Id
    private long id;

    @Column(nullable = false)
    private String name;

    private double latitude;

    private double longitude;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String address;

}
