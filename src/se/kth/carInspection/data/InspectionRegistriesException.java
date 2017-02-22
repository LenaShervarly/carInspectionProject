/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.carInspection.data;

/**
 * Thrown when something goes wrong while performing an operation in the Inspection Registry Collection
 * @author Lena Shervarly
 */
public class InspectionRegistriesException extends RuntimeException {
    
    
    /**
     * Creates a new instance of exception representing the condition described in the specified message.
     * @param msg A message that describes what went wrong.
     */
    public InspectionRegistriesException(String msg) {
        super(msg);
    }
    
}
