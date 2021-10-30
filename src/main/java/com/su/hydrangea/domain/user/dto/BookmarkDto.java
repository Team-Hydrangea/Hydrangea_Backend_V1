package com.su.hydrangea.domain.user.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

public class BookmarkDto {

    @Getter
    @AllArgsConstructor
    @ApiModel(value = "즐겨찾기 response", description = "즐겨찾기 response")
    public static class Response {

        @ApiModelProperty(value = "총 요소 개수", example = "100")
        private long totalElements;

        private List<Content> content;

    }

    @Getter
    @AllArgsConstructor
    @ApiModel(value = "관광지 리스트", description = "관광지 리스트")
    public static class Content {

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

    }

}
