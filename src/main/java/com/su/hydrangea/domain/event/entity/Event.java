package com.su.hydrangea.domain.event.entity;

import com.su.hydrangea.domain.event.entity.id.EventId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Event {

    @EmbeddedId
    private EventId id;

    @Column(nullable = false)
    private String image;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

}
