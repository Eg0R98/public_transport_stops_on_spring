package com.example.public_transport_stop_on_spring.repositories;

import com.stulikov.public_transport_stops_on_spring.PublicTransportStopOnSpringApplication;
import com.stulikov.public_transport_stops_on_spring.jpa.repositories.StopCustomRepository;
import com.stulikov.public_transport_stops_on_spring.stop.StopXmlUnmarshall;
import com.stulikov.public_transport_stops_on_spring.transformation.Unmarshalling;
import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {PublicTransportStopOnSpringApplication.class})
public class StopCustomRepositoryTest {

    @Autowired
    private StopCustomRepository repository;

    URL urlStops = new URL("https://tosamara.ru/api/v2/classifiers/stopsFullDB.xml");

    private List<StopXmlUnmarshall> stops = Unmarshalling.unmarshallXmlStops(urlStops).getListStopXmlUnmarshall();

    public StopCustomRepositoryTest() throws JAXBException, MalformedURLException {
    }


    @Test
    @Transactional
    public void findAllTest() {

        List<StopXmlUnmarshall> all = (List<StopXmlUnmarshall>) repository.findAll();

        all.forEach(System.out::println);

    }

    @Test
    @Transactional
    public void saveTest() {
        repository.saveAll(stops);
    }

    @Test
    @Transactional
    public void deleteTest() {
        repository.deleteAll();
    }


}
