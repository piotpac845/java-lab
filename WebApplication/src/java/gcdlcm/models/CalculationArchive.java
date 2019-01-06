package gcdlcm.models;

import java.util.ArrayList;

/**
 * Used for storing GCD and LCM calculation results
 * @author Piotr Paczuła
 * @version 1.0
 */
public class CalculationArchive {
    final ArrayList<Integer> divisorArchive;
    final ArrayList<Integer> multiplyArchive;
    public CalculationArchive() {
        divisorArchive = new ArrayList<>();
        multiplyArchive = new ArrayList<>();
    }
    /**
     * Adds new results to archive
     * @param divisor result of GCD
     * @param multiply result of LCM
     */
    public void addResultToArchive(int divisor, int multiply){
        if(divisorArchive.size()>=10)
        {
            divisorArchive.remove(0);
        }
        if(multiplyArchive.size()>=10)
        {
            multiplyArchive.remove(0);
        }
        divisorArchive.add(divisor);
        multiplyArchive.add(multiply);
    }
    /**
     * 
     * @return string of last 10 divisor results.
     */
    public String getDivisorArchive(){
        String result = createStringFromArray(divisorArchive);
        if(result.isEmpty()){
            return "Empty";
        }
        return result;
    }
    /**
     * 
    * @return string of last 10 multiple results.
     */
    public String getMultiplyArchive(){
        String result = createStringFromArray(multiplyArchive);
        if(result.isEmpty()){
            return "Empty";
        }
        return result;
    }
    
    /**
     * Helping method used for converting Integer array to String.
     * @param array
     * @return Integer Array represented as a String.
     */
    private String createStringFromArray(ArrayList<Integer> array){
        StringBuilder builder = new StringBuilder();
        array.forEach(a->builder.append(a+" "));
        return builder.toString().trim();
    }
}
