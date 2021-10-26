package com.su.hydrangea;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableBatchProcessing
@EnableFeignClients
@SpringBootApplication
public class HydrangeaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HydrangeaApplication.class, args);
    }

}
