package com.newicom.zk6playground.service.log;

import com.newicom.zk6playground.model.LogEntry;
import com.newicom.zk6playground.repository.Repository;
import com.newicom.zk6playground.repository.log.InMemoryLogEntryRepository;
import org.apache.commons.lang3.Validate;

import java.util.List;

/**
 * @author Pawel Kaczor
 */
public class DummyLogService implements LogService {

    private Repository<LogEntry> repository;

    private static LogService instance;

    private DummyLogService() {
        repository = new InMemoryLogEntryRepository();
        repository.add(new LogEntry("Ah, not yet."));
        repository.add(new LogEntry("OK, done!"));
        repository.add(new LogEntry("Hmm... ClassCastException..."));
        repository.add(new LogEntry("Got response, have to write a simple app. A piece of cake."));
        repository.add(new LogEntry("Sending my CV to SoftwareMill. Fingers crossed."));
    }

    static synchronized public LogService getInstance() {
        if (instance == null) {
            instance = new DummyLogService();
        }
        return instance;
    }

    @Override
    public void submitEntry(final LogEntry entry) {
        Validate.notNull(entry, "Log entry is null");
        Validate.notEmpty(entry.getMessage(), "Log message must not be empty");
        repository.add(entry);
    }

    @Override
    public List<LogEntry> getAll() {
        return repository.getAll();
    }


}
