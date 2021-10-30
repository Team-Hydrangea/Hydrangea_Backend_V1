package com.su.hydrangea.domain.event.scheduler;

import com.su.hydrangea.domain.event.entity.Event;
import com.su.hydrangea.domain.event.outbound.EventClient;
import com.su.hydrangea.domain.event.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class EventScheduler {

    private final EventRepository repository;
    private final EventClient client;

    @Value("${openapi.secret}")
    private String secretKey;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Scheduled(cron = "0 0 3 * * ?")
    public void saveEvent() {
        repository.deleteAll();
        LocalDate now = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");

        for (int i = 0; i < 10; i++) {
            var response = client.getFestival(secretKey, 100, i, "ETC", "test", now, now.plusMonths(1));
            var events = response.getBody().getItems()
                    .stream().map(item -> Event.builder()
                            .endDate(LocalDate.parse(item.getEndDate(), format))
                            .startDate(LocalDate.parse(item.getStartDate(), format))
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
