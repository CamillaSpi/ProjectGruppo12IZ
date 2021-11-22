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
public class CalculatorTest {
    
    public CalculatorTest() {
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
     * Test of addiction method, of class Calculator.
     */
    @Test
    public void testAddiction() {
        System.out.println("addiction");
        ComplexNumber a = null;
        ComplexNumber b = null;
        ComplexNumber expResult = null;
        ComplexNumber result = Calculator.addiction(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of subtraction method, of class Calculator.
     */
    @Test
    public void testSubtraction() {
        System.out.println("subtraction");
        ComplexNumber a = null;
        ComplexNumber b = null;
        ComplexNumber expResult = null;
        ComplexNumber result = Calculator.subtraction(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of multiplication method, of class Calculator.
     */
    @Test
    public void testMultiplication() {
        System.out.println("multiplication");
        ComplexNumber a = null;
        ComplexNumber b = null;
        ComplexNumber expResult = null;
        ComplexNumber result = Calculator.multiplication(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of division method, of class Calculator.
     */
    @Test
    public void testDivision() {
        System.out.println("division");
        ComplexNumber a = null;
        ComplexNumber b = null;
        ComplexNumber expResult = null;
        ComplexNumber result = Calculator.division(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of squareRoot method, of class Calculator.
     */
    @Test
    public void testSquareRoot() {
        System.out.println("squareRoot");
        ComplexNumber a = null;
        ComplexNumber expResult = null;
        ComplexNumber result = Calculator.squareRoot(a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of invertSign method, of class Calculator.
     */
    @Test
    public void testInvertSign() {
        System.out.println("invertSign");
        ComplexNumber a = null;
        ComplexNumber expResult = null;
        ComplexNumber result = Calculator.invertSign(a);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
