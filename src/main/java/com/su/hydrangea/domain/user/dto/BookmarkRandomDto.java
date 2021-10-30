package com.su.hydrangea.domain.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

public class BookmarkRandomDto {

    @Getter
    @AllArgsConstructor
    @Builder
    @ApiModel(value = "관광지 response", description = "관광지 response")
    public static class Response {

        @ApiModelProperty(value = "관광지 위도", example = "33.33333")
        private double latitude;

        @ApiModelProperty(value = "관광지 경도", example = "123.33333")
        private double longitude;

        @ApiModelProperty(value = "관광지 이름", example = "백두산")
        private String title;

        @ApiModelProperty(value = "관광지 전화번호", example = "010-2809-3338")
        private String number;

        @ApiModelProperty(value = "관광지 이미지", example = "대충 이미지 링크")
        private String image;

        @ApiModelProperty(value = "주소", example = "대구광역시 동구 동화사1길 1")
        private String address;

        @ApiModelProperty(value = "상세주소", example = "도학동")
        private String detailAddress;

        @ApiModelProperty(value = "평균 별점", example = "5.0")
        private double starScore;

    }

}
