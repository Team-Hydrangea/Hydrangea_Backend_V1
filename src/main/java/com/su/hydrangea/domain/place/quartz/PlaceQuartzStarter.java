package com.su.hydrangea.domain.place.quartz;

import com.su.hydrangea.domain.place.repository.ElasticPlaceRepository;
import com.su.hydrangea.global.quartz.QuartzFacade;
import lombok.RequiredArgsConstructor;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Component
public class PlaceQuartzStarter {

    private final QuartzFacade quartzFacade;
    private final ElasticPlaceRepository repository;

    @PostConstruct
    public void addCovidQuartz() throws SchedulerException {
        final String cron = "0 0 3 * * ?";
        quartzFacade.addCronJob(PlaceQuartzJob.class, "placeQuartzJob", null, cron);
    }
}
