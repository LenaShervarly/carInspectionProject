
package se.kth.carInspection.integration;
import se.kth.carInspection.data.CarRegistrationNumbersDatabase;

/**
 * Represents a connection to the external system for checking the car's registration numbers and it's type (later theSystem)
 * @author Lena Shervarly
 * @version 0.1
 */
public class ExternalCheckingRegNoSystem {

    /**
     * Provides the information whether the provided registration number of the car exists in theSystem
     * @param regNo The registation number of the car
     * @return true if provided number is available in theSystem
     */
    public static boolean getApprovalOfTheCarRegNo(String regNo) {
      if(CarRegistrationNumbersDatabase.checkTheRegister(regNo))
          return true;
      else 
          return false;
    }

    /**
     * Get the car type of the car on the base of it registration number
     * @param regNo the registration number of the car
     * @return the registration number of the car
     */
    public static String getCarType(String regNo) {
        String carType = CarRegistrationNumbersDatabase.getCarType(regNo);
        return carType;
    }
}
