package com.su.hydrangea.domain.place.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

public class PlaceDto {

    @Getter
    @NoArgsConstructor
    public static class Request {

        @NotBlank
        @ApiModelProperty(value = "장소1_위도", example = "33.3333")
        private double latitude1;

        @NotBlank
        @ApiModelProperty(value = "장소1_경도", example = "123.3333")
        private double longitude1;

        @NotBlank
        @ApiModelProperty(value = "장소2_위도", example = "33.3333")
        private double latitude2;

        @NotBlank
        @ApiModelProperty(value = "장소2_경도", example = "123.3333")
        private double longitude2;

    }

    @Getter
    @AllArgsConstructor
    public static class Response {

        @ApiModelProperty(value = "관광지 이름", example = "백두산")
        private String title;

        @ApiModelProperty(value = "관광지 전화번호", example = "01-1010-0020")
        private String number;

        @ApiModelProperty(value = "관광지 이미지", example = "모름 대충 사진 url")
        private String image;

    }

}
