
package se.kth.carInspection.data;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Represents a sample external database for registration numbers of the car and their types
 * @author Lena Shervarly
 * @version 0.1
 */
public class CarRegistrationNumbersDatabase {
    private static HashMap<String, String> registrationNumbers = new HashMap<>();
    
    /**
     * Creates a sample external database for registration numbers of the car and their types, filling the database with data
     */
    public CarRegistrationNumbersDatabase(){
        registrationNumbers = new HashMap<>();
        fillSampleRegister();
    }

    /**
     * Filling the database with new <code>regNo</code> and their relevant <code>carType</code>
     * @param regNo registration number of the car
     * @param carType type of the car
     */
    public static void addingLinesToDatabase(String regNo, String carType) {
        if(!regNo.equals(null) && !carType.equals(null))
            registrationNumbers.put(regNo, carType);
    }
    /**
     * Filling the database with data: 
     * Key represents "the registration number" 
     * Value represents "Type of the car"
     */
    public static void fillSampleRegister() {
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
    public static boolean checkTheRegister(String registrationNumber){
        if(registrationNumbers.containsKey(registrationNumber))
            return true;
        else
            return false;
    }
    
    /**
     * Provides the type of the car on the base of it registration number
     * @param registrationNumber the registration number of the car
     * @return the matching type of the car 
     * @throws SQLException when the registration number can't be found in the database
     */
    public static String getCarType(String registrationNumber) throws SQLException {
        
        if(checkTheRegister(registrationNumber))
            return registrationNumbers.get(registrationNumber);
        else
            throw new SQLException("The registration number " + registrationNumber + " is not in the database");
    }
}
