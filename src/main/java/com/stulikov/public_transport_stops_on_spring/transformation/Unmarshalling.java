package com.stulikov.public_transport_stops_on_spring.transformation;

import com.stulikov.public_transport_stops_on_spring.stop.StopsXmlUnmarshallRepository;
import com.stulikov.public_transport_stops_on_spring.timeUpdate.Classifiers;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import java.net.URL;

public class Unmarshalling {

    public static StopsXmlUnmarshallRepository unmarshallXmlStops(URL urlStops) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(StopsXmlUnmarshallRepository.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        StopsXmlUnmarshallRepository stopsXmlUnmarshallRepository = (StopsXmlUnmarshallRepository) unmarshaller.unmarshal(urlStops);

        return stopsXmlUnmarshallRepository;
    }


    public static Classifiers unmarshallTimeUpdate(URL urlTimeUpdate) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Classifiers.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Classifiers classifiers = (Classifiers) unmarshaller.unmarshal(urlTimeUpdate);

        return classifiers;
    }

}
