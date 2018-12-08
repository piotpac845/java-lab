package gcdlcm.controllers;

import gcdlcm.views.ResultView;
import java.util.List;
import javafx.util.Pair;
import tcpserver.TcpServer;

/**
 * Manages application flow
 * @author Piotr Paczuła
 * @version 1.2
 */
public class FlowController {

    /**
     * Used for managing calculations.
     */
    private final CalculationController calculator;
    
    /**
     * Used for managing user's inputs.
     */
    private final InputController input;
    
    /**
     * Used for displaying information.
     */
    private final ResultView view;
    private final TcpServer server;
    
    public FlowController(TcpServer server){
        this.server = server;
        this.view = new ResultView(server);
        this.input = new InputController(server);
        this.calculator = new CalculationController(server);
    }

    
    /**
     * Main method responsible for application start
     */
    public boolean run()
    {
        boolean quitSession = false;
        boolean quitProgram = false;
        do
        {
            String[] arguments = view.getInput();
            Pair<State,List<Integer>> result = input.getInput(arguments);
            List<Integer> numbers = result.getValue();
            State state = result.getKey();

            switch(state)
            {
                case correct:
                    calculator.calculate(numbers);
                    break;
                case help:
                    view.helpView();
                    break;
                case endProgram:
                    quitProgram = true;
                    break;
                case endSession:
                    quitSession = true;
                    break;
                default:
                    break;
            }
        }while(!(quitSession || quitProgram));
        view.endView();
        server.closeConnection();
        return quitProgram;
        //view.endView();
    }
    
    
}
