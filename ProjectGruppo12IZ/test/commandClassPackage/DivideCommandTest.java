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
public class DivideCommandTest {
    
    public DivideCommandTest() {
    }

    /**
     * Test of execute method, of class DivideCommand, checking is pushed the correct result.
     */
    @Test
    public void testExecuteCorrectDivision() {
        System.out.println("execute correct division");
        MyOperandCollection collector = new MyOperandCollection(12);
        ComplexNumber a = new ComplexNumber("-4", "2");
        ComplexNumber b = new ComplexNumber("-7", "3");
        collector.insert(a);
        collector.insert(b);
        DivideCommand instance = new DivideCommand(collector);
        instance.execute();
        assertEquals(collector.last(),Calculator.division(a, b));
    }
    
     /**
     * Test of execute method, of class DivideCommand, checking the correct size of operands in the collector.
     */
    @Test
    public void testExecuteCorrectSize() {
        System.out.println("execute correct size");
        MyOperandCollection collector = new MyOperandCollection(12);
        ComplexNumber a = new ComplexNumber("-4", "2");
        ComplexNumber b = new ComplexNumber("-7", "3");
        collector.insert(a);
        collector.insert(b);
        DivideCommand instance = new DivideCommand(collector);
        instance.execute();
        assertEquals(1, collector.collectionLength());
    }
    
    /**
     * Test of undo method, of class DivideCommand, checking the operands are correctly re-pushed.
     */
    @Test
    public void testUndoCorrectOperands() {
        System.out.println("undo correct operands");
        MyOperandCollection collector = new MyOperandCollection(12);
        ComplexNumber a = new ComplexNumber("-4", "2");
        ComplexNumber b = new ComplexNumber("-7", "3");
        collector.insert(a);
        collector.insert(b);
        DivideCommand instance = new DivideCommand(collector);
        instance.execute();
        instance.undo();
        assertEquals(b, collector.last());
        assertEquals(a, collector.secondLast()); 
    }
    
    /**
     * Test of undo method, of class DivideCommand, checking the operands are correctly repushed.
     */
    @Test
    public void testUndoCorrectSize() {
        System.out.println("undo correct size");
        MyOperandCollection collector = new MyOperandCollection(12);
        ComplexNumber a = new ComplexNumber("-4", "2");
        ComplexNumber b = new ComplexNumber("-7", "3");
        collector.insert(a);
        collector.insert(b);
        DivideCommand instance = new DivideCommand(collector);
        instance.execute();
        instance.undo();
        assertEquals(2, collector.collectionLength());
    }
    
    /**
     * Test of null collector
     */
    @Test(expected = AssertionError.class)
    public void  testNull(){
        DivideCommand division = new DivideCommand(null);
    }
    
    /**
     * Test of collector without elements
     */
    @Test
    public void  testNullOperands(){
        MyOperandCollection collector = new MyOperandCollection(12);
        DivideCommand division = new DivideCommand(collector);
        assertEquals(false, division.execute());
    }
}
