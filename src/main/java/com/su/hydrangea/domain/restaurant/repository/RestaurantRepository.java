package com.su.hydrangea.domain.restaurant.repository;

import com.su.hydrangea.domain.restaurant.entity.Restaurant;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface RestaurantRepository extends ElasticsearchRepository<Restaurant, String> {
}
