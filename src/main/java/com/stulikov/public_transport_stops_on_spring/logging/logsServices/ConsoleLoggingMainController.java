package com.stulikov.public_transport_stops_on_spring.logging.logsServices;

import com.stulikov.public_transport_stops_on_spring.MainController;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


@Profile("consoleLoggingMainController")
@Component("consoleLoggingMainControllerBean")
public class ConsoleLoggingMainController implements Logging {

    private final Logger logger = LoggerFactory.getLogger(MainController.class);

    @Override
    public void recordBeforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Вызов метода {}", methodName);
    }

    @Override
    public void recordAfterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.info("Метод: {} успешно выполнен", methodName);
    }

    @Override
    public void recordAfterThrowingInMethod(JoinPoint joinPoint, Throwable ex) {
        String methodName = joinPoint.getSignature().getName();
        String exceptionClassName = ex.getClass().getSimpleName();
        StackTraceElement[] stackTraceElements = ex.getStackTrace();
        int lineNumber = stackTraceElements[0].getLineNumber();
        logger.error("В методе {} возникло исключение {}, строка {}", methodName, exceptionClassName, lineNumber);
    }
}
