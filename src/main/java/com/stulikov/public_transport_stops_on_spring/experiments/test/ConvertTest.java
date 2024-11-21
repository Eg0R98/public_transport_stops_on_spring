package com.stulikov.public_transport_stops_on_spring.experiments.test;

import com.stulikov.public_transport_stops_on_spring.stop.StopXmlUnmarshall;
import jakarta.xml.bind.JAXBException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.net.MalformedURLException;

public class ConvertTest {
    public static void main(String[] args) throws MalformedURLException, JAXBException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        StopXmlUnmarshall stopXmlUnmarshall = context.getBean("stopXmlUnmarshallBean",StopXmlUnmarshall.class);

//        URL urlStops = new URL("https://tosamara.ru/api/v2/classifiers/stopsFullDB.xml");
//        StopsXmlUnmarshallRepository repository = Unmarshalling.unmarshallXmlStops(urlStops);
//        List<Stop> stops = ConvertingStopXmlUnmarshallToStop.convertUsingBeans(repository.getListStopXmlUnmarshall());



    }
}
