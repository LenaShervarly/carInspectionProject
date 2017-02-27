/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.carInspection.model;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author tmpuser-10206
 */
public class PricingFactory {
    //private static final PaymentType PROMOTING_PAYMENT_TYPE = PaymentType.CASH;
    //private static final String CAR_TYPE_TO_PROMOTE = "Volvo";
    private static final PricingFactory pricingFactory = new PricingFactory();
    
    Scanner scanner = new Scanner(new InputStreamReader(System.in));
    private PaymentType PROMOTING_PAYMENT_TYPE;
    private String CAR_TYPE_TO_PROMOTE;
    
    private PricingFactory() 
    {
        System.out.println("choose a payment type: true  = cash, false = credit card");
        boolean result = scanner.nextBoolean();
        PROMOTING_PAYMENT_TYPE = result ? PaymentType.CASH : PaymentType.CREDIT_CARD;
         System.out.println("choose a car to promote: ");
        CAR_TYPE_TO_PROMOTE = scanner.next();
    }
    
    public PaymentType getPROMOTING_PAYMENT_TYPE() {
        return PROMOTING_PAYMENT_TYPE;
    }

    public String getCAR_TYPE_TO_PROMOTE() {
        return CAR_TYPE_TO_PROMOTE;
    }

    public static PricingFactory getPricingFactory() {
        return pricingFactory;
    }
    
    
    private IPriceMatcher policy;
    
    public IPriceMatcher getBestMatcher(String carTypeActual, PaymentType paymentTypeActual) {
       int discount = 0;
       if(paymentTypeActual.equals(PROMOTING_PAYMENT_TYPE)) {
           policy =  new PromotingPaymentType();
           policy.setPromotingPaymentType(PROMOTING_PAYMENT_TYPE);
           discount = policy.bestPrice(carTypeActual, paymentTypeActual);
          
       }
       else if(carTypeActual.equals(CAR_TYPE_TO_PROMOTE)) {
           policy = new PromotingCarPricing();
           policy.setCarTypeToPromote(CAR_TYPE_TO_PROMOTE);
           discount =  policy.bestPrice(carTypeActual, paymentTypeActual);
       }
       else if(paymentTypeActual.equals(PROMOTING_PAYMENT_TYPE) && carTypeActual.equals(CAR_TYPE_TO_PROMOTE)){
           policy = new PromotingPaymentAndCarType();
           policy.setCarTypeToPromote(CAR_TYPE_TO_PROMOTE);
           policy.setPromotingPaymentType(PROMOTING_PAYMENT_TYPE);
           discount = policy.bestPrice(carTypeActual, paymentTypeActual);
       }
       return policy;
    }
}
