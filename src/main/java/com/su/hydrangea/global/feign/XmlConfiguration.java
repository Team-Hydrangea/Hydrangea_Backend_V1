package com.su.hydrangea.global.feign;

import feign.jaxb.JAXBContextFactory;
import feign.jaxb.JAXBDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class XmlConfiguration {

    @Bean
    public JAXBDecoder decoder() {
        return new JAXBDecoder(new JAXBContextFactory.Builder()
                .withMarshallerJAXBEncoding("UTF-8")
                .build());
    }

}
