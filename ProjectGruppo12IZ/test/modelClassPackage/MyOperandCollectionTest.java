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
     * Test of clear method, of class MyOperandCollection, with only one number in the operands stack.
     */
    @Test
    public void testClearWithOneNumber() {
        System.out.println("clear with one number");
        MyOperandCollection instance = new MyOperandCollection();
        instance.insert(new ComplexNumber("1","1"));
        boolean expresult = true;
        boolean result = instance.clear();
        assertEquals(expresult,result);
    }
    
    /**
     * Test of clear method, of class MyOperandCollection, with more than one elements in the operands stack.
     */
    @Test
    public void testClearWithMoreThanOneNumber() {
        System.out.println("clear with more than one number");
        MyOperandCollection instance = new MyOperandCollection();
        instance.insert(new ComplexNumber("1","1"));
        instance.insert(new ComplexNumber("1","1"));
        instance.insert(new ComplexNumber("1","1"));
        instance.insert(new ComplexNumber("1","1"));
        boolean expresult = true;
        boolean result = instance.clear();
        assertEquals(expresult,result);
    }
    
    /**
     * Test of clear method, of class MyOperandCollection, with zero elements in the operands stack.
     */
    @Test
    public void testClearWithZeroNumbers() {
        System.out.println("clear with zero numbers");
        MyOperandCollection instance = new MyOperandCollection();
        boolean expresult = false;
        boolean result = instance.clear();
        assertEquals(expresult,result);
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
