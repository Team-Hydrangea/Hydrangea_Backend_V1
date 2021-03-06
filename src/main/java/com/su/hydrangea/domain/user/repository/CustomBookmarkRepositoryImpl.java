package com.su.hydrangea.domain.user.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.su.hydrangea.domain.user.entity.Bookmark;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.su.hydrangea.domain.user.entity.QBookmark.bookmark;

@Repository
@RequiredArgsConstructor
public class CustomBookmarkRepositoryImpl {

    private final JPAQueryFactory query;

    public Optional<Bookmark> getRandomBookmark(long userId) {
        long count = query.selectFrom(bookmark)
                .where(bookmark.user.id.eq(userId))
                .fetchCount();

        return Optional.ofNullable(query.selectFrom(bookmark)
                .where(bookmark.user.id.eq(userId))
                .offset((int)((Math.random()*10)%count))
                .limit(1)
                .fetchOne());
    }

}
