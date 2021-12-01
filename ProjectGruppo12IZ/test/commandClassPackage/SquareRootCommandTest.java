/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import modelClassPackage.Calculator;
import modelClassPackage.ComplexNumber;
import modelClassPackage.MyOperandCollection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Gruppo 12 IZ
 */
public class SquareRootCommandTest {

    MyOperandCollection collector;

    public SquareRootCommandTest() {
        collector = new MyOperandCollection(12);
        collector.insert(new ComplexNumber("2", "7"));
    }

    /**
     * Test of execute method, of class SquareRootCommand.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        SquareRootCommand instance = new SquareRootCommand(collector);
        ComplexNumber previusly = collector.last();
        instance.execute();
        ComplexNumber result = collector.last();
        ComplexNumber expResult = Calculator.squareRoot(previusly);
        assertEquals(result, expResult);
    }

    /**
     * Test of undo method, of class SquareRootCommand.
     */
    @Test
    public void testUndo() {
        System.out.println("undo");
        SquareRootCommand instance = new SquareRootCommand(collector);
        ComplexNumber previusly = collector.last();
        instance.execute();
        instance.undo();
        ComplexNumber result = collector.last();
        assertEquals(result, previusly);
    }
    
    /**
     * Test of null method, of class SquareRootCommand.
     * Expected AssertionError in new SquareRootCommand
     */
    @Test(expected = AssertionError.class)
    public void testNull() {
        System.out.println("undo");
        SquareRootCommand instance = new SquareRootCommand(null);
    }

}
