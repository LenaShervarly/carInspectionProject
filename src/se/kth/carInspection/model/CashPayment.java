package se.kth.carInspection.model;

import se.kth.carInspection.integration.*;
import se.kth.carInspection.controller.*;
import java.util.ArrayList;

public class CashPayment {

    private int amountPaid;
    private int totalCost;
    private CashRegistry cashRegistry;

    public CashPayment(int amountPaid) {
        this.amountPaid = amountPaid;
        totalCost = getInspectionCost();
    }

    public int getChange(int amountPaid) {
        
        int change = totalCost - amountPaid;
        return change;
    }
    
    public void updateCashPresent() {
        
        cashRegistry.addAmount(totalCost);
    }

     public int getInspectionCost() {
        InspectionRegistry inspectionRegistry = new InspectionRegistry();
        ArrayList<InspectionDTO> inspections=new ArrayList<>();
        inspections=inspectionRegistry.getInspectionCollection();
        for(InspectionDTO inspection: inspections)
           totalCost+=inspection.getCost();
        return totalCost;
        
    }

   
}
