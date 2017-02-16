

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
        inspectionCollection = new ArrayList<>();
        carType = carType;
    }
    
    /**
     * Enables to fill the registry with the inspections for the type of a car, specified during the creation of this particular registry.
     * @param newInspection The new inspection for the specified car
     */
    public void setInspectioCollectio(InspectionDTO newInspection) {
        inspectionCollection.add(newInspection);
        carType = carType;
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
    
}
