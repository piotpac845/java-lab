package gcdlcm.models;


import java.util.ArrayList;
import java.util.List;
import gcdlcm.exceptions.TooShortArrayException;
import gcdlcm.exceptions.ZeroNumberException;

/**
 * Used for calculating GCD of numbers
 * @author Piotr Paczuła
 * @version 1.0
 */
public class GreatestCommonDivisor {
    
    /**
     * List of numbers used for calculating GCD
     */
    private List<Integer> numbers;      
    
    /**
     * Constructor without parameters
     */
    public GreatestCommonDivisor()
    {
        this.numbers = new ArrayList<>();
    }
    /**
     * 
     * Constructor with parameters
     *
     * @param numbers list of integer used for calculating GCD
     */
    public GreatestCommonDivisor(List<Integer> numbers)
    {
        this.numbers = numbers;
    }
    /**
     * Setter for numbers field
     * @param numbers new value
     */
    
    public void setNumbers(List<Integer> numbers)
    {
        this.numbers = numbers;
    }
    /**
     * Getter for numbers field
     * @return current values
     */
    public List<Integer> getNumbers()
    {
        return numbers;
    }

    /**
     * Method returns biggest common divisor given List of Integers
     * @return Integer representing LCM result.
     * @throws TooShortArrayException for too given too short array 
     * of less than 2 elements
     * @throws ZeroNumberException when 0 is given as parameter
     */
    public Integer calculate() throws TooShortArrayException, ZeroNumberException
    {
        Integer arraySize = numbers.size();
        if(arraySize>0)
        {
            List<Integer> newDivisors;
            List<Integer> commonDivisors = PrimeFactors.getPrimes(numbers.get(0));
            for (int i = 1; i < arraySize; i++) {
                newDivisors = PrimeFactors.getPrimes(numbers.get(i));
                int counter = 0;
                while(commonDivisors.size()>counter)
                {
                    int searchedValue = commonDivisors.get(counter);
                    if(newDivisors.remove((Integer)searchedValue))
                    {
                        counter++;
                    }
                    else
                    {
                        commonDivisors.remove((Integer)searchedValue);
                        
                    }
                }
            }
            Integer result = 1;
            for(Integer divisor: commonDivisors)
            {
                result*=divisor;
            }
            return result;
        }
        else
        {
           throw new TooShortArrayException();
        }
    }
    
}
