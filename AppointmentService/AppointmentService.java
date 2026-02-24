/**
 * AppointmentService.java
 * Author: Oliver Flores
 * Date: Feb 2, 2026
 * Class: CS320
 * This service manages all the appointments
 */

import java.util.HashMap;
import java.util.Date;

public class AppointmentService {
    // Using HashMap to store appointments
    HashMap<String, Appointment> allAppointments;

    // Constructor
    public AppointmentService() {
        allAppointments = new HashMap<>();
    }

    // Add an appointment
    public void addAppointment(Appointment a) {
        // Check if ID already there
        if (allAppointments.containsKey(a.getAppointmentID())) {
            throw new IllegalArgumentException("That ID already exists");
        }
        allAppointments.put(a.getAppointmentID(), a);
    }

    // Delete an appointment
    public void deleteAppointment(String id) {
        if (!allAppointments.containsKey(id)) {
            throw new IllegalArgumentException("Cant find that ID");
        }
        allAppointments.remove(id);
    }

    // Update methods for date and description (ID cannot be updated)
    public void updateAppointmentDate(String id, Date newDate) {
        if (!allAppointments.containsKey(id)) {
            throw new IllegalArgumentException("Cant find that ID");
        }
        allAppointments.get(id).setAppointmentDate(newDate);
    }

    public void updateDescription(String id, String newDescription) {
        if (!allAppointments.containsKey(id)) {
            throw new IllegalArgumentException("Cant find that ID");
        }
        allAppointments.get(id).setDescription(newDescription);
    }

    // Get an appointment
    public Appointment getAppointment(String id) {
        return allAppointments.get(id);
    }

    // Check if exists
    public boolean hasAppointment(String id) {
        return allAppointments.containsKey(id);
    }
}