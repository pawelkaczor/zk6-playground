package com.newicom.zk6playground.web.log;

import com.newicom.zk6playground.model.LogEntry;
import com.newicom.zk6playground.service.log.DummyLogService;
import com.newicom.zk6playground.service.log.LogService;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zul.ListModel;
import org.zkoss.zul.ListModelList;

/**
 * @author Pawel Kaczor
 */
public class LogVM {

    private LogEntry newEntry;

    private ListModelList<LogEntry> entries;

    private LogService logService = DummyLogService.getInstance();

    public ListModel<LogEntry> getEntries() {
        if (entries == null) {
            entries = new ListModelList<LogEntry>(getLogService().getAll());
        }
        return entries;
    }

    public LogEntry getNewEntry() {
        if (newEntry == null) {
            newEntry = new LogEntry();
        }
        return newEntry;
    }

    @Command
    @NotifyChange({"newEntry, entries"})
    public void submit() {
        if (newEntry != null) {
            logService.submitEntry(newEntry);
            entries.add(newEntry);
            newEntry = null;
        }
    }

    public LogService getLogService() {
        return logService;
    }

    public void setLogService(LogService logService) {
        this.logService = logService;
    }
}