/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package se.kth.carInspection.view;

import java.util.Date;

/**
 * This class is responsible for showing error messages to the user.
 * @author Lena Shervarly
 */
public class ErrorMessagesHandler {
              
    /**
     * Displays the error information till the final user
     * @param msg The error message.
     */
    public void showErrorMessage(String msg) {
        StringBuilder message = new StringBuilder();
        message.append("On the " + getErrorTime() + "\n");
        message.append("ERROR: " + msg);
        System.out.println(message);       
    }
    
    /**
     * Get the time, when error happened
     * @return 
     */
  public String getErrorTime() {
        Date errorTime = new Date();
        int month = errorTime.getMonth();
        int year = errorTime.getYear();
        int date = errorTime.getDay();
        int hour = errorTime.getHours();
        int minut = errorTime.getMinutes();
        int seconds = errorTime.getSeconds();
        String errorTimeDescription = date + " of " + month + "." + year + " at " + hour + ":"  + minut + ":" + seconds;
        return errorTimeDescription;
    }
}
