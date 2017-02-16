/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.carInspection.data;
import java.util.HashMap;

/**
 *
 * @author tmpuser-10206
 */
public class CarRegistrationNumbersDatabase {
    private HashMap<String, String> registrationNumbers;
    
    public CarRegistrationNumbersDatabase(){
        registrationNumbers = new HashMap<>();
        fillTheRegister();
    }
    
    private void fillTheRegister() {
        registrationNumbers.put("A12", "Volvo");
        registrationNumbers.put("A23", "Saab");
        registrationNumbers.put("A44", "Toyota");
        registrationNumbers.put("B13", "Volvo");
        registrationNumbers.put("B45", "Tesla");
        registrationNumbers.put("B16", "Saab");    
    }
    public boolean checkTheRegister(String regNo){
        if(registrationNumbers.containsKey(regNo))
            return true;
        else
            return false;
    }
    public String getCarType(String registrationNumber) {
        return registrationNumbers.get(registrationNumber);
    }
}
