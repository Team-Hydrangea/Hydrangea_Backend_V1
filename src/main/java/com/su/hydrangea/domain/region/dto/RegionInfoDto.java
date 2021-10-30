package com.su.hydrangea.domain.region.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class RegionInfoDto {

    @Getter
    @AllArgsConstructor
    @ApiModel(value = "지역 정보 가져오기 response", description = "지역 정보 가져오기 response")
    public static class Response {

        @ApiModelProperty(value = "시 이름", example = "광주광역시")
        private String name;

        @ApiModelProperty(value = "확진자 수", example = "1000")
        private long confirmCaseCount;

        @ApiModelProperty(value = "백신 접종 인원", example = "100")
        private long vaccinateCaseCount;

        @ApiModelProperty(value = "인구", example = "1000")
        private long population;

        @ApiModelProperty(value = "안전 지수", example = "98.8")
        private double score;

    }


}
