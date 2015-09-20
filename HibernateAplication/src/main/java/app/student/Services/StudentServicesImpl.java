package app.student.Services;

import app.student.Dao.StudentDao;
import app.student.Model.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Acer on 17.09.2015.
 */
@Service
public class StudentServicesImpl implements StudentServices {
    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    @Transactional
    public void addStudent(Student student) {
this.studentDao.addStudent(student);
    }

    @Override
    @Transactional
    public List<Student> listStudent() {
       return this.studentDao.listStudent();

    }

    @Override
    @Transactional
    public void update(Student student) {
        this.studentDao.update(student);
    }

    @Override
    @Transactional
    public void delete(int id) {
this.studentDao.delete(id);
    }

    @Override
    @Transactional
    public Student getById(int id) {
        return this.studentDao.getById(id);
    }
}
