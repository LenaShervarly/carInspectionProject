package se.kth.carInspection.model;
=======

/**
 * Write a description of class Garage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Garage
{
    private GarageDoor door;
    private QueueNumberDisplay display;
    /**
     * Constructor for objects of class Garage
     */
    public Garage()
    {
        door = new GarageDoor(false);
        display = new QueueNumberDisplay(0);
    }

    /**
     *
     */
    public void nextCustomer()
    {
        door.open();
        display.incrementCurrentNumber();
        System.out.println("Current customer number is: " + display.getCurrentNumber());
    }
    
    public void closeDoor()
    {
        door.close();
    }
}
