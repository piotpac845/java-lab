package gcdlcm.exceptions;

/**
 * Custom exception thrown when given array is too short for operation.
 * @author Piotr Paczuła
 * @version 1.0
 */
public class TooShortArrayException extends Exception  {
/**
 * Overridden method getMessage() returning exception message.
 * @return message string
 */
    @Override
    public String getMessage()
    {
            String message = "Podano za krótką listę liczb. Minimalna liczba wynosi: 2.";
            return message;
    }
}
