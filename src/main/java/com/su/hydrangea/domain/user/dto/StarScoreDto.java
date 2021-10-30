package com.su.hydrangea.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class StarScoreDto {

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateRequest {
        private Double score;
    }

    @Getter
    @AllArgsConstructor
    public static class GetResponse {

        private double score;

    }

}
