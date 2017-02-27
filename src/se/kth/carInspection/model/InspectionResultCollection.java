
package se.kth.carInspection.model;
import se.kth.carInspection.data.InspectionDTO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import se.kth.carInspection.data.InspectionRegistriesCollection;
import se.kth.carInspection.data.InspectionRegistriesException;
import se.kth.carInspection.view.InspectionStatsView;

/**
 * The collection of the results of inspections provided by inspector for one car
 * @author Lena Shervarly
 * @version 0.1
 */
public class InspectionResultCollection {
    private HashMap<InspectionDTO, Boolean> results;
    private ArrayList<InspectionDTO> inspectionCollection;
    private String carType;
    private int successfulInspections;
    private int failedInspections;
    private InspectionResultObserver observer;

    
    /**
     * Creates the collection of the inspections' results
     * @param carType the Type of the car for which the collection of results is provided
     * @throws IllegalArgumentException if it's not possible to create a collection of inspction results for the <code>carType</code>
     */
    public InspectionResultCollection(String carType) {
        try {
            this.carType = carType;
            results = new HashMap<>();
            if(InspectionRegistriesCollection.getInspectionRegCollection().checkAvailability(carType))
               inspectionCollection = InspectionRegistriesCollection.getInspectionRegCollection().getInspectionCollection(carType);

            for(int i = 0; i < inspectionCollection.size(); i++)
               results.put(inspectionCollection.get(i), false);
        } catch (InspectionRegistriesException inspRegExc) {
            throw new IllegalArgumentException("It's not possible to create the result collection for the car " + carType, inspRegExc);
        }
    }
    
    /**
     * Get the result of the precise <code>inspection</code>
     * @param inspection inspection for which the result is being looked for
     * @return the result of the specific inspection, passed as a parameter
     */
    public boolean getInspectionResult(InspectionDTO inspection)  {
        if(results.containsKey(inspection))
            return results.get(inspection);
        else {
            System.out.print("This inspection is not provided for the car");
            return false;
        }       
    }
    
    /**
     * Enables to save the results for provided inspections
     * @param inspection inspection that had been done
     * @param updatedResult result for <code>inspection</code>
     */
    public void saveInspectionResult(InspectionDTO inspection, Boolean updatedResult)  {
        if(results.containsKey(inspection)) {
            results.replace(inspection, updatedResult);
            observer = new InspectionStatsView();
            observer.newInspectionResultCollection(this);
        } else {
            System.out.print("This inspection is not provided for the car");    
        }
    }
    
    /**
     * Get the collecion of all the inspections' results
     * @return the collecion of all the inspections' results
     */
    public HashMap<InspectionDTO, Boolean> getAllResults() {
        return results;
    }
    
    /**
     * Prints information regarding all the results of inspections
     */
    public StringBuffer prepareInspResultsForPrinting() {
        StringBuffer inspectionResultsPrint = new StringBuffer();
        inspectionResultsPrint.append("***************Results of provided inspections***************" + "\n");
        inspectionResultsPrint.append("For the car " + carType + " the following inspections were made: " + "\n");

        for(Map.Entry<InspectionDTO, Boolean> entry : results.entrySet())
            inspectionResultsPrint.append(" - " + entry.getKey().getDesctription() + " : " + (entry.getValue() ? "pass" : "fail") + "\n");

        return inspectionResultsPrint;
    }
    
    public StringBuffer prepareResulsForTheScreen() {
         successfulInspections =  getSuccesInspections();
         failedInspections = results.size()- successfulInspections;
         StringBuffer inspectionResultsScreen = new StringBuffer();
         inspectionResultsScreen.append("\nFor the car " + carType + " the results of inspections are: \n");
         if(successfulInspections < 1)
             inspectionResultsScreen.append("All the inspections failed: ");
         else
            inspectionResultsScreen.append(successfulInspections + " successful inspections made\n");
         
         if(failedInspections > 0)
            inspectionResultsScreen.append(failedInspections + " inspections steel haven't passed(failed)\n");
         else
             inspectionResultsScreen.append("All the inspections passed. Well done!\n");
         return inspectionResultsScreen;
    }
    
    public int getSuccesInspections() {
        successfulInspections = 0;
        for(Map.Entry<InspectionDTO, Boolean> entry : results.entrySet()) {
            if(entry.getValue().equals(true))
                successfulInspections++;
        }
        return successfulInspections; 
    }
}
