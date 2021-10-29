package com.su.hydrangea.domain.region.outbound;

import com.su.hydrangea.domain.region.quartz.payload.PopulationResponse;

public interface PopulationClient {
    PopulationResponse.PopulationInformation getPopulation();
}