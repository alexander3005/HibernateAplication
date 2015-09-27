package app.student.Dao;

import app.discipline.Model.Discipline;
import app.student.Model.Student;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;



import java.util.List;
import java.util.Set;

/**
 * Created by Acer on 17.09.2015.
 */
@Repository
public class StudentDaoImpl implements StudentDao{
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addStudent(Student student) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(student);

    }

    @Override

    public List<Student> listStudent() {
        Session session =this.sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        List<Student> students =session.createQuery("from Student").list();
        return students;
    }

    @Override
    public void update(Student student) {
        Session session =this.sessionFactory.getCurrentSession();
        session.update(student);
    }

    @Override
    public void delete(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Student student=(Student)session.load(Student.class,new Integer(id));
        if(null !=student){
            session.delete(student);
        }


    }

    @Override
    public Student getById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Student student=(Student)session.get(Student.class,new Integer(id));
        return student;

    }
}
