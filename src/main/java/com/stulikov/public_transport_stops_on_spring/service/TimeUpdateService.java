package com.stulikov.public_transport_stops_on_spring.service;

import jakarta.xml.bind.JAXBException;

public interface TimeUpdateService {
    boolean updateOrNot() throws  JAXBException;
}
