package com.su.hydrangea.domain.restaurant.outbound;

import com.su.hydrangea.domain.restaurant.outbound.payload.RestaurantResponse;
import com.su.hydrangea.global.feign.XmlConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "restaurantClient", configuration = XmlConfiguration.class, url = "https://openapi.gg.go.kr")
public interface RestaurantClient {

    @GetMapping("/SafetyRestrntInfo")
    RestaurantResponse.RestaurantInformation getRestaurantInformation(@RequestParam("KEY") @Value("${openapi.kyeongki.secret}") String secretKey);

}