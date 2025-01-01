package com.stulikov.public_transport_stops_on_spring.jpa.hybernate;

public interface TimeUpdateDBRepository {
    void upsertTimeUpdateToTable(Double timeUpdate);

    Double selectTimeUpdateFromTable();
}
