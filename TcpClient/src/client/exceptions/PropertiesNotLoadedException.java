package client.exceptions;

/**
 * Exception thrown when properties from file aren't loaded properly.
 * @author Piotr Paczuła
 * @version 1.0
 */
public class PropertiesNotLoadedException extends Exception {

    public PropertiesNotLoadedException() {
    }
    @Override
    public String getMessage()
    {
            String message = "Błąd podczas wczytywania konfiguracji z pliku.";
            return message;
    }
    
    
}
