package com.su.hydrangea.domain.place.outbound;

import com.su.hydrangea.domain.place.batch.payload.PlaceResponse;
import com.su.hydrangea.global.feign.XmlConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "tourPlaceClient", configuration = XmlConfiguration.class, url = "http://api.visitkorea.or.kr")
public interface TourPlaceClient {

    @GetMapping("/openapi/service/rest/KorService/areaCode")
    PlaceResponse.PlaceInformation getTourInformation(@RequestParam("ServiceKey") @Value("${openapi.secret}") String serviceKey,
                                                      @RequestParam("numOfRows") Integer numOfRows,
                                                      @RequestParam("pageNo") Integer pageNo,
                                                      @RequestParam("MobileOS") String mobileOS,
                                                      @RequestParam("MobileApp") String mobileApp);
}
