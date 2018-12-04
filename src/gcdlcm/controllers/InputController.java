package gcdlcm.controllers;

import gcdlcm.views.ResultView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Manages user's input
 * @author Piotr Paczuła
 * @version 1.1
 */
public class InputController {
    
    /**
     * View object used for displaying information to user.
     */
    private final ResultView view = new ResultView();
    
    /**
     * Checks if user wants to quit application
     * @param args user's input
     * @return True if application should end.
     */
    private boolean checkQuitCondition(String[] args)
    {
        if(args.length == 1)
                {
                    if("q".equals(args[0]) || "Q".equals(args[0]))
                        return true;
                }
        return false;
    }
    
    /**
     * Validates if given input's number of parameters was correct.
     * @param args user's input
     * @return True if number of parameters is correct.
     */
    private boolean validateArgsSize(String[] args)
    {
        boolean result = args.length>1;
        if(args.length == 1)
        {
            if("q".equals(args[0]) || "Q".equals(args[0]))
            {
                result = true;
            }
        }
        return result;
    }
    
    /**
     * Gets valid input from user and converts it to list of integers.
     * Used for calculations after the first initial one.
     * 
     * @return List of integer 
     */
    
    public List<Integer> getAnotherInput()
    {
        String[] args = view.anotherCalc();
        return getInput(args);
    }
    
    /**
     * Gets valid input from user and converts it to list of integers
     * @param args user's input. Valid options are 
     * numbers separated by spaces or "q"/"Q".
     * @return List of integer 
     */
    @SafeVarargs
    public final List<Integer> getInput(String... args){
        String[] argmunets = args;
        boolean validArray = false;
        List<Integer> array = new ArrayList<>();
        while(!validArray)
        {
            try{
              
                if(validateArgsSize(argmunets))
                {
                    
                   if(!checkQuitCondition(argmunets))
                   { 
                       Arrays.asList(argmunets).forEach(arg->{
                       array.add(Integer.parseInt(arg));
                       });
                   }
                   validArray = true;
                }
                else
                {
                    argmunets = view.tooShortInputArray();
                }
            }
            catch(NumberFormatException exception)
            {   
                array.clear();            
                argmunets = view.wrongInputFormat();
            }
        }
        return array;
    }
}
