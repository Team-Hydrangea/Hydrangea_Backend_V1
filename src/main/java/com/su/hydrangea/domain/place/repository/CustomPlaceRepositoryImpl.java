package com.su.hydrangea.domain.place.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.su.hydrangea.domain.place.entity.Place;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class CustomPlaceRepositoryImpl {

    private final JPAQueryFactory query;

    public List<Place> getPlaceList(double latitude1, double longitude1, double latitude2, double longitude2) {
        return null; // TODO entity 수정 후 추가 예정
    }

}
