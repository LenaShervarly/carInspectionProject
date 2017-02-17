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

    public void payCreditCard(CreditCardDTO creditCard, int amount) {
        paymentType = "Credit card";
        creditCardPayment = new CreditCardPayment(creditCard, amount);
        creditCardPayment.authorizePayment();

    }

    public void payCash(int amountPaid, int totalCost) {
        paymentType = "Cash";
        cashPayment = new CashPayment(amountPaid, totalCost);
        cashPayment.payCash();
    }

    public boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus() {
        paymentStatus = !paymentStatus;
    }

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

    public String completeReceiptInfo() {

        String receiptInfo = prepareReceiptInfo();
        if (paymentType.equals("Cash")) {
            receipt += cashPayment.getPaymentInfo();
        } else {
            receipt += creditCardPayment.getPaymentInfo();
        }
        return receipt;
    }

    public void printReciept() {
        prepareReceiptInfo();
        completeReceiptInfo();
        Printer.printReceipt(receipt);
    }

}
