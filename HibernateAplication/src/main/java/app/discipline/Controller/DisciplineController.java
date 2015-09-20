package app.discipline.Controller;

import app.discipline.Model.Discipline;
import app.discipline.Services.DisciplineServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Acer on 18.09.2015.
 */
@Controller

public class DisciplineController {

    private DisciplineServices disciplineServices;
    @Autowired(required = true)
    @Qualifier(value="disciplineServices")
    public void setDisciplineServices(DisciplineServices disciplineServices) {
        this.disciplineServices = disciplineServices;
    }
    @RequestMapping(value = "/disciplines", method = RequestMethod.GET)
    public String listDisciplines(Model model) {
        model.addAttribute("discipline", new Discipline());
        model.addAttribute("listDisciplines", this.disciplineServices.listDiscipline());
        return "discipline";
    }


    @RequestMapping(value= "/discipline/add", method = RequestMethod.POST)
    public String addDiscipline(@ModelAttribute("discipline") Discipline discipline){

        if(discipline.getId() == 0){

         this.disciplineServices.addDiscipline(discipline);
        }else{

           this.disciplineServices.update(discipline);
        }

        return "redirect:/disciplines";

    }

    @RequestMapping("/removeDiscipline/{id}")
    public String removeDiscipline(@PathVariable("id") int id){

       this.disciplineServices.delete(id);
        return "redirect:/disciplines";
    }

    @RequestMapping("/editDiscipline/{id}")
    public String editDisipline(@PathVariable("id") int id, Model model){
        model.addAttribute("discipline", this.disciplineServices.getById(id));
        model.addAttribute("listDisciplines", this.disciplineServices.listDiscipline());
        return "discipline";
    }
}
