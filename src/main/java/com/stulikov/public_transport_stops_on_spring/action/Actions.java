package com.stulikov.public_transport_stops_on_spring.action;


import com.stulikov.public_transport_stops_on_spring.exceptions.ConnectException;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.sql.SQLException;


public interface Actions {
    void update() throws ClassNotFoundException, ConnectException;

    void loadStops() throws ClassNotFoundException, JAXBException, ConnectException, SQLException, IOException;
}
