package gcdlcm.models;

import gcdlcm.exceptions.TooShortArrayException;
import gcdlcm.exceptions.ZeroNumberException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test suite for LeastCommonMultiple class
 * @author Piotr Paczuła
 * @version 1.2
 */
public class LeastCommonMultipleTest {
    
    /**
     * Test of calculate method, of class LeastCommonMultiple.
     * Should throw TooShortArrayException.
     * @throws gcdlcm.exceptions.TooShortArrayException
     * @throws gcdlcm.exceptions.ZeroNumberException
     */
    @Test(expected=TooShortArrayException.class)
    public void shouldThrowTooShortArrayException() throws TooShortArrayException, ZeroNumberException {
        List<Integer> numbers = new ArrayList<>();
        LeastCommonMultiple instance = new LeastCommonMultiple();
        instance.setNumbers(numbers);
        int expResult = 300;
        int result = instance.calculate();
    }
    /**
     * Test of calculate method, of class LeastCommonMultiple.
     * Should throw ZeroNumberException.
     * @throws gcdlcm.exceptions.TooShortArrayException
     * @throws gcdlcm.exceptions.ZeroNumberException
     */
    @Test(expected=ZeroNumberException.class)
    public void shouldThrowZeroNumberException() throws TooShortArrayException, ZeroNumberException {
        List<Integer> numbers = Arrays.asList(20, 10, 0, 50);
        LeastCommonMultiple instance = new LeastCommonMultiple();
        instance.setNumbers(numbers);
        int expResult = 300;
        int result = instance.calculate();
    }
    /**
     * Test of calculate method, of class LeastCommonMultiple.
     * @throws gcdlcm.exceptions.TooShortArrayException
     * @throws gcdlcm.exceptions.ZeroNumberException
     */
    
    @Test
    public void testCalculate() throws TooShortArrayException, ZeroNumberException  {
        List<Integer> numbers = Arrays.asList(20, 10, 3, 50);
        LeastCommonMultiple instance = new LeastCommonMultiple();
        instance.setNumbers(numbers);
        int expResult = 300;
        int result = instance.calculate();
        assertEquals(expResult, result);
    }
    
}
