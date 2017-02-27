package se.kth.carInspection.model;

import se.kth.carInspection.integration.*;
import se.kth.carInspection.controller.*;
import se.kth.carInspection.data.*;
import java.util.ArrayList;

public class CashPayment {
    private int amountPaid;
    private int totalCost;

    public CashPayment(int amountPaid,int totalCost) {
        this.amountPaid = amountPaid;
        this.totalCost=totalCost;
    }

    private int getChange() {
        int change = totalCost - amountPaid;
        return change;
    }

    private void updateCashPresent() {

        CashRegistry.getCashRegistry().addAmount(totalCost);
        System.out.println("The cash present updated\n");
    }

    public void payCash() {
        int change = getChange();
        updateCashPresent();
    }
    
    public String getPaymentInfo(){
        String info = "The change: " + getChange();
        return info;
    }
 }

