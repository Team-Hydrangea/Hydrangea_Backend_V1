package com.su.hydrangea.domain.place.entity;

import com.su.hydrangea.domain.place.entity.id.PlaceId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;

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

    private String image;
}
