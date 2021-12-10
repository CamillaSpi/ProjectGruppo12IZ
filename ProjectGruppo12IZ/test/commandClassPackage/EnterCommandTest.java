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
 * @author nando
 */
public class EnterCommandTest {

    public EnterCommandTest() {
    }

    /**
     * Test of execute method, of class EnterCommand.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        MyOperandCollection collector = new MyOperandCollection(12);
        ComplexNumber a = new ComplexNumber("-2", "9");
        EnterCommand instance = new EnterCommand(collector, a);
        boolean expResult = true;
        boolean result = instance.execute();
        assertEquals(expResult, result);
    }

    /**
     * Test of undo method, of class EnterCommand.
     */
    @Test
    public void testUndo() {
        System.out.println("undo");
        System.out.println("undo");
        MyOperandCollection coll = new MyOperandCollection(12);
        ComplexNumber a = new ComplexNumber("-2", "9");
        EnterCommand instance = new EnterCommand(coll, a);
        instance.execute();
        instance.undo();
        assertEquals(0, coll.collectionLength());
    }

    /**
     * Test of null method, of class OverCommand. Expected AssertionError in new
     * OverCommand
     */
    @Test(expected = AssertionError.class)
    public void testNullCollection() {
        System.out.println("null");
        EnterCommand instance = new EnterCommand(null, new ComplexNumber("-2", "9"));
    }

    /**
     * Test of null method, of class OverCommand. Expected AssertionError in new
     * OverCommand
     */
    @Test(expected = AssertionError.class)
    public void testNullComplexNumber() {
        System.out.println("null");

        MyOperandCollection collector = new MyOperandCollection(12);
        EnterCommand instance = new EnterCommand(collector, null);
    }
}
