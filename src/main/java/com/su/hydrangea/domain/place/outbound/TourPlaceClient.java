package com.su.hydrangea.domain.place.outbound;

import com.su.hydrangea.domain.place.batch.payload.PlaceResponse;
import com.su.hydrangea.global.feign.XmlConfiguration;
import feign.Param;
import feign.RequestLine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "tourPlaceClient", configuration = XmlConfiguration.class, url = "http://api.visitkorea.or.kr")
public interface TourPlaceClient {

    @RequestLine("GET /openapi/service/rest/KorService/areaCode")
    PlaceResponse.PlaceInformation getTourInformation(@Param("ServiceKey") @Value("${openapi.secret}") String serviceKey,
                                                      @Param("numOfRows") Integer numOfRows,
                                                      @Param("pageNo") Integer pageNo,
                                                      @Param("MobileOS") String mobileOS,
                                                      @Param("MobileApp") String mobileApp);
}
