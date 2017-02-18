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
