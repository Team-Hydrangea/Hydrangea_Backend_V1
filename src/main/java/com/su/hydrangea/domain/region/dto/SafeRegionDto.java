package com.su.hydrangea.domain.region.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class SafeRegionDto {

    @Getter
    @AllArgsConstructor
    @ApiModel(value = "안전한 지역 가져오기 response", description = "안전한 지역 가져오기 response")
    public static class Response {

        @ApiModelProperty(value = "시 이름", example = "광주광역시")
        private String name;

    }

}
