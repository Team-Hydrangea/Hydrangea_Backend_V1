package com.su.hydrangea.domain.region.entity;

import com.su.hydrangea.domain.region.entity.id.RegionInfoId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RegionInfo {

    @EmbeddedId
    private RegionInfoId id;

    @Column(name = "confirm_case_count")
    private long confirmCaseCount;

    @Column(name = "vaccinate_case_count")
    private long vaccinateCaseCount;

    private long population;

    @ManyToOne
    @MapsId("code")
    @JoinColumn(name = "region_code_code")
    private RegionCode regionCode;

}
