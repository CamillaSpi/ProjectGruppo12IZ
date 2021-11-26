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
    public void testDropWithTwoNumber() {
        System.out.println("drop");
        MyOperandCollection instance = new MyOperandCollection();
        instance.insert(new ComplexNumber("1","1"));
        instance.insert(new ComplexNumber("2","1"));
        boolean expResult = true;
        boolean result = instance.drop();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result);
    }
     /**
     * Test of drop method, of class MyOperandCollection.
     */
    @Test
    public void testDropWithOneNumber() {
        System.out.println("drop");
        MyOperandCollection instance = new MyOperandCollection();
        instance.insert(new ComplexNumber("1","1"));
        boolean expResult = true;
        boolean result = instance.drop();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result);
    }
     /**
     * Test of drop method, of class MyOperandCollection.
     */
    @Test
    public void testDropWithZeroNumber() {
        System.out.println("drop");
        MyOperandCollection instance = new MyOperandCollection();
        boolean expResult = false;
        boolean result = instance.drop();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result);
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
     * Test of swap method, of class MyOperandCollection.
     */
    @Test
    public void testSwap() {
        System.out.println("swap");
        MyOperandCollection instance = new MyOperandCollection();
        instance.swap();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
