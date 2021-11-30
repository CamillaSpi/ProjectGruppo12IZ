/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelClassPackage;

import java.util.Map;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mattia
 */
public class VariablesTest {
    
    public VariablesTest() {
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
     * Test of getMyVariables method, of class Variables.
     */
    @Test
    public void testGetMyVariables() {
        System.out.println("getMyVariables");
        Variables instance = new Variables();
        Map<String, ComplexNumber> expResult = null;
        Map<String, ComplexNumber> result = instance.getMyVariables();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
  
    /**
     * Test of insert method, of class OperandCollection.
     */
    @Test
    public void testSaveToVariablesCorrectNumber() {
        System.out.println("insert a complex Number correctly created");
        ComplexNumber a = new ComplexNumber("1000", "1000");
        Variables instance = new Variables();
        instance.saveToVariables('a', a);
        System.out.println(instance.toString());
        assertEquals(a, instance.getMyVariables().get("a"));
    }
    
    /**
     * Test of insert method, of class OperandCollection.
     */
    @Test
    public void testSaveToVariablesNullNumber() {
        System.out.println("insert a complex Number equal to null");
        ComplexNumber a = null;
        Variables instance = new Variables();
        instance.saveToVariables('a', a);
        assertEquals(null, instance.getMyVariables().get("a"));
    }
    
    /**
     * Test of insert method, of class OperandCollection.
     */
    
    @Test
    public void testSaveToVariablesWrongKey() {
        System.out.println("insert a complex Number correctly created");
        ComplexNumber a = new ComplexNumber("1000", "1000");
        Variables instance = new Variables();
        instance.saveToVariables('8', a);
        assertEquals(null, instance.getMyVariables().get("8"));
    }
    

    /**
     * Test of toString method, of class Variables.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Variables instance = new Variables();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
