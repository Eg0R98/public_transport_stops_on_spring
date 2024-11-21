package com.stulikov.public_transport_stops_on_spring.forecast;

public class Forecast {

  private int time;

  private String route;

  private String transportVehicle;

  private String transportPosition;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getTransportVehicle() {
        return transportVehicle;
    }

    public void setTransportVehicle(String transportVehicle) {
        this.transportVehicle = transportVehicle;
    }

    public String getTransportPosition() {
        return transportPosition;
    }

    public void setTransportPosition(String transportPosition) {
        this.transportPosition = transportPosition;
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "time=" + time +
                ", route='" + route + '\'' +
                ", transportVehicle='" + transportVehicle + '\'' +
                ", transportPosition='" + transportPosition + '\'' +
                '}';
    }
}
