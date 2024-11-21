package com.stulikov.public_transport_stops_on_spring.cache;

import com.stulikov.public_transport_stops_on_spring.forecast.Forecast;

import java.time.Instant;
import java.util.List;

public class CacheItem {

    private Instant instantStart;
    private List<Forecast> forecasts;

    CacheItem(List<Forecast> forecasts) {
        this.instantStart = Instant.now();
        this.forecasts = forecasts;
    }

    public Instant getInstantStart() {
        return instantStart;
    }

    public List<Forecast> getForecasts() {
        return forecasts;
    }

    public void setForecasts(List<Forecast> forecasts) {
        this.forecasts = forecasts;
    }
}
