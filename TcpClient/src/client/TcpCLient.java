/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;

/**
 *
 * @author Piotr
 */
public class TcpCLient {

 public static void main(String argv[]) throws Exception {
  String inputString = "input";
  String quitString = "quit";
  String message,response = "";
  
  Properties props = new Properties();
  InputStream input =new FileInputStream("config.properties");
  props.load(input);
  
  int port = Integer.parseInt(props.getProperty("port"));
  String url = props.getProperty("url");
  
  Scanner userInput = new Scanner(System.in);
  Socket socket = new Socket(url, port);
  while(!quitString.equals(response))
  {
    Scanner streamInput = new Scanner(socket.getInputStream());
    PrintStream sender = new PrintStream(socket.getOutputStream());
    response = streamInput.nextLine();
    if(!inputString.equals(response))
    {
       System.out.println(response);
       sender.println("ready");
    }
    else
    {
        System.out.println("Waiting for input...");
        message = userInput.nextLine();
        sender.println(message);
    }
  }
  System.out.println("Application quit!");
 }
}
