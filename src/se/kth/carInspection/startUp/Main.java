/*
 * Public university project.
 * 
 */
package se.kth.rentalcarproject.startUp;

import se.kth.carInspection.controller.Payment;
import se.kth.carInspection.integration.CashRegistry;
import se.kth.carInspection.integration.ExternalCheckingRegNoSystem;
import se.kth.carInspection.integration.ExternalPaymentAuthorizationSystem;
import se.kth.carInspection.integration.Printer;
import se.kth.carInspection.model.Garage;
import se.kth.rentalcarproject.view.View;

/**
 *
 * @author Leo
 */
public class Main {
    
    public static void main(String[] args) {
        Printer printer = new Printer();
        CashRegistry cashRegister = new CashRegistry();
        ExternalPaymentAuthorizationSystem externalAuthorSyst = new ExternalPaymentAuthorizationSystem();
        ExternalCheckingRegNoSystem externalRegNoSystem = new ExternalCheckingRegNoSystem();
        Garage garage= new Garage();
        Controller controller = new Controller(printer, externalRegNoSystem, garage, cashRegister, externalAuthorSyst); 
       
        
        View view = new View(controller);
        
        
        
    }
    
}
