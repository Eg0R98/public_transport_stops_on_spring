package com.stulikov.public_transport_stops_on_spring;

import com.stulikov.public_transport_stops_on_spring.action.Actions;
import com.stulikov.public_transport_stops_on_spring.action.ActionsWithDataBase;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.net.MalformedURLException;

@SpringBootApplication
public class PublicTransportStopOnSpringApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) throws MalformedURLException, JAXBException {
        SpringApplication.run(PublicTransportStopOnSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Actions actions = applicationContext.getBean(ActionsWithDataBase.class);
        actions.loadStops();
    }
}
