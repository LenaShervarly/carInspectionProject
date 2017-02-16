
package se.kth.carInspection.controller;
import se.kth.carInspection.integration.ExternalCheckingRegNoSystem;
import se.kth.carInspection.integration.InspectionRegistry;
import se.kth.carInspection.data.InspectionDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import se.kth.carInspection.data.InspectionRegistriesCollection;
import se.kth.carInspection.integration.Vehicle;
import se.kth.carInspection.model.InspectionResultCollection;
/**
 * Inspection Process deals with everything needed in order to provide inspection
 * @author Lena Shervarly
 * @version 0.1
 */
public class InspectionProcess {
    private InspectorDTO inspectorWhoLogsIn;
    private ExternalCheckingRegNoSystem checkingRegNo;
    private InspectionRegistriesCollection inspectionRegistriesCollection;
    private String registrationNumber;
    private String carType;
    private ArrayList<InspectionDTO> inspectionsForVehicle;
    
    /**
     * Created Inspection Process on the base of login details of the Inspector
     * @param inspector inspector who initializes the inspection process
     */
    public InspectionProcess(InspectorDTO inspector) {
        inspectorWhoLogsIn = inspector;
        checkingRegNo = new ExternalCheckingRegNoSystem();
        inspectionRegistriesCollection = new InspectionRegistriesCollection();
    }
    
    /**
     * Get the registration number of the vehicle
     * @param vehicleBeingInspected the car whose registration number is being searched
     * @return the registration number of the vehicle
     */
    public String getRegNo(Vehicle vehicleBeingInspected) {
        registrationNumber = vehicleBeingInspected.getRegistrationNumber();
        return registrationNumber;
    }
    
    /**
     * Get the car type of the given <code>vehicleBeingInspected</code>
     * @param vehicleBeingInspected the car whose type is being searched
     * @return the car type of the vehicle
     */
    public String getCarType(Vehicle vehicleBeingInspected) {
        carType = checkingRegNo.getCarType(registrationNumber);
        return carType; 
    }
    
    /**
     * Entering the registration number of the <code>vehicleBeingInspected</code> to the system
     * @param vehicleBeingInspected the car, which enters the garage for the inspection
     * @return true if the operation of entering the registration number to the system was successful 
     */
    public boolean enterVehicleRegNumber(Vehicle vehicleBeingInspected){
        getRegNo(vehicleBeingInspected);
        if(checkingRegNo.getApprovalOfTheCarRegNo(registrationNumber))
            return true;
        else
            return false;
    }
    
    /**
     * Retrieve a collection of inspections for a specified <code>vehicleBeingInspected</code>
     * @param vehicleBeingInspected the vehicle being inspected
     * @return a collection of inspections for a specified vehicle
     * @throws NullPointerException 
     */
    public ArrayList<InspectionDTO> retrieveInspections(Vehicle vehicleBeingInspected) throws NullPointerException {
        getRegNo(vehicleBeingInspected);
                
        if(enterVehicleRegNumber(vehicleBeingInspected)) {
            inspectionsForVehicle = inspectionRegistriesCollection.getInspectionCollection(carType);
            return inspectionsForVehicle;
        }
        else {
            throw new NullPointerException("This vehicle is number is not in service");
        }
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
    public void inspect(Vehicle vehicleBeingInspected) {
        getCarType(vehicleBeingInspected);
        InspectionResultCollection inspectionResults  = new InspectionResultCollection(carType);
        HashMap<InspectionDTO, Boolean> resultsCollection = inspectionResults.getAllResults();

        for(Map.Entry<InspectionDTO, Boolean> result : resultsCollection.entrySet()) {
            inspectionResults.saveInspectionResult(result.getKey(), true);
        }
    }
}
