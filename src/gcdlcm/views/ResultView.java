package gcdlcm.views;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tcpserver.TcpServer;

/**
 * View representing results, errors and input requests in user's console
 * 
 * @author Piotr Paczuła
 * @version 1.2
 */
public class ResultView {
    /**
     * Used for read and write
     */
    private final TcpServer server;
    
    public ResultView(TcpServer server) {
       this.server = server;
    }
    
    /**
     * Prints given parameters to user's console.
     * 
     * @param gcm Greatest common divisor
     * @param lcm Least common multiple
     */
    public void printResult(int gcm, int lcm){
        try {
            server.write("Twoje wyniki to: ");
            server.write("NWD: "+gcm);
            server.write("NWW: "+lcm);
        } catch (IOException ex) {
            Logger.getLogger(ResultView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * Prints input request and reads input from user's console.
     * Then splits it to array of strings.
     * 
     * @return new array of strings
     */
    public String[] getInput() {
        try {
            server.write("Wprowadź liczby oddzielone spacjami lub zakończ program. [ q ]");
            return server.read().split(" ");
        } catch (IOException ex) {
            Logger.getLogger(ResultView.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new String[]{};
    }
    
    /**
     * Prints format error and reads input from user's console.
     * @return new array of strings
     */
    public void wrongInputFormat()
    {
        
        try {
            server.write("Niepoprawny format argumentów.");
        } catch (IOException ex) {
            Logger.getLogger(ResultView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Prints length error and reads input from user's console.
     * @return new array of strings
     */
    public void tooShortInputArray() 
    {
        try {
            server.write("Za mało argumentów. Potrzeba conajmniej dwóch liczb do wykonania obliczeń.");
        } catch (IOException ex) {
            Logger.getLogger(ResultView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Prints program's end message.
     */
    public void endView()
    {
        try {
            server.write("Koniec obliczeń.");
            server.write("quit");
        } catch (IOException ex) {
            Logger.getLogger(ResultView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Prints given error message on user's console.
     * @param excMessage exception string message.
     */
    public void exceptionMessage(String excMessage)
    {
        try {
            server.write("Error: "+excMessage);
        } catch (IOException ex) {
            Logger.getLogger(ResultView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}