package com.su.hydrangea.domain.region.outbound;

import com.su.hydrangea.domain.region.quartz.payload.CovidResponse;
import com.su.hydrangea.global.feign.XmlConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@FeignClient(url = "http://openapi.data.go.kr", configuration = XmlConfiguration.class, name = "regionCovidInformation")
public interface RegionCovidClient {

    @GetMapping("/openapi/service/rest/Covid19/getCovid19SidoInfStateJson")
    CovidResponse.CovidInformation getCovidCount(@RequestParam("ServiceKey") String serviceKey,
                                                 @RequestParam("numOfRows") int numOfRows,
                                                 @RequestParam("startCreateDt") @DateTimeFormat(pattern = "yyyyMMdd") LocalDate startCreateDt,
                                                 @RequestParam("endCreateDt") @DateTimeFormat(pattern = "yyyyMMdd") LocalDate endCreateDt);

}
