package com.su.hydrangea.domain.restaurant.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "restaurant")
public class Restaurant {

    @Id
    private String id;

    private String name;

    private double latitude;

    private double longitude;

    private String number;

}
