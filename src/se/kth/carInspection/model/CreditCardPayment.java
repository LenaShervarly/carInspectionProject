package se.kth.carInspection.model;

import se.kth.carInspection.integration.CreditCardDTO;
import se.kth.carInspection.integration.ExternalPaymentAuthorizationSystem;

public class CreditCardPayment {

    private CreditCardDTO creditCard;
    private boolean paymentStatus;
    private int amount;

    public CreditCardPayment(CreditCardDTO creditCard, int amount) {
        this.creditCard = creditCard;
        this.amount = amount;
    }

    public CreditCardPayment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean authorizePayment(CreditCardDTO creditCard, int amount) {
        ExternalPaymentAuthorizationSystem response = new ExternalPaymentAuthorizationSystem();
        paymentStatus = response.getPaymentStatus();
        return paymentStatus;
    }

    public boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void updatePaymentStatus(boolean paymentStatus) {
        paymentStatus = !paymentStatus;
    }

    public boolean payCreditCard(CreditCardDTO creditCard, int amount) {
        boolean returnedValue = false;
        authorizePayment(creditCard, amount);
        returnedValue = getPaymentStatus();
        return returnedValue;

    }
}
