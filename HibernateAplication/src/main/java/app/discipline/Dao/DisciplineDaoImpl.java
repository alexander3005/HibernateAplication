package app.discipline.Dao;

import app.discipline.Model.Discipline;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Acer on 18.09.2015.
 */
@Repository
public class DisciplineDaoImpl implements DisciplineDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addDiscipline(Discipline discipline) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(discipline);

    }

    @Override
    public List<Discipline> listDiscipline() {
        Session session = this.sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<Discipline> disciplineList = session.createQuery("from Discipline ").list();
        return disciplineList;
    }

    @Override
    public Discipline getById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Discipline discipline = (Discipline) session.get(Discipline.class, new Integer(id));
        return  discipline;
    }

    @Override
    public void update(Discipline discipline) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(discipline);
    }

    @Override
    public void delete(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Discipline discipline = (Discipline) session.load(Discipline.class, new Integer(id));
        if(null != discipline) {
            session.delete(discipline);
        }
    }
}
