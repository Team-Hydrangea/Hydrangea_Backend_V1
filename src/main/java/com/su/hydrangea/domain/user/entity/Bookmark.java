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
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"id", "longitude", "latitude"})
})
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Double longitude;

    private Double latitude;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
