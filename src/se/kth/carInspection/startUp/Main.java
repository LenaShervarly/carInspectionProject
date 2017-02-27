/*
 * Public university project.
 * 
 */
package se.kth.carInspection.startUp;

import se.kth.carInspection.controller.Controller;
import se.kth.carInspection.controller.Payment;
import se.kth.carInspection.data.CarRegistrationNumbersDatabase;
import se.kth.carInspection.data.InspectionRegistriesCollection;
import se.kth.carInspection.integration.CashRegistry;
import se.kth.carInspection.integration.ExternalCheckingRegNoSystem;
import se.kth.carInspection.integration.ExternalPaymentAuthorizationSystem;
import se.kth.carInspection.integration.Printer;
import se.kth.carInspection.model.Garage;
import se.kth.carInspection.model.GarageDoor;
import se.kth.carInspection.model.QueueNumberDisplay;
import se.kth.carInspection.view.View;

/**
 *
 * @author Leo
 */
public class Main {
    
    public static void main(String[] args) {
        
        ExternalPaymentAuthorizationSystem externalAuthorSyst = new ExternalPaymentAuthorizationSystem();
        
        
        Controller controller = new Controller(externalAuthorSyst);

        View view = new View(controller);
        view.sampleExecution();
    }
}
