/*
 * Public university project.
 * 
 */
package se.kth.carInspection.startUp;

import se.kth.carInspection.controller.Controller;
import se.kth.carInspection.controller.Payment;
import se.kth.carInspection.integration.CashRegistry;
import se.kth.carInspection.integration.ExternalCheckingRegNoSystem;
import se.kth.carInspection.integration.ExternalPaymentAuthorizationSystem;
import se.kth.carInspection.integration.Printer;
import se.kth.carInspection.model.Garage;
import se.kth.carInspection.view.View;

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
        Controller controller = new Controller(printer, externalAuthorSyst, garage); 
        
               
        View view = new View(controller);
        
        
        
    }
    
}
