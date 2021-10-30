package com.su.hydrangea.domain.user.service;

import com.su.hydrangea.domain.user.dto.StarScoreDto;
import com.su.hydrangea.domain.user.entity.StarScore;
import com.su.hydrangea.domain.user.entity.User;
import com.su.hydrangea.domain.user.excpetion.UserNotFoundException;
import com.su.hydrangea.domain.user.repository.StarScoreRepository;
import com.su.hydrangea.domain.user.repository.UserRepository;
import com.su.hydrangea.global.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StarScoreService {

    private final StarScoreRepository starScoreRepository;
    private final AuthenticationFacade authenticationFacade;
    private final UserRepository userRepository;

    public void createStarScore(StarScoreDto.CreateRequest request, Double longitude, Double latitude) {
        User user = userRepository.findById(authenticationFacade.getId())
                .orElseThrow(UserNotFoundException::new);

        starScoreRepository.findByUserAndLatitudeAndLongitude(user, latitude, longitude)
                .ifPresentOrElse(starScore -> {
                            starScore.updateScore(request.getScore());
                            starScoreRepository.save(starScore);
                        },
                        () -> {
                            StarScore starScore = StarScore.builder()
                                    .score(request.getScore())
                                    .latitude(latitude)
                                    .longitude(longitude)
                                    .user(user)
                                    .build();
                            starScoreRepository.save(starScore);
                        });
    }
}
