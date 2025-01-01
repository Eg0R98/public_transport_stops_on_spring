package com.example.public_transport_stop_on_spring.repositories;

import com.stulikov.public_transport_stops_on_spring.PublicTransportStopOnSpringApplication;
import com.stulikov.public_transport_stops_on_spring.jpa.repositories.TimeUpdateCustomRepository;
import com.stulikov.public_transport_stops_on_spring.timeUpdate.Classifiers;
import com.stulikov.public_transport_stops_on_spring.timeUpdate.TimeUpdateItem;
import com.stulikov.public_transport_stops_on_spring.transformation.Unmarshalling;
import jakarta.xml.bind.JAXBException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {PublicTransportStopOnSpringApplication.class})
public class TimeUpdateCustomRepositoryTest {

    private URL urlTimeUpdate = new URL("https://tosamara.ru/api/v2/classifiers");

    @Autowired
    private TimeUpdateCustomRepository repository;

    private Classifiers classifiers;

    public TimeUpdateCustomRepositoryTest() throws MalformedURLException {
    }

    @Test
    public void saveTest() throws JAXBException {
//        repository.deleteAll();
        classifiers = Unmarshalling.unmarshallTimeUpdate(urlTimeUpdate);
        Double newTimeUpdate = classifiers.getTimeUpdate();
        Optional<TimeUpdateItem> oldTimeUpdate = repository.findById(1);
        if (oldTimeUpdate.isPresent()) {
            TimeUpdateItem oldTimeUpdateItem = oldTimeUpdate.get();
            oldTimeUpdateItem.setTimeUpdate(newTimeUpdate);
            repository.save(oldTimeUpdateItem);
        }



    }
}
