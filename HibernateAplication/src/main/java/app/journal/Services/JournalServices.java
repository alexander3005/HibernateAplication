package app.journal.Services;

import app.journal.model.Journal;
import app.student.Model.Student;
import app.student.Model.StudentDTO;

import java.util.List;

/**
 * Created by Acer on 20.09.2015.
 */
public interface JournalServices {
    public List<Student> getALL();
    public void delete(int id);
}
