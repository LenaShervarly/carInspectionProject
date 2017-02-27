/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.carInspection.model;

/**
 * Defines the ability to find the best pricing strategy for a specified car type and payment method
 * @author Lena Shervarly
 */
public interface IPriceMatcher {
    
    /**
     *
     * @param carType
     * @param payment
     * @return
     */
    int bestPrice(String carType, PaymentType paymentType);
    void setPromotingPaymentType(PaymentType promotingPaymentType);
    void setCarTypeToPromote(String carTypeToPromote);
}
