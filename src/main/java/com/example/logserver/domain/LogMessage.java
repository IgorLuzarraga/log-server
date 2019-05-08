package com.example.logserver.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class LogMessage {
    @Id
    @GeneratedValue
    private Long id;

    private String log;

    public LogMessage(){}
    public LogMessage(String log){
        this.log = log;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogMessage that = (LogMessage) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(log, that.log);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, log);
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "id=" + id +
                ", log='" + log + '\'' +
                '}';
    }
}
