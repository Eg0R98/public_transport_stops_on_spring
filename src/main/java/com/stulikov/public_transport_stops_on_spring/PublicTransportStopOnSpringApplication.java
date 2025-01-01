package com.stulikov.public_transport_stops_on_spring;

import com.stulikov.public_transport_stops_on_spring.exceptions.ConnectException;
import com.stulikov.public_transport_stops_on_spring.service.StopsService;
import com.stulikov.public_transport_stops_on_spring.service.StopsServiceImpl;
import jakarta.xml.bind.JAXBException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.io.IOException;
import java.sql.SQLException;

@SpringBootApplication
@EnableAspectJAutoProxy
public class PublicTransportStopOnSpringApplication implements CommandLineRunner {

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(PublicTransportStopOnSpringApplication.class, args);
    }

    @Override
    public void run(String... args)  {

        StopsService stopsService = applicationContext.getBean(StopsServiceImpl.class);

        try {
            stopsService.loadStops();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } catch (ConnectException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}




