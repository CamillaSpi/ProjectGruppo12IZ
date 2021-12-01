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
public class MultiplyCommandTest {
    
    
    
    public MultiplyCommandTest() {
       
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
     * Test of execute method, of class MultiplyCommand, checking is pushed the correct result.
     */
    @Test
    public void testExecuteCorrectMultiplication() {
        System.out.println("execute correct addiction");
        MyOperandCollection collector = new MyOperandCollection(12);
        ComplexNumber a = new ComplexNumber("-2", "9");
        ComplexNumber b = new ComplexNumber("4", "-3");
        collector.insert(a);
        collector.insert(b);
        MultiplyCommand instance = new MultiplyCommand(collector);
        instance.execute();
        assertEquals(collector.last(),Calculator.multiplication(a, b));
    }
    
        /**
     * Test of execute method, of class MultiplyCommand, checking the correct size of operands in the collector.
     */
    @Test
    public void testExecuteCorrectSize() {
        System.out.println("execute correct size");
        MyOperandCollection collector = new MyOperandCollection(12);
        ComplexNumber a = new ComplexNumber("-2", "9");
        ComplexNumber b = new ComplexNumber("4", "-3");
        collector.insert(a);
        collector.insert(b);
        MultiplyCommand instance = new MultiplyCommand(collector);
        instance.execute();
        assertEquals(1, collector.collectionLength());
    }
    

    /**
     * Test of undo method, of class MultiplyCommand, checking the operands are correctly repushed.
     */
    @Test
    public void testUndoCorrectOperands() {
        System.out.println("undo correct operands");
        MyOperandCollection collector = new MyOperandCollection(12);
        ComplexNumber a = new ComplexNumber("-2", "9");
        ComplexNumber b = new ComplexNumber("4", "-3");
        collector.insert(a);
        collector.insert(b);
        MultiplyCommand instance = new MultiplyCommand(collector);
        instance.execute();
        instance.undo();
        assertEquals(b, collector.last());
        assertEquals(a, collector.secondLast()); 
    }
    /**
     * Test of undo method, of class MultiplyCommand, checking the operands are correctly repushed.
     */
    @Test
    public void testUndoCorrectSize() {
        System.out.println("undo correct size");
        MyOperandCollection collector = new MyOperandCollection(12);
        ComplexNumber a = new ComplexNumber("-2", "9");
        ComplexNumber b = new ComplexNumber("4", "-3");
        collector.insert(a);
        collector.insert(b);
        MultiplyCommand instance = new MultiplyCommand(collector);
        instance.execute();
        instance.undo();
        assertEquals(2, collector.collectionLength());
    }
    
    /**
     * Test of null collector
     */
    @Test(expected = AssertionError.class)
    public void  testNull(){
        MultiplyCommand mul = new MultiplyCommand(null);
    }
    
    /**
     * Test of collector without elements
     */
    @Test(expected = AssertionError.class)
    public void  testNullOperands(){
        MyOperandCollection collector = new MyOperandCollection(12);
        MultiplyCommand mul = new MultiplyCommand(collector);
    }
    
}
