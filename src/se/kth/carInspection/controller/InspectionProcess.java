/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.carInspection.controller;
import se.kth.carInspection.integration.ExternalCheckingRegNoSystem;
import se.kth.carInspection.integration.InspectionRegistry;
import se.kth.carInspection.data.InspectionDTO;
import java.util.ArrayList;
import se.kth.carInspection.model.InspectionResultCollection;
/**
 *
 * @author tmpuser-10206
 */
public class InspectionProcess {
    private InspectorDTO inspectorWhoLogsIn;
    private ExternalCheckingRegNoSystem checkingRegNo;
    private InspectionRegistry registry;
    private ArrayList<InspectionDTO> specifiedInspectionsForVehicle;
    
    public InspectionProcess(InspectorDTO inspector) {
        inspectorWhoLogsIn = inspector;
        checkingRegNo = new ExternalCheckingRegNoSystem();
        registry = new InspectionRegistry();
    }
    public boolean enterVehicleRegNumber(String vehicleRegNo){
        if(checkingRegNo.getApprovalOfTheCarRegNo(vehicleRegNo))
            return true;
        else
            return false;
    }
    
    public ArrayList<InspectionDTO> retrieveInspections(String vehicleRegNo) throws NullPointerException {
        if(checkingRegNo.getCarType(vehicleRegNo).equals(registry.getCarType())) {
            specifiedInspectionsForVehicle = registry.getInspectionCollection();
            return specifiedInspectionsForVehicle;
        }
        else {
            throw new NullPointerException("This vehicle is number is not in service");
        }
    }
    
    public int calculateInspectionCost() {
        int totalCost = 0;
        for(InspectionDTO inspection : specifiedInspectionsForVehicle)
            totalCost += inspection.getCost();
        return totalCost;
    }
    
    public void inspect(String carType, ArrayList<InspectionDTO> inspectionCollection) {
        InspectionResultCollection inspectionResults  = new InspectionResultCollection(carType, inspectionCollection);
        for(InspectionDTO inspection : inspectionCollection) {
            inspectionResults.saveInspectionResult(inspection, true);
        }
    }
}
