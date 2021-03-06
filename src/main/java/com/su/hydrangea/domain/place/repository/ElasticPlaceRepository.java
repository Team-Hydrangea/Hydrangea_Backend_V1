package com.su.hydrangea.domain.place.repository;

import com.su.hydrangea.domain.place.entity.Place;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.Optional;

public interface ElasticPlaceRepository extends ElasticsearchRepository<Place, String> {

    List<Place> findByLatitudeBetweenAndLongitudeBetween(double latitude, double latitude2, double longitude, double longitude2);
    Page<Place> findByTitleContaining(String title, Pageable pageable);
    Optional<Place> findByLongitudeAndLatitude(double longitude, double latitude);

}
