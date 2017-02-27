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
public enum PaymentType {
    
    CASH("Cash"), CREDIT_CARD("Credit card");
    
    private String paymentString;
    
    PaymentType(String paymentString) {
    this.paymentString = paymentString;
}

}
