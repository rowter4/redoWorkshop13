package vttp2022.ssf.workshop13Redo.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.server.ResponseStatusException;

import vttp2022.ssf.workshop13Redo.model.Contact;

public class Contacts {
    public void saveContact(Contact contact, Model model, ApplicationArguments args) {
        String dataFilename = contact.getId();

        Set<String> optNames = args.getOptionNames();
        String[] optNamesArr = optNames.toArray(new String [optNames.size()]);

        List<String> optValues = args.getOptionValues(optNamesArr[0]);
        String[] optValuesArr = optValues.toArray(new String[optValues.size()]);

        PrintWriter printWriter = null;

        // this is to append the data to the file
        try {
            FileWriter fileWriter = new FileWriter(optValuesArr[0] + "/" + dataFilename, Charset.forName("utf-8"));
        
            printWriter = new PrintWriter(fileWriter);
            printWriter.println(contact.getName());
            printWriter.println(contact.getEmail());
            printWriter.println(contact.getPhoneNumber());

        } catch (IOException e) {
            
        } finally { 
            printWriter.close();
        }

        model.addAttribute("contact", new Contact(contact.getId(), contact.getName(), contact.getEmail(), contact.getPhoneNumber()));
        
    }

    // this is to get the data back when we were to call it inside the browser
    public void getContactById(Model model, String contactId, ApplicationArguments args){
        
        // these 4 lines is the same as the codes that are contained inside the saveContacts details
        Set<String> optNames = args.getOptionNames();
        String[] optNamesArr = optNames.toArray(new String [optNames.size()]);

        List<String> optValues = args.getOptionValues(optNamesArr[0]);
        String[] optValuesArr = optValues.toArray(new String[optValues.size()]);

        Contact cResp = new Contact();

        try {
            Path filePath = new File(optValuesArr[0] + '/' + contactId).toPath();
            Charset charset = Charset.forName("utf-8");
            List<String> stringList = Files.readAllLines(filePath, charset);

            cResp.setName(stringList.get(0));
            cResp.setEmail(stringList.get(1));
            cResp.setPhoneNumber(Integer.parseInt(stringList.get(2)));
            
        } catch (IOException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Contact not found", e);
        }

        model.addAttribute("contact", cResp);
    }
}
