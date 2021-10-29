package com.su.hydrangea.domain.region.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RegionInfo {

    @Id
    private String name;

    @Column(name = "confirm_case_count")
    private long confirmCaseCount;

    @Column(name = "dead_case_count")
    private long deadCaseCount;

    @Column(name = "vaccinate_case_count")
    private long vaccinateCaseCount;

    private long population;

}
