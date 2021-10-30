package com.su.hydrangea.domain.restaurant.service;

import com.su.hydrangea.domain.restaurant.dto.RestaurantDto;
import com.su.hydrangea.domain.restaurant.entity.Restaurant;
import com.su.hydrangea.domain.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public List<RestaurantDto.Response> getRestaurantList(RestaurantDto.Request request) {
        List<Restaurant> restaurantList = restaurantRepository.findByLatitudeBetweenAndLongitudeBetween(
                request.getLatitude1(),
                request.getLatitude2(),
                request.getLongitude1(),
                request.getLongitude2()
        );

        return restaurantList.stream().map(
                restaurant ->
                        new RestaurantDto.Response(
                                restaurant.getName(),
                                restaurant.getLatitude(),
                                restaurant.getLongitude(),
                                restaurant.getNumber()
                        )).collect(Collectors.toList());
    }
}
