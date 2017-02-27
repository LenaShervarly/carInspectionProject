/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.carInspection.model;

/**
 * Thrown when an operation fails, and the reason is unknown.
 * @author Lena Shervarly
 */
public class OperationFailedException extends Exception{
    
    private String msg; 
    private Exception cause;

    /**
     * Creates a new instance of exception with the specified message and root cause.
     * @param msg The exception message.
     * @param cause The exception that caused this exception.
     */
    public OperationFailedException(String msg, Exception cause) {
        super(msg, cause);
        this.msg = msg;
        this.cause = cause;
    }
    
    
    public String getMsg() {
        return msg;
    }

    public Exception getCause() {
        return cause;
    }
}