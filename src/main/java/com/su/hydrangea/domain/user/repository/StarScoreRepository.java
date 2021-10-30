package com.su.hydrangea.domain.user.repository;

import com.su.hydrangea.domain.user.entity.StarScore;
import com.su.hydrangea.domain.user.entity.User;
import com.su.hydrangea.domain.user.service.StarScoreService;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StarScoreRepository extends CrudRepository<StarScore, Long> {
    Optional<StarScore> findByUserAndLatitudeAndLongitude(User user, Double latitude, Double longitude);
}
