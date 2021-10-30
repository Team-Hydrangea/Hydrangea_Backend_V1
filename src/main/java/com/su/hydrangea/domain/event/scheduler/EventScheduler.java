package com.su.hydrangea.domain.event.scheduler;

import com.su.hydrangea.domain.event.entity.Event;
import com.su.hydrangea.domain.event.outbound.EventClient;
import com.su.hydrangea.domain.event.outbound.EventResponse;
import com.su.hydrangea.domain.event.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class EventScheduler {

    private final EventRepository repository;
    private final EventClient client;

    @Value("${openapi.secret}")
    private String secretKey;

    @Scheduled(cron = "0 0 3 * * ?")
    public void saveEvent() {
        repository.deleteAll();
        LocalDate now = LocalDate.now();
        for(int i = 0; i < 10; i ++) {
            var response = client.getFestival(secretKey, 100, i, "ETC", "test", now, now.plusMonths(1));
            var events = response.getBody().getItems()
                    .stream().map(item -> Event.builder()
                            .endDate(item.getEndDate())
                            .startDate(item.getStartDate())
                            .image(item.getImage())
                            .latitude(item.getLatitude())
                            .longitude(item.getLongitude())
                            .name(item.getName())
                            .build())
                    .collect(Collectors.toList());
            repository.saveAll(events);
        }
    }

}
