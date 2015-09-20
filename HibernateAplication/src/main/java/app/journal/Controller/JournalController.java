package app.journal.Controller;

import app.journal.Services.JournalServices;
import app.journal.model.Journal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Acer on 20.09.2015.
 */
@Controller
public class JournalController {
    private JournalServices journalServices;
    @Autowired(required = true)
    @Qualifier(value="journalServices")
    public void setJournalServices(JournalServices journalServices) {
        this.journalServices = journalServices;
    }





    @RequestMapping(value = "/journals", method = RequestMethod.GET)
    public String listJournal(Model model) {
        model.addAttribute("journal", new Journal());
        model.addAttribute("listJournals", this.journalServices.listJournal());
        return "journal";
    }


    @RequestMapping(value= "/journal/add", method = RequestMethod.POST)
    public String addJournal(@ModelAttribute("journal")Journal journal){

        if(journal.getId() == 0){

            this.journalServices.addJournal(journal);
        }else{

            this.journalServices.update(journal);
        }

        return "redirect:/journals";

    }

    @RequestMapping("/removeJournal/{id}")
    public String removeJournal(@PathVariable("id") int id){

        this.journalServices.delete(id);
        return "redirect:/journals";
    }

    @RequestMapping("/editJournal/{id}")
    public String editJournal(@PathVariable("id") int id, Model model){
        model.addAttribute("journal", this.journalServices.getById(id));
        model.addAttribute("listJournals", this.journalServices.listJournal());
        return "journal";
    }

}
