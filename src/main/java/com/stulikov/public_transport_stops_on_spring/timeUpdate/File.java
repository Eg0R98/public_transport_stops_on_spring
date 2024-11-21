package com.stulikov.public_transport_stops_on_spring.timeUpdate;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "file")
@XmlAccessorType(XmlAccessType.FIELD)
public class File {

    @XmlAttribute(name = "name")
    private String name;
    @XmlElement(name = "modified")
    private Double modified;

    public String getName() {
        return name;
    }

    public Double getModified() {
        return modified;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setModified(Double modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "File{" +
                "name='" + name + '\'' +
                ", modified=" + modified +
                '}';
    }
}
