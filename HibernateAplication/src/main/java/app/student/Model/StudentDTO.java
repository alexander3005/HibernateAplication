package app.student.Model;

import app.discipline.Model.Discipline;

import java.util.List;
import java.util.Set;

/**
 * Created by Acer on 26.09.2015.
 */
public class StudentDTO {
    private Integer id;
    private String firstName;
    private String secondName;
    private List<Discipline> disciplineSet;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public List<Discipline> getDisciplineSet() {
        return disciplineSet;
    }

    public void setDisciplineSet(List<Discipline> disciplineSet) {
        this.disciplineSet = disciplineSet;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String toString(){
        return  id +" " + firstName + "   " + secondName + " " + disciplineSet;
    }
}
