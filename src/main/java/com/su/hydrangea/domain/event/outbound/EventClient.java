package com.su.hydrangea.domain.event.outbound;

import com.su.hydrangea.global.feign.XmlConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@FeignClient(configuration = XmlConfiguration.class, name = "eventClient", url = "http://api.visitkorea.or.kr")
public interface EventClient {

    @GetMapping("/openapi/service/rest/KorService/searchFestival")
    EventResponse.EventInfo getFestival(@RequestParam("ServiceKey") String serviceKey,
                                        @RequestParam("numOfRows") Integer numOfRows,
                                        @RequestParam("pageNo") Integer pageNo,
                                        @RequestParam("MobileOS") String mobileOs,
                                        @RequestParam("MobileApp") String mobileApp,
                                        @RequestParam("eventStartDate") @DateTimeFormat(pattern = "yyyyMMdd") LocalDate startDate,
                                        @RequestParam("eventEndDate") @DateTimeFormat(pattern = "yyyyMMdd") LocalDate endDate);

}
