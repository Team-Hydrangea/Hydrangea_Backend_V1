package com.su.hydrangea.global.batch;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class UniqueIdGenerator extends RunIdIncrementer {

    private static final String KEY = "job.id";
    private static final Long DEFAULT_VALUE = 0L;

    @Override
    public JobParameters getNext(@Nullable JobParameters parameters) {
        JobParameters params = new JobParameters();
        return new JobParametersBuilder()
                .addLong(KEY, params.getLong(KEY, DEFAULT_VALUE) + 1)
                .toJobParameters();
    }

}
