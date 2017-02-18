
package se.kth.carInspection.integration;
import se.kth.carInspection.data.CarRegistrationNumbersDatabase;

/**
 * Represents a connection to the external system for checking the car's registration numbers and it's type (later theSystem)
 * @author Lena Shervarly
 * @version 0.1
 */
public class ExternalCheckingRegNoSystem {
    private boolean isApproved;
    private static CarRegistrationNumbersDatabase RegNodatabase;
    private static String carType;
    
    /**
     * Creates a representant of theSystem 
     */
    public ExternalCheckingRegNoSystem() {
        isApproved = false;
        RegNodatabase = new CarRegistrationNumbersDatabase();
    }
    
    /**
     * Provides the information whether the provided registration number of the car exists in theSystem
     * @param regNo The registation number of the car
     * @return true if provided number is available in theSystem
     */
    public static boolean getApprovalOfTheCarRegNo(String regNo) {
      if(RegNodatabase.checkTheRegister(regNo))
          return true;
      else 
          return false;
    }
    
    /**
     * Get information whether the number was approved
     * @return true if the registration number had beed approved
     */
    public boolean getIsApproved() {
        return isApproved;
    }       
    
    /**
     * Get the car type of the car on the base of it registration number
     * @param regNo the registration number of the car
     * @return the registration number of the car
     */
    public static String getCarType(String regNo) {
        carType = RegNodatabase.getCarType(regNo);
        return carType;
    }
}
