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
public class PromotingPaymentType implements IPriceMatcher{
    private PaymentType promotingPaymentType;
    
    public PromotingPaymentType() {}
    
    public void setPromotingPaymentType(PaymentType promotingPaymentType) {
        this.promotingPaymentType = promotingPaymentType;
    }
    
   @Override
   public int bestPrice(String carType, PaymentType paymentType) {
       int discount = 0;
       if(paymentType.equals(promotingPaymentType))
           discount = 10;
       return discount;
   }

    @Override
    public void setCarTypeToPromote(String carTypeToPromote) {
    }
    
}
