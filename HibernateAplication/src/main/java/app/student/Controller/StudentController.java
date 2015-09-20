package app.student.Controller;

import app.student.Model.Student;
import app.student.Services.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



/**
 * Created by Acer on 17.09.2015.
 */
 @Controller

public class StudentController {
    private StudentServices studentServices;

    @Autowired(required = true)
    @Qualifier(value="studentServices")

    public void setStudentServices(StudentServices studentServices) {
        this.studentServices = studentServices;
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String listStudents(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("listStudents", this.studentServices.listStudent());
        return "student";
    }


    @RequestMapping(value= "/student/add", method = RequestMethod.POST)
    public String addStudent(@ModelAttribute("student") Student student){

        if(student.getId() == 0){

            this.studentServices.addStudent(student);
        }else{

            this.studentServices.update(student);
        }

        return "redirect:/students";

    }

    @RequestMapping("/remove/{id}")
    public String removeStudent(@PathVariable("id") int id){

        this.studentServices.delete(id);
        return "redirect:/students";
    }

    @RequestMapping("/edit/{id}")
    public String editStudent(@PathVariable("id") int id, Model model){
        model.addAttribute("student", this.studentServices.getById(id));
        model.addAttribute("listStudents", this.studentServices.listStudent());
        return "student";
    }
}
