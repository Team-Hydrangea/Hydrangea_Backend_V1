package com.su.hydrangea.domain.place.batch.job;

import com.su.hydrangea.domain.place.batch.payload.PlaceResponse;
import com.su.hydrangea.domain.place.entity.Place;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PlaceJobConfiguration {

    @Bean
    Step jobStep(StepBuilderFactory factory,
                 ItemReader<PlaceResponse.PlaceInformation> reader,
                 ItemProcessor<PlaceResponse.PlaceInformation, List<Place>> processor,
                 PlaceWriter writer) {

        return factory.get("savePlaceInformation")
                .<PlaceResponse.PlaceInformation, List<Place>>chunk(1)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}
