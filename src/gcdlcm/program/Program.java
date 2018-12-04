package gcdlcm.program;

import gcdlcm.controllers.FlowController;

/**
 * Greatest common divisor and least common multiple console calculator
 * 
 * @author Piotr Paczuła
 * @version 1.0
 */
public class Program {

    
    /**
     * @param args the command line arguments which are numbers separated by spaces 
     * used for calculating Greatest Common Divisor and Least Common Multiple
     */
    public static void main(String[] args) {
       FlowController program = new FlowController();
       program.run(args);
    }
    
}
