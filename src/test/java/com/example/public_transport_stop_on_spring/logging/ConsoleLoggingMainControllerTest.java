package com.example.public_transport_stop_on_spring.logging;

import com.stulikov.public_transport_stops_on_spring.PublicTransportStopOnSpringApplication;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@ContextConfiguration(classes = {PublicTransportStopOnSpringApplication.class})
public class ConsoleLoggingMainControllerTest {

    @Test
    public void recordAfterThrowingInMethodTest(){

    }
}
