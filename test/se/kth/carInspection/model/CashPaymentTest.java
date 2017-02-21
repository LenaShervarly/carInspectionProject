
package se.kth.carInspection.model;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import se.kth.carInspection.integration.*;

public class CashPaymentTest {
    CashRegistry cashRegistry;
    CashPayment cashPayment;
    
    public CashPaymentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        cashRegistry=new CashRegistry();
        
    }
    
    @After
    public void tearDown() {
        cashRegistry=null;
    }

   
   
    @Test
    public void testEqualsPayCash() {
        int amount=100;
        int total=100;
        
        cashRegistry.addAmount(total);
        int expectedResult=total-amount;
       cashPayment= new CashPayment( amount,total);
       int result=cashPayment.payCash();
       assertEquals("Wrong subtraction",expectedResult,result);
       
    }
    
    @Test
    public void testPayCash() {
        int amount=50;
        int total=100;
       
       cashRegistry.addAmount(total);
        int expectedResult=total-amount;
       cashPayment= new CashPayment( amount,total);
       int result=cashPayment.payCash();
       
       assertEquals("Wrong subtraction",expectedResult,result);
       
    }
    
    @Test
     public void testGetChange() {
        int amount=50;
        int total=100;
        int expectedResult =total- amount;
        cashPayment= new CashPayment( amount,total);
        int result=cashPayment.getChange();
       assertEquals("Wrong subtraction",expectedResult,result);
       
    }


}
