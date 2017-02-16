/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.carInspection.integration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author tmpuser-10206
 */
public class InspectionResultCollection {
    private HashMap<InspectionDTO, Boolean> results;
    private InspectionRegistry inspectionRegistry;
    
    
    public InspectionResultCollection(String carType, ArrayList<InspectionDTO> inspectionCollection) {
        results = new HashMap<>();
        if(inspectionRegistry.getCarType().equals(carType)){
            for(int i = 0; i< inspectionCollection.size(); i++)
                results.put(inspectionCollection.get(i), false);
        }
    }
    
    public void addResultsCollection(InspectionDTO inspection, Boolean result) {
        results.put(inspection, result);
    } 
            
    public boolean getInspectionResult(InspectionDTO inspection)  {
        if(results.containsKey(inspection))
            return results.get(inspection);
        else {
            System.out.print("This inspection is not provided for the car");
            return false;
        }       
    }
    public void saveInspectionResult(InspectionDTO inspection, Boolean updatedResult)  {
        if(results.containsKey(inspection))
            results.replace(inspection, updatedResult);
        else {
            System.out.print("This inspection is not provided for the car");
            
        }       
    }
    
    public HashMap<InspectionDTO, Boolean> getAllResults() {
        return results;
    }
    
    // !!!!Change System.out.println to PRINTER command
    public void printAllResults() {
        for(Map.Entry<InspectionDTO, Boolean> entry : results.entrySet())
            System.out.println(entry.getKey() + " " + entry.getValue());
    } 

}
