package com.stulikov.public_transport_stops_on_spring.logging;

import jakarta.persistence.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component("logEntityBean")
@Scope("prototype")
@Entity
@Table(name = "LOGS")
public class LogEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATE")
    private LocalDate date = LocalDate.now();

    @Column(name = "TIME")
    private LocalTime time = LocalTime.now();

    @Column(name = "THREAD")
    private String thread;

    @Column(name = "LEVEL")
    private String level;

    @Column(name = "CLASS-NAME")
    private String className;

    @Column(name = "MESSAGE")
    private String message;

    public String getThread() {
        return thread;
    }

    public void setThread(String thread) {
        this.thread = thread;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
