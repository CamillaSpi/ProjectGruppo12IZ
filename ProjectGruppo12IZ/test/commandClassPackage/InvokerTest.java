/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package commandClassPackage;

import modelClassPackage.ComplexNumber;
import modelClassPackage.MyOperandCollection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vitot
 */
public class InvokerTest {
    
    public InvokerTest() {
    }
    
    /**
     * Test of execute method, of class Invoker, with correct elements.
     */
    @Test
    public void testExecuteCorrect() {
        System.out.println("execute correct");
        MyOperandCollection collector = new MyOperandCollection(12);
        ComplexNumber a = new ComplexNumber("-4", "2");
        ComplexNumber b = new ComplexNumber("-7", "3");
        Command command = new AddCommand(collector);
        collector.insert(a);
        collector.insert(b);
        Invoker instance = new Invoker();
        assertEquals(true,instance.execute(command));
        assertEquals(command,instance.getStack().getLast());
    }
    
    /**
     * Test of execute method, of class Invoker, with incorrect elements.
     */
    @Test
    public void testExecuteIncorrect() {
        System.out.println("execute incorrect");
        MyOperandCollection collector = new MyOperandCollection(12);
        Command command = new AddCommand(collector);
        Invoker instance = new Invoker();
        assertEquals(false,instance.execute(command));
        assertEquals(command,instance.getStack().getLast());
    }
    /**
     * Test of undoLast method, of class Invoker.
     */
    @Test
    public void testUndoLast() {
        System.out.println("undo");
        MyOperandCollection collector = new MyOperandCollection(12);
        ComplexNumber a = new ComplexNumber("-4", "2");
        ComplexNumber b = new ComplexNumber("-7", "3");
        Command command = new AddCommand(collector);
        collector.insert(a);
        collector.insert(b);
        Invoker instance = new Invoker();
        instance.execute(command);
        instance.undoLast();
        assertEquals(true,instance.getStack().isEmpty());
    }
    
}
