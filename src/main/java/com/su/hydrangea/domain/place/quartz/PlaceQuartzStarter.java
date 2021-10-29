package com.su.hydrangea.domain.place.quartz;

import com.su.hydrangea.domain.place.entity.ElasticPlaceRepository;
import com.su.hydrangea.domain.place.entity.Place;
import com.su.hydrangea.global.quartz.QuartzFacade;
import lombok.RequiredArgsConstructor;
import org.quartz.SchedulerException;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Component
public class PlaceQuartzStarter {

    private final QuartzFacade quartzFacade;
    private final ElasticPlaceRepository repository;

    @PostConstruct
    public void addCovidQuartz() throws SchedulerException {
        Place place = Place.builder()
                .number("asdfsdaf")
                .image("asdfasdf")
                .title("dsafad")
                .location(new GeoPoint(12.12, 12.312))
                .build();
        repository.save(place);
        System.out.println(repository.findAllBy().size());
        final String cron = "0 0 3 * * ?";
        quartzFacade.addCronJob(PlaceQuartzJob.class, "placeQuartzJob", null, cron);
    }
}
