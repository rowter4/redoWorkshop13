package vttp2022.ssf.workshop13Redo.controller;

// import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import vttp2022.ssf.workshop13Redo.model.Contact;
import vttp2022.ssf.workshop13Redo.utils.Contacts;

@Controller
public class AddressBookController {

    @Autowired // need to access the arguments
    private ApplicationArguments args;

    @GetMapping("/")
    public String contactForm(Model model){
        model.addAttribute("contact", new Contact());
        return "contact";
    }

    @PostMapping("/contact") // this is to submit the data when we click on the register button
    public String contactSubmit(@ModelAttribute Contact contact, Model model){

        
        Contacts ct = new Contacts();
        ct.saveContact(contact, model, args);

        // long startTime = System.currentTimeMillis();
        // long endTime = System.currentTimeMillis();

        return "showContact";
    }


    @GetMapping("/contact/{contactId}")
    public String getContact(Model model, @PathVariable(value="contactId") String contactId) {
        Contacts ct = new Contacts();
        ct.getContactById(model, contactId, args);
        return "showContact";
    }
}
