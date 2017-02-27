/*
 * Public university project.
 * 
 */
package se.kth.carInspection.view;

import java.io.File;
import java.io.IOException;
import se.kth.carInspection.controller.Controller;
import se.kth.carInspection.model.InspectionProcess;
import se.kth.carInspection.controller.InspectorDTO;
import se.kth.carInspection.model.OperationFailedException;
import se.kth.carInspection.controller.Payment;
import se.kth.carInspection.integration.ExternalCheckingRegNoSystem;
import se.kth.carInspection.integration.ExternalPaymentAuthorizationSystem;
import se.kth.carInspection.integration.IllegalLicenseNumberException;
import se.kth.carInspection.integration.Vehicle;
import se.kth.carInspection.model.InspectionResultCollection;
import se.kth.carInspection.model.PaymentType;
import util.LogHandler;

/**
 *
 * @author Leo
 */
public class View {
    private Controller controller;
    private ErrorMessagesHandler errMessHandler  = new ErrorMessagesHandler();
    private LogHandler logHandler;
    
    public View(Controller controller) {
        this.controller = controller;
    }

    public void sampleExecution() {
        try {
            InspectorDTO inspector = new InspectorDTO ("Student", "KTH");
            InspectionProcess inspectioning = new InspectionProcess(inspector);
            Vehicle sampleCar = new Vehicle("A12");
            controller.startNewInspectionProcess(inspector);
            controller.nextCustomer();
            controller.closeGarageDoor();
            inspectioning.enterVehicleRegNumber(sampleCar);
            try {
                inspectioning.retrieveInspections(sampleCar);
            } catch (OperationFailedException e) {
                handleException(e, "It's not possible to retrieve a list of inspections for your car. Please check if the registration number is valid and try again.");
            }
            System.out.println("The price for all inspections is " + inspectioning.calculateInspectionCost() + " SEK\n");
            
            Payment payment = new Payment(PaymentType.CASH, sampleCar);
            payment.pay(1500, null);
            payment.printReciept();
                    
            String sampleCarType = inspectioning.getCarType(sampleCar);
            
            sampleCarType = inspectioning.getCarType(sampleCar);
            try {
                inspectioning.inspect(sampleCar);
            } catch (OperationFailedException e) {
                handleException(e, "Couldn't inspect the car: " + sampleCarType + " Please check everything and try again");
            }
            inspectioning.printingResults();
        } catch (Exception e) {
            handleException(e, "Failed to inspect. Please try again.");
        }
    }
    
    private void handleException(Exception e, String msgForUser ) {
        try {
            logHandler = new LogHandler();    
        } catch(IOException ioe) {
            System.out.println(e.getMessage());
        }
        errMessHandler.showErrorMessage(msgForUser);
        logHandler.loggingException(e);
    }
}
