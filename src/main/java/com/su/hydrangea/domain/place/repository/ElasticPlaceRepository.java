package com.su.hydrangea.domain.place.repository;

import com.su.hydrangea.domain.place.entity.Place;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ElasticPlaceRepository extends ElasticsearchRepository<Place, String> {

    List<Place> findByLocationLatBetweenAndLocationLon(double lat1, double lat2, double lon1, double lon2);

}
