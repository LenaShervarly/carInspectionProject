package se.kth.carInspection.integration;

import se.kth.carInspection.model.CashPayment;

public class CashRegistry {

    private int balance;

    public CashRegistry() {

    }

    /**
     * add the cost of inspections to the balance
     */
    public void addAmount(int finalPayment) {
        balance += finalPayment;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalanceToZero() {
        balance = 0;
    }
}
