
package se.kth.carInspection.integration;

import se.kth.carInspection.controller.*;
import se.kth.carInspection.model.InspectionResultCollection;

public  class Printer { 
    private static final Printer ptinter = new Printer();
    
    private Printer() {
    }
    
    /**
     * Get the only one instance of the class Printer
     * @return 
     */
    public static Printer getPtinter() {
        return ptinter;
    }
    
    /**
     * Prints the receipt of payment 
     * @param receiptInfo the receipt information of the payment made
     */
    public void printReceipt(String receiptInfo) {
      System.out.println(receiptInfo);
    }

    /**
     * Printing to the screen information regarding results of the provided inspetions
     * @param resultInfo information regarding results of the provided inspetions
     */
    public void printInspectionResult(StringBuffer resultInfo) {
        System.out.println(resultInfo);
    }

}
