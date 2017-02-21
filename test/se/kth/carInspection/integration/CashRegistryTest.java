package se.kth.carInspection.integration;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CashRegistryTest {

    private CashRegistry instance;

    public CashRegistryTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new CashRegistry();
    }

    @After
    public void tearDown() {
        instance = null;
    }

    /**
     * Test of addAmount method, of class CashRegistry.
     */
    @Test
    public void testAddZeroAmount() {

        int finalPayment = 0;
        instance.setBalanceToZero();
        int balance = instance.getBalance();
        int expectedResult = finalPayment + balance;
        instance.addAmount(finalPayment);
        int result = instance.getBalance();
        assertEquals("Wrong adding result", expectedResult, result);

    }

    @Test
    public void testAddNegativeAmount() {

        int finalPayment = -50;
        instance.setBalanceToZero();
        int balance = instance.getBalance();
        int expectedResult = finalPayment + balance;
        instance.addAmount(finalPayment);
        int result = instance.getBalance();
        assertEquals("Wrong adding result", expectedResult, result);

    }

    @Test
    public void testAddPositiveAmount() {

        int finalPayment = 50;
        instance.setBalanceToZero();
        int balance = instance.getBalance();
        int expectedResult = finalPayment + balance;
        instance.addAmount(finalPayment);
        int result = instance.getBalance();
        assertEquals("Wrong adding result", expectedResult, result);

    }

}
