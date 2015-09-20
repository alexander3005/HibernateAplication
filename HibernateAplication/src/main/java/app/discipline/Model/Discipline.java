package app.discipline.Model;

import app.journal.model.Journal;
import app.student.Model.Student;

import javax.persistence.*;

/**
 * Created by Acer on 18.09.2015.
 */
@Entity
@Table(name="discipline")
public class Discipline {
    private int id;
    private String nameDiscipline;

    public Discipline(int id, String nameDiscipline) {
        this.id = id;
        this.nameDiscipline = nameDiscipline;
    }
    private Student student;

    public void setStudent(Student student) {
        this.student = student;
    }

    @ManyToOne
    @JoinTable(name = "journal",joinColumns = @JoinColumn(name = "discipline_id"),inverseJoinColumns = @JoinColumn(name = "student_id"))
    public Student getStudent(){
        return student;

    }
    public Discipline() {
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
    @Column(name="name_discipline")
    public String getNameDiscipline() {
        return nameDiscipline;
    }

    public void setNameDiscipline(String nameDiscipline) {
        this.nameDiscipline = nameDiscipline;
    }
}
