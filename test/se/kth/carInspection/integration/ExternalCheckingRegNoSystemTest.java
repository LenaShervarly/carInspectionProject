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


    @Before
    public void setUp() throws Exception {

        CarRegistrationNumbersDatabase.fillSampleRegister();
        CarRegistrationNumbersDatabase.addingLinesToDatabase("A15", "Mers");
        CarRegistrationNumbersDatabase.addingLinesToDatabase("A25", "BMV");
        CarRegistrationNumbersDatabase.addingLinesToDatabase("B20", "Lanos");
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getApprovalOfTheCarRegNoTest() throws Exception {
        assertTrue("Doesn't approve the value that should be in the database",ExternalCheckingRegNoSystem.getApprovalOfTheCarRegNo("A15"));
        assertTrue("Doesn't approve the value that should be in the database",ExternalCheckingRegNoSystem.getApprovalOfTheCarRegNo("A25"));
        assertTrue("Doesn't approve the value that should be in the database",ExternalCheckingRegNoSystem.getApprovalOfTheCarRegNo("B20"));
        assertFalse("Approves the value that shouldn't be in the database",ExternalCheckingRegNoSystem.getApprovalOfTheCarRegNo(""));
        assertFalse("Approves the value that shouldn't be in the database",ExternalCheckingRegNoSystem.getApprovalOfTheCarRegNo(" "));
        assertFalse("Approves the value that shouldn't be in the database",ExternalCheckingRegNoSystem.getApprovalOfTheCarRegNo("B"));
    }

    @Test
    public void getCarType() throws Exception {
        assertNotNull(ExternalCheckingRegNoSystem.getCarType("A15"));
        assertEquals("Doesn't return the right carType","Mers", ExternalCheckingRegNoSystem.getCarType("A15"));

        assertEquals("Doesn't return the right carType", "BMV", ExternalCheckingRegNoSystem.getCarType("A25"));
        assertEquals("Doesn't return the right carType", "Lanos", ExternalCheckingRegNoSystem.getCarType("B20"));

    }

}