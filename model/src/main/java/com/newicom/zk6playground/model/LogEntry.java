package com.newicom.zk6playground.model;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Pawel Kaczor
 */
public class LogEntry implements Serializable {

    private static final long serialVersionUID = 3036488481303369588L;

    private final String id;
    private String message;

    public LogEntry() {
        this.id = UUID.randomUUID().toString();
    }

    public LogEntry(String message) {
        this();
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        LogEntry logEntry = (LogEntry) o;

        if (!id.equals(logEntry.id)) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}