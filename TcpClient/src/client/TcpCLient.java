package client;

import client.exceptions.PropertiesNotLoadedException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author Piotr Paczuła
 * @version 1.0
 */
public class TcpCLient {

    
 /**
  * Main method of client
  * @param argv starting parameters
  */
 public static void main(String argv[]) {
    StringBuilder builder = new StringBuilder();
    for(String s : argv) {
    builder.append(s);
    builder.append(" ");
    }
    String firstMessage = builder.toString();
    
    try {
        boolean connected = false;
        String inputString = "input";
        String quitString = "quit";
        String message,response = "";
        
        Properties props = new Properties();
        try {
            InputStream input =new FileInputStream("config.properties");
            props.load(input);
        } catch (IOException ex) {
            throw new PropertiesNotLoadedException();
        }
        
        int port = Integer.parseInt(props.getProperty("port"));
        String url = props.getProperty("url");
        
        Scanner userInput = new Scanner(System.in);
        Socket socket = new Socket(url, port);
        connected = true;
        while(connected)
        {
            Scanner streamInput = new Scanner(socket.getInputStream());
            PrintStream sender = new PrintStream(socket.getOutputStream());
            response = streamInput.nextLine();
            if(inputString.equals(response))
            {
                System.out.println("Wprowadź dane...");
                if(!firstMessage.isEmpty()) {
                    message = firstMessage;
                    firstMessage = "";
                }
                else {
                    message = userInput.nextLine();
                }
                sender.println(message);
            }
            else if(quitString.equals(response))
            {
                connected = false;
            }
            else
            {
                System.out.println(response);
                sender.println("ready");
            }
        }
        System.out.println("Klient został wyłączony.");
    } catch (IOException ex) {
         System.out.println("Błąd podczas łączenia z serwerem.");
    } catch (PropertiesNotLoadedException ex) {
         System.out.println(ex.getMessage());
    } catch(Exception ex) {
        System.out.println("Wystąpił nieznany błąd:\n"+ex.getMessage());
    }
 }
}
