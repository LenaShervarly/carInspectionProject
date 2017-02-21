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

    /**
     * @return payment status fromm an external authorization system /
     */
    public boolean authorizePayment() {
        paymentStatus = ExternalPaymentAuthorizationSystem.getPaymentStatus();
        return paymentStatus;
    }

    public boolean getPaymentStatus() {
        return paymentStatus;
    }
    /**
     * update the payment status
     * @param paymentStatus the payment status to be updated
     */
    public void updatePaymentStatus(boolean paymentStatus) {
        paymentStatus = !paymentStatus;
    }

   /**
     * prepare the creditcard payment information for printing
     *
     * @return the payment status(authorized or not) to be printed
     */

    public String getPaymentInfo() {
       String creditCardPaymentInfo="";
       if(authorizePayment())
            creditCardPaymentInfo ="Authorized payment \n"+"Card name " + creditCard.getCardName() + "\n"+"Credit card holder " +creditCard.getCardHolder();
            return creditCardPaymentInfo;
    }
}
