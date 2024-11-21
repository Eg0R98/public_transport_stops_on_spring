package com.stulikov.public_transport_stops_on_spring.hybernate;

import com.stulikov.public_transport_stops_on_spring.stop.StopXmlUnmarshall;

import java.util.List;

public interface StopsDBRepository {
     void upsertListStopsToTable(List<StopXmlUnmarshall> listStops);
     List<StopXmlUnmarshall> selectListStopsFromTable();


}
