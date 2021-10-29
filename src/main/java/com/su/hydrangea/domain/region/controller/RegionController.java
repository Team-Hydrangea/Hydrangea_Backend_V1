package com.su.hydrangea.domain.region.controller;

import com.su.hydrangea.domain.region.dto.SafeRegionDto;
import com.su.hydrangea.domain.region.service.RegionService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/region")
public class RegionController {

    private final RegionService regionService;

    @GetMapping("/safe")
    @ApiOperation(value = "안전 점수가 높은 랜덤 지역", notes = "안전 점수가 높은 랜덤 지역 가져옵니다")
    public SafeRegionDto.Response getSafeRegion() {
        return regionService.getSafeRegion();
    }

}
