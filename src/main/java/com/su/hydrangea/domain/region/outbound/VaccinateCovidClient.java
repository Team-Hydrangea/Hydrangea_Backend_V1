package com.su.hydrangea.domain.region.outbound;

import com.su.hydrangea.domain.region.quartz.payload.VaccinateResponse;
import com.su.hydrangea.global.feign.XmlConfiguration;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(url = "https://nip.kdca.go.kr", configuration = XmlConfiguration.class, name = "vaccinateCovidInformation")
public interface VaccinateCovidClient {

    @RequestLine("GET /irgd/cov19stats.do?list=sido")
    VaccinateResponse.VaccinateInformation getCovidResponse();

}
