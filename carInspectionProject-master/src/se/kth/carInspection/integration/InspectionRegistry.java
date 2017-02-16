
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.carInspection.integration;
import java.util.ArrayList;

/**
 *
 * @author tmpuser-10206
 */
public class InspectionRegistry {
    private ArrayList<InspectionDTO> inspectionCollection;
    private String carType;
    
    public InspectionRegistry(){
        inspectionCollection = new ArrayList<>();
        carType = "";
    }
    
    public void setInspectioCollectio(InspectionDTO inspection, String carType) {
        inspectionCollection.add(inspection);
        carType = carType;
    }
    
    
    public ArrayList<InspectionDTO> getInspectionCollection() {
        return inspectionCollection;
    }
    public String getCarType() {
        return carType;
    }    
    
}
