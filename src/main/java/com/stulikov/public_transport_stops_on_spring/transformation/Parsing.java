package com.stulikov.public_transport_stops_on_spring.transformation;

import com.stulikov.public_transport_stops_on_spring.forecast.Forecast;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class Parsing {
    public static List<Forecast> parseHttpResponse(Document document) {
        List<Forecast> forecasts = new ArrayList<>();
        Elements table = document.select("tbody").select("tr");
        for(Element element: table){
            Forecast forecast = new Forecast();
            forecast.setTime(Integer.parseInt(element.getElementsByAttributeValue("class", "trans-num").text()));
            forecast.setRoute(element.getElementsByAttributeValue("class", "trans-name").select("a").text());
            forecast.setTransportVehicle(element.getElementsByAttributeValue("class", "trans-model").getFirst().ownText());
            forecast.setTransportPosition(element.getElementsByAttributeValue("class", "trans-position").text());
            forecasts.add(forecast);

        }
        return forecasts;
    }

}



















