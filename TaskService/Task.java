/**
 * Task.java
 * Author: Oliver Flores
 * Date: Jan 26, 2026
 * Class: CS320
 * Task class for the mobile application
 */

public class Task {
    // My variables here
    String taskID;
    String taskName;
    String taskDescription;
    
    // The constructor
    public Task(String taskID, String taskName, String taskDescription) {
        // Checking ID
        if (taskID == null) {
            throw new IllegalArgumentException("ID cant be nothing");
        }
        if (taskID.length() > 10) {
            throw new IllegalArgumentException("ID is too big");
        }
        
        // Task name check
        if (taskName == null) {
            throw new IllegalArgumentException("Name cant be nothing");
        }
        if (taskName.length() > 20) {
            throw new IllegalArgumentException("Name is too long");
        }
        
        // Description check
        if (taskDescription == null) {
            throw new IllegalArgumentException("Description cant be nothing");
        }
        if (taskDescription.length() > 50) {
            throw new IllegalArgumentException("Description is too long");
        }
        
        // Set everything
        this.taskID = taskID;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }
    
    // Getters
    public String getTaskID() {
        return taskID;
    }
    
    public String getTaskName() {
        return taskName;
    }
    
    public String getTaskDescription() {
        return taskDescription;
    }
    
    // Setters (update methods)
    public void setTaskName(String newName) {
        if (newName == null || newName.length() > 20) {
            throw new IllegalArgumentException("Name is too long");
        }
        taskName = newName;
    }
    
    public void setTaskDescription(String newDescription) {
        if (newDescription == null || newDescription.length() > 50) {
            throw new IllegalArgumentException("Description is too long");
        }
        taskDescription = newDescription;
    }
}