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
 * @author Utente
 */
public class ArgCommandTest {
    
    public ArgCommandTest() {
    }
    
    /**
     * Test of execute method, of class ArgCommand, with a collection length greater than 0.
     */
    @Test
    public void testExecuteWithCollectionLengthGreaterThanZero() {
        System.out.println("execute with a collection length greater than 0");
        MyOperandCollection collector = new MyOperandCollection(12);
        ComplexNumber a = new ComplexNumber("-2", "9");
        ComplexNumber b = new ComplexNumber("4", "-3");
        collector.insert(a);
        collector.insert(b);
        ArgCommand instance = new ArgCommand(collector);
        boolean expResult = true;
        boolean result = instance.execute();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of execute method, of class ArgCommand, with a collection length equal to 0.
     */
    @Test
    public void testExecuteWithCollectionLengthEqualToZero() {
        System.out.println("execute with a collection equal to 0");
        MyOperandCollection collector = new MyOperandCollection(12);
        ArgCommand instance = new ArgCommand(collector);
        boolean expResult = false;
        boolean result = instance.execute();
        assertEquals(expResult, result);
    }

    /**
     * Test of undo method, of class ArgCommand, checking the operands are correctly repushed.
     */
    @Test
    public void testUndo() {
        System.out.println("undo");
        MyOperandCollection collector = new MyOperandCollection(12);
        ComplexNumber a = new ComplexNumber("-2", "9");
        collector.insert(a);
        ArgCommand instance = new ArgCommand(collector);
        instance.execute();
        instance.undo();
        assertEquals(1, collector.collectionLength());
        assertEquals(a, collector.last());
    }
    
}
