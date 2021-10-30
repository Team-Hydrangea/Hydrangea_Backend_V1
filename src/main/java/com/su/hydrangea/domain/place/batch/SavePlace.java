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
    @Scheduled(cron = "0 0 3 * * ?")
    public void savePlaceList() {
        repository.deleteAll();
        for (int i = 1; i < 10; i++) {
            var response = placeClient.getTourInformation(secret, 100, i, "ETC", "test");
            var places = response.getBody()
                    .getItems().stream()
                    .map(item -> Place.builder()
                            .latitude(item.getMapy())
                            .longitude(item.getMapx())
                            .title(item.getTitle())
                            .image(item.getFirstimage())
                            .number(item.getTel())
                            .addr1(item.getAddr1())
                            .addr2(item.getAddr2())
                            .build())
                    .collect(Collectors.toList());
            repository.saveAll(places);
        }

    }

}
