package com.stulikov.public_transport_stops_on_spring.logging;

import com.stulikov.public_transport_stops_on_spring.logging.logsServices.Logging;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class LoggingAspect {

    private Logging logging;

    @Autowired
    public LoggingAspect(Logging logging) {
        this.logging = logging;
    }


    @Before("execution(public String com.stulikov.public_transport_stops_on_spring.MainController.*(..))")
    public void logMethodCall(JoinPoint joinPoint) {
        logging.recordBeforeMethod(joinPoint);
    }

    @AfterReturning("execution(public String com.stulikov.public_transport_stops_on_spring.MainController.*(..))")
    public void logAfterSuccessfulExecution(JoinPoint joinPoint) {
        logging.recordAfterMethod(joinPoint);
    }

    @AfterThrowing("execution(public String com.stulikov.public_transport_stops_on_spring.MainController.*(..))")
    public void logAfterException(JoinPoint joinPoint, Throwable ex) {
        logging.recordAfterThrowingInMethod(joinPoint, ex);
    }
}
