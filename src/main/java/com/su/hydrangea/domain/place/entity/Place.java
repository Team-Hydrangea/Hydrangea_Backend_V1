package com.su.hydrangea.domain.place.entity;

import com.su.hydrangea.domain.place.entity.id.PlaceId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Place {

    @EmbeddedId
    private PlaceId id;

    @Field
    private String name;

    @Column(nullable = false)
    private String number;

    @Column(nullable = false)
    private String address;

    private String image;

}
