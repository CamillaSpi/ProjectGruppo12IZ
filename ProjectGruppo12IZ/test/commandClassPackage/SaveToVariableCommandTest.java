/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import modelClassPackage.ComplexNumber;
import modelClassPackage.MyOperandCollection;
import modelClassPackage.Variables;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mattia
 */
public class SaveToVariableCommandTest {
    
    public SaveToVariableCommandTest() {
    }
    
    /**
     * Test of execute method, of class SaveToVariableCommand, correct entry.
     */
    @Test
    public void testExecute() {
        System.out.println("save to variable execute correct");
        MyOperandCollection coll = new MyOperandCollection(12);
        coll.insert(ComplexNumber.create("5+6j"));
        coll.insert(ComplexNumber.create("-0.2+18j"));
        Variables var = new Variables();
        SaveToVariableCommand instance = new SaveToVariableCommand(coll, var, "a");
        instance.execute();
        assertEquals(ComplexNumber.create("-0.2+18j"), var.getValue("a"));
    }
    
    /**
     * Test of execute method, of class SaveToVariableCommand, with empty Collection.
     */
    @Test
    public void testExecuteEmpty() {
        System.out.println("save to variable execute empty");
        MyOperandCollection coll = new MyOperandCollection(12);
        Variables var = new Variables();
        SaveToVariableCommand instance = new SaveToVariableCommand(coll, var, "a");
        assertEquals(false, instance.execute());
    }

    /**
     * Test of undo method, of class SaveToVariableCommand.
     */
    @Test
    public void testUndo() {
        System.out.println("save to variable undo");
        MyOperandCollection coll = new MyOperandCollection(12);
        coll.insert(ComplexNumber.create("5+6j"));
        coll.insert(ComplexNumber.create("-0.2+18j"));
        Variables var = new Variables();
        SaveToVariableCommand instance = new SaveToVariableCommand(coll, var, "a");
        instance.execute();
        System.out.println("Execute:");
        System.out.println(var.getValue("a"));
        instance.undo();
        assertEquals(null, var.getValue("a"));
    }
    
}
