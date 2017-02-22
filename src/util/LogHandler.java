/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 *
 * @author tmpuser-10206
 */
public class LogHandler {
    
    private static final String LOGFILE_NAME = "/afs/kth.se/home/tmp/1009/tmpuser-10206/NetBeansProjects/JavaApplication1/src/se/kth/carInspection/view/inspect_car.txt";
    private File file;
    private FileWriter writer;
    private PrintWriter logfile;
    
    /**
     * Creates an instance of LogHadler
     * @throws IOException 
     */
    public LogHandler() throws IOException {
        file = new File("/afs/kth.se/home/tmp/1009/tmpuser-10206/NetBeansProjects/JavaApplication1/src/se/kth/carInspection/view/inspect_car.txt");
        if(!file.exists()) {
           file.createNewFile();
        }
        writer = new FileWriter(file);
        logfile =  new PrintWriter(new FileWriter(LOGFILE_NAME), true);
    }
    
    /**
     * Writes log information
     * @param exception the exception, about wich LogHandler writes down information 
     */
    public void loggingException(Exception exception) {
        StringBuilder message = new StringBuilder();
        message.append("On the " + getErrorTime() + "\n");
        message.append("Error message was thrown: " + exception.getMessage());
        logfile.println(message);
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
