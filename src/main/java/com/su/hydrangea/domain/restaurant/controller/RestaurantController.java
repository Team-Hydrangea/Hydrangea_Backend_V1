package com.su.hydrangea.domain.restaurant.controller;

import com.su.hydrangea.domain.restaurant.dto.RestaurantDto;
import com.su.hydrangea.domain.restaurant.service.RestaurantService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping("/all")
    @ApiOperation(value = "좌표 안에 있는 음식점", notes = "입력한 좌표 안에 있는 음식점 리스트를 가져옵니다")
    public RestaurantDto.Response getRestaurantList(@RequestParam("size") int size, @RequestParam("page") int page,
                                               @RequestBody RestaurantDto.Request request) {
        return restaurantService.getRestaurantList(request, PageRequest.of(page, size));
    }

}
