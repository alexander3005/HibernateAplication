package app.journal.model;

import app.discipline.Model.Discipline;
import app.student.Model.Student;

import javax.persistence.*;
import javax.persistence.Table;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Acer on 20.09.2015.
 */

@Entity
@Table(name = "journal")
public class Journal {
    private int id;
    private int studentId;

    private int disciplineId;




    public Journal() {
    }

    public Journal(int id, int studentId, int disciplineId) {
        this.id = id;
        this.studentId = studentId;
        this.disciplineId = disciplineId;
    }

    @Id
    @GeneratedValue
    @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name="student_id")
    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }
    @Column(name="discipline_id")
    public int getDisciplineId() {
        return disciplineId;
    }

    public void setDisciplineId(int disciplineId) {
        this.disciplineId = disciplineId;
    }
    public String toString(){
        return id + "  " + disciplineId + "  "+ studentId;
    }
}