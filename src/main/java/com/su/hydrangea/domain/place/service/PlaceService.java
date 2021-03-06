package com.su.hydrangea.domain.place.service;

import com.su.hydrangea.domain.place.dto.PlaceDto;
import com.su.hydrangea.domain.place.dto.PlaceSearchDto;
import com.su.hydrangea.domain.place.entity.Place;
import com.su.hydrangea.domain.place.repository.ElasticPlaceRepository;
import com.su.hydrangea.domain.user.repository.BookmarkRepository;
import com.su.hydrangea.domain.user.repository.CustomStarScoreRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlaceService {

    private final ElasticPlaceRepository placeRepository;
    private final CustomStarScoreRepositoryImpl customStarScoreRepository;
    private final BookmarkRepository bookmarkRepository;

    public List<PlaceDto.Response> getPlaceList(PlaceDto.Request request, boolean isLogin, Long userId) {
        List<Place> placeList = placeRepository.findByLatitudeBetweenAndLongitudeBetween(
                request.getLatitude1(),
                request.getLatitude2(),
                request.getLongitude1(),
                request.getLongitude2()
        );

        return placeList.stream().map(
                place -> new PlaceDto.Response(
                        place.getTitle(),
                        place.getNumber(),
                        place.getImage(),
                        place.getLatitude(),
                        place.getLongitude(),
                        place.getAddr1(),
                        place.getAddr2(),
                        customStarScoreRepository.getAvg(
                                place.getLatitude(),
                                place.getLongitude()
                        ),
                        isLogin != false && bookmarkRepository.existsByUserIdAndLongitudeAndLatitude(
                                userId,
                                place.getLongitude(),
                                place.getLatitude()
                        )
                )).collect(Collectors.toList());
    }

    public PlaceSearchDto.Response getPlaceListBySearch(PlaceSearchDto.Request request, Pageable pageable, boolean isLogin, Long userId) {
        Page<Place> placeList = placeRepository.findByTitleContaining(request.getWord(), pageable);

        return new PlaceSearchDto.Response(
                placeList.getTotalElements(),
                placeList.stream().map(
                        place -> new PlaceSearchDto.Content(
                                place.getTitle(),
                                place.getNumber(),
                                place.getImage(),
                                place.getLatitude(),
                                place.getLongitude(),
                                place.getAddr1(),
                                place.getAddr2(),
                                customStarScoreRepository.getAvg(
                                        place.getLatitude(),
                                        place.getLongitude()
                                ),
                                isLogin != false && bookmarkRepository.existsByUserIdAndLongitudeAndLatitude(
                                        userId,
                                        place.getLongitude(),
                                        place.getLatitude()
                                )
                        )).collect(Collectors.toList())
        );
    }

}
