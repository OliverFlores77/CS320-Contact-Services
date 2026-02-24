/**
 * ContactTest.java  
 * Author: Oliver Flores
 * Date: Jan 26, 2026
 * Class: CS320
 * Testing the Contact class
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ContactTest {
    
    // Test 1: Make a normal contact
    @Test
    void testMakeContactNormal() {
        Contact c = new Contact("ID123", "Juan", "Garcia", "5551112222", 
                               "123 Unicorn Rainbow Lane");
        assertNotNull(c);
        assertEquals("Juan", c.getFirstName());
        assertEquals("123 Unicorn Rainbow Lane", c.getAddress());
    }
    
    // Test 2: ID too long
    @Test
    void testIdTooLong() {
        try {
            Contact c = new Contact("ID12345678901", "Maria", "Lopez", "5552223333", 
                                   "456 Taco Truck Alley");
            fail("Should have thrown error");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("ID is too big"));
        }
    }
    
    // Test 3: First name too long
    @Test
    void testFirstNameLong() {
        try {
            Contact c = new Contact("ID1", "GuadalupeMaria", "Rodriguez", "5553334444", 
                                   "789 Dragon Scale Boulevard");
            fail("Should have thrown error");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("First name is too long"));
        }
    }
    
    // Test 4: Last name too long
    @Test
    void testLastNameLong() {
        try {
            Contact c = new Contact("ID2", "Carlos", "HernandezDelRio", "5554445555", 
                                   "321 Pirate Ship Cove");
            fail("Should have thrown error");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Last name is too long"));
        }
    }
    
    // Test 5: Address too long
    @Test
    void testAddressLong() {
        String crazyLongAddress = "12345 Really Really Ridiculously Long Street Name Avenue";
        try {
            Contact c = new Contact("ID3", "Ana", "Martinez", "5555556666", 
                                   crazyLongAddress);
            fail("Should have thrown error");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Address is too long"));
        }
    }
    
    // Test 6: Phone wrong (too short)
    @Test
    void testPhoneShort() {
        try {
            Contact c = new Contact("ID4", "Pedro", "Sanchez", "555123", 
                                   "654 Wizard Hat Circle");
            fail("Should have thrown error");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Phone needs exactly 10 numbers"));
        }
    }
    
    // Test 7: Phone wrong (too long)
    @Test
    void testPhoneLong() {
        try {
            Contact c = new Contact("ID5", "Luisa", "Fernandez", "555123456789", 
                                   "987 Spaceship Landing Pad");
            fail("Should have thrown error");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Phone needs exactly 10 numbers"));
        }
    }
    
    // Test 8: Phone has letters
    @Test
    void testPhoneLetters() {
        try {
            Contact c = new Contact("ID6", "Miguel", "Torres", "555-ABC-DEF", 
                                   "159 Giant Slide Park");
            fail("Should have thrown error");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Phone can only have numbers"));
        }
    }
    
    // Test 9: Test all the setter methods
    @Test
    void testAllSetters() {
        Contact c = new Contact("ID7", "Elena", "Ramos", "5558889999", 
                               "753 Chocolate Fountain Way");
        
        c.setFirstName("Elenita");
        assertEquals("Elenita", c.getFirstName());
        
        c.setLastName("Ramirez");
        assertEquals("Ramirez", c.getLastName());
        
        c.setPhone("5557778888");
        assertEquals("5557778888", c.getPhone());
        
        c.setAddress("456 Balloon Animal Street");
        assertEquals("456 Balloon Animal Street", c.getAddress());
    }
    
    // Test 10: Another contact 
    @Test
    void testFunAddress() {
        Contact c = new Contact("ID8", "Sofia", "Mendoza", "5556667777", 
                               "888 Disco Ball Drive");
        assertEquals("888 Disco Ball Drive", c.getAddress());
        assertEquals("Sofia", c.getFirstName());
    }
    

    // Test 11: ID null in constructor
    @Test
    void testIdNullConstructor() {
        try {
            Contact c = new Contact(null, "Juan", "Garcia", "5551112222", "123 Rainbow Road");
            fail("Should have thrown error for null ID");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("ID cant be nothing"));
        }
    }
    
    // Test 12: First name null in constructor
    @Test
    void testFirstNameNullConstructor() {
        try {
            Contact c = new Contact("ID123", null, "Garcia", "5551112222", "123 Rainbow Road");
            fail("Should have thrown error for null first name");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("First name cant be nothing"));
        }
    }
    
    // Test 13: Last name null in constructor
    @Test
    void testLastNameNullConstructor() {
        try {
            Contact c = new Contact("ID123", "Juan", null, "5551112222", "123 Rainbow Road");
            fail("Should have thrown error for null last name");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Last name cant be nothing"));
        }
    }
    
    // Test 14: Phone null in constructor
    @Test
    void testPhoneNullConstructor() {
        try {
            Contact c = new Contact("ID123", "Juan", "Garcia", null, "123 Rainbow Road");
            fail("Should have thrown error for null phone");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Phone cant be nothing"));
        }
    }
    
    // Test 15: Address null in constructor
    @Test
    void testAddressNullConstructor() {
        try {
            Contact c = new Contact("ID123", "Juan", "Garcia", "5551112222", null);
            fail("Should have thrown error for null address");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Address cant be nothing"));
        }
    }
    
    // Test 16: First name null in setter
    @Test
    void testFirstNameNullSetter() {
        Contact c = new Contact("ID9", "Carlos", "Santana", "5559990000", "456 Guitar Lane");
        try {
            c.setFirstName(null);
            fail("Should have thrown error for null first name in setter");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("First name is too long"));
        }
    }
    
    // Test 17: Last name null in setter
    @Test
    void testLastNameNullSetter() {
        Contact c = new Contact("ID10", "Carlos", "Santana", "5559990000", "456 Guitar Lane");
        try {
            c.setLastName(null);
            fail("Should have thrown error for null last name in setter");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Last name is too long"));
        }
    }
    
    // Test 18: Phone null in setter
    @Test
    void testPhoneNullSetter() {
        Contact c = new Contact("ID11", "Carlos", "Santana", "5559990000", "456 Guitar Lane");
        try {
            c.setPhone(null);
            fail("Should have thrown error for null phone in setter");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Phone needs exactly 10 numbers"));
        }
    }
    
    // Test 19: Address null in setter
    @Test
    void testAddressNullSetter() {
        Contact c = new Contact("ID12", "Carlos", "Santana", "5559990000", "456 Guitar Lane");
        try {
            c.setAddress(null);
            fail("Should have thrown error for null address in setter");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Address is too long"));
        }
    }
}