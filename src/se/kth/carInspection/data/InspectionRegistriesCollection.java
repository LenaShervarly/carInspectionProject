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
    }
    
    /**
     * Fills the Collection of Inspection registries on the base of provided <code>oneInspectionRegistryLine</code>
     * @param oneInspectionRegistryLine one instanse InspectionRegistry class representing one line of Excel
     */
    public void fillCollection(InspectionRegistry oneInspectionRegistryLine) {
        inspectionRegistryCollection.put(oneInspectionRegistryLine.getCarType(), oneInspectionRegistryLine.getInspectionCollection());
    }
    
    /**
     * Fills the Collection of Inspection registries with sample data
     */
    private void fillSampleCollection() {
        InspectionRegistry InspectionRegistryLine1 = new InspectionRegistry("Volvo");
        InspectionRegistry InspectionRegistryLine2 = new InspectionRegistry("Saab");
        InspectionRegistry InspectionRegistryLine3 = new InspectionRegistry("Toyota");
        InspectionRegistry InspectionRegistryLine4 = new InspectionRegistry("Tesla");
        InspectionRegistry InspectionRegistryLine5 = new InspectionRegistry("Mers");
        InspectionRegistry InspectionRegistryLine6 = new InspectionRegistry("BMV");
        InspectionRegistry InspectionRegistryLine7 = new InspectionRegistry("Smart");
        InspectionRegistry InspectionRegistryLine8 = new InspectionRegistry("Lanos");
        InspectionRegistry InspectionRegistryLine9 = new InspectionRegistry("Honda");
        InspectionRegistry InspectionRegistryLine10 = new InspectionRegistry("Other");
    }
}
