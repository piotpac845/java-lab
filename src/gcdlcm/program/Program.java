/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcdlcm.program;

import gcdlcm.controllers.FlowController;
import java.io.IOException;
import tcpserver.TcpServer;

/**
 *
 * @author Piotr
 */
public class Program {
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws IOException{
        TcpServer server = new TcpServer();
        FlowController flow = new FlowController(server);
        while(!flow.run());
        
    }
}
