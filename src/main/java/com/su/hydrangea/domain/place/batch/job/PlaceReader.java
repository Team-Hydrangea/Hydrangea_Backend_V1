package com.su.hydrangea.domain.place.batch.job;

import com.su.hydrangea.domain.place.batch.payload.PlaceResponse;
import com.su.hydrangea.domain.place.outbound.TourPlaceClient;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
@StepScope
public class PlaceReader implements ItemReader<PlaceResponse.PlaceInformation> {

    private final TourPlaceClient placeClient;

    @Value("${openapi.secret}")
    private String secret;

    private int page;
    private PlaceResponse.PlaceInformation placeInformation;

    @Override
    public PlaceResponse.PlaceInformation read() {
        setPage();
        placeInformation = getTourInformation();
        return placeInformation;
    }

    private void setPage() {
        if (isFirst()) {
            page = 1;
        } else if (hasMorePage(placeInformation)) {
            page++;
        } else {
            page = 0;
        }
    }

    private boolean isFirst() {
        return placeInformation == null;
    }

    private PlaceResponse.PlaceInformation getTourInformation() {
        return placeClient.getTourInformation(secret, 100, page, "ETC", "test");
    }

    private boolean hasMorePage(PlaceResponse.PlaceInformation information) {
        return placeInformation.getBody().getPageNo() > page;
    }

}
