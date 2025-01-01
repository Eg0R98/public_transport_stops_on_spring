package com.stulikov.public_transport_stops_on_spring.service;


import com.stulikov.public_transport_stops_on_spring.jpa.repositories.TimeUpdateCustomRepository;
import com.stulikov.public_transport_stops_on_spring.timeUpdate.Classifiers;
import com.stulikov.public_transport_stops_on_spring.timeUpdate.TimeUpdateItem;
import com.stulikov.public_transport_stops_on_spring.transformation.Unmarshalling;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;

@Service("TimeUpdateImplBean")
public class TimeUpdateServiceImpl implements TimeUpdateService {

    private URL urlTimeUpdate = new URL("https://tosamara.ru/api/v2/classifiers");

    private TimeUpdateCustomRepository repository;

    private Classifiers classifiers;

    @Autowired
    public TimeUpdateServiceImpl(TimeUpdateCustomRepository repository) throws MalformedURLException {
        this.repository = repository;
    }

    public TimeUpdateServiceImpl() throws MalformedURLException {
    }

    @Override
    public boolean updateOrNot() throws JAXBException {
        classifiers = Unmarshalling.unmarshallTimeUpdate(urlTimeUpdate);
        Optional<TimeUpdateItem> oldTimeUpdateOpt = repository.findById(1);
        Double newTimeUpdate = classifiers.getTimeUpdate();
        if(oldTimeUpdateOpt.isPresent()){
            TimeUpdateItem oldTimeUpdateItem = oldTimeUpdateOpt.get();
            if (newTimeUpdate > oldTimeUpdateItem.getTimeUpdate()) {
                oldTimeUpdateItem.setTimeUpdate(newTimeUpdate);
                repository.save(oldTimeUpdateItem);
                return true;
            }
        }
        return false;
    }
}


