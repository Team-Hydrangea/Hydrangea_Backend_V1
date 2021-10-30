package com.su.hydrangea.domain.event.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

public class EventDto {

    @Getter
    @NoArgsConstructor
    @ApiModel(value = "축제/공연/행사 리스트 가져오기 request", description = "축제/공연/행사 리스트 가져오기 request")
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
    @ApiModel(value = "축제/공연/행사 리스트 가져오기 response", description = "축제/공연/행사 리스트 가져오기 response")
    public static class Response {

        @ApiModelProperty(value = "축제 이름", example = "백두산 축제")
        private String title;

        @ApiModelProperty(value = "축제 이미지", example = "모름 대충 사진 url")
        private String image;

        @ApiModelProperty(value = "축제 위도", example = "33.3333")
        private double latitude;

        @ApiModelProperty(value = "축제 경도", example = "123.3333")
        private double longitude;

        @ApiModelProperty(value = "축제 시작일", example = "20210301")
        private String startDate;

        @ApiModelProperty(value = "축제 종료일", example = "20210301")
        private String endDate;

        @ApiModelProperty(value = "주소", example = "대구광역시 동구 동화사1길 1")
        private String address;

        @ApiModelProperty(value = "상세주소", example = "도학동")
        private String detailAddress;

    }

}
