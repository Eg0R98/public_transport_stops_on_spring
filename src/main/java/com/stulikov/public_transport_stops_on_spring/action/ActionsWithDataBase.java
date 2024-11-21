package com.stulikov.public_transport_stops_on_spring.action;


import com.stulikov.public_transport_stops_on_spring.exceptions.ConnectException;
import com.stulikov.public_transport_stops_on_spring.hybernate.StopsDBRepository;
import com.stulikov.public_transport_stops_on_spring.stop.ConvertingStopXmlUnmarshallToStop;
import com.stulikov.public_transport_stops_on_spring.stop.Stop;
import com.stulikov.public_transport_stops_on_spring.stop.StopXmlUnmarshall;
import com.stulikov.public_transport_stops_on_spring.stop.Stops;
import com.stulikov.public_transport_stops_on_spring.timeUpdate.TimeUpdate;
import com.stulikov.public_transport_stops_on_spring.transformation.Unmarshalling;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;

@Component("actionsWithDataBaseBean")
public class ActionsWithDataBase implements Actions  {

    private TimeUpdate timeUpdate;

    private StopsDBRepository stopsDBRepository;

    private URL urlStops = new URL("https://tosamara.ru/api/v2/classifiers/stopsFullDB.xml");

    private List<StopXmlUnmarshall> listStopsFromURL = Unmarshalling.unmarshallXmlStops(urlStops).getListStopXmlUnmarshall();

    @Autowired
    public ActionsWithDataBase(@Qualifier("stopsMySQLRepositoryBean") StopsDBRepository stopsDBRepository,
                               @Qualifier("timeUpdateUsingDataBaseBean") TimeUpdate timeUpdate) throws MalformedURLException, JAXBException {
        this.stopsDBRepository = stopsDBRepository;
        this.timeUpdate = timeUpdate;
    }

    public void update() {
            stopsDBRepository.upsertListStopsToTable(listStopsFromURL);
    }

    @Override
    public void loadStops() throws ClassNotFoundException, JAXBException, ConnectException, IOException, SQLException {
        if (timeUpdate.updateOrNot()) update();
        List<StopXmlUnmarshall> listStopsFromDataBase = stopsDBRepository.selectListStopsFromTable();
        List<Stop> stops = ConvertingStopXmlUnmarshallToStop.convert(listStopsFromDataBase);
        Stops.setListStops(stops);
    }
}


