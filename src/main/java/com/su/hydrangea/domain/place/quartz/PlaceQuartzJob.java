package com.su.hydrangea.domain.place.quartz;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;

@RequiredArgsConstructor
public class PlaceQuartzJob implements Job {

    private final org.springframework.batch.core.Job savePlaceJob;
    private final JobLauncher jobLauncher;

    @SneakyThrows
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        jobLauncher.run(savePlaceJob, new JobParameters());
    }

}
