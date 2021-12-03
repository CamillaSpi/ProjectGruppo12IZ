/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import java.util.LinkedList;
import java.util.List;
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
public class ConcreteCommandPersonalizedTest {
    
    public ConcreteCommandPersonalizedTest() {
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
     * Test of execute method, of class ConcreteCommandPersonalized.
     */
    @Test
    public void testExecuteCorrectEntry(){
        System.out.println("execute correct concrete");
        MyOperandCollection collector = new MyOperandCollection(12);
        ComplexNumber a = new ComplexNumber("-4", "2");
        ComplexNumber b = new ComplexNumber("-7", "3");
        ComplexNumber c = new ComplexNumber("-8", "5");
        ComplexNumber d = new ComplexNumber("-11", "7");
        List<Command> l = new LinkedList();
        l.add(new AddCommand(collector));
        l.add(new AddCommand(collector));
        l.add(new AddCommand(collector));
        collector.insert(a);
        collector.insert(b);
        collector.insert(c);
        collector.insert(d);
        ConcreteCommandPersonalized instance = new ConcreteCommandPersonalized("super_somma", "+ + +", l);
        instance.execute();
        assertEquals(collector.last(),ComplexNumber.create("-30+17j"));
    }
    
    /**
     * Test of execute method, of class ConcreteCommandPersonalized.
     */
    @Test
    public void testExecuteFewOperand(){
        System.out.println("execute correct concrete");
        MyOperandCollection collector = new MyOperandCollection(12);
        ComplexNumber a = new ComplexNumber("-4", "2");
        ComplexNumber b = new ComplexNumber("-7", "3");
        ComplexNumber c = new ComplexNumber("-8", "5");
        List<Command> l = new LinkedList();
        l.add(new AddCommand(collector));
        l.add(new AddCommand(collector));
        l.add(new AddCommand(collector));
        collector.insert(a);
        collector.insert(b);
        collector.insert(c);
        ConcreteCommandPersonalized instance = new ConcreteCommandPersonalized(new ConcreteCommandPersonalized("super_somma","+ + +", l));
        instance.execute();
        assertEquals(collector.last(),ComplexNumber.create("-8+5j"));
    }

    /**
     * Test of undo method, of class ConcreteCommandPersonalized.
     */
    @Test
    public void testUndo() {
                System.out.println("execute correct concrete");
        MyOperandCollection collector = new MyOperandCollection(12);
        ComplexNumber a = new ComplexNumber("-4", "2");
        ComplexNumber b = new ComplexNumber("-7", "3");
        ComplexNumber c = new ComplexNumber("-8", "5");
        ComplexNumber d = new ComplexNumber("-11", "7");
        List<Command> l = new LinkedList();
        AddCommand sum1=new AddCommand(collector);
        AddCommand sum2=new AddCommand(collector);
        AddCommand sum3=new AddCommand(collector);
        l.add(sum1);
        l.add(sum2);
        l.add(sum3);
        collector.insert(a);
        collector.insert(b);
        collector.insert(c);
        collector.insert(d);
        ConcreteCommandPersonalized instance = new ConcreteCommandPersonalized("super_somma", "+ + +", l);
        instance.execute();
        
        instance.undo();
        assertEquals(collector.last(),ComplexNumber.create("-11+7j"));
    }
    
}
