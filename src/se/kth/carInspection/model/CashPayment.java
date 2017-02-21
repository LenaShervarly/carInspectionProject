package se.kth.carInspection.model;

import se.kth.carInspection.integration.*;
import se.kth.carInspection.controller.*;
import se.kth.carInspection.data.*;
import java.util.ArrayList;

public class CashPayment {

    private int amountPaid;
    private int totalCost;
    private CashRegistry cashRegistry;

    public CashPayment(int amountPaid, int totalCost) {
        this.amountPaid = amountPaid;
        this.totalCost = totalCost;
    }

    /**
     * calculates the change
     *
     * @return change
     */
    public int getChange() {

        int change = totalCost - amountPaid;
        return change;
    }

    /**
     * updates the balance
     */
    public void updateCashPresent() {
        cashRegistry = new CashRegistry();
        cashRegistry.addAmount(totalCost);
    }

    /**
     * calculate the change and updates the balance
     *
     * @return change
     */
    public int payCash() {
        int change = getChange();
        updateCashPresent();
        return change;

    }

    /**
     * prepare the cash payment information for printing
     *
     * @return change to be printed
     */
    public String getPaymentInfo() {
        String info = "The change: " + getChange();
        return info;
    }
}
