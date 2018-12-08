package gcdlcm.controllers;

import gcdlcm.exceptions.TooShortArrayException;
import gcdlcm.exceptions.ZeroNumberException;
import gcdlcm.models.GreatestCommonDivisor;
import gcdlcm.models.LeastCommonMultiple;
import gcdlcm.views.ResultView;
import java.util.List;
import tcpserver.TcpServer;

/**
 * Manages application calculations
 * @author Piotr Paczuła
 * @version 1.2
 */
public class CalculationController {
    /**
     * Used for displaying information.
     */
    private final ResultView resultView;
    private final GreatestCommonDivisor gcdCalculator;
    private final LeastCommonMultiple lcmCalculator;
    private final TcpServer server;
    /**
    * @param server TCP server used for communication with client.
    */
    public CalculationController(TcpServer server){
        this.server = server;
        this.resultView = new ResultView(server);
        gcdCalculator = new GreatestCommonDivisor();
        lcmCalculator  = new LeastCommonMultiple();
    }
    /**
     * Used for calculating Greatest Common Divisor and Least Common Multiple 
     * and returning the result to view.
     * @param numbers list of integers which are gonna used for calculations.
     */
    public void calculate(List<Integer> numbers)
    {
        int gcm, lcm;
        //GreatestCommonDivisor gcdCalculator = new GreatestCommonDivisor(numbers);
        gcdCalculator.setNumbers(numbers);
        lcmCalculator.setNumbers(numbers);
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
