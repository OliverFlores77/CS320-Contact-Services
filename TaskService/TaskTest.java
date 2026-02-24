/**
 * TaskTest.java  
 * Author: Oliver Flores
 * Date: Jan 26, 2026
 * Class: CS320
 * Testing the Task class
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    
    // Test 1: Make a normal task
    @Test
    void testMakeTaskNormal() {
        Task t = new Task("TASK001", "Do homework", "Finish math assignment chapter 5");
        assertNotNull(t);
        assertEquals("Do homework", t.getTaskName());
        assertEquals("Finish math assignment chapter 5", t.getTaskDescription());
    }
    
    // Test 2: ID too long
    @Test
    void testIdTooLong() {
        try {
            Task t = new Task("THISIDISTOOLONG", "Clean room", "Vacuum and dust everything");
            fail("Should have thrown error");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("ID is too big"));
        }
    }
    
    // Test 3: Task name too long
    @Test
    void testTaskNameLong() {
        String longName = "This task name is way too long for what is allowed";
        try {
            Task t = new Task("TASK002", longName, "Simple description");
            fail("Should have thrown error");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Name is too long"));
        }
    }
    
    // Test 4: Description too long
    @Test
    void testDescriptionLong() {
        String longDescription = "This description is way too long because it has more than fifty characters which is not allowed";
        try {
            Task t = new Task("TASK003", "Short name", longDescription);
            fail("Should have thrown error");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Description is too long"));
        }
    }
    
    // Test 5: ID null in constructor
    @Test
    void testIdNullConstructor() {
        try {
            Task t = new Task(null, "Do laundry", "Wash clothes and fold them");
            fail("Should have thrown error for null ID");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("ID cant be nothing"));
        }
    }
    
    // Test 6: Name null in constructor
    @Test
    void testNameNullConstructor() {
        try {
            Task t = new Task("TASK004", null, "This is a description");
            fail("Should have thrown error for null name");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Name cant be nothing"));
        }
    }
    
    // Test 7: Description null in constructor
    @Test
    void testDescriptionNullConstructor() {
        try {
            Task t = new Task("TASK005", "Go shopping", null);
            fail("Should have thrown error for null description");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Description cant be nothing"));
        }
    }
    
    // Test 8: Test all the setter methods
    @Test
    void testAllSetters() {
        Task t = new Task("TASK006", "Study", "Read chapter 3");
        
        t.setTaskName("Study for test");
        assertEquals("Study for test", t.getTaskName());
        
        t.setTaskDescription("Read chapter 3 and do practice problems");
        assertEquals("Read chapter 3 and do practice problems", t.getTaskDescription());
    }
    
    // Test 9: Name null in setter
    @Test
    void testNameNullSetter() {
        Task t = new Task("TASK007", "Walk dog", "Take Sparky for a walk");
        try {
            t.setTaskName(null);
            fail("Should have thrown error for null name in setter");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Name is too long"));
        }
    }
    
    // Test 10: Description null in setter
    @Test
    void testDescriptionNullSetter() {
        Task t = new Task("TASK008", "Cook dinner", "Make spaghetti and meatballs");
        try {
            t.setTaskDescription(null);
            fail("Should have thrown error for null description in setter");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Description is too long"));
        }
    }
}