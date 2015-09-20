package app.journal.Services;

import app.journal.Dao.JournalDao;
import app.journal.model.Journal;
import app.journal.model.Table;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.SecondaryTable;
import java.util.List;

/**
 * Created by Acer on 20.09.2015.
 */
@Service
public class JournalServicesImpl  implements  JournalServices{

    private JournalDao journalDao;

    public void setJournalDao(JournalDao journalDao) {
        this.journalDao = journalDao;
    }

    @Override
    @Transactional
    public void addJournal(Journal journal) {
        this.journalDao.addJournal(journal);
    }

    @Override
    @Transactional
    public List<Table> listJournal() {
        return this.journalDao.listJournal();
    }

    @Override
    @Transactional
    public void update(Journal journal) {
          this.journalDao.update(journal);
    }

    @Override
    @Transactional
    public void delete(int id) {
      this.journalDao.delete(id);
    }

    @Override
    @Transactional
    public Journal getById(int id) {
        return this.journalDao.getById(id);
    }
}
