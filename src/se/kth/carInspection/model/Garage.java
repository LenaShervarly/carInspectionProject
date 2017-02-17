
package se.kth.carInspection.model;

/**
 * This class is an interface to the control system opening the

 * door and also to the queue number display. The constructor connects to the door and

 * display, closes the door and shows the number zero. The method nextCustomer opens

 * the door and displays the next queue number. The method closeDoor closes the door.
 *
 * @author valentina
 * @version 0.1 2017/02/14
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
     * This method opens the door and displays the next queue number
     */

    public void nextCustomer()
    {
        door.open();
        display.incrementCurrentNumber();
        System.out.println("Current customer number is: " + display.getCurrentNumber());
    }

    /**
     * This method closes the door
     */
    public void closeDoor()
    {
        door.close();
    }
}
