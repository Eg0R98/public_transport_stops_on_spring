package com.stulikov.public_transport_stops_on_spring.logging.logsServices;

import com.stulikov.public_transport_stops_on_spring.jpa.repositories.LogEntityRepository;
import com.stulikov.public_transport_stops_on_spring.logging.LogEntity;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("dbLogging")
@Component("dbLoggingBean")
public class DBLogging implements Logging {

    private LogEntityRepository repository;

    @Autowired
    public DBLogging(LogEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public void recordBeforeMethod(JoinPoint joinPoint) {
        LogEntity logEntity = new LogEntity();
        logEntity.setThread(Thread.currentThread().getName());
        logEntity.setLevel("INFO");
        logEntity.setClassName(joinPoint.getTarget().getClass().getCanonicalName());
        String methodName = joinPoint.getSignature().getName();
        String message = String.format("Вызов метода %s ", methodName);
        logEntity.setMessage(message);
        repository.save(logEntity);
    }

    @Override
    public void recordAfterMethod(JoinPoint joinPoint) {
        LogEntity logEntity = new LogEntity();
        logEntity.setThread(Thread.currentThread().getName());
        logEntity.setLevel("INFO");
        logEntity.setClassName(joinPoint.getTarget().getClass().getCanonicalName());
        String methodName = joinPoint.getSignature().getName();
        String message = String.format("Успешное завершение метода %s", methodName);
        logEntity.setMessage(message);
        repository.save(logEntity);
    }

    @Override
    public void recordAfterThrowingInMethod(JoinPoint joinPoint, Throwable ex) {
        LogEntity logEntity = new LogEntity();
        logEntity.setThread(Thread.currentThread().getName());
        logEntity.setLevel("ERROR");
        logEntity.setClassName(joinPoint.getTarget().getClass().getCanonicalName());
        String methodName = joinPoint.getSignature().getName();
        String exceptionClassName = ex.getClass().getSimpleName();
        StackTraceElement[] stackTraceElements = ex.getStackTrace();
        int lineNumber = stackTraceElements[0].getLineNumber();
        String message = String.format("Выброшено исключение %s в методе %s, строка %d", exceptionClassName, methodName, lineNumber);
        logEntity.setMessage(message);
        repository.save(logEntity);
    }
}
