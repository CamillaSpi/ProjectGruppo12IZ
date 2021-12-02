/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

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
 * @author Gruppo 12
 */
public class SwapCommandTest {
    
    public SwapCommandTest() {
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
     * Test of execute method, of class SwapCommand with correct entry.
     */
    @Test
    public void testExecuteWithNumber() {
        System.out.println("execute");
        MyOperandCollection coll = new MyOperandCollection(12);
        coll.insert(ComplexNumber.create("5+6j"));
        coll.insert(ComplexNumber.create("-0.2+18j"));
        SwapCommand instance = new SwapCommand(coll);
        instance.execute();
        assertEquals(ComplexNumber.create("5+6j"), coll.last());
    }
    
    /**
     * Test of execute method, of class SwapCommand, with empty Collection.
     */
    @Test
    public void testExecuteEmpty() {
        System.out.println("execute");
        MyOperandCollection coll = new MyOperandCollection(12);
        DropCommand instance = new DropCommand(coll);
        assertEquals(false, instance.execute());
    }
    
    /**
     * Test of undo method, of class SwapCommand, correct.
     */
    @Test
    public void testUndo() {
        System.out.println("undo");
        MyOperandCollection coll = new MyOperandCollection(12);
        coll.insert(ComplexNumber.create("5+6j"));
        coll.insert(ComplexNumber.create("-0.2+18j"));
        SwapCommand instance = new SwapCommand(coll);
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
