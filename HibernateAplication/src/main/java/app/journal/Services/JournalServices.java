package app.journal.Services;

import app.journal.model.Journal;
import app.journal.model.Table;

import java.util.List;

/**
 * Created by Acer on 20.09.2015.
 */
public interface JournalServices {
    public void addJournal(Journal journal);
    public List<Table> listJournal();
    public void update(Journal journal);
    public void delete(int id);

    public Journal getById(int id);
}
