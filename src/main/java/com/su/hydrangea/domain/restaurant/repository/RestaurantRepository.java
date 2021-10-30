package com.su.hydrangea.domain.restaurant.repository;

import com.su.hydrangea.domain.restaurant.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface RestaurantRepository extends ElasticsearchRepository<Restaurant, String> {

    Page<Restaurant> findByLatitudeBetweenAndLongitudeBetween(double latitude, double latitude2, double longitude, double longitude2, Pageable pageable);

}
