/**
 * TaskService.java
 * Author: Oliver Flores
 * Date: Jan 26, 2026
 * Class: CS320
 * This service manages all the tasks
 */

import java.util.HashMap;

public class TaskService {
    // Using HashMap to store tasks
    HashMap<String, Task> allTasks;
    
    // Constructor
    public TaskService() {
        allTasks = new HashMap<>();
    }
    
    // Add a task
    public void addTask(Task t) {
        // Check if ID already there
        if (allTasks.containsKey(t.getTaskID())) {
            throw new IllegalArgumentException("That ID already exists");
        }
        allTasks.put(t.getTaskID(), t);
    }
    
    // Delete a task
    public void deleteTask(String id) {
        if (!allTasks.containsKey(id)) {
            throw new IllegalArgumentException("Cant find that ID");
        }
        allTasks.remove(id);
    }
    
    // Update methods
    public void updateTaskName(String id, String newName) {
        if (!allTasks.containsKey(id)) {
            throw new IllegalArgumentException("Cant find that ID");
        }
        allTasks.get(id).setTaskName(newName);
    }
    
    public void updateTaskDescription(String id, String newDescription) {
        if (!allTasks.containsKey(id)) {
            throw new IllegalArgumentException("Cant find that ID");
        }
        allTasks.get(id).setTaskDescription(newDescription);
    }
    
    // Get a task
    public Task getTask(String id) {
        return allTasks.get(id);
    }
    
    // Check if exists
    public boolean hasTask(String id) {
        return allTasks.containsKey(id);
    }
}