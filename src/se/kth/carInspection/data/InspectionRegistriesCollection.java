/*
 * Public university project.
 * 
 */
package se.kth.carInspection.data;

import java.util.ArrayList;
import java.util.HashMap;
import se.kth.carInspection.integration.InspectionRegistry;

/**
 *
 * Represents a sample external database for all the collection of all inspection registries
 * @author Lena Shervarly
 * @version 0.1
 */
public class InspectionRegistriesCollection {
    
    private HashMap<String, ArrayList<InspectionDTO>> inspectionRegistryCollection;
    
    
    /**
     * Creates a sample external database for all the collection of all inspection registries
     */
    public InspectionRegistriesCollection() {
        inspectionRegistryCollection = new HashMap<>();
        fillSampleCollection();
    }
    
    /**
     * Fills the Collection of Inspection registries on the base of provided <code>oneInspectionRegistryLine</code>
     * @param oneInspectionRegistryLine one instanse InspectionRegistry class representing one line of Excel
     */
    public void fillCollection(InspectionRegistry oneInspectionRegistryLine) {
        inspectionRegistryCollection.put(oneInspectionRegistryLine.getCarType(), oneInspectionRegistryLine.getInspectionCollection());
    }
    
    /**
     * Get the list of all the inspections for the specified car type
     * @param carType the type of the car, the list of inspections should be found for
     * @return the list of all the inspections for the specified car type
     */
    public ArrayList<InspectionDTO> getInspectionCollection(String carType){
        if(inspectionRegistryCollection.containsKey(carType))
            return inspectionRegistryCollection.get(carType);
        else 
            throw new IllegalArgumentException("Type the car is now valid. Type the right one");
    }
    
    /**
     * Checks whether the car type is registred in the collection
     * @param carType the type of the car, whose presense in the register we are checking
     */
    public boolean checkAvailability(String carType) {
        if(inspectionRegistryCollection.containsKey(carType))
            return true;
        else 
            return false;
    }
    
    /**
     * Fills the Collection of Inspection registries with sample data
     */
    private void fillSampleCollection() {
        InspectionRegistry inspectionRegistryLine1 = new InspectionRegistry("Volvo");
        InspectionRegistry inspectionRegistryLine2 = new InspectionRegistry("Saab");
        InspectionRegistry inspectionRegistryLine3 = new InspectionRegistry("Toyota");
        InspectionRegistry inspectionRegistryLine4 = new InspectionRegistry("Tesla");
        InspectionRegistry inspectionRegistryLine5 = new InspectionRegistry("Mers");
        InspectionRegistry inspectionRegistryLine6 = new InspectionRegistry("BMV");
        InspectionRegistry inspectionRegistryLine7 = new InspectionRegistry("Smart");
        InspectionRegistry inspectionRegistryLine8 = new InspectionRegistry("Lanos");
        InspectionRegistry inspectionRegistryLine9 = new InspectionRegistry("Honda");
        InspectionRegistry inspectionRegistryLine10 = new InspectionRegistry("Other");
        
        inspectionRegistryCollection.put(inspectionRegistryLine1.getCarType(), inspectionRegistryLine1.getInspectionCollection());
        inspectionRegistryCollection.put(inspectionRegistryLine2.getCarType(), inspectionRegistryLine2.getInspectionCollection());
        inspectionRegistryCollection.put(inspectionRegistryLine3.getCarType(), inspectionRegistryLine3.getInspectionCollection());
        inspectionRegistryCollection.put(inspectionRegistryLine4.getCarType(), inspectionRegistryLine4.getInspectionCollection());
        inspectionRegistryCollection.put(inspectionRegistryLine5.getCarType(), inspectionRegistryLine5.getInspectionCollection());
        inspectionRegistryCollection.put(inspectionRegistryLine6.getCarType(), inspectionRegistryLine6.getInspectionCollection());
        inspectionRegistryCollection.put(inspectionRegistryLine7.getCarType(), inspectionRegistryLine7.getInspectionCollection());
        inspectionRegistryCollection.put(inspectionRegistryLine8.getCarType(), inspectionRegistryLine8.getInspectionCollection());
        inspectionRegistryCollection.put(inspectionRegistryLine9.getCarType(), inspectionRegistryLine9.getInspectionCollection());
        inspectionRegistryCollection.put(inspectionRegistryLine10.getCarType(), inspectionRegistryLine10.getInspectionCollection());
    }
}
