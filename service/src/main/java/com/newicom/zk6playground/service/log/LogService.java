package com.newicom.zk6playground.service.log;

import com.newicom.zk6playground.model.LogEntry;

import java.util.List;

/**
 * @author Pawel Kaczor
 */
public interface LogService {

    void submitEntry(LogEntry entry);

    List<LogEntry> getAll();
}
