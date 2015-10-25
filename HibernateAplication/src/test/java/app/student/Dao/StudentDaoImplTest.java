package app.student.Dao;



import app.student.Model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.Transaction;



import org.hibernate.cfg.Configuration;

import java.util.List;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;



/**
 * Created by Acer on 16.10.2015.
 */
public class StudentDaoImplTest {

private Session session;
  private SessionFactory sessionFactory;
    private SessionFactory createSessionFactory(){
        sessionFactory=  new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
  
        

   
    public void testAddStudent() throws Exception {
sessionFactory =createSessionFactory();
        session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Student> students =session.createQuery("from Student").list();
        Student student=new Student();
        student.setFirstName("Sasha");
        student.setSecondName("Lix");
         session.persist(student);
        List<Student> students1 =session.createQuery("from Student").list();
        assertTrue(students.size()< students1.size());
session.close();
        sessionFactory.close();
    }

  
    public void testListStudent() throws Exception {
sessionFactory =createSessionFactory();
        session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Student student = new Student();
        student.setFirstName("sss");
        student.setSecondName("sssss");
        session.persist(student);
        List<Student> students=session.createQuery("from Student ").list();
       assertTrue(students.size()>0);
session.close();
        sessionFactory.close();
    }

   
    public void testUpdate() throws Exception {
sessionFactory =createSessionFactory();
        session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
Student student =new Student();
        student.setId(95);
        student.setFirstName("Alex");
        student.setSecondName("M");
        session.update(student);
        Student student1=new Student();
        student1=(Student)session.get(Student.class,new Integer(student.getId()));
        assertEquals(student.getId(),student1.getId());
        assertEquals(student.getFirstName(),student1.getFirstName());
        assertEquals(student.getSecondName(),student1.getSecondName());
session.close();
        sessionFactory.close();

    }

  
    public void testDelete() throws Exception {
sessionFactory =createSessionFactory();
        session=sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Student> students =session.createQuery("from Student").list();
        Student student =new Student();
        student.setFirstName("Alex");
        student.setSecondName("M");
        session.persist(student);
        session.delete(student);
        List<Student> students1 =session.createQuery("from Student").list();
        assertEquals(students,students1);
session.close();
        sessionFactory.close();

    }
}