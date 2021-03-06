package app.student.Dao;

import app.student.Model.Student;

import java.util.List;

/**
 * Created by Acer on 17.09.2015.
 */
public interface StudentDao  {
    public void addStudent(Student student);
    public List<Student> listStudent();
    public void update(Student student);
    public void delete(int id);
    public Student getById(int id);
}
