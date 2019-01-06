package gcdlcm.models;

import gcdlcm.exceptions.TooShortArrayException;
import gcdlcm.exceptions.ZeroNumberException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test suite for GreatestCommonDivisor class
 * @author Piotr Paczuła
 * @version 1.3
 */
public class GreatestCommonDivisorTest {
    
    
     /**
     * Test of calculate method, of class GreatestCommonDivisor. 
     * Should throw ZeroNumberException exception.
     * @throws gcdlcm.exceptions.TooShortArrayException
     * @throws gcdlcm.exceptions.ZeroNumberException
     */
    @Test(expected=ZeroNumberException.class)
    public void calculateShouldThrowZeroNumberException() throws TooShortArrayException, ZeroNumberException {
          
        GreatestCommonDivisor instance = new GreatestCommonDivisor();
        List<Integer> numbers = Arrays.asList(0, 10 , 20);
        instance.setNumbers(numbers);
        int result = instance.calculate();
    }
    
     /**
     * Test of calculate method, of class GreatestCommonDivisor.
     * Should throw TooShortArrayException.
     * @throws gcdlcm.exceptions.TooShortArrayException
     * @throws gcdlcm.exceptions.ZeroNumberException
     */
    @Test(expected=TooShortArrayException.class)
    public void calculateShouldThrowTooShortArrayException() throws TooShortArrayException, ZeroNumberException {
          
        GreatestCommonDivisor instance = new GreatestCommonDivisor();
        List<Integer> numbers = new ArrayList<>();
        instance.setNumbers(numbers);
        int result = instance.calculate();
    }
    /**
     * Test of calculate method, of class GreatestCommonDivisor.
     * @throws gcdlcm.exceptions.TooShortArrayException
     * @throws gcdlcm.exceptions.ZeroNumberException
     */
    @Test
    public void testCalculate() throws TooShortArrayException, ZeroNumberException {
       
        GreatestCommonDivisor instance = new GreatestCommonDivisor();
        List<Integer> numbers = Arrays.asList(10, 20, 100, 40);
        instance.setNumbers(numbers);
        int expResult = 10;
        int result = instance.calculate();
        assertEquals(expResult, result);
    }
     /**
     * Test of calculate method, of class GreatestCommonDivisor.
     * Few parameters scenario.
     * @throws gcdlcm.exceptions.TooShortArrayException
     * @throws gcdlcm.exceptions.ZeroNumberException
     */
    @Test
    public void testCalculateForFewParams() throws TooShortArrayException, ZeroNumberException {
       
        GreatestCommonDivisor instance = new GreatestCommonDivisor();
        List<Integer> numbers = Arrays.asList(123, -33);
        instance.setNumbers(numbers);
        int expResult = 3;
        int result = instance.calculate();
        assertEquals(expResult, result);
    }
     /**
     * Test of calculate method, of class GreatestCommonDivisor.
     * Many parameters scenario.
     * @throws gcdlcm.exceptions.TooShortArrayException
     * @throws gcdlcm.exceptions.ZeroNumberException
     */
      @Test
    public void testCalculateForManyParams() throws TooShortArrayException, ZeroNumberException {
       
        GreatestCommonDivisor instance = new GreatestCommonDivisor();
        List<Integer> numbers = Arrays.asList(10, 20, 100, 40, 22, -124, 123124, -23132);
        instance.setNumbers(numbers);
        int expResult = 2;
        int result = instance.calculate();
        assertEquals(expResult, result);
    }
    
}
