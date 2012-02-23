package com.newicom.zk6playground.web.log;

import com.newicom.zk6playground.model.LogEntry;
import com.newicom.zk6playground.service.log.LogService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.BDDMockito.given;

/**
 * @author Pawel Kaczor
 */
@RunWith(org.mockito.runners.MockitoJUnitRunner.class)
public class LogVMTest {

    private LogVM viewModelUnderTest;

    @Mock
    private LogService logService;

    @Before
    public void setupViewModel() {
        viewModelUnderTest = new LogVM();
        viewModelUnderTest.setLogService(logService);
    }

    @Test
    public void shouldInitialize() {
        // given
        List<LogEntry> initialEntries = new ArrayList<LogEntry>();
        given(logService.getAll()).willReturn(initialEntries);

        // when
        viewModelUnderTest.initialize();

        // then
        assertNotNull(viewModelUnderTest.getEntries());
        assertEquals(initialEntries, viewModelUnderTest.getEntries().getInnerList());
    }

    @Test
    public void shouldSubmitNotEmptyMessage() {
        // given
        viewModelUnderTest.initialize();

        LogEntry newEntry = new LogEntry("some message");
        viewModelUnderTest.setNewEntry(newEntry);

        // when
        viewModelUnderTest.submit();

        // then
        assertTrue("New entry is missing in entries!", viewModelUnderTest.getEntries().contains(newEntry));
        assertNotSame("New entry not cleared!", newEntry, viewModelUnderTest.getNewEntry());

    }

}
