package se.kth.carInspection.model;

import org.junit.Test;
import static org.junit.Assert.*;


public class GarageDoorTest {

    @Test
    public void testConstructor() throws Exception {

        GarageDoor garageDo1 = new GarageDoor(false);
        assertEquals(false, garageDo1.getIsOpened());

    }

    @Test
    public void testOpen() throws Exception {

        GarageDoor door = new GarageDoor(false);
        door.open();
        assertEquals(true, door.getIsOpened());

    }

    @Test
    public void testClose() throws Exception {

        GarageDoor door2 = new GarageDoor(true);
        door2.close();
        assertEquals(false, door2.getIsOpened());

    }
}