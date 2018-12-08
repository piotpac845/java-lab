package tcpserver;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Responsible for handling TCP connection with client applications.
 * @author Piotr Paczuła
 * @version 1.0
 */
public final class TcpServer {

   private final ServerSocket server;
   private Socket connectionSocket;
   private String message;
    public TcpServer() throws IOException
    {
        Properties props = new Properties();
        InputStream input =new FileInputStream("config.properties");
        props.load(input);
        int port = Integer.parseInt(props.getProperty("port"));
        server = new ServerSocket(port);
        resetConnection();
    }
    
    /**
     * Closes socket connection
     */
    public void closeConnection(){
       try {
           connectionSocket.close();
           System.out.println("Connection closed");
       } catch (IOException ex) {
           Logger.getLogger(TcpServer.class.getName()).log(Level.SEVERE, null, ex);
       }
       
    }
     /**
     * Resets socket connection
     */
   public void resetConnection() {
       try {
           connectionSocket = server.accept();
           System.out.println("Connection started");
       } catch (IOException ex) {
           Logger.getLogger(TcpServer.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
    /**
     * @return string from client.
     */
   public String read() {
       try {
           if(connectionSocket.isClosed())
               resetConnection();
           requestInput();
           BufferedReader input = new BufferedReader (new InputStreamReader(connectionSocket.getInputStream()));
           message = input.readLine();
           System.out.println("Server got: "+message);
           return message;
       } catch (IOException ex) {
           System.out.println("Connection error!");
           closeConnection();
       }
       return "q";
    }
   /**
    * Request input from client
    */
   private void requestInput() {
       try {
           if(connectionSocket.isClosed())
               resetConnection();
           PrintWriter output;
           output = new PrintWriter(
                   new BufferedWriter(
                           new OutputStreamWriter(
                                   connectionSocket.getOutputStream())), true);
           System.out.println("Input requested");
           output.println("input");
       } catch (IOException ex) {
           System.out.println("Connection error!");
           closeConnection();
       }
   }
   /**
    * Sends message to client
    * @param msg send message
    */
   public void write(String msg) {
       try {
           if(connectionSocket.isClosed())
               resetConnection();
           PrintWriter output;
           output = new PrintWriter(
                   new BufferedWriter(
                           new OutputStreamWriter(
                                   connectionSocket.getOutputStream())), true);
           System.out.println("Server send: "+msg);
           output.println(msg);
           // Wait for response
           BufferedReader response = new BufferedReader (new InputStreamReader(connectionSocket.getInputStream()));
           message = response.readLine();
           if(!"ready".equals(message))
           {
              System.out.println("Client's response was invalid. Expected: ready. Got: "+message);
           }
       } catch (IOException ex) {
           System.out.println("Connection error!");
           closeConnection();
       }
   }
   
}
