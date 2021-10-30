package com.su.hydrangea.domain.place.batch;

import com.su.hydrangea.domain.place.entity.Place;
import com.su.hydrangea.domain.place.outbound.TourPlaceClient;
import com.su.hydrangea.domain.place.repository.ElasticPlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class SavePlace {

    private final ElasticPlaceRepository repository;
    private final TourPlaceClient placeClient;

    @Value("${openapi.secret}")
    private String secret;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Scheduled(cron = "0 8 * * * ?")
    public void savePlaceList() {
        repository.deleteAll();
        for (int i = 0; i < 10; i++) {
            var response = placeClient.getTourInformation(secret, 100, i, "ETC", "test");
            var places = response.getBody()
                    .getItems().stream()
                    .map(item -> Place.builder()
                            .id(UUID.randomUUID().toString())
                            .latitude(item.getMapY())
                            .longitude(item.getMapX())
                            .title(item.getTitle())
                            .image(item.getFirstimage())
                            .number(item.getTel())
                            .build())
                    .collect(Collectors.toList());
            repository.saveAll(places);
        }

    }

}
