/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcdlcm.models;

import gcdlcm.exceptions.ZeroNumberException;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test suite for PrimeFactors class
 * @author Piotr Paczuła
 * @version 1.0 
 */
public class PrimeFactorsTest {

    /**
     * Test of getPrimes method, of class PrimeFactors.
     * Should throw ZeroNumberException.
     * @throws gcdlcm.exceptions.ZeroNumberException
     */
    @Test(expected=ZeroNumberException.class)
    public void shouldThrowZeroNumberException() throws ZeroNumberException {
        System.out.println("getPrimes");
        int value = 0;
        List<Integer> expResult =  Arrays.asList(3, 23);
        List<Integer> result = PrimeFactors.getPrimes(value);
    }
    
     /**
     * Test of getPrimes method, of class PrimeFactors.
     * @throws gcdlcm.exceptions.ZeroNumberException
     */
    @Test
    public void testGetPrimes() throws ZeroNumberException {
        System.out.println("getPrimes");
        int value = 69;
        List<Integer> expResult =  Arrays.asList(3, 23);
        List<Integer> result = PrimeFactors.getPrimes(value);
        assertEquals(expResult, result);
    }
    
}
