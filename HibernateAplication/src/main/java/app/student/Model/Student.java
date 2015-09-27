package app.student.Model;





import app.discipline.Model.Discipline;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Entity
@Table(name="student")
public class Student  {
 private int id;
 private String firstName;
 private String secondName;
private List<Discipline> disciplines;

 public Student() {
 }

 public Student(int id, String firstName, String secondName, List<Discipline> disciplines) {
  this.id = id;
  this.firstName = firstName;
  this.secondName = secondName;
  this.disciplines = disciplines;
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

 @ManyToMany
 @JoinTable(name = "journal",joinColumns = @JoinColumn(name = "student_id"),inverseJoinColumns = @JoinColumn(name = "discipline_id"))
 public List<Discipline> getDisciplines() {
  return disciplines;
 }

 public void setDisciplines(List<Discipline> disciplines) {
  this.disciplines = disciplines;
 }
}