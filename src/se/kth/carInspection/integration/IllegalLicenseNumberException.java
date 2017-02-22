/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.carInspection.integration;

/**
 * Thrown when trying to use a car whith invalid registration number.
 * @author Lena Shervarly
 */
public class IllegalLicenseNumberException extends Exception{
    private String illegalLicenceNo;
    private Exception cause;

    /**
     * Creates a new instance with a message specifying which registration number is not valid and why
     * @param licenceNumber the registration number, that is not valid
     * @param cause the cause of the exception
     */   
    public IllegalLicenseNumberException(String licenceNumber, Exception cause) {
        super("The licence number " + licenceNumber + " is illegal, as it's not present in the database", cause);
        this.illegalLicenceNo = licenceNumber;
    }

    /**
     * the registration number, that is not valid
     * @return 
     */
    public String getIllegalLicenceNo() {
        return illegalLicenceNo;
    }
    
    /**
     * the cause of the exception
     * @return 
     */
    public Exception getCause() {
        return cause;
    }
}
