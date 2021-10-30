package com.su.hydrangea.domain.restaurant.scheduler;

import com.su.hydrangea.domain.place.repository.ElasticPlaceRepository;
import com.su.hydrangea.domain.restaurant.entity.Restaurant;
import com.su.hydrangea.domain.restaurant.outbound.RestaurantClient;
import com.su.hydrangea.domain.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RestaurantScheduler {

    private final RestaurantRepository repository;
    private final RestaurantClient client;

    @Value("${openapi.kkyeongki.secret}")
    private String secret;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Scheduled(cron = "0 8 * * * ?")
    public void saveRestaurant() {
        repository.deleteAll();
        var response = client.getRestaurantInformation(secret);
        var restaurants = response.getRow()
                .stream()
                .filter(row -> row.getLatitude() != null && row.getLongitude() != null)
                .map(row -> Restaurant.builder()
                        .name(row.getName())
                        .number(row.getNumber())
                        .latitude(row.getLatitude())
                        .longitude(row.getLongitude())
                        .build())
                .collect(Collectors.toList());

        repository.saveAll(restaurants);
    }
}
