/**
 * TaskServiceTest.java
 * Author: Oliver Flores
 * Date: Jan 26, 2026
 * Class: CS320  
 * Testing the TaskService
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TaskServiceTest {
    
    TaskService ts;
    
    @BeforeEach
    void setUpEachTest() {
        ts = new TaskService();
    }
    
    // Test 1: Add one task
    @Test
    void testAddSingleTask() {
        Task t = new Task("ID001", "Buy groceries", "Milk, eggs, bread, and cheese");
        ts.addTask(t);
        assertTrue(ts.hasTask("ID001"));
    }
    
    // Test 2: Add multiple tasks
    @Test
    void testAddMultipleTasks() {
        Task t1 = new Task("A100", "Do laundry", "Wash, dry, and fold clothes");
        Task t2 = new Task("B200", "Clean house", "Vacuum and dust all rooms");
        Task t3 = new Task("C300", "Pay bills", "Electric, water, and internet bills");
        
        ts.addTask(t1);
        ts.addTask(t2);
        ts.addTask(t3);
        
        assertTrue(ts.hasTask("A100"));
        assertTrue(ts.hasTask("B200"));
        assertTrue(ts.hasTask("C300"));
    }
    
    // Test 3: Try to add duplicate ID
    @Test
    void testDuplicateIDError() {
        Task t1 = new Task("DUP99", "Study", "Read chapter 4 for class");
        Task t2 = new Task("DUP99", "Exercise", "Go for a 30 minute run");
        
        ts.addTask(t1);
        
        try {
            ts.addTask(t2);
            fail("Should have thrown exception");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("already exists"));
        }
    }
    
    // Test 4: Add then get task back
    @Test
    void testAddAndRetrieveTask() {
        Task original = new Task("GET55", "Call mom", "Remember to wish her happy birthday");
        ts.addTask(original);
        
        Task retrieved = ts.getTask("GET55");
        assertNotNull(retrieved);
        assertEquals("Call mom", retrieved.getTaskName());
        assertEquals("Remember to wish her happy birthday", retrieved.getTaskDescription());
    }
    
    // Test 5: Update task with VALID inputs
    @Test
    void testUpdateTaskValid() {
        Task t = new Task("UPD77", "Water plants", "Water all the indoor plants");
        ts.addTask(t);
        
        // Update name
        ts.updateTaskName("UPD77", "Water indoor plants");
        assertEquals("Water indoor plants", ts.getTask("UPD77").getTaskName());
        
        // Update description with valid length 
        ts.updateTaskDescription("UPD77", "Water indoor plants, ferns, succulents");
        assertEquals("Water indoor plants, ferns, succulents", ts.getTask("UPD77").getTaskDescription());
    }
    
    // Test 6: Delete a task
    @Test
    void testDeleteTask() {
        Task t = new Task("DEL33", "Walk dog", "Take dog to park for 30 minutes");
        ts.addTask(t);
        
        assertTrue(ts.hasTask("DEL33"));
        ts.deleteTask("DEL33");
        assertFalse(ts.hasTask("DEL33"));
    }
    
    // Test 7: Try to update task that doesn't exist
    @Test
    void testUpdateNonExistent() {
        try {
            ts.updateTaskName("NOSUCH", "New task");
            fail("Should have thrown exception");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Cant find"));
        }
    }
    
    // Test 8: More task examples
    @Test
    void testMoreTasks() {
        Task t1 = new Task("FUN1", "Read book", "Finish reading mystery novel");
        Task t2 = new Task("FUN2", "Watch movie", "Watch new superhero movie");
        Task t3 = new Task("FUN3", "Play guitar", "Practice new song for 30 minutes");
        
        ts.addTask(t1);
        ts.addTask(t2);
        ts.addTask(t3);
        
        assertEquals("Read book", ts.getTask("FUN1").getTaskName());
        assertEquals("Watch new superhero movie", ts.getTask("FUN2").getTaskDescription());
        assertEquals("Play guitar", ts.getTask("FUN3").getTaskName());
    }
    
    // Test 9: Delete non-existent task
    @Test
    void testDeleteNonExistent() {
        try {
            ts.deleteTask("NOTHERE");
            fail("Should have thrown exception");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Cant find"));
        }
    }
    
    // Test 10: Update with invalid description (too long)
    @Test
    void testUpdateInvalidDescription() {
        Task t = new Task("INV100", "Test task", "Short description");
        ts.addTask(t);
        
        // Try to update with description that's too long (55 chars)
        try {
            ts.updateTaskDescription("INV100", "This description is way too long because it has more than fifty characters");
            fail("Should have thrown exception for description too long");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Description is too long"));
        }
    }
    
    // Test 11: Update with invalid name (too long)
    @Test
    void testUpdateInvalidName() {
        Task t = new Task("INV200", "Short name", "Description");
        ts.addTask(t);
        
        // Try to update with name that's too long (40 chars)
        try {
            ts.updateTaskName("INV200", "This task name is definitely way too long for the limit");
            fail("Should have thrown exception for name too long");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Name is too long"));
        }
    }
}