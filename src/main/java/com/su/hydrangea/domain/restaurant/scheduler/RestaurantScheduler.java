package com.su.hydrangea.domain.restaurant.scheduler;

import com.su.hydrangea.domain.restaurant.entity.Restaurant;
import com.su.hydrangea.domain.restaurant.outbound.RestaurantClient;
import com.su.hydrangea.domain.restaurant.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RestaurantScheduler {

    private final RestaurantRepository repository;
    private final RestaurantClient client;

    @Value("${openapi.kkyeongki.secret}")
    private String secret;

    @Scheduled(cron = "0 0 3 * * ?")
    public void saveRestaurant() {
        repository.deleteAll();
        var response = client.getRestaurantInformation(secret);
        var restaurants = response.getRow()
                .stream().map(row -> Restaurant.builder()
                        .name(row.getName())
                        .number(row.getNumber())
                        .latitude(row.getLatitude())
                        .longitude(row.getLongitude())
                        .build())
                .collect(Collectors.toList());

        repository.saveAll(restaurants);
    }
}
