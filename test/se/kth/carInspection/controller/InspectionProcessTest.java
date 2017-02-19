package se.kth.carInspection.controller;

import se.kth.carInspection.data.CarRegistrationNumbersDatabase;
import se.kth.carInspection.data.InspectionDTO;
import se.kth.carInspection.data.InspectionRegistriesCollection;
import se.kth.carInspection.integration.Vehicle;
import se.kth.carInspection.model.InspectionResultCollection;

import java.util.ArrayList;

import static org.junit.Assert.*;
/**
 *
 * @author Lena Shervarly
 */
public class InspectionProcessTest {
    InspectorDTO inspectorWhoLogsIn;
    String registrationNumber1;
    String registrationNumber2;
    String carType1;
    String carType2;
    //InspectionResultCollection inspectionResults;
    Vehicle vehicleBeingInspected1;
    Vehicle vehicleBeingInspected2;
    InspectionProcess inspectionProcess;

    @org.junit.Before
    public void setUp() throws Exception {
        registrationNumber1 = "A15";
        registrationNumber2 = "B29";
        inspectorWhoLogsIn = new InspectorDTO("Lena", "KTH");
        CarRegistrationNumbersDatabase.addingLinesToDatabase(registrationNumber1, "Saab");
        CarRegistrationNumbersDatabase.addingLinesToDatabase(registrationNumber2, "Volvo");
        InspectionRegistriesCollection.fillSampleCollection();

        vehicleBeingInspected1 = new Vehicle("A15");
        vehicleBeingInspected2 = new Vehicle("B29");
        inspectionProcess = new InspectionProcess(inspectorWhoLogsIn);

        carType1 = CarRegistrationNumbersDatabase.getCarType(registrationNumber1);
        carType2 = CarRegistrationNumbersDatabase.getCarType(registrationNumber2);
    }

    @org.junit.After
    public void tearDown() throws Exception {
        inspectorWhoLogsIn = null;
        vehicleBeingInspected1 = null;
        vehicleBeingInspected2 = null;


    }

    @org.junit.Test
    public void enterVehicleRegNumber() throws Exception {
        assertTrue("The registation verification base is not working properly", inspectionProcess.enterVehicleRegNumber(vehicleBeingInspected1));
        assertTrue("The registation verification base is not working properly", inspectionProcess.enterVehicleRegNumber(vehicleBeingInspected2));
    }

    @org.junit.Test
    public void retrieveInspections() throws Exception {
        ArrayList<InspectionDTO> inspectionsForVehicleFound1 = inspectionProcess.retrieveInspections(vehicleBeingInspected1);
        ArrayList<InspectionDTO> inspectionsExpected1 = InspectionRegistriesCollection.getInspectionCollection(carType1);
        assertNotNull(inspectionProcess.retrieveInspections(vehicleBeingInspected1));
        assertNotNull(InspectionRegistriesCollection.getInspectionCollection(carType1));
        assertEquals("Collections for inspections are not found", inspectionsExpected1, inspectionsForVehicleFound1);

        ArrayList<InspectionDTO> inspectionsForVehicleFound2 = inspectionProcess.retrieveInspections(vehicleBeingInspected2);
        ArrayList<InspectionDTO> inspectionsExpected2 = InspectionRegistriesCollection.getInspectionCollection(carType2);
        assertEquals("Collections for inspections are not found", inspectionsExpected2, inspectionsForVehicleFound2);
    }

    @org.junit.Test
    public void calculateInspectionCost() throws Exception {
        inspectionProcess.retrieveInspections(vehicleBeingInspected1);
        assertEquals("The sum is not correct", 700, inspectionProcess.calculateInspectionCost());
        
    }

    @org.junit.Test
    public void inspect() throws Exception {

    }

}