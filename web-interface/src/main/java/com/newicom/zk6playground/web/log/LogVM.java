package com.newicom.zk6playground.web.log;

import com.newicom.zk6playground.model.LogEntry;
import com.newicom.zk6playground.service.log.DefaultLogService;
import com.newicom.zk6playground.service.log.LogService;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;

/**
 * @author Pawel Kaczor
 */
public class LogVM {

    private LogEntry newEntry;

    private ListModelList<LogEntry> entries = new ListModelList<LogEntry>();

    @WireVariable
    private LogService logService;

    @Init
    public void initialize() {
        entries.addAll(getLogService().getAll());
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
        submitEntry(newEntry);
        setNewEntry(null);
    }

    private void submitEntry(LogEntry entry) {
        logService.submitEntry(entry);
        entries.add(entry);
    }

    public LogService getLogService() {
        return logService;
    }

    public void setLogService(LogService logService) {
        this.logService = logService;
    }

    public ListModelList<LogEntry> getEntries() {
        return entries;
    }

    void setNewEntry(LogEntry newEntry) {
        this.newEntry = newEntry;
    }

}