package com.su.hydrangea.domain.region.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.su.hydrangea.domain.region.entity.RegionInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class CustomRegionRepositoryImpl {

    private final JPAQueryFactory query;

    public RegionInfo getSafeRandomRegion() {
        return null; // TODO entity 수정 후 바꿀 예정
    }

}
