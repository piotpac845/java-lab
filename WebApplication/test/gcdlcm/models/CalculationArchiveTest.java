package gcdlcm.models;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test suite for CalculationArchive class
 * @author Piotr Paczuła
 * @version 1.0
 */
public class CalculationArchiveTest {

    /**
     * Test of addResultToArchive method, of class CalculationArchive.
     * Checks basic functionality.
     */
    @Test
    public void testAddResultToArchiveAndGetResultsFromArchive() {
        int divisor = 3;
        int multiply = 5;
        CalculationArchive instance = new CalculationArchive();
        instance.addResultToArchive(divisor, multiply);
        assertEquals(instance.getDivisorArchive(), "3");
        assertEquals(instance.getMultiplyArchive(),"5");
    }
     
    /**
     * Test of addResultToArchive method, of class CalculationArchive.
     * Checks the maximum possible archive storage.
     */
    @Test
    public void testMaximumArchiveStorage() {
        String expectedDivisor = "11 12 13 14 15 16 17 18 19 20";
        String expectedMultiple= "11 12 13 14 15 16 17 18 19 20";
       
        CalculationArchive instance = new CalculationArchive();
        for(int i = 0; i <= 20; i++){
            instance.addResultToArchive(i, i);
        }
        assertEquals(instance.getDivisorArchive(), expectedDivisor);
        assertEquals(instance.getMultiplyArchive(),expectedMultiple);
    }


    /**
     * Test of getDivisorArchive method, of class CalculationArchive.
     * Checks if the return value is valid for empty array.
     */
    @Test
    public void testGetDivisorArchiveWhenEmpty() {
         CalculationArchive instance = new CalculationArchive();
         assertEquals(instance.getDivisorArchive(), "Empty");
    }
    

    /**
     * Test of getMultiplyArchive method, of class CalculationArchive.
     * Checks if the return value is valid for empty array.
     */
    @Test
    public void testGetMultiplyArchiveWhenEmpty() {
         CalculationArchive instance = new CalculationArchive();
         assertEquals(instance.getMultiplyArchive(),"Empty");
    }
    
}
