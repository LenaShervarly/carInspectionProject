/*
 * Public university project.
 * 
 */
package se.kth.carInspection.data;

import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.carInspection.data.CarRegistrationNumbersDatabase;

/**
 *
 * @author Lena Shervarly
 */
public class CarRegistrationNumberDatabaseTest {
    
         
    @Before
    public void setUp() { 
        CarRegistrationNumbersDatabase.getCarDataBase().addingLinesToDatabase("AK51", "Kollibri");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testCheckTheRegister(){
        assertTrue("The search works wrongly", CarRegistrationNumbersDatabase.getCarDataBase().checkTheRegister("A12"));
        assertTrue(CarRegistrationNumbersDatabase.getCarDataBase().checkTheRegister("A12"));
        assertTrue(CarRegistrationNumbersDatabase.getCarDataBase().checkTheRegister("AK51"));
        assertFalse("The search works wrongly", CarRegistrationNumbersDatabase.getCarDataBase().checkTheRegister("BM355"));
    }
    
    @Test
    public void testGettingCarType() throws SQLException {
        assertEquals("Couldn't properly receive the type of the car", "Volvo", CarRegistrationNumbersDatabase.getCarDataBase().getCarType("A12"));
        assertNotNull(CarRegistrationNumbersDatabase.getCarDataBase().getCarType("A12"));
        assertNotNull(CarRegistrationNumbersDatabase.getCarDataBase().getCarType("A12"));
        assertEquals("Couldn't properly receive the type of the car", "Tesla", CarRegistrationNumbersDatabase.getCarDataBase().getCarType("B45"));
        assertNotNull(CarRegistrationNumbersDatabase.getCarDataBase().getCarType("B45"));
        assertNotNull(CarRegistrationNumbersDatabase.getCarDataBase().getCarType("B45"));

        assertEquals("Couldn't properly receive the type of the car", "Kollibri", CarRegistrationNumbersDatabase.getCarDataBase().getCarType("AK51"));
    }

}
