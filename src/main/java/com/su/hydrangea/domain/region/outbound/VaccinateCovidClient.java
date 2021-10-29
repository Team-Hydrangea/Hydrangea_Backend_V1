package com.su.hydrangea.domain.region.outbound;

import com.su.hydrangea.domain.region.quartz.payload.VaccinateResponse;
import com.su.hydrangea.global.feign.XmlConfiguration;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

<<<<<<< Updated upstream:src/main/java/com/su/hydrangea/domain/region/quartz/outbound/VaccinateCovidInformation.java
@FeignClient(url = "https://nip.kdca.go.kr", configuration = XmlConfiguration.class)
public interface VaccinateCovidInformation {
=======
@FeignClient(url = "https://nip.kdca.go.kr", configuration = XmlConfiguration.class, name = "vaccinateCovidInformation")
public interface VaccinateCovidClient {
>>>>>>> Stashed changes:src/main/java/com/su/hydrangea/domain/region/outbound/VaccinateCovidClient.java

    @RequestLine("GET /irgd/cov19stats.do?list=sido")
    VaccinateResponse.VaccinateInformation getCovidResponse();

}
