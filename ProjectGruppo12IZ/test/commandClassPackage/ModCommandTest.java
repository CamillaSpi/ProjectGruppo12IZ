/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import modelClassPackage.Calculator;
import modelClassPackage.ComplexNumber;
import modelClassPackage.MyOperandCollection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gruppo 12 IZ
 */
public class ModCommandTest {
    
    public ModCommandTest() {
    }
    

    /**
     * Test of execute method, of class ModCommand, with a collection length greater than 0.
     */
    @Test
    public void testExecuteWithCollectionLengthGreaterThanZero() {
        System.out.println("execute with a collection length greater than 0");
        MyOperandCollection collector = new MyOperandCollection(12);
        ComplexNumber a = new ComplexNumber("-2", "9");
        ComplexNumber b = new ComplexNumber("4", "-3");
        collector.insert(a);
        collector.insert(b);
        ModCommand instance = new ModCommand(collector);
        boolean expResult = true;
        boolean result = instance.execute();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of execute method, of class ModCommand, with a collection length equal to 0.
     */
    @Test
    public void testExecuteWithCollectionLengthEqualToZero() {
        System.out.println("execute with a collection equal to 0");
        MyOperandCollection collector = new MyOperandCollection(12);
        ModCommand instance = new ModCommand(collector);
        boolean expResult = false;
        boolean result = instance.execute();
        assertEquals(expResult, result);
    }

    /**
     * Test of undo method, of class ModCommand, checking the operands are correctly repushed.
     */
    @Test
    public void testUndo() {
        System.out.println("undo");
        MyOperandCollection collector = new MyOperandCollection(12);
        ComplexNumber a = new ComplexNumber("-2", "9");
        collector.insert(a);
        ModCommand instance = new ModCommand(collector);
        instance.execute();
        instance.undo();
        assertEquals(1, collector.collectionLength());
        assertEquals(a, collector.last());
    }
    
}
