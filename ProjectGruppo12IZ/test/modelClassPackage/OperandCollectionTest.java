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
    
}
