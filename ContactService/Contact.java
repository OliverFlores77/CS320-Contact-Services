/**
 * Contact.java
 * Author: Oliver Flores  
 * Date: Jan 20, 2026
 * Class: CS320
 * Contact class for the appointment app
 */

public class Contact {
    // My variables here
    String contactID;
    String firstName;
    String lastName;
    String phoneNum;
    String homeAddress;
    
    // The constructor
    public Contact(String contactID, String firstName, String lastName, String phoneNum, String homeAddress) {
        // Checking ID
        if (contactID == null) {
            throw new IllegalArgumentException("ID cant be nothing");
        }
        if (contactID.length() > 10) {
            throw new IllegalArgumentException("ID is too big");
        }
        
        // First name check
        if (firstName == null) {
            throw new IllegalArgumentException("First name cant be nothing");
        }
        if (firstName.length() > 10) {
            throw new IllegalArgumentException("First name is too long");
        }
        
        // Last name check
        if (lastName == null) {
            throw new IllegalArgumentException("Last name cant be nothing");
        }
        if (lastName.length() > 10) {
            throw new IllegalArgumentException("Last name is too long");
        }
        
        // Phone number stuff
        if (phoneNum == null) {
            throw new IllegalArgumentException("Phone cant be nothing");
        }
        if (phoneNum.length() != 10) {
            throw new IllegalArgumentException("Phone needs exactly 10 numbers");
        }
        // Make sure its all numbers
        for (int i = 0; i < phoneNum.length(); i++) {
            char c = phoneNum.charAt(i);
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException("Phone can only have numbers");
            }
        }
        
        // Address check
        if (homeAddress == null) {
            throw new IllegalArgumentException("Address cant be nothing");
        }
        if (homeAddress.length() > 30) {
            throw new IllegalArgumentException("Address is too long");
        }
        
        // Set everything
        this.contactID = contactID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.homeAddress = homeAddress;
    }
    
    // Getters
    public String getID() {
        return contactID;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public String getPhone() {
        return phoneNum;
    }
    
    public String getAddress() {
        return homeAddress;
    }
    
    // Setters (update methods)
    public void setFirstName(String newName) {
        if (newName == null || newName.length() > 10) {
            throw new IllegalArgumentException("First name is too long");
        }
        firstName = newName;
    }
    
    public void setLastName(String newName) {
        if (newName == null || newName.length() > 10) {
            throw new IllegalArgumentException("Last name is too long");
        }
        lastName = newName;
    }
    
    public void setPhone(String newPhone) {
        if (newPhone == null || newPhone.length() != 10) {
            throw new IllegalArgumentException("Phone needs exactly 10 numbers");
        }
        for (int i = 0; i < newPhone.length(); i++) {
            char c = newPhone.charAt(i);
            if (c < '0' || c > '9') {
                throw new IllegalArgumentException("Phone can only have numbers");
            }
        }
        phoneNum = newPhone;
    }
    
    public void setAddress(String newAddress) {
        if (newAddress == null || newAddress.length() > 30) {
            throw new IllegalArgumentException("Address is too long");
        }
        homeAddress = newAddress;
    }
}