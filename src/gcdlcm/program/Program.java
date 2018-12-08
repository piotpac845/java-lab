package gcdlcm.program;

import gcdlcm.controllers.FlowController;
import java.io.IOException;
import tcpserver.TcpServer;

/**
 * Main area of application, responsible for handling starting parameters
 * @author Piotr
 * @version 1.2
 */
public class Program {
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws IOException{
        boolean willRun = false;
        switch(args.length){
            case 0:
                willRun = true;
                break;
            case 1:
                if("info".equals(args[0])){
                     System.out.println("Program służy jako serwer obliczeniowy najmniejszej wspólnej wielokrotności oraz największego wspólnego dzielnika.\n"
                             + "Dane konfiguracyjne można znaleźć w pliku config.properties");
                }
            default:
            System.out.println("Nieprawidłowe dane wejściowe.");
                break;
        }
        
        if(willRun){
            TcpServer server = new TcpServer();
            FlowController flow = new FlowController(server);
            while(!flow.run());
            System.out.println("Program quit.");
        }
        
    }
}
