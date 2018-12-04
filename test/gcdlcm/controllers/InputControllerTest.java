/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gcdlcm.controllers;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test suite for InputController class
 * @author Piotr Paczuła
 * @version 1.0
 */
public class InputControllerTest {
    /**
     * Test of getInput method, of class InputController.
     */
    @Test
    public void testGetInput() {
        String[] args = new String[]{"19", "38", "398"};
        InputController instance = new InputController();
        List<Integer> expResult = Arrays.asList(19,38,398);
        List<Integer> result = instance.getInput(args);
        assertEquals(expResult, result);
    }
}
