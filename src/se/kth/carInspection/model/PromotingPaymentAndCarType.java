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
public class PromotingPaymentAndCarType implements IPriceMatcher{
    private PaymentType promotingPaymentType;
    private String carTypeToPromote;
    
    public PromotingPaymentAndCarType() {}
    
    public void setPromotingPaymentType(PaymentType promotingPaymentType) {
        this.promotingPaymentType = promotingPaymentType;
    }
    
    public void setCarTypeToPromote(String carTypeToPromote) {
        this.carTypeToPromote = carTypeToPromote;
    }
    
   @Override
   public int bestPrice(String carTypeActual, PaymentType paymentTypeActual) {
       int discount = 0;
       if(paymentTypeActual.equals(promotingPaymentType) && carTypeActual.equals(carTypeToPromote)){
           discount = 20;
       }  
       return discount;
   }   
}
