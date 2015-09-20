package app.journal.model;

import app.discipline.Model.Discipline;
import app.student.Model.Student;

import javax.persistence.Entity;

/**
 * Created by Acer on 20.09.2015.
 */

public class Table {
    private Student student;
    private Discipline discipline;
    private Journal journal;


    public Table(Student student, Discipline discipline, Journal journal) {
        this.student = student;
        this.discipline = discipline;
        this.journal = journal;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }


}
