/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpserver;

import gcdlcm.controllers.FlowController;
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
 *
 * @author Piotr
 */
public class TcpServer {

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
   public void resetConnection() throws IOException {
       connectionSocket = server.accept();
       System.out.println("Connection started");
   }
   
   public String read() throws IOException {
       if(connectionSocket.isClosed())
           resetConnection();
        requestInput();
        BufferedReader input = new BufferedReader (new InputStreamReader(connectionSocket.getInputStream()));
        message = input.readLine();
        System.out.println("Server got: "+message);
        return message;
    }
   private void requestInput() throws IOException{
        if(connectionSocket.isClosed())
             resetConnection();
       PrintWriter output;
        output = new PrintWriter(
                new BufferedWriter(
                        new OutputStreamWriter(
                                connectionSocket.getOutputStream())), true);
        System.out.println("Input requested");
        output.println("input");
   }
   
   public void write(String msg) throws IOException {
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
            //throw ex
        }
   }
   
}
