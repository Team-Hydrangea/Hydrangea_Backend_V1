package com.su.hydrangea.domain.region.quartz.outbound;

import com.su.hydrangea.domain.region.quartz.payload.CovidResponse;
import com.su.hydrangea.global.feign.XmlConfiguration;
import feign.Param;
import feign.RequestLine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@FeignClient(url = "http://openapi.data.go.kr", configuration = XmlConfiguration.class)
public interface RegionCovidInformation {

    @RequestLine("GET /openapi/service/rest/Covid19/getCovid19SidoInfStateJson")
    CovidResponse.CovidInformation getCovidCount(@Param("ServiceKey") @Value("${openapi.secret}") String serviceKey,
                                @Param("numOfRows") int numOfRows,
                                @Param("startCreateDt") @DateTimeFormat(pattern = "yyyyMMdd") LocalDate startCreateDt,
                                @Param("endCreateDt") @DateTimeFormat(pattern = "yyyyMMdd") LocalDate endCreateDt);

}
