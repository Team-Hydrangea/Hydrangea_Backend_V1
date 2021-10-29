package com.su.hydrangea.domain.region.outbound;

import com.su.hydrangea.domain.region.quartz.payload.VaccinateResponse;
import com.su.hydrangea.global.feign.XmlConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "https://nip.kdca.go.kr", configuration = XmlConfiguration.class, name = "vaccinateCovidInformation")
public interface VaccinateCovidClient {

    @GetMapping("/irgd/cov19stats.do?list=sido")
    VaccinateResponse.VaccinateInformation getCovidResponse();

}
