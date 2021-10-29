package com.su.hydrangea.domain.event.repository;

import com.su.hydrangea.domain.event.entity.Event;
import com.su.hydrangea.domain.place.entity.Place;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EventRepository extends ElasticsearchRepository<Event, String> {

    List<Event> findByLocationLatBetweenAndLocationLon(double lat1, double lat2, double lon1, double lon2);

}
