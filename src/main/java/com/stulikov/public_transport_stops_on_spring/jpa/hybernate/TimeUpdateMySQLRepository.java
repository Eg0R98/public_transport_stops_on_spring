package com.stulikov.public_transport_stops_on_spring.jpa.hybernate;

import com.stulikov.public_transport_stops_on_spring.stop.StopXmlUnmarshall;
import com.stulikov.public_transport_stops_on_spring.timeUpdate.TimeUpdateItem;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository("timeUpdateMySQLRepositoryBean")
public class TimeUpdateMySQLRepository implements TimeUpdateDBRepository {

    @PersistenceContext(name = "persistence")
    private EntityManager entityManager;

    @Transactional
    public void upsertTimeUpdateToTable(Double timeUpdate) {
        String query = "REPLACE INTO TIME_UPDATE(ID, TIME) VALUES(?, ?)";
        Query nativeQuery = entityManager.createNativeQuery(query, StopXmlUnmarshall.class);
        nativeQuery.setParameter(1, 1);
        nativeQuery.setParameter(2, timeUpdate);
        nativeQuery.executeUpdate();
    }

    @Transactional
    public Double selectTimeUpdateFromTable() {
        TimeUpdateItem timeUpdateItem = entityManager.find(TimeUpdateItem.class, 1);
        return timeUpdateItem.getTimeUpdate();

    }
}

