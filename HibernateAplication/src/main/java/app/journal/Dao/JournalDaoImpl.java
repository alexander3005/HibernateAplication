package app.journal.Dao;

import app.journal.model.Journal;
import app.student.Model.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Acer on 20.09.2015.
 */
@Repository
  public class JournalDaoImpl implements JournalDao{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Student> getALL() {
        Session session = this.sessionFactory.getCurrentSession();
        Query query= session.createQuery("From Student  AS S inner join fetch S.disciplines ");

        return query.list();
    }

    @Override
    public void delete(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Query query=session.createSQLQuery("Delete From Journal  where id=" + id);
       query.executeUpdate();

    }
}