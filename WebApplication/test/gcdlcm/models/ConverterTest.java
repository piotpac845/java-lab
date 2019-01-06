/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcdlcm.models;

import java.util.ArrayList;
import java.util.List;
import javafx.util.Pair;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test suite for Converter class
 * @author Piotr Paczuła
 * @version 1.0
 */
public class ConverterTest {

    /**
     * Test of getInput method, of class Converter.
     * Checks the correct scenario.
     */
    @Test
    public void testGetInputCorrect() {
        String args = "22 123 555 332";
        Converter instance = new Converter();
        ArrayList<Integer> expectedNumbers = new ArrayList<>();
        expectedNumbers.add(22);
        expectedNumbers.add(123);
        expectedNumbers.add(555);
        expectedNumbers.add(332);
        Pair<ConvertingState, List<Integer>> expResult = new Pair<>(ConvertingState.correct,expectedNumbers);
        Pair<ConvertingState, List<Integer>> result = instance.getInput(args);
        assertEquals(expResult, result);
    }
     /**
     * Test of getInput method, of class Converter.
     * Checks the too short input scenario.
     */
    @Test
    public void testGetInputTooShortInput() {
         String args = "22";
        Converter instance = new Converter();
        ArrayList<Integer> expectedNumbers = new ArrayList<>();
        Pair<ConvertingState, List<Integer>> expResult = new Pair<>(ConvertingState.tooShort,expectedNumbers);
        Pair<ConvertingState, List<Integer>> result = instance.getInput(args);
        assertEquals(expResult, result);
    }
     /**
     * Test of getInput method, of class Converter.
     * Checks the wrong format input scenario.
     */
     @Test
    public void testGetInputWrongFormat() {
         String args = "22 asdasd 555 332";
        Converter instance = new Converter();
        ArrayList<Integer> expectedNumbers = new ArrayList<>();
        Pair<ConvertingState, List<Integer>> expResult = new Pair<>(ConvertingState.wrongFormat,expectedNumbers);
        Pair<ConvertingState, List<Integer>> result = instance.getInput(args);
        assertEquals(expResult, result);
    }
    
}
