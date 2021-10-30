package com.su.hydrangea.domain.place.service;

import com.su.hydrangea.domain.place.dto.PlaceDto;
import com.su.hydrangea.domain.place.dto.PlaceSearchDto;
import com.su.hydrangea.domain.place.entity.Place;
import com.su.hydrangea.domain.place.repository.ElasticPlaceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final ElasticPlaceRepository placeRepository;

    public PlaceDto.Response getPlaceList(PlaceDto.Request request, Pageable pageable) {
        Page<Place> placeList = placeRepository.findByLatitudeBetweenAndLongitudeBetween(
                request.getLatitude1(),
                request.getLatitude2(),
                request.getLongitude1(),
                request.getLongitude2(),
                pageable
        );

        return new PlaceDto.Response(
                placeList.getTotalElements(),
                placeList.stream().map(
                        place -> new PlaceDto.Content(
                                place.getTitle(),
                                place.getNumber(),
                                place.getImage(),
                                place.getLatitude(),
                                place.getLongitude()
                        )).collect(Collectors.toList())
        );
    }

    public PlaceSearchDto.Response getPlaceListBySearch(PlaceSearchDto.Request request, Pageable pageable) {
        Page<Place> placeList = placeRepository.findByTitleContaining(request.getWord(), pageable);

        return new PlaceSearchDto.Response(
                placeList.getTotalElements(),
                placeList.stream().map(
                        place -> new PlaceSearchDto.Content(
                                place.getTitle(),
                                place.getNumber(),
                                place.getImage(),
                                place.getLatitude(),
                                place.getLongitude()
                        )).collect(Collectors.toList())
        );
    }

}
