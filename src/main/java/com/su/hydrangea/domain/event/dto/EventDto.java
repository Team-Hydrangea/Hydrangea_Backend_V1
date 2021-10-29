package com.su.hydrangea.domain.event.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class EventDto {

    @Getter
    @NoArgsConstructor
    @ApiModel(value = "축제/공연/행사 리스트 가져오기 request", description = "축제/공연/행사 리스트 가져오기 request")
    public static class Request {

        @NotBlank
        @ApiModelProperty(value = "위도1", example = "33.3333")
        private double latitude1;

        @NotBlank
        @ApiModelProperty(value = "경도1", example = "123.3333")
        private double longitude1;

        @NotBlank
        @ApiModelProperty(value = "위도2", example = "33.3333")
        private double latitude2;

        @NotBlank
        @ApiModelProperty(value = "경도2", example = "123.3333")
        private double longitude2;

    }

    @Getter
    @AllArgsConstructor
    @ApiModel(value = "축제/공연/행사 리스트 가져오기 response", description = "축제/공연/행사 리스트 가져오기 response")
    public static class Response {

        @ApiModelProperty(value = "축제 이름", example = "백두산 축제")
        private String name;

        @ApiModelProperty(value = "축제 이미지", example = "모름 대충 사진 url")
        private String image;

        @ApiModelProperty(value = "축제 위도", example = "33.3333")
        private double latitude;

        @ApiModelProperty(value = "축제 경도", example = "123.3333")
        private double longitude;

        @ApiModelProperty(value = "축제 시작일", example = "2021-03-01")
        private LocalDate startDate;

        @ApiModelProperty(value = "축제 종료일", example = "2021-03-01")
        private LocalDate endDate;

    }

}
