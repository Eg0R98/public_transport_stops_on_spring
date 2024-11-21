package com.stulikov.public_transport_stops_on_spring.timeUpdate;

import jakarta.xml.bind.JAXBException;

import java.io.IOException;
import java.sql.SQLException;

public interface TimeUpdate {
    boolean updateOrNot() throws IOException, JAXBException, SQLException, ClassNotFoundException;
}
