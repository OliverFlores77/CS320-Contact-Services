/**
 * AppointmentServiceTest.java
 * Author: Oliver Flores
 * Date: Feb 2, 2026
 * Class: CS320
 * Testing the AppointmentService
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Date;
import java.util.Calendar;

public class AppointmentServiceTest {

    AppointmentService as;

    @BeforeEach
    void setUpEachTest() {
        as = new AppointmentService();
    }

    // Helper to create a future date
    private Date getFutureDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime();
    }

    // Test 1: Add one appointment
    @Test
    void testAddSingleAppointment() {
        Date futureDate = getFutureDate();
        Appointment a = new Appointment("ID001", futureDate, "Doctor visit");
        as.addAppointment(a);
        assertTrue(as.hasAppointment("ID001"));
    }

    // Test 2: Add multiple appointments
    @Test
    void testAddMultipleAppointments() {
        Date futureDate1 = getFutureDate();
        Date futureDate2 = getFutureDate();
        Date futureDate3 = getFutureDate();

        Appointment a1 = new Appointment("A100", futureDate1, "Dentist");
        Appointment a2 = new Appointment("B200", futureDate2, "Haircut");
        Appointment a3 = new Appointment("C300", futureDate3, "Meeting");

        as.addAppointment(a1);
        as.addAppointment(a2);
        as.addAppointment(a3);

        assertTrue(as.hasAppointment("A100"));
        assertTrue(as.hasAppointment("B200"));
        assertTrue(as.hasAppointment("C300"));
    }

    // Test 3: Try to add duplicate ID
    @Test
    void testDuplicateIDError() {
        Date futureDate = getFutureDate();
        Appointment a1 = new Appointment("DUP99", futureDate, "Study group");
        Appointment a2 = new Appointment("DUP99", futureDate, "Gym session");

        as.addAppointment(a1);

        try {
            as.addAppointment(a2);
            fail("Should have thrown exception");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("already exists"));
        }
    }

    // Test 4: Add then get appointment back
    @Test
    void testAddAndRetrieveAppointment() {
        Date futureDate = getFutureDate();
        Appointment original = new Appointment("GET55", futureDate, "Call dad");
        as.addAppointment(original);

        Appointment retrieved = as.getAppointment("GET55");
        assertNotNull(retrieved);
        assertEquals("Call dad", retrieved.getDescription());
        assertEquals(futureDate, retrieved.getAppointmentDate());
    }

    // Test 5: Delete an appointment
    @Test
    void testDeleteAppointment() {
        Date futureDate = getFutureDate();
        Appointment a = new Appointment("DEL33", futureDate, "Walk dog");
        as.addAppointment(a);

        assertTrue(as.hasAppointment("DEL33"));
        as.deleteAppointment("DEL33");
        assertFalse(as.hasAppointment("DEL33"));
    }

    // Test 6: Try to delete non-existent appointment
    @Test
    void testDeleteNonExistent() {
        try {
            as.deleteAppointment("NOTHERE");
            fail("Should have thrown exception");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Cant find"));
        }
    }

    // Test 7: Update appointment date
    @Test
    void testUpdateAppointmentDate() {
        Date futureDate = getFutureDate();
        Appointment a = new Appointment("UPD77", futureDate, "Water plants");
        as.addAppointment(a);

        Calendar newCal = Calendar.getInstance();
        newCal.add(Calendar.DAY_OF_YEAR, 5);
        Date newDate = newCal.getTime();

        as.updateAppointmentDate("UPD77", newDate);
        assertEquals(newDate, as.getAppointment("UPD77").getAppointmentDate());
    }

    // Test 8: Update description
    @Test
    void testUpdateDescription() {
        Date futureDate = getFutureDate();
        Appointment a = new Appointment("DESC99", futureDate, "Short desc");
        as.addAppointment(a);

        as.updateDescription("DESC99", "Updated longer description");
        assertEquals("Updated longer description", as.getAppointment("DESC99").getDescription());
    }

    // Test 9: Try to update non-existent appointment
    @Test
    void testUpdateNonExistent() {
        Date futureDate = getFutureDate();
        try {
            as.updateAppointmentDate("NOSUCH", futureDate);
            fail("Should have thrown exception");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Cant find"));
        }
    }

    // Test 10: Update with too long description
    @Test
    void testUpdateInvalidDescription() {
        Date futureDate = getFutureDate();
        Appointment a = new Appointment("INV100", futureDate, "Short description");
        as.addAppointment(a);

        String longDesc = "This description is way too long because it has more than fifty characters which is not allowed";
        try {
            as.updateDescription("INV100", longDesc);
            fail("Should have thrown exception");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Description is too long"));
        }
    }
}