package com.su.hydrangea.domain.restaurant.dto;

import com.su.hydrangea.domain.place.dto.PlaceDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class RestaurantDto {

    @Getter
    @NoArgsConstructor
    @ApiModel(value = "음식점 리스트 가져오기 request", description = "음식점 리스트 가져오기 request")
    public static class Request {

        @ApiModelProperty(value = "위도1", example = "33.3333")
        private double latitude1;

        @ApiModelProperty(value = "경도1", example = "123.3333")
        private double longitude1;

        @ApiModelProperty(value = "위도2", example = "33.3333")
        private double latitude2;

        @ApiModelProperty(value = "경도2", example = "123.3333")
        private double longitude2;

    }

    @Getter
    @AllArgsConstructor
    @ApiModel(value = "음식점 리스트 가져오기 response", description = "음식점 리스트 가져오기 response")
    public static class Response {

        @ApiModelProperty(value = "음식점 이름", example = "백두라면")
        private String name;

        @ApiModelProperty(value = "음식점 위도", example = "33.3333")
        private double latitude;

        @ApiModelProperty(value = "음식점 경도", example = "123.3333")
        private double longitude;

        @ApiModelProperty(value = "음식점 전화번호", example = "010-2809-3338")
        private String number;

    }

}
