package com.su.hydrangea.domain.place.batch.job;

import com.su.hydrangea.domain.place.repository.ElasticPlaceRepository;
import com.su.hydrangea.domain.place.entity.Place;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@RequiredArgsConstructor
@StepScope
public class PlaceWriter implements ItemWriter<List<Place>> {

    private final ElasticPlaceRepository repository;

    @Override
    public void write(List<? extends List<Place>> items) throws Exception {
        items.forEach(repository::saveAll);
    }
}
