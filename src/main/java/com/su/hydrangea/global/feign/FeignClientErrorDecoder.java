package com.su.hydrangea.global.feign;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.su.hydrangea.global.error.exception.FailToCurlException;
import feign.Response;
import feign.codec.ErrorDecoder;

public class FeignClientErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public FailToCurlException decode(final String methodKey, Response response) {

        String message = "Server failed to request other server.";

        if (response.body() != null) {
            try {
                message = objectMapper.readTree(response.body().toString())
                        .get("msg").asText();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }

        return new FailToCurlException(response.status(), message);
    }

}
