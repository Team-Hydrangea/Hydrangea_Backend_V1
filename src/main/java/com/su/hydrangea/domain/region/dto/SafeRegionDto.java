package com.su.hydrangea.domain.region.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

public class SafeRegionDto {

    @Getter
    @AllArgsConstructor
    public static class Response {

        @ApiModelProperty(value = "시 이름", example = "광주광역시")
        private String name;

    }

}
