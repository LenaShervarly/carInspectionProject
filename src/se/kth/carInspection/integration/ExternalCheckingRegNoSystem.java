/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.carInspection.integration;
import se.kth.carInspection.data.CarRegistrationNumbersDatabase;

/**
 *
 * @author tmpuser-10206
 */
public class ExternalCheckingRegNoSystem {
    boolean isApproved;
    CarRegistrationNumbersDatabase RegNodatabase;
    
    public ExternalCheckingRegNoSystem() {
        isApproved = false;
        RegNodatabase = new CarRegistrationNumbersDatabase();
    }
    
    public boolean getApprovalOfTheCarRegNo(String regNo) {
      if(RegNodatabase.checkTheRegister(regNo))
          return true;
      else 
          return false;
    }
            
    public boolean getStatus() {
        return isApproved;
    }       
    
    public String getCarType(String regNo) {
        return RegNodatabase.getCarType(regNo);
    }
}
