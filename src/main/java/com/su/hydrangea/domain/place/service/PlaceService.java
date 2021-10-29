package com.su.hydrangea.domain.place.service;

import com.su.hydrangea.domain.place.dto.PlaceDto;
import com.su.hydrangea.domain.place.entity.Place;
import com.su.hydrangea.domain.place.repository.ElasticPlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final ElasticPlaceRepository placeRepository;

    public List<PlaceDto.Response> getPlaceList(PlaceDto.Request request) {
        List<Place> placeList = placeRepository.findByLatitudeBetweenAndLongitudeBetween(
                request.getLatitude1(),
                request.getLatitude2(),
                request.getLongitude1(),
                request.getLongitude2());

        return placeList.stream().map(
                place -> {
                    return new PlaceDto.Response(
                            place.getTitle(),
                            place.getNumber(),
                            place.getImage(),
                            place.getLatitude(),
                            place.getLongitude()
                    );
                }
        ).collect(Collectors.toList());
    }

}
