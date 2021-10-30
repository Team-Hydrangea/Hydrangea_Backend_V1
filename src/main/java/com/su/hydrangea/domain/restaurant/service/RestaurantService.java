package com.su.hydrangea.domain.restaurant.service;

import com.su.hydrangea.domain.restaurant.dto.RestaurantDto;
import com.su.hydrangea.domain.restaurant.entity.Restaurant;
import com.su.hydrangea.domain.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public RestaurantDto.Response getRestaurantList(RestaurantDto.Request request, Pageable pageable) {
        Page<Restaurant> restaurantList = restaurantRepository.findByLatitudeBetweenAndLongitudeBetween(
                request.getLatitude1(),
                request.getLatitude2(),
                request.getLongitude1(),
                request.getLongitude2(),
                pageable
        );

        System.out.println("테스트" + restaurantList.getTotalPages());

        return new RestaurantDto.Response(
                restaurantList.getTotalElements(),
                restaurantList.stream().map(
                        restaurant ->
                            new RestaurantDto.Content(
                                    restaurant.getName(),
                                    restaurant.getLatitude(),
                                    restaurant.getLongitude(),
                                    restaurant.getNumber()
                            )).collect(Collectors.toList())
        );
    }
}
