
package se.kth.carInspection.controller;
import se.kth.carInspection.integration.ExternalCheckingRegNoSystem;
import se.kth.carInspection.data.InspectionDTO;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import se.kth.carInspection.data.InspectionRegistriesCollection;
import se.kth.carInspection.integration.Printer;
import se.kth.carInspection.integration.Vehicle;
import se.kth.carInspection.model.InspectionResultCollection;

import static java.lang.System.in;
import java.io.InputStream;
import se.kth.carInspection.data.InspectionRegistriesException;
import se.kth.carInspection.integration.IllegalLicenseNumberException;

/**
 * Inspection Process deals with everything needed in order to provide inspection
 * @author Lena Shervarly
 * @version 0.1
 */
public class InspectionProcess {
    private InspectorDTO inspectorWhoLogsIn;
    private String registrationNumber;
    private String carType;
    private ArrayList<InspectionDTO> inspectionsForVehicle;
    private InspectionResultCollection inspectionResults;
    Scanner scanner = new Scanner(new InputStreamReader(System.in));

    
    /**
     * Created Inspection Process on the base of login details of the Inspector
     * @param inspectorWhoLogsIn inspectorWhoLogsIn who initializes the inspection process
     */
    public InspectionProcess(InspectorDTO inspectorWhoLogsIn) {
        this.inspectorWhoLogsIn = inspectorWhoLogsIn;
    }

    /**
     * Get data regarding inspector, who launched the system
     * @return inspector who logs in data
     */
    public InspectorDTO getInspectorWhoLogsIn() {return inspectorWhoLogsIn;}
    
    /**
     * Get the registration number of the vehicle
     * @param vehicleBeingInspected the car whose registration number is being searched
     * @return the registration number of the vehicle
     */
    private String getRegistrationNo(Vehicle vehicleBeingInspected) {
        registrationNumber = vehicleBeingInspected.getRegistrationNumber();
        return registrationNumber;
    }
    
    /**
     * Get the car type of the given <code>vehicleBeingInspected</code>
     * @param vehicleBeingInspected the car whose type is being searched
     * @return the car type of the vehicle
     */
    public String getCarType(Vehicle vehicleBeingInspected) throws OperationFailedException {
        try {
            registrationNumber = getRegistrationNo(vehicleBeingInspected);
            carType = ExternalCheckingRegNoSystem.getCarType(registrationNumber);
            return carType; 
        } catch(IllegalLicenseNumberException illLicE) {
            throw new OperationFailedException("The licence number of the vehicle " + vehicleBeingInspected.getRegistrationNumber() + " is not valid. Please check again.", illLicE);
        }
    }
    
    /**
     * Entering the registration number of the <code>vehicleBeingInspected</code> to the system
     * @param vehicleBeingInspected the car, which enters the garage for the inspection
     * @return true if the operation of entering the registration number to the system was successful 
     */
    public boolean enterVehicleRegNumber(Vehicle vehicleBeingInspected){
        registrationNumber = getRegistrationNo(vehicleBeingInspected);
        if(ExternalCheckingRegNoSystem.getApprovalOfTheCarRegNo(registrationNumber))
            return true;
        else
            return false;
    }
    
    /**
     * Retrieve a collection of inspections for a specified <code>vehicleBeingInspected</code>
     * @param vehicleBeingInspected the vehicle being inspected
     * @return a collection of inspections for a specified vehicle
     * @throws OperationFailedException if it's not possible to retrieve inspections for the specified vehicle 
     */
    public ArrayList<InspectionDTO> retrieveInspections(Vehicle vehicleBeingInspected) throws OperationFailedException {
        
        carType = getCarType(vehicleBeingInspected);
        if(enterVehicleRegNumber(vehicleBeingInspected)) {
            try{
                inspectionsForVehicle = InspectionRegistriesCollection.getInspectionCollection(carType);
                return inspectionsForVehicle;
            } catch(InspectionRegistriesException e) {
                 throw new OperationFailedException("This vehicle with registration number " + vehicleBeingInspected.getRegistrationNumber() + " is not in service", e);
            }
        }
        return inspectionsForVehicle;
    }
    
    /**
     * Get the total cost of all the inspections for the vehicle
     * @return  cost of all the inspections for the vehicle
     */
    public int calculateInspectionCost() {
        int totalCost = 0;
        for(InspectionDTO inspection : inspectionsForVehicle)
            totalCost += inspection.getCost();
        return totalCost;
    }
    
    /**
     * Inspect the given vehicle
     * @param vehicleBeingInspected the vehicle being inspected
     */
    public void inspect(Vehicle vehicleBeingInspected) throws OperationFailedException {
        carType = getCarType(vehicleBeingInspected);
        inspectionResults  = new InspectionResultCollection(carType);
        HashMap<InspectionDTO, Boolean> resultsCollection = inspectionResults.getAllResults();

        for(Map.Entry<InspectionDTO, Boolean> resultsEstablishing : resultsCollection.entrySet()) {
            System.out.println("The result for the inspection " + resultsEstablishing.getKey().getDesctription() + " is: ");
            boolean result = scanner.nextBoolean();
            inspectionResults.saveInspectionResult(resultsEstablishing.getKey(), result);
        }
    }

    /**
     * Printing information regarding results of the provided inspetions
     */
    public void printingResults () {
        Printer.printInspectionResult(inspectionResults.prepareInspResultsForPrinting());
    }
}
