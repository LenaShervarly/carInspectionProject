package se.kth.carInspection.model;

import se.kth.carInspection.integration.*;
import se.kth.carInspection.controller.*;
import se.kth.carInspection.data.*;
import java.util.ArrayList;

public class CashPayment {
    private int amountPaid;
    private int totalCost;
    private CashRegistry cashRegistry;

    public CashPayment(int amountPaid,int totalCost) {
        this.amountPaid = amountPaid;
        this.totalCost=totalCost;
    }

    public int getChange() {

        int change = totalCost - amountPaid;
        return change;
    }

    public void updateCashPresent() {

        cashRegistry.addAmount(totalCost);
    }

    public int payCash() {
        int change = getChange();
        updateCashPresent();
        return change;
        

    }
    public String getPaymentInfo(){
        String info="The change: "+getChange();
        return info;
    }
 }

