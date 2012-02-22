package com.newicom.zk6playground.repository.log;

import com.newicom.zk6playground.model.LogEntry;
import com.newicom.zk6playground.repository.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Pawel Kaczor
 */
public class InMemoryLogEntryRepository implements Repository<LogEntry> {

    private final List<LogEntry> logEntryStore = new ArrayList<LogEntry>();

    @Override
    public List<LogEntry> getAll() {
        return Collections.unmodifiableList(logEntryStore);
    }

    @Override
    public void add(LogEntry entity) {
        logEntryStore.add(entity);
    }
}
