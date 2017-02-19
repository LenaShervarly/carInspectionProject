
package se.kth.carInspection.integration;

import se.kth.carInspection.controller.*;
import se.kth.carInspection.model.InspectionResultCollection;

public  class Printer {

    
    public static void printReceipt(String receiptInfo) {
      System.out.println(receiptInfo);
    }

    /**
     * Printing to the screen information regarding results of the provided inspetions
     * @param resultInfo information regarding results of the provided inspetions
     */
    public static void printInspectionResult(StringBuffer resultInfo) {
        System.out.println(resultInfo);
    }

}
