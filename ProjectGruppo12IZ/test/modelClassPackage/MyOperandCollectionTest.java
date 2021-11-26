/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelClassPackage;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author nando
 */
public class MyOperandCollectionTest {
    
    public MyOperandCollectionTest() {
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
        System.out.println("drop with Two number");
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
        System.out.println("drop with one number");
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
        System.out.println("drop with zero number");
        MyOperandCollection instance = new MyOperandCollection();
        boolean expResult = false;
        boolean result = instance.drop();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result);
    }

    /**
     * Test of drop method, of class MyOperandCollection.
     */
    @Test
    public void testDupWithTwoNumber() {
        System.out.println("dup with two number");
        MyOperandCollection instance = new MyOperandCollection();
        instance.insert(new ComplexNumber("178","881"));
        instance.insert(new ComplexNumber("2567","-561"));
        boolean expResult = true;
        boolean result = instance.dup();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result);
    }
     /**
     * Test of drop method, of class MyOperandCollection.
     */
    @Test
    public void testDupWithOneNumber() {
        System.out.println("dup with one number");
        MyOperandCollection instance = new MyOperandCollection();
        instance.insert(new ComplexNumber("-89","0"));
        boolean expResult = true;
        boolean result = instance.dup();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result);
    }
     /**
     * Test of drop method, of class MyOperandCollection.
     */
    @Test
    public void testDupWithZeroNumber() {
        System.out.println("dup with zero number");
        MyOperandCollection instance = new MyOperandCollection();
        boolean expResult = false;
        boolean result = instance.dup();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result);
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
     * Test of drop method, of class MyOperandCollection.
     */
    @Test
    public void testOverWithThreeNumber() {
        System.out.println("drop with Three number ");
        MyOperandCollection instance = new MyOperandCollection();
        instance.insert(new ComplexNumber("1","1"));
        instance.insert(new ComplexNumber("2","1"));
        instance.insert(new ComplexNumber("3","1"));
        System.out.println("after");
        boolean expResult = true;
        boolean result = instance.over();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result);
    }

    /**
     * Test of drop method, of class MyOperandCollection.
     */
    @Test
    public void testOverWithTwoNumber() {
        System.out.println("drop with Two number ");
        MyOperandCollection instance = new MyOperandCollection();
        instance.insert(new ComplexNumber("1","1"));
        instance.insert(new ComplexNumber("2","1"));
        boolean expResult = true;
        boolean result = instance.over();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result);
    }
     /**
     * Test of drop method, of class MyOperandCollection.
     */
    @Test
    public void testOverWithOneNumber() {
        System.out.println("drop with one number ");
        MyOperandCollection instance = new MyOperandCollection();
        instance.insert(new ComplexNumber("1","1"));
        boolean expResult = false;
        boolean result = instance.over();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result);
    }
     /**
     * Test of drop method, of class MyOperandCollection.
     */
    @Test
    public void testOverWithZeroNumber() {
        System.out.println("drop with zero number ");
        MyOperandCollection instance = new MyOperandCollection();
        boolean expResult = false;
        boolean result = instance.over();
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(expResult, result);
    }    
}
