/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.carInspection.model;

/**
 *
 * @author tmpuser-10206
 */
public class PromotingCarPricing implements IPriceMatcher{
    private String carTypeToPromote;
    
    public PromotingCarPricing() {}
    
    public void setCarTypeToPromote(String carTypeToPromote) {
        this.carTypeToPromote = carTypeToPromote;
    }
    
    @Override 
    public int bestPrice(String carType, PaymentType paymentType) {
        int discount = 0;
        if(carType.equals(carTypeToPromote))
            discount = 15;
        return discount;
    }

    @Override
    public void setPromotingPaymentType(PaymentType promotingPaymentType) {
    }
}
