package com.su.hydrangea.domain.event.entity.id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class EventId implements Serializable {

    private double latitude;

    private double longitude;

    private String name;

}
