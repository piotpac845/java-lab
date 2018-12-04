package gcdlcm.controllers;

import gcdlcm.exceptions.TooShortArrayException;
import gcdlcm.exceptions.ZeroNumberException;
import gcdlcm.models.GreatestCommonDivisor;
import gcdlcm.models.LeastCommonMultiple;
import gcdlcm.views.ResultView;
import java.util.List;

/**
 * Manages application calculations
 * @author Piotr Paczuła
 * @version 1.0
 */
public class CalculationController {
    /**
     * Used for displaying information.
     */
    private final ResultView resultView = new ResultView();
 
    /**
     * Used for calculating Greatest Common Divisor and Least Common Multiple 
     * and returning the result to view.
     * @param numbers list of integers which are gonna used for calculations.
     */
    public void calculate(List<Integer> numbers)
    {
        int gcm, lcm;
        GreatestCommonDivisor gcdCalculator = new GreatestCommonDivisor(numbers);
        LeastCommonMultiple lcmCalculator  = new LeastCommonMultiple(numbers);
        try
        {
           gcm = gcdCalculator.calculate();
           lcm = lcmCalculator.calculate();
           resultView.printResult(gcm, lcm);
        }
        catch(TooShortArrayException exception)
        {
           resultView.exceptionMessage(exception.getMessage());
        }
        catch(ZeroNumberException exception)
        {
            resultView.exceptionMessage(exception.getMessage());
        }
        
        
        
        
    }
}
