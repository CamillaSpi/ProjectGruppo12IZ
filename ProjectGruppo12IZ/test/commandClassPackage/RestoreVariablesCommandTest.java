/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import javafx.collections.ObservableMap;
import modelClassPackage.ComplexNumber;
import modelClassPackage.Variables;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nando
 */
public class RestoreVariablesCommandTest {

    public RestoreVariablesCommandTest() {
    }

    /**
     * Test of execute method, of class RestoreVariablesCommand.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        Variables vars = new Variables();
        RestoreVariablesCommand instance = new RestoreVariablesCommand(vars);
        boolean expResult = true;
        boolean result = instance.execute();
        assertEquals(expResult, result);
    }

    /**
     * Test of undo method, of class RestoreVariablesCommand.
     */
    @Test
    public void testUndo() {
        System.out.println("undo");
        Variables vars = new Variables();
        RestoreVariablesCommand instance = new RestoreVariablesCommand(vars);
        ObservableMap<String, ComplexNumber> expResult = vars.getMyVariables();
        instance.execute();
        instance.undo();
        ObservableMap<String, ComplexNumber> result = vars.getMyVariables();
        assertEquals(expResult, result);
    }

    /**
     * Test of create RestoreVariablesCommand with null Variables
     */
    @Test(expected = AssertionError.class)
    public void testNull() {
        System.out.println("null");
        RestoreVariablesCommand instance = new RestoreVariablesCommand(null);
        boolean expResult = true;
        boolean result = instance.execute();
        assertEquals(expResult, result);
    }

}
