/*
 * Public university project.
 * 
 */
package se.kth.carInspection.view;

import se.kth.carInspection.controller.Controller;
import se.kth.carInspection.controller.InspectionProcess;
import se.kth.carInspection.controller.InspectorDTO;
import se.kth.carInspection.integration.ExternalCheckingRegNoSystem;
import se.kth.carInspection.integration.ExternalPaymentAuthorizationSystem;
import se.kth.carInspection.integration.Vehicle;
import se.kth.carInspection.model.InspectionResultCollection;

/**
 *
 * @author Leo
 */
public class View {
    private Controller controller;
    
    public View(Controller controller) {
        this.controller = controller;
    }

    public void sampleExecution() {
        InspectorDTO inspector = new InspectorDTO ("Student", "KTH");
        InspectionProcess inspectioning = new InspectionProcess(inspector);
        Vehicle sampleCar = new Vehicle("A12");
        inspectioning.enterVehicleRegNumber(sampleCar);
        inspectioning.retrieveInspections(sampleCar);
        inspectioning.calculateInspectionCost();
        String sampleCarType = ExternalCheckingRegNoSystem.getCarType(sampleCar.getRegistrationNumber());
        InspectionResultCollection inspectionResultCollection = new InspectionResultCollection(sampleCarType);
        //System.out.println(inspectionResultCollection.prepareInspResultsForPrinting());
        inspectioning.inspect(sampleCar);
        inspectioning.printingResults();
    }
}
