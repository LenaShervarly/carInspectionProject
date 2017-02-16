package se.kth.carInspection.controller;

import se.kth.carInspection.integration.CreditCardDTO;
import se.kth.carInspection.model.CreditCardPayment;

public class Payment {

    private String paymentType;
    private boolean paymentStatus;
    

    public Payment(String paymentType) {
        this.paymentType = paymentType;
    }

    public boolean payCreditCard(CreditCardDTO creditCard, int amount) {
        CreditCardPayment creditCardPayment = new CreditCardPayment(creditCard, amount);
        return creditCardPayment.payCreditCard(creditCard, amount);

    }

    public int payCash(int amount) {

    }

    public boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus() {
        paymentStatus = !paymentStatus;
    }

    public void printReceipt(Payment payment) {

    }
    
    
}
