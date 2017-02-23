package se.kth.carInspection.controller;

import se.kth.carInspection.model.InspectionProcess;
import se.kth.carInspection.integration.CashRegistry;
import se.kth.carInspection.integration.ExternalPaymentAuthorizationSystem;
import se.kth.carInspection.integration.Printer;
import se.kth.carInspection.model.Garage;
import se.kth.carInspection.model.GarageDoor;
import se.kth.carInspection.model.QueueNumberDisplay;

/**
 * The Controller class gives information about the
 *
 * @author valentina
 * @version 0.1 2017/02/16
 */
public class Controller
{
    private ExternalPaymentAuthorizationSystem paymentAuthorization;
    private InspectionProcess inspectionProcess;
    

    /**
     * Constructor for objects of class Contoller that is initializing the
     */

    public Controller(ExternalPaymentAuthorizationSystem paymentAuthorization)
    {
        this.paymentAuthorization = paymentAuthorization;
    }

    /**
     * This method is starting new inspection
     */
    public void startNewInspectionProcess(InspectorDTO inspector)
    {
        inspectionProcess = new InspectionProcess(inspector);
    }

    /**
     * Gives the number of the next customer
     */
    public void nextCustomer()
    {
        Garage.getGarage().nextCustomer();
    }

    /**
     * Closes the door
     */
    public void closeGarageDoor()
    {
        Garage.getGarage().closeDoor();
    }
}
