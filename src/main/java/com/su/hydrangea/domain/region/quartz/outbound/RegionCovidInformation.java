package com.su.hydrangea.domain.region.quartz.outbound;

import com.su.hydrangea.domain.region.quartz.payload.CovidResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@FeignClient(url = "http://openapi.data.go.kr/openapi/")
public interface RegionCovidInformation {

    @GetMapping("service/rest/Covid19")
    CovidResponse getCovidCount(@RequestParam("ServiceKey") @Value("${openapi.secret}") String serviceKey,
                                @RequestParam("numOfRows") int numOfRows,
                                @RequestParam("startCreateDt") @DateTimeFormat(pattern = "yyyyMMdd") LocalDate startCreateDt,
                                @RequestParam("endCreateDt") @DateTimeFormat(pattern = "yyyyMMdd") LocalDate endCreateDt);

}
