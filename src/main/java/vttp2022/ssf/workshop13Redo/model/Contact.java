package vttp2022.ssf.workshop13Redo.model;

import java.util.Random;

public class Contact {
    private String name;
    private String email;
    private int phoneNumber;
    private String id;

    // getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getPhoneNumber() { return phoneNumber;  }
    public void setPhoneNumber(int phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    

    // the code that is required to generate the random ID
    public synchronized String generateId(int numchars) {
        Random r = new Random();
        StringBuffer sb = new StringBuffer();

        while (sb.length() < numchars){
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0,numchars);
    }


    // the constructors that is required to make the Contacts object

    public Contact(){
        this.id = this.generateId(8);
    }

    public Contact(String name, String email, int phoneNumber) {
        this.id = this.generateId(8);
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Contact(String name, String email, String id, int phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
}
