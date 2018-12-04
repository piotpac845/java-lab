package gcdlcm.views;

import java.util.Scanner;

/**
 * View representing results, errors and input requests in user's console
 * 
 * @author Piotr Paczuła
 *
 */
public class ResultView {
    /**
     * Used for reading user's input from console
     */
    private final Scanner reader = new Scanner(System.in);
    
    /**
     * Prints given parameters to user's console.
     * 
     * @param gcm Greatest common divisor
     * @param lcm Least common multiple
     */
    public void printResult(int gcm, int lcm){
           System.out.println("Twoje wyniki to:");
           System.out.print("NWD: ");
           System.out.println(gcm);
           System.out.print("NWW: ");
           System.out.println(lcm);
    }
    /**
     * Prints input request and reads input from user's console.
     * Then splits it to array of strings.
     * 
     * @return new array of strings
     */
    public String[] getInput(){
        System.out.println("Wprowadź liczby oddzielone spacjami lub zakończ program. [ q ]");
        return reader.nextLine().split(" ");
    }
    
    /**
     * Prints format error and reads input from user's console.
     * @return new array of strings
     */
    public String[] wrongInputFormat()
    {
           System.out.println("Niepoprawny format argumentów.");
           return getInput();
    }
    
    /**
     * Prints length error and reads input from user's console.
     * @return new array of strings
     */
    public String[] tooShortInputArray()
    {
         System.out.println("Za mało argumentów. Potrzeba conajmniej dwóch liczb do wykonania obliczeń.");
         return getInput();
    }
    
    /**
     * Gets data set for new calculation or exit parameter
     * @return new array of strings
     */
    public String[] anotherCalc()
    {
         System.out.println("");
         return getInput();
    }
    
    /**
     * Prints program's end message.
     */
    public void endView()
    {
         System.out.println("Koniec obliczeń.");
    }
    
    /**
     * Prints given error message on user's console.
     * @param excMessage exception string message.
     */
    public void exceptionMessage(String excMessage)
    {
        System.out.print("Error: ");
        System.out.println(excMessage);
    }
    
}