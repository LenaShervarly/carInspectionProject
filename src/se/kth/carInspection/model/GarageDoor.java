package se.kth.carInspection.model;


/**
 * Write a description of class GarageDoor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    
    public boolean getIsOpened()
    {
        return isOpened;
    }
    
    public void open()
    {
        isOpened = true;
    }
    
    public void close()
    {
        isOpened = false;
    }
}
