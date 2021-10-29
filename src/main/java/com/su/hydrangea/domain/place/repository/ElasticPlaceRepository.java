package com.su.hydrangea.domain.place.repository;

import com.su.hydrangea.domain.place.entity.Place;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ElasticPlaceRepository extends ElasticsearchRepository<Place, String> {

    List<Place> findByLatitudeBetweenAndLongitudeBetween(double latitude, double latitude2, double longitude, double longitude2);
    List<Place> findByTitleContaining(String title);

}
