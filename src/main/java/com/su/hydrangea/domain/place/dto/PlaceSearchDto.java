package com.su.hydrangea.domain.place.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

public class PlaceSearchDto {

    @Getter
    @NoArgsConstructor
    @ApiModel(value = "검색에 따른 관광지 리스트 가져오기 request", description = "검색에 따른 관광지 리스트 가져오기 request")
    public static class Request {

        @NotBlank
        @ApiModelProperty(value = "검색어", example = "백두산")
        private String word;
    }

    @Getter
    @AllArgsConstructor
    @ApiModel(value = "검색에 따른 관광지 리스트 가져오기 response", description = "검색에 따른 관광지 리스트 가져오기 response")
    public static class Response {

        @ApiModelProperty(value = "총 요소 개수", example = "100")
        private long totalElements;

        private List<Content> content;

    }

    @Getter
    @AllArgsConstructor
    @ApiModel(value = "검색에 따른 관광지 리스트", description = "검색에 따른 관광지 리스트")
    public static class Content {

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
