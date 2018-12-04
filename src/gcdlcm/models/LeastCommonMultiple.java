package gcdlcm.models;

import java.util.ArrayList;
import java.util.List;
import gcdlcm.exceptions.TooShortArrayException;
import gcdlcm.exceptions.ZeroNumberException;

/**
 * Used for calculating LCM of numbers
 * @author Piotr Paczuła
 * @version 1.0
 */
public class LeastCommonMultiple {
    
    /**
     * List of numbers used for calculating LCM
     */
    private List<Integer> numbers;  
    
    /**
     * Object used for calculating GCD 
     * which is used in LCM calculating algorithm.
     */
    private GreatestCommonDivisor gcDivisor;
    
    /**
     * Constructor initializes GCD object and list of numbers
     * @param numbers list of numbers used for calculating LCM
     */
    public LeastCommonMultiple(List<Integer> numbers)
    {
        this.numbers = numbers;
        gcDivisor = new GreatestCommonDivisor();
    }
    /** 
     * Method returns least common multiple given List of Integers
     * @return Integer representing LCM result.
     * @throws TooShortArrayException for too given too short array 
     * of less than 2 elements
     * @throws ZeroNumberException when 0 is given as parameter
     */
    public Integer calculate() throws TooShortArrayException, ZeroNumberException
    {
      
        int numbersSize = numbers.size();
        if(numbersSize>1)
        {
            List<Integer> newCollection = new ArrayList<>();
            int tempLCM =numbers.get(0);
            int newNumber;
            for (int i = 1; i < numbersSize; i++) {
                newNumber = numbers.get(i);
                newCollection.clear();
                newCollection.add(tempLCM);
                newCollection.add(newNumber);
                gcDivisor.setNumbers(newCollection);
                tempLCM = tempLCM*newNumber/gcDivisor.calculate();
            }
            return tempLCM;
        }
        else
        {
            throw new TooShortArrayException();
        }
        
    }
}
