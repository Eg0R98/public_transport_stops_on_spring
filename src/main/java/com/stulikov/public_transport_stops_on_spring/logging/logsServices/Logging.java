package com.stulikov.public_transport_stops_on_spring.logging.logsServices;

import org.aspectj.lang.JoinPoint;

public interface Logging {
     void recordBeforeMethod(JoinPoint joinPoint);

     void recordAfterMethod(JoinPoint joinPoint);

     void recordAfterThrowingInMethod(JoinPoint joinPoint, Throwable ex);
}
