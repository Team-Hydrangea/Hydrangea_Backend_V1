package com.su.hydrangea.domain.place.batch.job;

import com.su.hydrangea.domain.place.batch.payload.PlaceResponse;
import com.su.hydrangea.domain.place.entity.Place;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Configuration
@StepScope
public class PlaceProcessor implements ItemProcessor<PlaceResponse.PlaceInformation, List<Place>> {

    @Override
    public List<Place> process(PlaceResponse.PlaceInformation information) throws Exception {
        return information.getBody()
                .getItems().stream()
                .map(item -> Place.builder()
                        .id(UUID.randomUUID().toString())
                        .latitude(item.getMapY().doubleValue())
                        .longitude(item.getMapX().doubleValue())
                        .title(item.getTitle())
                        .createdAt(item.getCreatedtime())
                        .image(item.getFirstimage())
                        .number(item.getTel())
                        .build())
                .collect(Collectors.toList());
    }

}
