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
import se.kth.carInspection.data.InspectionRegistriesCollection;

/**
 *
 * @author tmpuser-10206
 */
public class InspectionRegistriesCollectionTest {
    
    InspectionRegistriesCollection inspectionReg;
    
    @Before
    public void setUp() {
        inspectionReg = new InspectionRegistriesCollection();
    }
    
    @After
    public void tearDown() {
        inspectionReg = null;
    }
    
    @Test
    public void testCheckAvailability() {
        assertTrue("Not able to find the car that is there", inspectionReg.checkAvailability("Volvo"));
        assertTrue("Not able to find the car that is there", inspectionReg.checkAvailability("Saab"));
        assertTrue("Not able to find the car that is there", inspectionReg.checkAvailability("Mers"));
        assertFalse("Able to find the car that is not in the database",inspectionReg.checkAvailability("Moskvich"));
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
