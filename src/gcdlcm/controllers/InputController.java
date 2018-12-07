package gcdlcm.controllers;

import gcdlcm.views.ResultView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.util.Pair;
import tcpserver.TcpServer;

/**
 * Manages user's input
 * @author Piotr Paczuła
 * @version 1.2
 */
public class InputController {
    
    /**
     * View object used for displaying information to user.
     */
    private final ResultView view;
    private final TcpServer server;
    public InputController(TcpServer server){
        this.server = server;
        this.view = new ResultView(server);
    }
    /**
     * Checks if user wants to quit application
     * @param args user's input
     * @return True if application should end.
     */

    
    private State checkQuitCondition(String[] args)
    {
        if(args.length == 1)
                {
                   switch(args[0])
                   {
                       case "q":
                           return State.endSession;
                       case "Q":
                           return State.endProgram;
                       default:
                           return State.correct;
                   }
                }
        return State.correct;
    }
    
   
    
    /**
     * Gets valid input from user and converts it to list of integers
     * @param args user's input. Valid options are 
     * numbers separated by spaces or "q"/"Q".
     * @return List of integer 
     */
    @SafeVarargs
    public final Pair<State, List<Integer>> getInput(String... args){
        String[] argmunets = args;
        List<Integer> array = new ArrayList<>();
        State state = checkQuitCondition(argmunets);

            if(state==State.correct)
            {
                try {
                    if(argmunets.length > 1) {
                        Arrays.asList(argmunets).forEach(arg->{
                            array.add(Integer.parseInt(arg));
                        });
                        state = State.correct;
                    }
                    else
                    {
                        array.clear();
                        state = State.tooShort;
                        view.tooShortInputArray();
                    }
                }
                catch(NumberFormatException exception)
                {   
                    array.clear();            
                    state = State.incorrectFormat;
                    view.wrongInputFormat();
                }
        }
        return new Pair(state,array);
    }
}
