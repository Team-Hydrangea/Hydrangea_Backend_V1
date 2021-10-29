package com.su.hydrangea.domain.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class BookmarkAddDto {

    @Getter
    @NoArgsConstructor
    @ApiModel(value = "즐겨찾기 추가 request", description = "즐겨찾기 추가 request")
    public static class Request {

        @ApiModelProperty(value = "관광지 위도", example = "33.33333")
        private double latitude;

        @ApiModelProperty(value = "관광지 경도", example = "123.33333")
        private double longitude;

    }

}
