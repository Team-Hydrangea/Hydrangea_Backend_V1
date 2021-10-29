package com.su.hydrangea.domain.place.controller;

import com.su.hydrangea.domain.place.dto.PlaceDto;
import com.su.hydrangea.domain.place.dto.PlaceSearchDto;
import com.su.hydrangea.domain.place.service.PlaceService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/place")
public class PlaceController {

    private final PlaceService placeService;

    @PostMapping("/all")
    @ApiOperation(value = "좌표 안에 있는 관광지", notes = "입력한 좌표 안에 있는 관광지 리스트를 가져옵니다")
    public List<PlaceDto.Response> getPlaceList(@RequestBody PlaceDto.Request request) {
        return placeService.getPlaceList(request);
    }

    @PostMapping("/list")
    @ApiOperation(value = "검색어에 맞는 관광지", notes = "검색어에 맞는 관광지 리스트를 가져옵니다")
    public List<PlaceSearchDto.Response> getPlaceListBySearch(@Valid @RequestBody PlaceSearchDto.Request request) {
        return placeService.getPlaceListBySearch(request);
    }

}
