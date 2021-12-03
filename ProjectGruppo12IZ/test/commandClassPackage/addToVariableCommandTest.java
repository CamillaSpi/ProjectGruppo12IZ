/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import modelClassPackage.Calculator;
import modelClassPackage.ComplexNumber;
import modelClassPackage.MyOperandCollection;
import modelClassPackage.Variables;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nando
 */
public class addToVariableCommandTest {

    private final MyOperandCollection collector;
    private final Variables vars;

    public addToVariableCommandTest() {
        collector = new MyOperandCollection(12);
        collector.insert(new ComplexNumber("-2", "9"));
        vars = new Variables();
        vars.saveToVariable("a", new ComplexNumber("2", "9"));

    }

    /**
     * Test of execute method, of class addToVariableCommand.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        
        addToVariableCommand instance = new addToVariableCommand(collector,vars,"a");
        ComplexNumber expResult = Calculator.addiction(vars.getValue("a"), collector.last());
        instance.execute();
        ComplexNumber result = vars.getValue("a");
        assertEquals(expResult, result);
    }

    /**
     * Test of undo method, of class addToVariableCommand.
     */
    @Test
    public void testUndo() {
        System.out.println("undo");
        addToVariableCommand instance = new addToVariableCommand(collector,vars,"a");
        ComplexNumber oldInStack = collector.last();
        ComplexNumber oldVariables = vars.getValue("a");
        
        instance.execute();
        instance.undo();
        assertEquals(oldInStack, collector.last());
        assertEquals(oldVariables, vars.getValue("a"));
        
    }
     /**
     * Test of No element in collection method, of class addToVariableCommand.
     */
    @Test
    public void testExecuteNoElementInCollections() {
        System.out.println("Execute with no element in collections");
        addToVariableCommand instance = new addToVariableCommand(collector,vars,"a");
        collector.remove();
        
        boolean result = instance.execute();
        boolean expResult = false;
        assertEquals(expResult, result);
        
    }
     /**
     * Test of Null Variable method, of class addToVariableCommand.
     */
    @Test
    public void testExecuteNullVar() {
        System.out.println("Execute with null variable");
        addToVariableCommand instance = new addToVariableCommand(collector,vars,"b");
        
        boolean result = instance.execute();
        boolean expResult = false;
        assertEquals(expResult, result);
        
    }

}
