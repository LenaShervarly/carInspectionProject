/*
 * Public university project.
 * 
 */
package se.kth.carInspection.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class GarageTest {


    @Test
    public void testConstructor() throws Exception {

        GarageDoor door = new GarageDoor(false);
        assertEquals(false, door.getIsOpened());
        QueueNumberDisplay display = new QueueNumberDisplay(0);
        assertEquals(0, display.getCurrentNumber());
    }

    @Test
    public void testNextCustomer() throws Exception {

        QueueNumberDisplay display = new QueueNumberDisplay(0);
        display.incrementCurrentNumber();
        assertEquals(1, display.getCurrentNumber());

    }

    @Test
    public void testCloseDoor() throws Exception {

        GarageDoor door = new GarageDoor(true);
        door.close();
        assertEquals(false, door.getIsOpened());

    }
}
