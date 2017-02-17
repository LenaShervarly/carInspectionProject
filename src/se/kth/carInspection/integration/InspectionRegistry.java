

package se.kth.carInspection.integration;
import se.kth.carInspection.data.InspectionDTO;
import java.util.ArrayList;

/**
 * Contains information about a registry of all the inspections matching one particular type of a car.
 * 
 * @author Lena Shervarly
 * @version 0.1
 */
public class InspectionRegistry {
    private ArrayList<InspectionDTO> inspectionCollection;
    private String carType;

    /**
     * Creates a new instance representing one registry of all the inspections matching one particular type of a car.
     * @param carType The type of the car for wich the collection of inspections is assigned.
     */    
    public InspectionRegistry(String carType){
         if(!carType.equals(null)) {
            this.carType = carType;
            inspectionCollection = new ArrayList<>();
            fillInspectionRegistry();

         }
         else 
             throw new IllegalArgumentException("Type in the type of the car");
    }
    
    /**
     * Enables to fill the registry with the inspections for the type of a car, specified during the creation of this particular registry.
     * @param newInspection The new inspection for the specified car
     */
    public void setInspectioCollection(InspectionDTO newInspection) {
        if(!newInspection.equals(null))
            inspectionCollection.add(newInspection);      
    }
    
     /**
     * Get the collection of all the inspections within this particular registry
     *
     * @return the collection of inspections
     */
    public ArrayList<InspectionDTO> getInspectionCollection() {
        return inspectionCollection;
    }
     /**
     * Get the type of the Car within this particular registry
     *
     * @return the type of the Car
     */
    public String getCarType() {
        return carType;
    }

    /**
     * Filling the Inspection registry with sample basic inspectionChecks basing on the description and cost of every inspection
     */    
    private void fillInspectionRegistry() {
        InspectionDTO inspectionWheel = new InspectionDTO("Inspecting the wheels", 150);
        InspectionDTO inspectionMotor = new InspectionDTO("Inspecting the motor", 350);
        InspectionDTO inspectionDoors = new InspectionDTO("Inspecting the doors", 200);
        
        inspectionCollection.add(inspectionDoors);
        inspectionCollection.add(inspectionMotor);
        inspectionCollection.add(inspectionWheel);
    }
}
