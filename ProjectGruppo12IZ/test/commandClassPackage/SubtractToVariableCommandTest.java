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
public class SubtractToVariableCommandTest {
    private final MyOperandCollection collector;
    private final Variables vars;  
    public SubtractToVariableCommandTest() {
        collector = new MyOperandCollection(12);
        collector.insert(new ComplexNumber("-2", "9"));
        vars = new Variables();
        vars.saveToVariable("a", new ComplexNumber("2","9"));
        
    }
    
    /**
     * Test of execute method, of class SubtractToVariableCommand.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        
        SubtractToVariableCommand instance = new SubtractToVariableCommand(collector,vars,"a");
        ComplexNumber expResult = Calculator.subtraction(vars.getValue("a"), collector.last());
        instance.execute();
        ComplexNumber result = vars.getValue("a");
        assertEquals(expResult, result);
    }

    /**
     * Test of undo method, of class SubtractToVariableCommand.
     */
    @Test
    public void testUndo() {
        System.out.println("undo");
        SubtractToVariableCommand instance = new SubtractToVariableCommand(collector,vars,"a");
        ComplexNumber oldInStack = collector.last();
        ComplexNumber oldVariables = vars.getValue("a");
        
        instance.execute();
        instance.undo();
        assertEquals(oldInStack, collector.last());
        assertEquals(oldVariables, vars.getValue("a"));
        
    }
     /**
     * Test of No element in collection method, of class SubtractToVariableCommand.
     */
    @Test
    public void testExecuteNoElementInCollections() {
        System.out.println("Execute with no element in collections");
        SubtractToVariableCommand instance = new SubtractToVariableCommand(collector,vars,"a");
        collector.remove();
        
        boolean result = instance.execute();
        boolean expResult = false;
        assertEquals(expResult, result);
        
    }
     /**
     * Test of Null Variable method, of class SubtractToVariableCommand.
     */
    @Test
    public void testExecuteNullVar() {
        System.out.println("Execute with null variable");
        SubtractToVariableCommand instance = new SubtractToVariableCommand(collector,vars,"b");
        
        boolean result = instance.execute();
        boolean expResult = false;
        assertEquals(expResult, result);
        
    }
    
    
}
