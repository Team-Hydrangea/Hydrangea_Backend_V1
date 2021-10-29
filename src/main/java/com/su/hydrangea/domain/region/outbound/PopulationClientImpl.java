package com.su.hydrangea.domain.region.outbound;

import com.su.hydrangea.domain.region.quartz.payload.PopulationResponse;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;

@Component
public class PopulationClientImpl implements PopulationClient {

    private static final String POPULATION_URL = "https://superkts.com/population/sum_sido/";
    private static final Connection conn = Jsoup.connect(POPULATION_URL);
    private static final String TR_XPATH = "/html/body/main/section/article/table/tbody/tr";

    @Override
    public PopulationResponse.PopulationInformation getPopulation() {

        var informationList = new ArrayList<PopulationResponse.CityPopulationInformation>();

        try {
            Document document = conn.get();
            Elements trList = document.selectXpath(TR_XPATH);

            for (Element tr : trList) {
                String region = tr.selectXpath("/tr/td[2]").text();

                if (region.equals("")) {
                    continue;
                }

                String number = tr.selectXpath("/tr/td[3]").text();
                Long population = Long.valueOf(number.replace(",", ""));

                var cityPopulation = new PopulationResponse.CityPopulationInformation(region, population);
                informationList.add(cityPopulation);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new PopulationResponse.PopulationInformation(informationList);
    }
}
