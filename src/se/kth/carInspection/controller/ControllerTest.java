package controller;

import org.junit.Test;


public class ControllerTest {

    @Test
    public void testNextCustomer() throws Exception {

        QueueNumberDisplay display = new QueueNumberDisplay(0);
        display.incrementCurrentNumber();
        assertEquals(1, display.getCurrentNumber());


    } 

    @Test
    public void testCloseGarageDoor() throws Exception {


        GarageDoor door = new GarageDoor(true);
        door.close();
        assertEquals(false, door.getIsOpened());


    }
}