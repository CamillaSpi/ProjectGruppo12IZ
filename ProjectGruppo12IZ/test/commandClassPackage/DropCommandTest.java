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
 * @author Mattia
 */
public class DropCommandTest {
    
    public DropCommandTest() {
    }
    
   

    /**
     * Test of execute method, of class DropCommand, correct.
     */
    @Test
    public void testExecuteWithNumber() {
        System.out.println("execute");
        MyOperandCollection coll = new MyOperandCollection(12);
        coll.insert(ComplexNumber.create("5+6j"));
        coll.insert(ComplexNumber.create("-0.2+18j"));
        DropCommand instance = new DropCommand(coll);
        instance.execute();
        assertEquals(ComplexNumber.create("5+6j"), coll.last());
    }

    /**
     * Test of execute method, of class DropCommand, with empty Collection.
     */
    @Test
    public void testExecuteEmpty() {
        System.out.println("execute");
        MyOperandCollection coll = new MyOperandCollection(12);
        DropCommand instance = new DropCommand(coll);
        assertEquals(false, instance.execute());
    }
    
    /**
     * Test of undo method, of class DropCommand, correct.
     */
    @Test
    public void testUndo() {
        System.out.println("undo");
        MyOperandCollection coll = new MyOperandCollection(12);
        coll.insert(ComplexNumber.create("5+6j"));
        coll.insert(ComplexNumber.create("-0.2+18j"));
        DropCommand instance = new DropCommand(coll);
        instance.execute();
        System.out.println("Execute:");
        System.out.println(coll.last());
        System.out.println(coll.secondLast());
        instance.undo();
        System.out.println("Undo:");
        System.out.println(coll.last());
        System.out.println(coll.secondLast());
        assertEquals(ComplexNumber.create("-0.2+18j"), coll.last());
    }
    
}
