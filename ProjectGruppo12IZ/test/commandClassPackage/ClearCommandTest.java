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
public class ClearCommandTest {
    
    public ClearCommandTest() {
    }

    /**
     * Test of execute method, of class ClearCommand, with numbers.
     */
    @Test
    public void testExecuteWithNumbers() {
        System.out.println("execute with numbers");
        MyOperandCollection coll = new MyOperandCollection(12);
        coll.insert(new ComplexNumber("5","6"));
        coll.insert(new ComplexNumber("5","6"));
        ClearCommand instance = new ClearCommand(coll);
        instance.execute();
        assertEquals(0, coll.collectionLength());
    }
    
    /**
     * Test of execute method, of class ClearCommand, with empty Collection.
     */
    @Test
    public void testExecuteEmpty() {
        System.out.println("execute empty collection");
        MyOperandCollection coll = new MyOperandCollection(12);
        ClearCommand instance = new ClearCommand(coll);
        assertEquals(false, instance.execute());
    }
    
    /**
     * Test of undo method, of class ClearCommand.
     */
    @Test
    public void testUndo() {
        System.out.println("undo");
        MyOperandCollection coll = new MyOperandCollection(12);
        coll.insert(ComplexNumber.create("5+6j"));
        coll.insert(ComplexNumber.create("-0.2+18j"));
        ClearCommand instance = new ClearCommand(coll);
        instance.execute();
        instance.undo();
        assertEquals(ComplexNumber.create("-0.2+18j"), coll.getL().get(0));
        assertEquals(ComplexNumber.create("5+6j"), coll.getL().get(1));
        assertEquals(2, coll.collectionLength());
    }
    
}
