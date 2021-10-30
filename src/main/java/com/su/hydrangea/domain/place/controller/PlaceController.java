package com.su.hydrangea.domain.place.controller;

import com.su.hydrangea.domain.place.dto.PlaceDto;
import com.su.hydrangea.domain.place.dto.PlaceSearchDto;
import com.su.hydrangea.domain.place.service.PlaceService;
import com.su.hydrangea.global.security.AuthenticationFacade;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/place")
public class PlaceController {

    private final PlaceService placeService;
    private final AuthenticationFacade authenticationFacade;

    @PostMapping("/all")
    @ApiOperation(value = "좌표 안에 있는 관광지", notes = "입력한 좌표 안에 있는 관광지 리스트를 가져옵니다")
    public List<PlaceDto.Response> getPlaceList(@RequestBody PlaceDto.Request request) {
        if (authenticationFacade.isLogin()) {
            return placeService.getPlaceList(request, authenticationFacade.isLogin(), authenticationFacade.getId());
        }
        return placeService.getPlaceList(request, authenticationFacade.isLogin(), null);
    }

    @PostMapping("/list")
    @ApiOperation(value = "검색어에 맞는 관광지", notes = "검색어에 맞는 관광지 리스트를 가져옵니다")
    public PlaceSearchDto.Response getPlaceListBySearch(@RequestParam("page") int page, @RequestParam("size") int size,
                                                        @Valid @RequestBody PlaceSearchDto.Request request) {
        if (authenticationFacade.isLogin()) {
            return placeService
                    .getPlaceListBySearch(request, PageRequest.of(page, size), authenticationFacade.isLogin(), authenticationFacade.getId());
        }
        return placeService.getPlaceListBySearch(request, PageRequest.of(page, size), authenticationFacade.isLogin(), null);
    }

}
