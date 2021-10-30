package com.su.hydrangea.domain.user.controller;

import com.su.hydrangea.domain.user.dto.StarScoreDto;
import com.su.hydrangea.domain.user.service.StarScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class StartScoreController {

    private final StarScoreService service;

    @PostMapping("/starscore")
    public void createStarScore(@RequestBody StarScoreDto.CreateRequest request,
                                @RequestParam Double longitude,
                                @RequestParam Double latitude) {
        service.createStarScore(request, longitude, latitude);
    }
}
