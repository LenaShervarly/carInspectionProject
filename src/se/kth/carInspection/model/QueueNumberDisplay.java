package se.kth.carInspection.model;


/**
 * QueueNumberDisplay class shows the current and next number of the customer
 *
 * @author valentina
 * @version 0.1 2017/02/14
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

    /**
     * Accessor method for current number
     * @return currentNumber The current number on the display
     */
    public int getCurrentNumber()
    {
        return currentNumber;
    }

    /**
     * Increments the current number on the display
     */
    public void incrementCurrentNumber()
    {
        currentNumber++;
    }
}
