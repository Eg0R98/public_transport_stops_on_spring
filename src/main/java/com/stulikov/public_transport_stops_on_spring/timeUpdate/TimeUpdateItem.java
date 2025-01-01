package com.stulikov.public_transport_stops_on_spring.timeUpdate;

import jakarta.persistence.*;

@Entity
@Table(name = "TIME_UPDATE")
public class TimeUpdateItem {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "TIME")
    private Double timeUpdate;

    public Double getTimeUpdate() {
        return timeUpdate;
    }

    public void setTimeUpdate(Double timeUpdate) {
        this.timeUpdate = timeUpdate;
    }

}
