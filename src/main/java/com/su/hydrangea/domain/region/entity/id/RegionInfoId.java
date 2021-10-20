package com.su.hydrangea.domain.region.entity.id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class RegionInfoId implements Serializable {

    private LocalDate date;

    private int code;

}
