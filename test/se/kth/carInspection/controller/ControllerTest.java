/*
 * Public university project.
 * 
 */
package se.kth.carInspection.controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import se.kth.carInspection.model.GarageDoor;
import se.kth.carInspection.model.QueueNumberDisplay;

import static org.junit.Assert.*;

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
