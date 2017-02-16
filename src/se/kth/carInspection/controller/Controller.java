package controller;

/**
 * The Contoller class gives information about the
 *
 * @author valentina
 * @version 0.1 2017/02/16
 */
public class Contoller
{
    private Printer printer;
    private ExternalPaymentAuthorizationSystem paymentAuthorization;
    private CashRegister cashReg;
    private InspectionProcess inspectionProcess;
    private GarageDoor door;
    private QueueNumberDisplay display;

    /**
     * Constructor for objects of class Contoller that is initializing the
     */
    public Contoller(Printer printer, ExternalPaymentAuthorizationSystem paymentAuthorization,CashRegister cashReg)
    {
        this.printer = printer;
        this.paymentAuthorization = paymentAuthorization;
        this.cashReg = cashReg;
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
        door.open();
        display.incrementCurrentNumber();
        System.out.println("Current customer number is: " + display.getCurrentNumber());
    }

    /**
     * Closes the door
     */
    public void closeGarageDoor()
    {
        door.close();
    }
}
