package com.su.hydrangea.global.feign;

import com.su.hydrangea.domain.user.exception.OauthServerException;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FeignClientErrorDecoder implements ErrorDecoder {

    @Override
    public OauthServerException decode(final String methodKey, Response response) {

        String message = "Server failed to request oauth server.";

        if (response.reason() != null) {
            message = response.reason();
        }

        return new OauthServerException(response.status(), message);
    }

}
