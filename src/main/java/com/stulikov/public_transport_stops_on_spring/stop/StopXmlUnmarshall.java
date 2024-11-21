package com.stulikov.public_transport_stops_on_spring.stop;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Objects;

@XmlRootElement(name = "stop")
@XmlAccessorType(XmlAccessType.FIELD)
@Component("stopXmlUnmarshallBean")
@Scope("prototype")
@Entity
@Table(name = "STOPS")
public class StopXmlUnmarshall {

    @XmlElement(name = "KS_ID")
    @Id
    @Column(name = "ID")
    private int stopID;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "ADJACENT_STREET")
    private String adjacentStreet;

    @Column(name = "DIRECTION")
    private String direction;

    @Column(name = "BUSES_MUNICIPAL")
    private String busesMunicipal;

    @Column(name = "BUSES_COMMERCIAL")
    private String busesCommercial;

    @Column(name = "BUSES_PRIGOROD")
    private String busesPrigorod;

    @Column(name = "BUSES_SEASON")
    private String busesSeason;

    @Column(name = "BUSES_SPECIAL")
    private String busesSpecial;

    @Column(name = "BUSES_INTERCITY")
    private String busesIntercity;

    @Column(name = "TROLLEYBUSES")
    private String trolleybuses;

    @Column(name = "TRAMS")
    private String trams;

    @Column(name = "METROS")
    private String metros;

    @Column(name = "ELECTRIC_TRAINS")
    private String electricTrains;

    @Column(name = "RIVER_TRANSPORTS")
    private String riverTransports;


    public StopXmlUnmarshall(int stopID, String title, String adjacentStreet, String direction, String busesMunicipal,
                             String busesCommercial, String busesPrigorod, String busesSeason, String busesSpecial,
                             String busesIntercity, String trolleybuses, String trams, String metros,
                             String electricTrains, String riverTransports) {
        this.stopID = stopID;
        this.title = title;
        this.adjacentStreet = adjacentStreet;
        this.direction = direction;
        this.busesMunicipal = busesMunicipal;
        this.busesCommercial = busesCommercial;
        this.busesPrigorod = busesPrigorod;
        this.busesSeason = busesSeason;
        this.busesSpecial = busesSpecial;
        this.busesIntercity = busesIntercity;
        this.trolleybuses = trolleybuses;
        this.trams = trams;
        this.metros = metros;
        this.electricTrains = electricTrains;
        this.riverTransports = riverTransports;
    }

    protected StopXmlUnmarshall() {
    }

    protected String getBuses() {
        StringBuilder builder = new StringBuilder();
        if (!this.busesMunicipal.isEmpty()) builder.append(this.busesMunicipal).append(", ");
        if (!this.busesCommercial.isEmpty()) builder.append(this.busesCommercial).append(", ");
        if (!this.busesCommercial.isEmpty()) builder.append(this.busesCommercial).append(", ");
        if (!this.busesSeason.isEmpty()) builder.append(this.busesSeason).append(", ");
        if (!this.busesIntercity.isEmpty()) builder.append(this.busesIntercity).append(", ");
        if (!builder.isEmpty()) builder.delete(builder.length() - 2, builder.length() - 1);

        return builder.toString();
    }

    public int getStopID() {
        return stopID;
    }

    public void setStopID(int stopID) {
        this.stopID = stopID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdjacentStreet() {
        return adjacentStreet;
    }

    public void setAdjacentStreet(String adjacentStreet) {
        this.adjacentStreet = adjacentStreet;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getBusesMunicipal() {
        return busesMunicipal;
    }

    public void setBusesMunicipal(String busesMunicipal) {
        this.busesMunicipal = busesMunicipal;
    }

    public String getBusesCommercial() {
        return busesCommercial;
    }

    public void setBusesCommercial(String busesCommercial) {
        this.busesCommercial = busesCommercial;
    }

    public String getBusesPrigorod() {
        return busesPrigorod;
    }

    public void setBusesPrigorod(String busesPrigorod) {
        this.busesPrigorod = busesPrigorod;
    }

    public String getBusesSeason() {
        return busesSeason;
    }

    public void setBusesSeason(String busesSeason) {
        this.busesSeason = busesSeason;
    }

    public String getBusesSpecial() {
        return busesSpecial;
    }

    public void setBusesSpecial(String busesSpecial) {
        this.busesSpecial = busesSpecial;
    }

    public String getBusesIntercity() {
        return busesIntercity;
    }

    public void setBusesIntercity(String busesIntercity) {
        this.busesIntercity = busesIntercity;
    }

    public String getTrolleybuses() {
        return trolleybuses;
    }

    public void setTrolleybuses(String trolleybuses) {
        this.trolleybuses = trolleybuses;
    }

    public String getTrams() {
        return trams;
    }

    public void setTrams(String trams) {
        this.trams = trams;
    }

    public String getMetros() {
        return metros;
    }

    public void setMetros(String metros) {
        this.metros = metros;
    }

    public String getElectricTrains() {
        return electricTrains;
    }

    public void setElectricTrains(String electricTrains) {
        this.electricTrains = electricTrains;
    }

    public String getRiverTransports() {
        return riverTransports;
    }

    public void setRiverTransports(String riverTransports) {
        this.riverTransports = riverTransports;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StopXmlUnmarshall that = (StopXmlUnmarshall) o;
        return stopID == that.stopID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(stopID);
    }

    @Override
    public String toString() {
        return "StopXmlUnmarshall{" +
                "stopID=" + stopID +
                ", title='" + title + '\'' +
                ", adjacentStreet='" + adjacentStreet + '\'' +
                ", direction='" + direction + '\'' +
                ", busesMunicipal='" + busesMunicipal + '\'' +
                ", busesCommercial='" + busesCommercial + '\'' +
                ", busesPrigorod='" + busesPrigorod + '\'' +
                ", busesSeason='" + busesSeason + '\'' +
                ", busesSpecial='" + busesSpecial + '\'' +
                ", busesIntercity='" + busesIntercity + '\'' +
                ", trolleybuses='" + trolleybuses + '\'' +
                ", trams='" + trams + '\'' +
                ", metros='" + metros + '\'' +
                ", electricTrains='" + electricTrains + '\'' +
                ", riverTransports='" + riverTransports + '\'' +
                '}';
    }
}
