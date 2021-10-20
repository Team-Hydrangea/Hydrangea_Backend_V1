package com.su.hydrangea.domain.region.entity;

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
@Table(name = "region_code")
@Entity
public class RegionCode {

    @Id
    private int code;

    @Column(nullable = false)
    private String name;

}
