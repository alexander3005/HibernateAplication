package app.journal.Services;

/**
 * Created by Acer on 20.09.2015.
 */


import app.journal.Dao.JournalDao;
import app.student.Model.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class JournalServicesImpl implements JournalServices{

    private JournalDao journalDao;

    public void setJournalDao(JournalDao journalDao) {
        this.journalDao = journalDao;
    }

    @Override
    @Transactional
    public List<Student> getALL() {
        return this.journalDao.getALL();
    }
    @Override
    @Transactional
    public void delete(int id){
        this.journalDao.delete(id);
    }
}