package com.newicom.zk6playground.repository.log;

import com.newicom.zk6playground.model.LogEntry;
import com.newicom.zk6playground.repository.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Pawel Kaczor
 */
@org.springframework.stereotype.Repository
public class InMemoryLogEntryRepository implements Repository<LogEntry> {

    private final List<LogEntry> logEntryStore = new ArrayList<LogEntry>();

    @PostConstruct
    public void addDummyData() {
        add(new LogEntry("Ah, not yet."));
        add(new LogEntry("OK, done!"));
        add(new LogEntry("Hmm... ClassCastException..."));
        add(new LogEntry("Got response, have to write a simple app. A piece of cake."));
        add(new LogEntry("Sending my CV to SoftwareMill. Fingers crossed."));
    }

    @Override
    public List<LogEntry> getAll() {
        return Collections.unmodifiableList(logEntryStore);
    }

    @Override
    public void add(LogEntry entity) {
        logEntryStore.add(entity);
    }
}
