/*
 * Public university project.
 * 
 */
package se.kth.carInspection.data;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import se.kth.carInspection.data.InspectionDTO;
import se.kth.carInspection.data.InspectionRegistriesCollection;
import se.kth.carInspection.integration.InspectionRegistry;

import java.util.ArrayList;

/**
 *
 * @author Lena Shervarly
 */
public class InspectionRegistriesCollectionTest {
    
    InspectionRegistriesCollection inspectionReg;
    InspectionRegistry firstInspectionRegistryLine;
    InspectionRegistry secondInspectionRegistryLine;
    InspectionRegistry thirdInspectionRegistryLine;
    
    @Before
    public void setUp() {
        inspectionReg = new InspectionRegistriesCollection();
        firstInspectionRegistryLine = new InspectionRegistry("Volvo");
        secondInspectionRegistryLine = new InspectionRegistry("Saab");
        thirdInspectionRegistryLine = new InspectionRegistry("Mers");

        inspectionReg.fillCollection(firstInspectionRegistryLine);
        inspectionReg.fillCollection(secondInspectionRegistryLine);
        inspectionReg.fillCollection(thirdInspectionRegistryLine);
    }
    
    @After
    public void tearDown() {
        inspectionReg = null;
    }
    
    @Test
    public void testCheckAvailability() {
        assertTrue("Not able to find the car that is there", inspectionReg.checkAvailability("Volvo"));
        assertTrue("Not able to find the car that is there", inspectionReg.checkAvailability("Saab"));
        assertTrue("Not able to find the car that is there", inspectionReg.checkAvailability("Mers"));
        assertFalse("Able to find the car that is not in the database",inspectionReg.checkAvailability("Moskvich"));
        assertFalse("Able to find the car that is not in the database",inspectionReg.checkAvailability(null));
    }

    @Test
    public void testGetInspectionCollection() {
        ArrayList<InspectionDTO> inpectionsExpected1 = firstInspectionRegistryLine.getInspectionCollection();
        ArrayList<InspectionDTO> inpectionsRetrieved1 = inspectionReg.getInspectionCollection("Volvo");
        assertEquals("The list of inspections is not matching", inpectionsExpected1, inpectionsRetrieved1);

        ArrayList<InspectionDTO> inpectionsExpected2 = secondInspectionRegistryLine.getInspectionCollection();
        ArrayList<InspectionDTO> inpectionsRetrieved2 = inspectionReg.getInspectionCollection("Saab");
        assertEquals("The list of inspections is not matching", inpectionsExpected2, inpectionsRetrieved2);

    }
}
