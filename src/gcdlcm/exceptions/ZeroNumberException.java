package gcdlcm.exceptions;

/**
 * Custom exception thrown when given number is equal to zero.
 * @author Piotr Paczuła
 * @version 1.0
 */
public class ZeroNumberException extends Exception  {
/**
 * Overridden method getMessage() returning exception message.
 * @return message string
 */
    @Override
    public String getMessage()
    {
            String message = "Podano 0 jako argument. Wszystkie podane liczby muszą być różne od 0.";
            return message;
    }
}
