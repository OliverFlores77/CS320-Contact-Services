/**
 * AppointmentTest.java
 * Author: Oliver Flores
 * Date: Feb 2, 2026
 * Class: CS320
 * Testing the Appointment class
 */

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.Calendar;

public class AppointmentTest {

    // Helper to create a future date
    private Date getFutureDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime();
    }

    // Test 1: Make a normal appointment
    @Test
    void testMakeAppointmentNormal() {
        Date futureDate = getFutureDate();
        Appointment a = new Appointment("APP001", futureDate, "Dentist checkup");
        assertNotNull(a);
        assertEquals("APP001", a.getAppointmentID());
        assertEquals(futureDate, a.getAppointmentDate());
        assertEquals("Dentist checkup", a.getDescription());
    }

    // Test 2: ID too long
    @Test
    void testIdTooLong() {
        Date futureDate = getFutureDate();
        try {
            Appointment a = new Appointment("THISIDISTOOLONG", futureDate, "Meeting");
            fail("Should have thrown error");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("ID is too big"));
        }
    }

    // Test 3: ID null
    @Test
    void testIdNull() {
        Date futureDate = getFutureDate();
        try {
            Appointment a = new Appointment(null, futureDate, "Meeting");
            fail("Should have thrown error");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("ID cant be nothing"));
        }
    }

    // Test 4: Date in the past
    @Test
    void testDateInPast() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -1);
        Date pastDate = cal.getTime();

        try {
            Appointment a = new Appointment("APP002", pastDate, "Meeting");
            fail("Should have thrown error");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Date is in the past"));
        }
    }

    // Test 5: Date null
    @Test
    void testDateNull() {
        try {
            Appointment a = new Appointment("APP003", null, "Meeting");
            fail("Should have thrown error");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Date cant be nothing"));
        }
    }

    // Test 6: Description too long
    @Test
    void testDescriptionLong() {
        Date futureDate = getFutureDate();
        String longDesc = "This description is way too long because it has more than fifty characters which is not allowed";

        try {
            Appointment a = new Appointment("APP004", futureDate, longDesc);
            fail("Should have thrown error");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Description is too long"));
        }
    }

    // Test 7: Description null
    @Test
    void testDescriptionNull() {
        Date futureDate = getFutureDate();
        try {
            Appointment a = new Appointment("APP005", futureDate, null);
            fail("Should have thrown error");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Description cant be nothing"));
        }
    }

    // Test 8: Test setters
    @Test
    void testSetters() {
        Date futureDate = getFutureDate();
        Appointment a = new Appointment("APP006", futureDate, "Initial description");

        // Update date
        Calendar newCal = Calendar.getInstance();
        newCal.add(Calendar.DAY_OF_YEAR, 2);
        Date newDate = newCal.getTime();
        a.setAppointmentDate(newDate);
        assertEquals(newDate, a.getAppointmentDate());

        // Update description
        a.setDescription("Updated description");
        assertEquals("Updated description", a.getDescription());
    }

    // Test 9: Set past date in setter
    @Test
    void testSetPastDate() {
        Date futureDate = getFutureDate();
        Appointment a = new Appointment("APP007", futureDate, "Test");

        Calendar pastCal = Calendar.getInstance();
        pastCal.add(Calendar.DAY_OF_YEAR, -1);
        Date pastDate = pastCal.getTime();

        try {
            a.setAppointmentDate(pastDate);
            fail("Should have thrown error");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Date is in the past"));
        }
    }

    // Test 10: Set null description in setter
    @Test
    void testSetNullDescription() {
        Date futureDate = getFutureDate();
        Appointment a = new Appointment("APP008", futureDate, "Test");

        try {
            a.setDescription(null);
            fail("Should have thrown error");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Description is too long"));
        }
    }
}