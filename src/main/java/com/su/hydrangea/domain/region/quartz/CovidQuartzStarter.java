package com.su.hydrangea.domain.region.quartz;

import com.su.hydrangea.domain.region.quartz.job.CovidJob;
import com.su.hydrangea.global.quartz.QuartzFacade;
import lombok.RequiredArgsConstructor;
import org.quartz.SchedulerException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@RequiredArgsConstructor
@Component
public class CovidQuartzStarter {

    private final QuartzFacade quartzFacade;

    @PostConstruct
    public void addCovidQuartz() throws SchedulerException {
        final String cron = "0 0 3 * * ?";
        quartzFacade.addCronJob(CovidJob.class, "covid", null, cron);
    }

}
