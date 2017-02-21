package se.kth.carInspection.controller;

import java.util.ArrayList;
import se.kth.carInspection.data.InspectionDTO;
import se.kth.carInspection.data.InspectionRegistriesCollection;
import se.kth.carInspection.integration.*;
import se.kth.carInspection.model.*;

public class Payment {

    private String paymentType;
    private boolean paymentStatus;
    private Vehicle carBeingServed;
    private ArrayList<InspectionDTO> productPayed;
    private ExternalCheckingRegNoSystem checkingRegNo;
    private int totalCost;
    private String carType;
    private String receipt;
    private CashPayment cashPayment;
    private CreditCardPayment creditCardPayment;

    public Payment(String paymentType, Vehicle carBeingServed) {
        this.paymentType = paymentType;
        this.carBeingServed = carBeingServed;
        carType = checkingRegNo.getCarType(carBeingServed.getRegistrationNumber());
    }

    /**
     * handels the credit card payment
     */
    public void payCreditCard(CreditCardDTO creditCard, int amount) {
        paymentType = "Credit card";
        creditCardPayment = new CreditCardPayment(creditCard, amount);
        creditCardPayment.authorizePayment();

    }

    /**
     * handels the cash payment
     */
    public void payCash(int amountPaid, int totalCost) {
        paymentType = "Cash";
        cashPayment = new CashPayment(amountPaid, totalCost);
        cashPayment.payCash();
    }

    /**
     * calculate the inspection cost
     *
     * @return inspection cost
     */
    public int getInspectionCost() {
        InspectionRegistriesCollection inspectionRegistry = new InspectionRegistriesCollection();
        checkingRegNo = new ExternalCheckingRegNoSystem();

        productPayed = inspectionRegistry.getInspectionCollection(carType);

        for (InspectionDTO inspection : productPayed) {
            totalCost += inspection.getCost();
        }
        return totalCost;

    }

    private String getPaymentType() {
        return paymentType;
    }

    private String prepareReceiptInfo() {
        receipt = "##################RECEIPT##################";
        receipt += "Car Type: " + carType + "\n" + "Payment type: " + getPaymentType() + "\n" + "Inspectin cost: " + getInspectionCost();
        return receipt;
    }

    /**
     * completes the receipt information depending on the payment type(cach or
     * creditcard)
     *
     * @return string representing the rest of the information
     */
    public String completeReceiptInfo() {

        String receiptInfo = prepareReceiptInfo();
        if (paymentType.equals("Cash")) {
            receipt += cashPayment.getPaymentInfo();
        } else {
            receipt += creditCardPayment.getPaymentInfo();
        }
        return receipt;
    }

    /**
     * calls the printer to print the reciept
     */
    public void printReciept() {
        prepareReceiptInfo();
        receipt = completeReceiptInfo();
        Printer.printReceipt(receipt);

    }

}
