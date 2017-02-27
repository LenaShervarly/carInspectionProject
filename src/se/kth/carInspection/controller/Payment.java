package se.kth.carInspection.controller;

import se.kth.carInspection.model.OperationFailedException;
import java.util.ArrayList;
import se.kth.carInspection.data.InspectionDTO;
import se.kth.carInspection.data.InspectionRegistriesCollection;
import se.kth.carInspection.integration.*;
import se.kth.carInspection.model.*;

public class Payment {

    private PaymentType paymentType;
    private boolean paymentStatus;
    private Vehicle carBeingServed;
    private ArrayList<InspectionDTO> productPayed;
    private int totalCost;
    private String carType;
    private String receipt;
    private CashPayment cashPayment;
    private CreditCardPayment creditCardPayment;
    private PromotingPaymentAndCarType discountCalculator;

    public Payment(PaymentType paymentType, Vehicle carBeingServed) throws OperationFailedException {
        this.paymentType = paymentType;
        this.carBeingServed = carBeingServed;
        try {
            carType = ExternalCheckingRegNoSystem.getExtCheckSyst().getCarType(carBeingServed.getRegistrationNumber());
        } catch(IllegalLicenseNumberException illLicE) {
            throw new OperationFailedException("The licence number of the vehicle " + carBeingServed.getRegistrationNumber() + " is not valid. Please check the registration number and try again.", illLicE);
        }
    }

    public void pay (int amountPaid, CreditCardDTO creditCard){
        if(paymentType.equals(PaymentType.CREDIT_CARD) && !creditCard.equals(null)) {
            totalCost = getTotalCostAfterDiscount(); 
            creditCardPayment = new CreditCardPayment(creditCard, totalCost);
            creditCardPayment.authorizePayment();           
        }
        if(paymentType.equals(PaymentType.CASH)) {
            totalCost = getTotalCostAfterDiscount(); 
            cashPayment = new CashPayment(amountPaid, totalCost);
            cashPayment.payCash();
        }
    }


    public boolean getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus() {
        paymentStatus = !paymentStatus;
    }

    private int getTotalCost() {      
        totalCost = 0;
        productPayed = InspectionRegistriesCollection.getInspectionRegCollection().getInspectionCollection(carType);
        for (InspectionDTO inspection : productPayed) {
            totalCost += inspection.getCost();
        }
        return totalCost;
    }
    private int getTotalCostAfterDiscount() {
        totalCost = getTotalCost();
        
        discountCalculator = new PromotingPaymentAndCarType();
        discountCalculator.setCarTypeToPromote("Volvo");
        discountCalculator.setPromotingPaymentType(PaymentType.CASH);
        
        int discount = discountCalculator.bestPrice(carType, paymentType);
        totalCost = totalCost- (totalCost * discount / 100);  
        return totalCost;
    }
    

    private PaymentType getPaymentType() {
        return paymentType;
    }

    private String prepareReceiptInfo() {
        receipt = "##################RECEIPT##################\n";
        receipt += "Car Type: " + carType + "\n" + "Payment type: " + getPaymentType() + "\n" + "Inspectin cost: " + getTotalCost() + "\nInspectin cost after discount: " + getTotalCostAfterDiscount();
        return receipt;
    }

    private String completeReceiptInfo() {

        //String receiptInfo = prepareReceiptInfo();
        if (paymentType.equals(paymentType.CASH)) {
            receipt += "\n" + cashPayment.getPaymentInfo();
        } else {
            receipt += "\n" + creditCardPayment.getPaymentInfo();
        }
        receipt +="\n############################################\n"; 
        return receipt;
    }

    public void printReciept() {
        prepareReceiptInfo();
        completeReceiptInfo();
        Printer.getPtinter().printReceipt(receipt);
    }

}
