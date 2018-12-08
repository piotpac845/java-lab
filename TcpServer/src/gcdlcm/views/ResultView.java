package gcdlcm.views;

import tcpserver.TcpServer;

/**
 * View representing results, errors and input requests in user's client
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
        server.write("Twoje wyniki to: ");
        server.write("NWD: "+gcm);
        server.write("NWW: "+lcm);
    }
    /**
     * Prints input request and reads input from user's client.
     * Then splits it to array of strings.
     * 
     * @return new array of strings
     */
    public String[] getInput() {
        server.write("Wprowadź liczby oddzielone spacjami lub zakończ program. [ q ]");
        return server.read().split(" ");
    }
    
    /**
     * Prints format error to user's client.
     */
    public void wrongInputFormat()
    {
        server.write("Niepoprawny format argumentów.");
    }
    
    /**
     * Prints length error to user's client.
     */
    public void tooShortInputArray() 
    {
        server.write("Za mało argumentów. Potrzeba conajmniej dwóch liczb do wykonania obliczeń.");
    }
    
    /*
    * Prints help message to user's client.
    */
    public void helpView() {
        server.write("Opis funkcjonalności: "+
                "1. 'help' - opis poleceń. "+
                "2. 'q' - zakończ sesje "+
                "3. 'Q' - zakończ program główny "+
                "4. Aby wprowadzić liczby potrzebne do obliczeń oddziel je spacjami we wskazany sposób: '10 20 412 44' "+
                "Dla programów typu puTTy: " + 
                "1. Każdą wiadomość należy potwierdzić wyrazeniem 'ready'. "+
                "2. W przypadku uzyskania wiadomości 'input' oczekiwane są dane od użytkownika np. komendy 'q'/'Q'/zestaw liczb...");
    }
    
    
    
    /**
     * Prints program's end message.
     */
    public void endView() {
        server.write("Koniec obliczeń.");
        server.write("quit");
    }
    
    /**
     * Prints given error message on user's console.
     * @param excMessage exception string message.
     */
    public void exceptionMessage(String excMessage)
    {
        server.write("Error: "+excMessage);
    }
    
}