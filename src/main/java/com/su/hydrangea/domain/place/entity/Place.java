package com.su.hydrangea.domain.place.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "place")
@Entity
public class Place {

    @Id
    private long id;

    @Column(nullable = false)
    private String name;

    private double latitude;

    private double longtitude;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String address;

}
