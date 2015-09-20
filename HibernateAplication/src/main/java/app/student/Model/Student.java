package app.student.Model;



import app.discipline.Model.Discipline;
import app.journal.model.Journal;

import javax.persistence.*;

/**
 * Created by Acer on 17.09.2015.
 */
@Entity
@Table(name="student")
public class Student  {
    private int id;

    private String firstName;

    private String secondName;




   @Id
   @GeneratedValue
   @Column(name="id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Column(name = "first_name")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @Column(name = "second_name")
    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    public String toString(){
        return "Id: "+ id +" First_Name: " + firstName+" Second_name: "+ secondName+"\n";
    }
}
