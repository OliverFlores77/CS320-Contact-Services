/**
 * ContactService.java
 * Author: Oliver Flores
 * Date: Jan 20, 2026  
 * Class: CS320
 * This service manages all the contacts
 */

import java.util.HashMap;

public class ContactService {
    // Using HashMap to store contacts
    HashMap<String, Contact> allContacts;
    
    // Constructor
    public ContactService() {
        allContacts = new HashMap<>();
    }
    
    // Add a contact
    public void addContact(Contact c) {
        // Check if ID already there
        if (allContacts.containsKey(c.getID())) {
            throw new IllegalArgumentException("That ID already exists");
        }
        allContacts.put(c.getID(), c);
    }
    
    // Delete a contact
    public void deleteContact(String id) {
        if (!allContacts.containsKey(id)) {
            throw new IllegalArgumentException("Cant find that ID");
        }
        allContacts.remove(id);
    }
    
    // Update methods
    public void updateFirstName(String id, String newFirst) {
        if (!allContacts.containsKey(id)) {
            throw new IllegalArgumentException("Cant find that ID");
        }
        allContacts.get(id).setFirstName(newFirst);
    }
    
    public void updateLastName(String id, String newLast) {
        if (!allContacts.containsKey(id)) {
            throw new IllegalArgumentException("Cant find that ID");
        }
        allContacts.get(id).setLastName(newLast);
    }
    
    public void updatePhone(String id, String newPhone) {
        if (!allContacts.containsKey(id)) {
            throw new IllegalArgumentException("Cant find that ID");
        }
        allContacts.get(id).setPhone(newPhone);
    }
    
    public void updateAddress(String id, String newAddress) {
        if (!allContacts.containsKey(id)) {
            throw new IllegalArgumentException("Cant find that ID");
        }
        allContacts.get(id).setAddress(newAddress);
    }
    
    // Get a contact
    public Contact getContact(String id) {
        return allContacts.get(id);
    }
    
    // Check if exists
    public boolean hasContact(String id) {
        return allContacts.containsKey(id);
    }
}