package model;

import org.junit.Test;


public class QueueNumberDisplayTest {

    @Test
    public void testConstructor() throws Exception {

        QueueNumberDisplay displayNumber = new QueueNumberDisplay(0);
        assertEquals(0, displayNumber.getCurrentNumber());

    }

    @Test
    public void testIncrementCurrentNumber() throws Exception {

        QueueNumberDisplay displayNumber = new QueueNumberDisplay(0);
        displayNumber.incrementCurrentNumber();
        assertEquals(1, displayNumber.getCurrentNumber());

    }
}