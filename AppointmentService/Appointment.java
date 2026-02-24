/**
 * Appointment.java
 * Author: Oliver Flores
 * Date: Feb 2, 2026
 * Class: CS320
 * Appointment class for the mobile application
 */

import java.util.Date;

public class Appointment {
    // My variables here
    String appointmentID;
    Date appointmentDate;
    String description;

    // The constructor
    public Appointment(String appointmentID, Date appointmentDate, String description) {
        // Checking ID
        if (appointmentID == null) {
            throw new IllegalArgumentException("ID cant be nothing");
        }
        if (appointmentID.length() > 10) {
            throw new IllegalArgumentException("ID is too big");
        }

        // Date check
        if (appointmentDate == null) {
            throw new IllegalArgumentException("Date cant be nothing");
        }
        if (appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Date is in the past");
        }

        // Description check
        if (description == null) {
            throw new IllegalArgumentException("Description cant be nothing");
        }
        if (description.length() > 50) {
            throw new IllegalArgumentException("Description is too long");
        }

        // Set everything
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Getters (ID is not updateable, so no setter for ID)
    public String getAppointmentID() {
        return appointmentID;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    // Setters (update methods) for date and description only
    public void setAppointmentDate(Date newDate) {
        if (newDate == null) {
            throw new IllegalArgumentException("Date cant be nothing");
        }
        if (newDate.before(new Date())) {
            throw new IllegalArgumentException("Date is in the past");
        }
        this.appointmentDate = newDate;
    }

    public void setDescription(String newDescription) {
        if (newDescription == null || newDescription.length() > 50) {
            throw new IllegalArgumentException("Description is too long");
        }
        this.description = newDescription;
    }
}