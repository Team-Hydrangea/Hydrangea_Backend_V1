package com.su.hydrangea.domain.user.entity;

import com.su.hydrangea.domain.place.entity.Place;
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
public class StarScore {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "place_latitude", nullable = false),
            @JoinColumn(name = "place_longtitude", nullable = false)
    })
    private Place place;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
