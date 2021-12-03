/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import modelClassPackage.ComplexNumber;
import modelClassPackage.MyOperandCollection;
import modelClassPackage.Variables;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Utente
 */
public class SaveFromVariableCommandTest {
    
    public SaveFromVariableCommandTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class SaveFromVariableCommand, with an initialized variable.
     */
    @Test
    public void testExecuteWithCorrectVariable() {
        System.out.println("execute with an initialized variable");
        MyOperandCollection coll = new MyOperandCollection(12);
        Variables vars= new Variables();
        vars.getMyVariables().put("a", new ComplexNumber("5","6"));
        SaveFromVariableCommand instance = new SaveFromVariableCommand(coll,vars,"a");
        boolean expResult = true;
        boolean result = instance.execute();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of execute method, of class SaveFromVariableCommand, with a not initialized variable.
     */
    @Test
    public void testExecuteWithIncorrectVariable() {
        System.out.println("execute with a not initialized variable");
        MyOperandCollection coll = new MyOperandCollection(12);
        Variables vars= new Variables();
        SaveFromVariableCommand instance = new SaveFromVariableCommand(coll,vars,"a");
        boolean expResult = false;
        boolean result = instance.execute();
        assertEquals(expResult, result);
        assertEquals(0, coll.collectionLength());
    }

    /**
     * Test of undo method, of class SaveFromVariableCommand.
     */
    @Test
    public void testUndo() {
        System.out.println("undo");
        MyOperandCollection coll = new MyOperandCollection(12);
        Variables vars = new Variables();
        ComplexNumber val = new ComplexNumber("5","6");
        vars.getMyVariables().put("a", val);
        SaveFromVariableCommand instance = new SaveFromVariableCommand(coll,vars,"a");
        boolean expResult = false;
        instance.execute();
        assertEquals(1, coll.collectionLength());
        instance.undo();
        assertEquals(0, coll.collectionLength());
        assertEquals(val,vars.getValue("a"));
    }
    
}
