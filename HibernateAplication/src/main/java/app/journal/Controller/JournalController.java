package app.journal.Controller;

import app.journal.Services.JournalServices;
import app.student.Model.Student;
import app.student.Model.StudentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Acer on 27.09.2015.
 */
@Controller
public class JournalController {
    private JournalServices journalServices;

    @Autowired(required = true)
    @Qualifier(value = "journalServices")
    public void setJournalServices(JournalServices journalServices) {
        this.journalServices = journalServices;
    }
   @RequestMapping(value = "/journal",method = RequestMethod.GET)
    public String getAll(Model model){

      List<Student> students=this.journalServices.getALL();
List<StudentDTO> studentDTO=new ArrayList<StudentDTO>();

      for(Student student:students){
           StudentDTO dto=new StudentDTO();
          dto.setId(student.getId());
          dto.setFirstName(student.getFirstName());
      dto.setSecondName(student.getSecondName());
           dto.setDisciplineSet(student.getDisciplines());
         studentDTO.add(dto);
      }
        model.addAttribute("journalsList", this.journalServices.getALL());
        return "journal";
    }
    @RequestMapping("/removeJournal/{id}")
    public String getAll(@PathVariable("id") int id){
        this.journalServices.delete(id);
        return "redirect:/journal";
    }
}
