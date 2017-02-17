/*
 * Public university project.
 * 
 */
package data;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.carInspection.data.CarRegistrationNumbersDatabase;

/**
 *
 * @author tmpuser-10206
 */
public class CarRegistrationNumberDatabaseTest {
    
    CarRegistrationNumbersDatabase database;
    
         
    @Before
    public void setUp() { 
        database = new CarRegistrationNumbersDatabase();
    }
    
    @After
    public void tearDown() {
        database = null;
    }

    @Test
    public void testCheckTheRegister(){
        assertTrue("The search works wrongly", database.checkTheRegister("A12"));
        assertFalse("The search works wrongly", database.checkTheRegister("BM355"));
    }
    
    @Test
    public void testGettingCarType() {
        assertEquals("Couldn't properly receive the type of the car", "Volvo", database.getCarType("A12"));
        assertEquals("Couldn't properly receive the type of the car", "Tesla", database.getCarType("B45"));
        
    }
// TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
