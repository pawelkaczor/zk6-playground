package com.newicom.zk6playground.service.log;

import com.newicom.zk6playground.model.LogEntry;
import com.newicom.zk6playground.repository.log.InMemoryLogEntryRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Pawel Kaczor
 */
public class DefaultLogServiceTest {

    private DefaultLogService logService;

    @Before
    public void initializeLogService() {
        logService = new DefaultLogService();
        logService.setRepository(new InMemoryLogEntryRepository());
    }

    @Test
    public void shouldSubmitValidEntry() {
        // when
        LogEntry entry = new LogEntry("some message");
        logService.submitEntry(entry);

        // then
        assertTrue(logService.getAll().contains(entry));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldFailSubmittingEmptyEntry() {
        // when
        LogEntry entry = new LogEntry("");
        logService.submitEntry(entry);
    }

    @Test(expected = NullPointerException.class)
    public void shouldFailSubmittingNullMessage() {
        // when
        LogEntry entry = new LogEntry();
        logService.submitEntry(entry);
    }
}
