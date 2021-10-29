package com.su.hydrangea.domain.region.repository;

import com.querydsl.core.types.dsl.NumberExpression;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import com.su.hydrangea.domain.region.entity.RegionInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.su.hydrangea.domain.region.entity.QRegionInfo.regionInfo;

@Repository
@RequiredArgsConstructor
public class CustomRegionRepositoryImpl {

    private final JPAQueryFactory query;

    public RegionInfo getSafeRandomRegion() {
         return query.selectFrom(regionInfo)
                .where((regionInfo.vaccinateCaseCount.divide(regionInfo.population).multiply(20))
                        .add(regionInfo.population.subtract(regionInfo.deadCaseCount
                                .multiply(5).add(regionInfo.confirmCaseCount)
                        ).divide(regionInfo.population).multiply(80))
                        .gt(
                                JPAExpressions.select(
                                        (regionInfo.vaccinateCaseCount.divide(regionInfo.population).multiply(20))
                                                .add(regionInfo.population.subtract(regionInfo.deadCaseCount
                                                        .multiply(5).add(regionInfo.confirmCaseCount)
                                                ).divide(regionInfo.population).multiply(80).max()
                                        ))
                                        .from(regionInfo)
                        ))
                 .orderBy(NumberExpression.random().asc())
                 .fetchFirst();
    }

}
