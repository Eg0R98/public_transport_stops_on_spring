package com.stulikov.public_transport_stops_on_spring.timeUpdate;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "classifiers")
@XmlAccessorType(XmlAccessType.FIELD)
public class Classifiers {

    @XmlElement(name = "file")
    private List<File> filesWithTimeUpdate = new ArrayList<>();

    public Double getTimeUpdate() {
        Double modified = null;

        for (File file : filesWithTimeUpdate) {
            if (file.getName().equals("stopsFullDB.xml")) {
                modified = file.getModified();
                break;
            }
        }
        return modified;
    }
}
