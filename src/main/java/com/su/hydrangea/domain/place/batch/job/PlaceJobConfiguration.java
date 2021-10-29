package com.su.hydrangea.domain.place.batch.job;

import com.su.hydrangea.domain.place.batch.payload.PlaceResponse;
import com.su.hydrangea.domain.place.entity.Place;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.JobFactory;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@RequiredArgsConstructor
@Configuration
public class PlaceJobConfiguration {

    private final StepBuilderFactory stepBuilderFactory;
    private final ItemReader<PlaceResponse.PlaceInformation> reader;
    private final ItemProcessor<PlaceResponse.PlaceInformation, List<Place>> processor;
    private final PlaceWriter writer;

    @Bean
    @JobScope
    Step jobStep() {
        return stepBuilderFactory.get("savePlaceInformation")
                .<PlaceResponse.PlaceInformation, List<Place>>chunk(1)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }

    @Bean(name = "savePlaceJob1")
    Job job(JobBuilderFactory factory) {
        return factory.get("savePlaceJob")
                .start(jobStep())
                .build();
    }

}
