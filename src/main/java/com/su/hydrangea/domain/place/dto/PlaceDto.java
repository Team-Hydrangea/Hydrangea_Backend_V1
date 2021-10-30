package com.su.hydrangea.domain.place.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PlaceDto {

    @Getter
    @NoArgsConstructor
    @ApiModel(value = "관광지 리스트 가져오기 request", description = "관광지 리스트 가져오기 request")
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
    @ApiModel(value = "관광지 리스트 가져오기 response", description = "관광지 리스트 가져오기 response")
    public static class Response {

        @ApiModelProperty(value = "관광지 이름", example = "백두산")
        private String title;

        @ApiModelProperty(value = "관광지 전화번호", example = "01-1010-0020")
        private String number;

        @ApiModelProperty(value = "관광지 이미지", example = "모름 대충 사진 url")
        private String image;

        @ApiModelProperty(value = "관광지 위도", example = "33.3333")
        private double latitude;

        @ApiModelProperty(value = "관광지 경도", example = "123.3333")
        private double longitude;

        @ApiModelProperty(value = "주소", example = "대구광역시 동구 동화사1길 1")
        private String address;

        @ApiModelProperty(value = "상세주소", example = "도학동")
        private String detailAddress;

        @ApiModelProperty(value = "평균 별점", example = "5.0")
        private double starScore;

        @ApiModelProperty(value = "즐겨찾기 여부", example = "true")
        private boolean bookmark;

    }

}
