package gcdlcm.models;

import gcdlcm.exceptions.ZeroNumberException;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for calculating numbers prime values
 * @author Piotr Paczuła
 * @version 1.0
 */
public class PrimeFactors {
    /**
     * Used for calculating primes of given number
     * @param value number which primes will be returned
     * @return list of integers
     * @throws ZeroNumberException when 0 is given as parameter
     */
    public static List<Integer> getPrimes(Integer value) throws ZeroNumberException
    {
        if(value==0)
            throw new ZeroNumberException();
        
        Integer divisor = 2;
        List<Integer> results =  new ArrayList<>();
        while(Math.abs(value)!=1)
        {
            if(value%divisor==0)
            {
                value /=divisor;
                results.add(divisor);
                divisor = 2;
            }
            else
            {
                divisor++;
            }
        }
        return results;
    }
}
