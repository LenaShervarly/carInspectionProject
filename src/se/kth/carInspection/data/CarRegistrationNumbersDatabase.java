
package se.kth.carInspection.data;
import java.util.HashMap;

/**
 * Represents a sample external database for registration numbers of the car and their types
 * @author Lena Shervarly
 * @version 0.1
 */
public class CarRegistrationNumbersDatabase {
    private HashMap<String, String> registrationNumbers;
    
    /**
     * Creates a sample external database for registration numbers of the car and their types, filling the database with data
     */
    public CarRegistrationNumbersDatabase(){
        registrationNumbers = new HashMap<>();
        fillTheRegister();
    }

    /**
     * Filling the database with new <code>regNo</code> and their relevant <code>carType</code>
     * @param regNo registration number of the car
     * @param carType type of the car
     */
    public void addingLinesToDatabase(String regNo, String carType) {
        registrationNumbers.put(regNo, carType);
    }
    /**
     * Filling the database with data: 
     * Key represents "the registration number" 
     * Value represents "Type of the car"
     */
    private void fillTheRegister() {
        registrationNumbers.put("A12", "Volvo");
        registrationNumbers.put("A23", "Saab");
        registrationNumbers.put("A44", "Toyota");
        registrationNumbers.put("B13", "Volvo");
        registrationNumbers.put("B45", "Tesla");
        registrationNumbers.put("B16", "Saab");    
    }
    
    /**
     * Check if <code>registrationNumber</code> is available in the database
     * @param registrationNumber the registration number of the car
     * @return 
     */
    public boolean checkTheRegister(String registrationNumber){
        if(registrationNumbers.containsKey(registrationNumber))
            return true;
        else
            return false;
    }
    
    /**
     * Provides the type of the car on the base of it registration number
     * @param registrationNumber the registration number of the car
     * @return 
     */
    public String getCarType(String registrationNumber) {
        if(registrationNumbers.containsKey(registrationNumber))
            return registrationNumbers.get(registrationNumber);
        else
            throw new IllegalArgumentException("The registration number is not valid. Try again");
    }
}
