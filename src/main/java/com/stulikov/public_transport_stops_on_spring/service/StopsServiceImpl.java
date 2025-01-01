package com.stulikov.public_transport_stops_on_spring.service;

import com.stulikov.public_transport_stops_on_spring.jpa.repositories.StopCustomRepository;
import com.stulikov.public_transport_stops_on_spring.stop.ConvertingStopXmlUnmarshallToStop;
import com.stulikov.public_transport_stops_on_spring.stop.Stop;
import com.stulikov.public_transport_stops_on_spring.stop.StopXmlUnmarshall;
import com.stulikov.public_transport_stops_on_spring.stop.Stops;
import com.stulikov.public_transport_stops_on_spring.transformation.Unmarshalling;
import io.micrometer.core.annotation.Timed;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Service("StopsServiceImplBean")
public class StopsServiceImpl implements StopsService {

    private TimeUpdateService timeUpdateService;

    StopCustomRepository repository;

    private URL urlStops = new URL("https://tosamara.ru/api/v2/classifiers/stopsFullDB.xml");

    private List<StopXmlUnmarshall> listStopsFromURL = Unmarshalling.unmarshallXmlStops(urlStops).getListStopXmlUnmarshall();

    @Autowired
    public StopsServiceImpl(StopCustomRepository repository,
                                    @Qualifier("TimeUpdateImplBean") TimeUpdateService timeUpdateService) throws MalformedURLException, JAXBException {
        this.repository = repository;
        this.timeUpdateService = timeUpdateService;
    }

    public void update() {
            repository.saveAll(listStopsFromURL);
    }

    @Override
    @Timed(value = "loadStops.timer", description = "measuring the execution time of a method loadStops()")
    public void loadStops() throws JAXBException {
        if (timeUpdateService.updateOrNot()) update();
        List<StopXmlUnmarshall> listStopsFromDataBase = (List<StopXmlUnmarshall>) repository.findAll();
        List<Stop> stops = ConvertingStopXmlUnmarshallToStop.convert(listStopsFromDataBase);
        Stops.setListStops(stops);
    }
}

