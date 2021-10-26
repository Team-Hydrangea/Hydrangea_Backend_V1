package com.su.hydrangea.global.quartz;

import lombok.RequiredArgsConstructor;
import org.quartz.*;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class QuartzFacadeImpl implements QuartzFacade {

    private final Scheduler scheduler;

    @Override
    public void addCronJob(Class<?> jobClass, String name, String description, Map<String, Object> params, String expression) throws SchedulerException {

        JobDetail jobDetail = buildJobDetail(jobClass, name, description, params);

        if (scheduler.checkExists(jobDetail.getKey())) {
            scheduler.deleteJob(jobDetail.getKey());
        }

        scheduler.scheduleJob(
                jobDetail,
                getCronJobTrigger(expression)
        );

    }

    private JobDetail buildJobDetail(Class jobClass, String name, String desc, Map<String, Object> params) {
        JobDataMap jobDataMap = new JobDataMap();
        if (params != null) jobDataMap.putAll(params);
        return JobBuilder
                .newJob(jobClass)
                .withIdentity(name)
                .withDescription(desc)
                .usingJobData(jobDataMap)
                .build();
    }

    private Trigger getCronJobTrigger(String cron) {
        return TriggerBuilder.newTrigger()
                .withSchedule(CronScheduleBuilder.cronSchedule(cron))
                .build();
    }
}