package com.stulikov.public_transport_stops_on_spring.experiments.console;


import com.stulikov.public_transport_stops_on_spring.stop.StopXmlUnmarshall;
import com.stulikov.public_transport_stops_on_spring.transformation.Unmarshalling;
import jakarta.xml.bind.JAXBException;


import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class IOCTest {
    public static void main(String[] args) throws MalformedURLException, JAXBException {
        URL urlStops = new URL("https://tosamara.ru/api/v2/classifiers/stopsFullDB.xml");
         List<StopXmlUnmarshall> listStopsFromURL = Unmarshalling.unmarshallXmlStops(urlStops).getListStopXmlUnmarshall();

//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        marshaller.setClassesToBeBound(Person.class);

    }
}
