package com.stulikov.public_transport_stops_on_spring.experiments.xmlSpring;




import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Processor {

    // Class data members
//    private Marshaller marshaller;
//    private Unmarshaller unmarshaller;

    // Setter
//    public void setMarshaller(Marshaller marshaller) {
//        this.marshaller = marshaller;
//    }
//
//    public void setUnmarshaller(Unmarshaller unmarshaller) {
//        this.unmarshaller = unmarshaller;
//    }
    // Converting Object to XML file
    public void objectToXML(String fileName, Object graph) throws IOException {
        FileOutputStream fos = null;

        // Try block to check for exceptions
        try {
            fos = new FileOutputStream(fileName);
//            marshaller.marshal(graph, new StreamResult(fos));
        }

        // finally block that will execute for sure
        finally {

            // Closing the connections
            fos.close();
        }
    }
    // Method
    // To Convert XML to Java Object
    public Object xmlToObject(String fileName) throws IOException {

        FileInputStream fis = null;

        // Try block to check for exceptions
//        try {
//            fis = new FileInputStream(fileName);
//            return unmarshaller.unmarshal(new StreamSource(fis));
//        }
//
//        // finally block that will execute for sure
//        finally {
//
//            // Closing the connections
//            fis.close();
//        }
        return null;
    }
}
