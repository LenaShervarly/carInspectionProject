/*
 * Public university project.
 * 
 */
package se.kth.carInspection.data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.ArrayList;

/**
 *
 * @author Lena Shervarly
 */
public class InspectionRegistriesCollectionTest {
    

    InspectionRegistry firstInspectionRegistryLine;
    InspectionRegistry secondInspectionRegistryLine;
    InspectionRegistry thirdInspectionRegistryLine;
    
    @Before
    public void setUp() {

        firstInspectionRegistryLine = new InspectionRegistry("Volvo");
        secondInspectionRegistryLine = new InspectionRegistry("Saab");
        thirdInspectionRegistryLine = new InspectionRegistry("Mers");

        InspectionRegistriesCollection.fillCollection(firstInspectionRegistryLine);
        InspectionRegistriesCollection.fillCollection(secondInspectionRegistryLine);
        InspectionRegistriesCollection.fillCollection(thirdInspectionRegistryLine);
    }
    
    @After
    public void tearDown() {
        //inspectionReg = null;
    }
    
    @Test
    public void testCheckAvailability() {
        assertTrue("Not able to find the car that is there", InspectionRegistriesCollection.checkAvailability("Volvo"));
        assertTrue("Not able to find the car that is there", InspectionRegistriesCollection.checkAvailability("Saab"));
        assertTrue("Not able to find the car that is there", InspectionRegistriesCollection.checkAvailability("Mers"));
        assertFalse("Able to find the car that is not in the database",InspectionRegistriesCollection.checkAvailability("Moskvich"));
        assertFalse("Able to find the car that is not in the database",InspectionRegistriesCollection.checkAvailability(null));
    }

    @Test
    public void testGetInspectionCollection() {
        ArrayList<InspectionDTO> inpectionsExpected1 = firstInspectionRegistryLine.getInspectionCollection();
        ArrayList<InspectionDTO> inpectionsRetrieved1 = InspectionRegistriesCollection.getInspectionCollection("Volvo");
        assertNotNull("The collection of inspections is empty", firstInspectionRegistryLine.getInspectionCollection());
        assertNotNull("The collection of inspections is empty", InspectionRegistriesCollection.getInspectionCollection("Volvo"));
        assertEquals("The list of inspections is not matching", inpectionsExpected1, inpectionsRetrieved1);

        ArrayList<InspectionDTO> inpectionsExpected2 = secondInspectionRegistryLine.getInspectionCollection();
        ArrayList<InspectionDTO> inpectionsRetrieved2 = InspectionRegistriesCollection.getInspectionCollection("Saab");
        assertNotNull("The list of inspections is not matching", InspectionRegistriesCollection.getInspectionCollection("Saab"));
        assertEquals("The list of inspections is not matching", inpectionsExpected2, inpectionsRetrieved2);

    }
}
