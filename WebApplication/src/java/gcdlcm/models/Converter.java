package gcdlcm.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.util.Pair;

/**
 *
 * @author Piotr Paczua
 * @version 1.0
 */
public class Converter {
/**
 * 
 * @param args user's input
 * @return pair where key is state of converted string and value is converted value.
 */
 public final Pair<ConvertingState, List<Integer>> getInput(String args){
        String[] argmunets = args.split(" ");
        List<Integer> array = new ArrayList<>();
        ConvertingState state;

                try {
                    if(argmunets.length > 1) {
                        Arrays.asList(argmunets).forEach(arg->{
                            array.add(Integer.parseInt(arg));
                        });
                        state = ConvertingState.correct;
                    }
                    else
                    {
                        array.clear();
                        state = ConvertingState.tooShort;
                    }
                }
                catch(NumberFormatException exception)
                {   
                    array.clear();            
                    state = ConvertingState.wrongFormat;
                }
        return new Pair(state,array);
    }
}