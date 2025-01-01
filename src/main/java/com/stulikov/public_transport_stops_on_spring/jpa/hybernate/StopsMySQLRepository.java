package com.stulikov.public_transport_stops_on_spring.jpa.hybernate;

import com.stulikov.public_transport_stops_on_spring.stop.StopXmlUnmarshall;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("stopsMySQLRepositoryBean")
public class StopsMySQLRepository implements StopsDBRepository {

    @PersistenceContext(name = "persistence")
    private EntityManager entityManager;

    @Transactional
    public void upsertListStopsToTable(List<StopXmlUnmarshall> listStops) {
        String query = "REPLACE INTO STOPS(ID, TITLE, ADJACENT_STREET, DIRECTION, BUSES_MUNICIPAL, BUSES_COMMERCIAL, BUSES_PRIGOROD, BUSES_SEASON, BUSES_SPECIAL, " +
                "BUSES_INTERCITY, TRAMS, TROLLEYBUSES, METROS, ELECTRIC_TRAINS, RIVER_TRANSPORTS) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Query nativeQuery = entityManager.createNativeQuery(query, StopXmlUnmarshall.class);
        for (StopXmlUnmarshall stop : listStops) {
            nativeQuery.setParameter(1, stop.getStopID());
            nativeQuery.setParameter(2, stop.getTitle());
            nativeQuery.setParameter(3, stop.getAdjacentStreet());
            nativeQuery.setParameter(4, stop.getDirection());
            nativeQuery.setParameter(5, stop.getBusesMunicipal());
            nativeQuery.setParameter(6, stop.getBusesCommercial());
            nativeQuery.setParameter(7, stop.getBusesPrigorod());
            nativeQuery.setParameter(8, stop.getBusesSeason());
            nativeQuery.setParameter(9, stop.getBusesSpecial());
            nativeQuery.setParameter(10, stop.getBusesIntercity());
            nativeQuery.setParameter(11, stop.getTrams());
            nativeQuery.setParameter(12, stop.getTrolleybuses());
            nativeQuery.setParameter(13, stop.getMetros());
            nativeQuery.setParameter(14, stop.getElectricTrains());
            nativeQuery.setParameter(15, stop.getRiverTransports());
            nativeQuery.executeUpdate();
        }
    }

    @Transactional
    public List<StopXmlUnmarshall> selectListStopsFromTable() {
        return entityManager.createQuery("from StopXmlUnmarshall", StopXmlUnmarshall.class).getResultList();
    }

}


