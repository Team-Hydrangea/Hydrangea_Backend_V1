package com.su.hydrangea.domain.place.service;

import com.su.hydrangea.domain.place.dto.PlaceDto;
import com.su.hydrangea.domain.place.entity.Place;
import com.su.hydrangea.domain.place.repository.CustomPlaceRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final CustomPlaceRepositoryImpl customPlaceRepository;

    public List<PlaceDto.Response> getPlaceList(PlaceDto.Request request) {
        List<Place> placeList = customPlaceRepository.getPlaceList(
                request.getLatitude1(),
                request.getLatitude2(),
                request.getLongitude1(),
                request.getLongitude2());

        return placeList.stream().map(
                place -> {
                    return new PlaceDto.Response(
                            place.getTitle(),
                            place.getNumber(),
                            place.getImage()
                    );
                }
        ).collect(Collectors.toList());
    }

}
