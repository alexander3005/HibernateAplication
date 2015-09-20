package app.journal.Dao;

import app.journal.model.Journal;
import app.journal.model.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Acer on 20.09.2015.
 */
@Repository
public class JournalDaoImpl implements  JournalDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addJournal(Journal journal) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(journal);
    }

    @Override
    public List<Table> listJournal() {
        Session session = this.sessionFactory.getCurrentSession();


        List<Table> journals =session.createSQLQuery("select j.id,s.second_name, s.first_name,d.name_discipline " +
                "from journal j inner join student s " +
                "on j.student_id=s.id " +
                "inner join discipline d on j.discipline_id=d.id ").addEntity(Journal.class).list();
        return journals;

    }

    @Override
    public void update(Journal journal) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(journal);

    }

    @Override
    public void delete(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Journal journal=(Journal)session.load(Journal.class,new Integer(id));
        if(null !=journal){
            session.delete(journal);
        }

    }

    @Override
    public Journal getById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Journal journal =(Journal)session.get(Journal.class, new Integer(id));
        return journal;

    }
}
