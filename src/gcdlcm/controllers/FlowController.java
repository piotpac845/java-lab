package gcdlcm.controllers;

import gcdlcm.views.ResultView;
import java.util.List;

/**
 * Manages application flow
 * @author Piotr Paczuła
 * @version 1.1
 */
public class FlowController {

    /**
     * Used for managing calculations.
     */
    private final CalculationController calculator = new CalculationController();
    
    /**
     * Used for managing user's inputs.
     */
    private final InputController input = new InputController();
    
    /**
     * Used for displaying information.
     */
    private final ResultView view = new ResultView();
    
    /**
     * Main method responsible for application start
     * @param args the command line arguments which are numbers separated by spaces
     */
    public void run(String[] args)
    {
        String[] arguments = args;
        boolean quitProgram = false;
        if(arguments.length==0)
        {
            arguments = view.getInput();
        }
         //Initialize controllers0
        List<Integer> numbers = input.getInput(arguments);
        do
        {
        if(!numbers.isEmpty())
        {
            calculator.calculate(numbers);
            numbers = input.getAnotherInput();
        }
        else
            quitProgram = true;
        }while(!quitProgram);
        
        view.endView();
    }
    
    
}
