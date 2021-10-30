package com.su.hydrangea.domain.restaurant.repository;

import com.su.hydrangea.domain.restaurant.entity.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface RestaurantRepository extends ElasticsearchRepository<Restaurant, String> {

    List<Restaurant> findByLatitudeBetweenAndLongitudeBetween(double latitude, double latitude2, double longitude, double longitude2);

}
