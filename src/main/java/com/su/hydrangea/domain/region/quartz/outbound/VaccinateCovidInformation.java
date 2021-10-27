package com.su.hydrangea.domain.region.quartz.outbound;

import com.su.hydrangea.domain.region.quartz.payload.VaccinateResponse;
import com.su.hydrangea.global.feign.XmlConfiguration;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "https://nip.kdca.go.kr", configuration = XmlConfiguration.class)
public interface VaccinateCovidInformation {

    @RequestLine("GET /irgd/cov19stats.do?list=sido")
    VaccinateResponse.VaccinateInformation getCovidResponse();

}
