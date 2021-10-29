package com.su.hydrangea.domain.event.repository;

import com.su.hydrangea.domain.event.entity.Event;
import com.su.hydrangea.domain.place.entity.Place;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EventRepository extends ElasticsearchRepository<Event, String> {

    Page<Event> findByLatitudeBetweenAndLongitudeBetween(double latitude, double latitude2, double longitude, double longitude2, Pageable pageable);

}
