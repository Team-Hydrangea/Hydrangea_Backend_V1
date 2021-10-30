package com.su.hydrangea.domain.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.su.hydrangea.domain.user.entity.QStarScore.starScore;

@Repository
@RequiredArgsConstructor
public class CustomStarScoreRepositoryImpl {

    private final JPAQueryFactory query;

    public double getAvg(double latitude, double longtitude) {
        Double aDouble = query.select(starScore.score.avg())
                .from(starScore)
                .where(starScore.latitude.eq(latitude)
                        .and(starScore.longitude.eq(longtitude)))
                .fetchOne();
        return aDouble==null ? 0 : aDouble;
    }

}
