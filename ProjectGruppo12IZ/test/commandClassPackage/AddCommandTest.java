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
 *
 * @author Gruppo 12 IZ
 */
public class AddCommandTest {
    
    
    
    public AddCommandTest() {
       
    }
    /**
     * Test of execute method, of class AddCommand, checking is pushed the correct result.
     */
    @Test
    public void testExecuteCorrectAddiction() {
        System.out.println("execute correct addiction");
        MyOperandCollection collector = new MyOperandCollection(12);
        ComplexNumber a = new ComplexNumber("-2", "9");
        ComplexNumber b = new ComplexNumber("4", "-3");
        collector.insert(a);
        collector.insert(b);
        AddCommand instance = new AddCommand(collector);
        instance.execute();
        assertEquals(collector.last(),Calculator.addiction(a, b));
    }
    
        /**
     * Test of execute method, of class AddCommand, checking the correct size of operands in the collector.
     */
    @Test
    public void testExecuteCorrectSize() {
        System.out.println("execute correct size");
        MyOperandCollection collector = new MyOperandCollection(12);
        ComplexNumber a = new ComplexNumber("-2", "9");
        ComplexNumber b = new ComplexNumber("4", "-3");
        collector.insert(a);
        collector.insert(b);
        AddCommand instance = new AddCommand(collector);
        instance.execute();
        assertEquals(1, collector.collectionLength());
    }
    

    /**
     * Test of undo method, of class AddCommand, checking the operands are correctly repushed.
     */
    @Test
    public void testUndoCorrectOperands() {
        System.out.println("undo correct operands");
        MyOperandCollection collector = new MyOperandCollection(12);
        ComplexNumber a = new ComplexNumber("-2", "9");
        ComplexNumber b = new ComplexNumber("4", "-3");
        collector.insert(a);
        collector.insert(b);
        AddCommand instance = new AddCommand(collector);
        instance.execute();
        instance.undo();
        assertEquals(b, collector.last());
        assertEquals(a, collector.secondLast()); 
    }
    /**
     * Test of undo method, of class AddCommand, checking the operands are correctly repushed.
     */
    @Test
    public void testUndoCorrectSize() {
        System.out.println("undo correct size");
        MyOperandCollection collector = new MyOperandCollection(12);
        ComplexNumber a = new ComplexNumber("-2", "9");
        ComplexNumber b = new ComplexNumber("4", "-3");
        collector.insert(a);
        collector.insert(b);
        AddCommand instance = new AddCommand(collector);
        instance.execute();
        instance.undo();
        assertEquals(2, collector.collectionLength());
    }
    
    /**
     * Test of null collector
     */
    @Test(expected = AssertionError.class)
    public void  testNull(){
        AddCommand adder = new AddCommand(null);
    }  
}
