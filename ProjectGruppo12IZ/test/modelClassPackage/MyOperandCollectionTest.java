/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelClassPackage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nando
 */
public class MyOperandCollectionTest {
    
    public MyOperandCollectionTest() {
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
     * Test of clear method, of class MyOperandCollection.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        MyOperandCollection instance = new MyOperandCollection();
        instance.clear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of drop method, of class MyOperandCollection.
     */
    @Test
    public void testDrop() {
        System.out.println("drop");
        MyOperandCollection instance = new MyOperandCollection();
        instance.drop();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dup method, of class MyOperandCollection.
     */
    @Test
    public void testDup() {
        System.out.println("dup");
        MyOperandCollection instance = new MyOperandCollection();
        instance.dup();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of swap method, of class MyOperandCollection, having only one operand inserted so not enough.
     */
    @Test
    public void testSwapNotEnough() {
        System.out.println("swap without not enough element inserted");
        MyOperandCollection instance = new MyOperandCollection();
        instance.insert(new ComplexNumber("-2", "5"));
        boolean ret = instance.swap();
        assertEquals(ret, false);
    }
    
    /**
     * Test of swap method, of class MyOperandCollection, checking the lenght of the collection does not change.
     */
    @Test
    public void testSwapcontrolLength() {
        System.out.println("swap without not enough element inserted");
        MyOperandCollection instance = new MyOperandCollection();
        instance.insert(new ComplexNumber("-2", "5"));
        instance.insert(new ComplexNumber("2.78", "4.98"));
        instance.insert(new ComplexNumber("-17.56", "-4.99"));
        int numInserted = 3; 
        instance.swap();
        assertEquals(instance.collectionLength(), numInserted);
    }
    
    /**
     * Test of swap method, of class MyOperandCollection, checking the elements have been correctly swap.
     */
    @Test
    public void testSwapcontrolElem() {
        System.out.println("swap without not enough element inserted");
        MyOperandCollection instance = new MyOperandCollection();
        ComplexNumber first = new ComplexNumber("-4.6", "9");
        ComplexNumber secondLast = new ComplexNumber("7.55", "9.8");
        ComplexNumber last = new ComplexNumber("-8", "-5.67");
        instance.insert(first);
        instance.insert(secondLast);
        instance.insert(last);
        instance.swap();
        assertEquals(instance.remove(), secondLast);
        assertEquals(instance.remove(), last);
    }
    
    
    /**
     * Test of over method, of class MyOperandCollection.
     */
    @Test
    public void testOver() {
        System.out.println("over");
        MyOperandCollection instance = new MyOperandCollection();
        instance.over();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
