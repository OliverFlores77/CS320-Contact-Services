/**
 * ContactServiceTest.java
 * Author: Oliver Flores
 * Date: Jan 20, 2026
 * Class: CS320  
 * Testing the ContactService
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactServiceTest {
    
    ContactService cs;
    
    @BeforeEach
    void setUpEachTest() {
        cs = new ContactService();
    }
    
    // Test 1: Add one contact
    @Test
    void testAddSingleContact() {
        Contact c = new Contact("ID001", "Jose", "Gomez", "5551110000", 
                               "111 Laughing Hyena Lane");
        cs.addContact(c);
        assertTrue(cs.hasContact("ID001"));
    }
    
    // Test 2: Add multiple contacts
    @Test
    void testAddMultipleContacts() {
        Contact c1 = new Contact("A100", "Rosa", "Vargas", "5552221111", 
                                "222 Bubbly Soda Pop Avenue");
        Contact c2 = new Contact("B200", "Diego", "Castro", "5553332222", 
                                "333 Floating Cloud Boulevard");
        Contact c3 = new Contact("C300", "Carmen", "Reyes", "5554443333", 
                                "444 Jellybean Junction");
        
        cs.addContact(c1);
        cs.addContact(c2);
        cs.addContact(c3);
        
        assertTrue(cs.hasContact("A100"));
        assertTrue(cs.hasContact("B200"));
        assertTrue(cs.hasContact("C300"));
    }
    
    // Test 3: Try to add duplicate ID
    @Test
    void testDuplicateIDError() {
        Contact c1 = new Contact("DUP99", "Manuel", "Ortega", "5555554444", 
                                "555 Roller Coaster Hill");
        Contact c2 = new Contact("DUP99", "Isabel", "Mendoza", "5556665555", 
                                "666 Magic Carpet Ride");
        
        cs.addContact(c1);
        
        try {
            cs.addContact(c2);
            fail("Should have thrown exception");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("already exists"));
        }
    }
    
    // Test 4: Add then get contact back
    @Test
    void testAddAndRetrieveContact() {
        Contact original = new Contact("GET55", "Ricardo", "Silva", "5557776666", 
                                      "777 Secret Underground Lair");
        cs.addContact(original);
        
        Contact retrieved = cs.getContact("GET55");
        assertNotNull(retrieved);
        assertEquals("Ricardo", retrieved.getFirstName());
        assertEquals("Silva", retrieved.getLastName());
        assertEquals("777 Secret Underground Lair", retrieved.getAddress());
    }
    
    // Test 5: Update all contact fields
    @Test
    void testUpdateEverything() {
        Contact c = new Contact("UPD77", "Patricia", "Navarro", "5558887777", 
                               "888 Time Machine Garage");
        cs.addContact(c);
        
        // Update first name
        cs.updateFirstName("UPD77", "Patty");
        assertEquals("Patty", cs.getContact("UPD77").getFirstName());
        
        // Update last name
        cs.updateLastName("UPD77", "Navarrez");
        assertEquals("Navarrez", cs.getContact("UPD77").getLastName());
        
        // Update phone
        cs.updatePhone("UPD77", "5559998888");
        assertEquals("5559998888", cs.getContact("UPD77").getPhone());
        
        // Update address to something even cooler
        cs.updateAddress("UPD77", "999 Robot Butler Mansion");
        assertEquals("999 Robot Butler Mansion", cs.getContact("UPD77").getAddress());
    }
    
    // Test 6: Delete a contact
    @Test
    void testDeleteContact() {
        Contact c = new Contact("DEL33", "Fernando", "Jimenez", "5550009999", 
                               "000 Invisible Castle");
        cs.addContact(c);
        
        assertTrue(cs.hasContact("DEL33"));
        cs.deleteContact("DEL33");
        assertFalse(cs.hasContact("DEL33"));
    }
    
    // Test 7: Try to update contact that doesn't exist
    @Test
    void testUpdateNonExistent() {
        try {
            cs.updateFirstName("NOSUCH", "Juan");
            fail("Should have thrown exception");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Cant find"));
        }
    }
    
    // Test 8: More addresses
    @Test
    void testMoreAddresses() {
        Contact c1 = new Contact("FUN1", "Alejandro", "Perez", "5551239876", 
                                "123 Double Rainbow Road");
        Contact c2 = new Contact("FUN2", "Valeria", "Diaz", "5559871234", 
                                "456 Moon Cheese Factory");
        Contact c3 = new Contact("FUN3", "Gabriel", "Ruiz", "5554567890", 
                                "789 Volcano Ice Cream Shop");
        
        cs.addContact(c1);
        cs.addContact(c2);
        cs.addContact(c3);
        
        assertEquals("123 Double Rainbow Road", cs.getContact("FUN1").getAddress());
        assertEquals("456 Moon Cheese Factory", cs.getContact("FUN2").getAddress());
        assertEquals("789 Volcano Ice Cream Shop", cs.getContact("FUN3").getAddress());
    }
    
    // Test 9: Update to a wacky address
    @Test
    void testUpdateToWackyAddress() {
        Contact c = new Contact("WACKY", "Mario", "Alvarez", "5551113333", 
                               "Original Boring Street");
        cs.addContact(c);
        
        cs.updateAddress("WACKY", "New: Giant Hamster Wheel Residence");
        assertEquals("New: Giant Hamster Wheel Residence", cs.getContact("WACKY").getAddress());
    }
}