package com.su.hydrangea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableFeignClients
@SpringBootApplication
@EnableScheduling
public class HydrangeaApplication {

    public static void main(String[] args) {
        SpringApplication.run(HydrangeaApplication.class, args);
    }

}
