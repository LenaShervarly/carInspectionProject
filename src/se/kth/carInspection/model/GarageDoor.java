package se.kth.carInspection.model;

/**
 * This class checks if the door is open or closed.
 * 
 * @author valentina
 * @version 0.1 2017/02/14
 */
public class GarageDoor
{
    private boolean isOpened;
    /**
     * Constructor for objects of class GarageDoor
     */
    public GarageDoor(boolean isOpened)
    {
        this.isOpened = isOpened;
    }

    /**
     * This method returns the status of the door
     * @return isOpened
     */
    public boolean getIsOpened()
    {
        return isOpened;
    }

    /**
     * If the door is open, then returns true
     */
    public void open()
    {
        isOpened = true;
    }

    /**
     * If the door is closed returns false
     */

    public void close()
    {
        isOpened = false;
    }
}
