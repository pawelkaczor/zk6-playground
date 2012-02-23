package com.newicom.zk6playground.service.log;

import com.newicom.zk6playground.model.LogEntry;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

/**
 * @author Pawel Kaczor
 */
public class DummyLogServiceTest {

    private LogService logService;

    @Before
    public void initializeLogService() {
        logService = DummyLogService.getInstance();
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
