package se.kth.carInspection.model;
=======

/**
 * Write a description of class QueueNumberDisplay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class QueueNumberDisplay
{
    private int currentNumber;
    
    /**
     * Constructor for objects of class QueueNumberDisplay
     */
    public QueueNumberDisplay(int currentQueueNumber)
    {
        currentNumber = currentQueueNumber;
    }
    
    public int getCurrentNumber()
    {
        return currentNumber;
    }
    
    public void incrementCurrentNumber()
    {
        currentNumber++;
    }
}
