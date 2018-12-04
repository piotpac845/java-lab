
package gcdlcm.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * Test suite for CalculationController class
 * @author Piotr Paczuła
 * @version 1.0
 */
public class CalculationControllerTest {
    /**
     * Test of calculate method, of class CalculationController.
     */
    @Test
    public void testCalculate() {
        List<Integer> numbers = Arrays.asList(10,20,55,123,22);
        CalculationController instance = new CalculationController();
        instance.calculate(numbers);
    }
    
     /**
     * Test of calculate method, of class CalculationController. Should handle wrong input.
     */
    @Test 
    public void shouldntCatchExceptionForWrongInput() {
        List<Integer> numbers = Arrays.asList(10,20,55,0,123,22);
        CalculationController instance = new CalculationController();
        instance.calculate(numbers);
    }
    
     /**
     * Test of calculate method, of class CalculationController. Should handle empty array as an input.
     */
    @Test 
    public void shouldCatchExceptionForEmptyArray() {
        List<Integer> numbers = new ArrayList<>();
        CalculationController instance = new CalculationController();
        instance.calculate(numbers);
    }
    
}
