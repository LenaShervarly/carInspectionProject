package se.kth.carInspection.model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import se.kth.carInspection.data.InspectionDTO;
import se.kth.carInspection.data.InspectionRegistriesCollection;
import se.kth.carInspection.data.InspectionRegistry;

import java.util.Set;


/**
 * Created by elena on 18.02.2017.
 */
public class InspectionResultCollectionTest {
    InspectionResultCollection inspectionResultCollection;
    InspectionRegistry sampeInspectionRegistryLine;
    String sampleCarType;
    InspectionDTO sampleInspection;

    @Before
    public void setUp() throws Exception {
        sampleCarType = "Lada";
        sampleInspection = new InspectionDTO("Checking the seats", 350);
        InspectionRegistriesCollection.fillSampleCollection();
        sampeInspectionRegistryLine = new InspectionRegistry(sampleCarType);
        sampeInspectionRegistryLine.setInspectionCollection(sampleInspection);

        InspectionRegistriesCollection.fillCollection(sampeInspectionRegistryLine);
        inspectionResultCollection = new InspectionResultCollection(sampleCarType);
    }

    @After
    public void tearDown() throws Exception {
        sampeInspectionRegistryLine = null;
        inspectionResultCollection = null;
    }

    @Test
    public void getInspectionResult() throws Exception {
        assertNotNull(inspectionResultCollection.getInspectionResult(sampleInspection));
        assertFalse(inspectionResultCollection.getInspectionResult(sampleInspection));
    }

    @Test
    public void saveInspectionResult() throws Exception {
        inspectionResultCollection.saveInspectionResult(sampleInspection, true);
        assertTrue(inspectionResultCollection.getInspectionResult(sampleInspection));
    }

    @Test
    public void getAllResults() throws Exception {
        Object[] expectedResultCollection = InspectionRegistriesCollection.getInspectionCollection(sampleCarType).toArray();
        Set<InspectionDTO> actualResultCollection = inspectionResultCollection.getAllResults().keySet();
        Object[] foundCollection = actualResultCollection.toArray();

        assertEquals("ResultCollection and Inspection Registry contain not the same list of inspections",expectedResultCollection, foundCollection);

    }

    @Test
    public void prepareInspResultsForPrinting() throws Exception {
        assertNotNull(inspectionResultCollection.prepareInspResultsForPrinting());
    }




}