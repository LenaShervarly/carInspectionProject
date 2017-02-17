package se.kth.carInspection.integration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import se.kth.carInspection.data.CarRegistrationNumbersDatabase;

import static org.junit.Assert.*;

/**
 *
 * @author Lena Shervarly
 */
public class ExternalCheckingRegNoSystemTest {
    private CarRegistrationNumbersDatabase RegNodatabase;
    private String carType;

    @Before
    public void setUp() throws Exception {
        RegNodatabase  = new CarRegistrationNumbersDatabase();
        RegNodatabase.addingLinesToDatabase("A15", "Mers");
        RegNodatabase.addingLinesToDatabase("A25", "BMV");
        RegNodatabase.addingLinesToDatabase("B20", "Lanos");
    }

    @After
    public void tearDown() throws Exception {
        RegNodatabase = null;
    }

    @Test
    public static void getApprovalOfTheCarRegNoTest() throws Exception {
        assertTrue("Doesn't approve the value that should be in the database",ExternalCheckingRegNoSystem.getApprovalOfTheCarRegNo("A15"));
        assertTrue("Doesn't approve the value that should be in the database",ExternalCheckingRegNoSystem.getApprovalOfTheCarRegNo("A25"));
        assertTrue("Doesn't approve the value that should be in the database",ExternalCheckingRegNoSystem.getApprovalOfTheCarRegNo("B20"));
        assertFalse("Approves the value that shouldn't be in the database",ExternalCheckingRegNoSystem.getApprovalOfTheCarRegNo(""));
        assertFalse("Approves the value that shouldn't be in the database",ExternalCheckingRegNoSystem.getApprovalOfTheCarRegNo(" "));
        assertFalse("Approves the value that shouldn't be in the database",ExternalCheckingRegNoSystem.getApprovalOfTheCarRegNo("B"));
    }

    @Test
    public void getCarType() throws Exception {
        assertEquals("Doesn't return the right carType","Mers", ExternalCheckingRegNoSystem.getCarType("A15"));
        assertEquals("Doesn't return the right carType", "BMV", ExternalCheckingRegNoSystem.getCarType("A25"));
        assertEquals("Doesn't return the right carType", "Lanos", ExternalCheckingRegNoSystem.getCarType("B20"));
        assertNotEquals("Finds what shouldn't be in the database", "", ExternalCheckingRegNoSystem.getCarType(null));
    }

}