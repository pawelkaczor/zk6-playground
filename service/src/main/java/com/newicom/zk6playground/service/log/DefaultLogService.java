package com.newicom.zk6playground.service.log;

import com.newicom.zk6playground.model.LogEntry;
import com.newicom.zk6playground.repository.Repository;
import org.apache.commons.lang3.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Pawel Kaczor
 */
@Service("logService")
public class DefaultLogService implements LogService {

    @Autowired
    private Repository<LogEntry> repository;

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

    void setRepository(Repository<LogEntry> repository) {
        this.repository = repository;
    }
}
