package com.su.hydrangea.domain.place.controller;

import com.su.hydrangea.domain.place.dto.PlaceDto;
import com.su.hydrangea.domain.place.dto.PlaceSearchDto;
import com.su.hydrangea.domain.place.service.PlaceService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/place")
public class PlaceController {

    private final PlaceService placeService;

    @PostMapping("/all")
    @ApiOperation(value = "좌표 안에 있는 관광지", notes = "입력한 좌표 안에 있는 관광지 리스트를 가져옵니다")
    public PlaceDto.Response getPlaceList(@RequestParam("page") int page, @RequestParam("size") int size,
                                          @RequestBody PlaceDto.Request request) {
        return placeService.getPlaceList(request, PageRequest.of(page, size));
    }

    @PostMapping("/list")
    @ApiOperation(value = "검색어에 맞는 관광지", notes = "검색어에 맞는 관광지 리스트를 가져옵니다")
    public PlaceSearchDto.Response getPlaceListBySearch(@RequestParam("page") int page, @RequestParam("size") int size,
                                                        @Valid @RequestBody PlaceSearchDto.Request request) {
        return placeService.getPlaceListBySearch(request, PageRequest.of(page, size));
    }

}
