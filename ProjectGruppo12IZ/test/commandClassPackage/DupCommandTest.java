/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import modelClassPackage.ComplexNumber;
import modelClassPackage.MyOperandCollection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gruppo 12 IZ
 */
public class DupCommandTest {
    
    MyOperandCollection collector;
    public DupCommandTest() {
        collector = new MyOperandCollection(12);
        collector.insert(new ComplexNumber("2", "7"));
    }

    /**
     * Test of execute method, of class OverCommand.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        DupCommand instance = new DupCommand(collector);
        ComplexNumber expResult = collector.last();
        instance.execute();
        ComplexNumber result = collector.last();
        assertEquals(result, expResult);
    }

    /**
     * Test of undo method, of class OverCommand.
     */
    @Test
    public void testUndo() {
        System.out.println("undo");
        DupCommand instance = new DupCommand(collector);
        ComplexNumber previusly = collector.last();
        instance.execute();
        instance.undo();
        ComplexNumber result = collector.last();
        assertEquals(result, previusly);
    }
    
    /**
     * Test of null method, of class OverCommand.
     * Expected AssertionError in new OverCommand
     */
    @Test(expected = AssertionError.class)
    public void testNull() {
        System.out.println("null");
        DupCommand instance = new DupCommand(null);
    }      
}
