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
public class OperandCollectionTest {
    
    public OperandCollectionTest() {
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
     * Test of insert method, of class OperandCollection.
     */
    @Test
    public void testInsertCorrectNumber() {
        System.out.println("insert a complex Number correctly created");
        ComplexNumber a = new ComplexNumber("1000", "1000");
        OperandCollection instance = new OperandCollection();
        instance.insert(a);
        assertEquals(1, instance.collectionLength());
    }
    
    /**
     * Test of insert method, of class OperandCollection.
     */
    
    @Test
    public void testInsertNullNumber() {
        System.out.println("insert a complex Number equal to null");
        ComplexNumber a = null;
        OperandCollection instance = new OperandCollection();
        instance.insert(a);
        assertEquals(0, instance.collectionLength());
    }

    /**
     * Test of remove method, of class OperandCollection.
     */
    @Test
    public void testRemoveNotEmptyCollection() {
        System.out.println("remove a complex Number from a not empty collection");
        OperandCollection instance = new OperandCollection();
        instance.insert(new ComplexNumber("5", "5"));
        ComplexNumber result = instance.remove();
        assertNotNull(result);
    }
    
    /**
     * Test of remove method, of class OperandCollection.
     */
    @Test
    public void testRemoveEmptyCollection() {
        System.out.println("remove a complex Number from an empty collection");
        OperandCollection instance = new OperandCollection();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.remove();
        assertEquals(expResult, result);
    }

    
    /**
     * Test of remove method, of class OperandCollection.
     */
    @Test
    public void testLastNotEmptyCollection() {
        System.out.println("return last complex Number from a not empty collection");
        OperandCollection instance = new OperandCollection();
        instance.insert(new ComplexNumber("5", "-5"));
        ComplexNumber result = instance.last();
        assertNotNull(result);
    }
    
    /**
     * Test of remove method, of class OperandCollection.
     */
    @Test
    public void testLastEmptyCollection() {
        System.out.println("return last complex Number from an empty collection");
        OperandCollection instance = new OperandCollection();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.last();
        assertEquals(expResult, result);
    }

    /**
     * Test of collectionLength method, of class OperandCollection.
     */
    @Test
    public void testCollectionLength() {
        System.out.println("return the lenght of the collection");
        OperandCollection instance = new OperandCollection();
        int expResult = instance.size();
        int result = instance.collectionLength();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCollection() {
        System.out.println("return the lenght of the collection");
        OperandCollection instance = new OperandCollection();
        instance.insert(new ComplexNumber("5", "5"));
        instance.insert(new ComplexNumber("7", "5"));
        instance.insert(new ComplexNumber("-3", "5"));
        ComplexNumber expResult = new ComplexNumber("-3", "5");
        ComplexNumber result = instance.remove();
        System.out.println(result);
        assertEquals(expResult, result);
    }

    /**
     * Test of insert method, of class OperandCollection.
     */
    @Test
    public void testInsert() {
        System.out.println("insert");
        ComplexNumber a = null;
        OperandCollection instance = new OperandCollection();
        instance.insert(a);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class OperandCollection.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        OperandCollection instance = new OperandCollection();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.remove();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of last method, of class OperandCollection.
     */
    @Test
    public void testLast() {
        System.out.println("last");
        OperandCollection instance = new OperandCollection();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.last();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of stamp method, of class OperandCollection.
     */
    @Test
    public void testStamp() {
        System.out.println("stamp");
        OperandCollection instance = new OperandCollection();
        instance.insert(new ComplexNumber("5", "5"));
        instance.insert(new ComplexNumber("7", "5"));
        instance.insert(new ComplexNumber("-3", "5"));
        instance.insert(new ComplexNumber("345", "5"));
        instance.insert(new ComplexNumber("745", "565"));
        instance.insert(new ComplexNumber("-398", "775"));
        instance.stamp();
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println(instance.last());
        System.out.println(instance.remove());
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        instance.stamp();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
