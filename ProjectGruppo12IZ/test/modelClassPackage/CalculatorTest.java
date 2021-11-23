/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelClassPackage;

import java.math.BigDecimal;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gruppo 12 IZ
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
     * Test of addiction method, of class Calculator, having concordant operands both positive.
     */
    @Test
    public void testAddictionConcordantPositive() {
        System.out.println("addiction with concordant positive operands");
        ComplexNumber a = new ComplexNumber(new BigDecimal("7.2"),new BigDecimal("8.4"));
        ComplexNumber b = new ComplexNumber("5.68","10.85");
        ComplexNumber expResult = new ComplexNumber("12.88", "19.25");
        ComplexNumber result = Calculator.addiction(a, b);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of addiction method, of class Calculator, having concordant operands both negative.
     */
    @Test
    public void testAddictionConcordantNegative() {
        System.out.println("addiction with concordant negative operands");
        ComplexNumber a = new ComplexNumber("-11.30","-4.50");
        ComplexNumber b = new ComplexNumber("-4.86", "-15.79");
        ComplexNumber expResult = new ComplexNumber("-16.16", "-20.29");
        ComplexNumber result = Calculator.addiction(a, b);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of addiction method, of class Calculator, having discordant real part.
     */
    @Test
    public void testAddictionDiscordantReal() {
        System.out.println("addiction with discordant real part");
        ComplexNumber a = new ComplexNumber("-12.45","-14.55");
        ComplexNumber b = new ComplexNumber("9.58", "-1.98");
        ComplexNumber expResult = new ComplexNumber("-2.87", "-16.53");
        ComplexNumber result = Calculator.addiction(a, b);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of addiction method, of class Calculator, having discordant imaginary part.
     */
    @Test
    public void testAddictionDiscordantImag() {
        System.out.println("addiction with discordant imaginary part");
        ComplexNumber a = new ComplexNumber("2.47", "-14.55");
        ComplexNumber b = new ComplexNumber("8.53", "13.98");
        ComplexNumber expResult = new ComplexNumber("11", "-0.57");
        ComplexNumber result = Calculator.addiction(a, b);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of addiction method, of class Calculator, having only imaginary part.
     */
    @Test
    public void testAddictionNoReal() {
        System.out.println("addiction with real part equal to 0");
        ComplexNumber a = new ComplexNumber("0", "4.95");
        ComplexNumber b = new ComplexNumber("0", "5.05");
        ComplexNumber expResult = new ComplexNumber("0", "10");
        ComplexNumber result = Calculator.addiction(a, b);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of addiction method, of class Calculator, having only real part.
     */
    @Test
    public void testAddictionNoImag() {
        System.out.println("addiction with imaginary part equal to 0");
        ComplexNumber a = new ComplexNumber("-1.26", "0");
        ComplexNumber b = new ComplexNumber("3.5", "0");
        ComplexNumber expResult = new ComplexNumber("2.24", "0");
        ComplexNumber result = Calculator.addiction(a, b);
        assertEquals(expResult, result);
    }
    
        
    /**
     * Test of addiction method, of class Calculator, having one operand null.
     */
    @Test
    public void testAddictionNull() {
        System.out.println("addiction with one operand null");
        ComplexNumber b = new ComplexNumber("3.5", "0");
        ComplexNumber result = Calculator.addiction(null, b);
        assertEquals(null, result);
    }
    
        /**
     * Test of addiction method, of class Calculator, having both operands null.
     */
    @Test
    public void testAddictionBothNull() {
        System.out.println("addiction with both operands null");
        ComplexNumber result = Calculator.addiction(null, null);
        assertEquals(null, result);
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
    public void testInvertSignPosPos() {
        System.out.println("invertSign");
        ComplexNumber a = new ComplexNumber("3", "5");
        ComplexNumber result = Calculator.invertSign(a);
        assertEquals(new BigDecimal("0"), result.getReal().add(a.getReal()).add(result.getImaginary().add(a.getImaginary())));
    }
    
    /**
     * Test of invertSign method, of class Calculator.
     */
    @Test
    public void testInvertSignNegPos() {
        System.out.println("invertSign");
        ComplexNumber a = new ComplexNumber("-3", "5");
        ComplexNumber result = Calculator.invertSign(a);
        assertEquals(new BigDecimal("0"), result.getReal().add(a.getReal()).add(result.getImaginary().add(a.getImaginary())));
    }
    
    /**
     * Test of invertSign method, of class Calculator.
     */
    @Test
    public void testInvertSignPosNeg() {
        System.out.println("invertSign");
        ComplexNumber a = new ComplexNumber("3", "-5");
        ComplexNumber result = Calculator.invertSign(a);
        assertEquals(new BigDecimal("0"), result.getReal().add(a.getReal()).add(result.getImaginary().add(a.getImaginary())));
    }
    
    /**
     * Test of invertSign method, of class Calculator.
     */
    @Test
    public void testInvertSignNegNeg() {
        System.out.println("invertSign");
        ComplexNumber a = new ComplexNumber("-3", "-5");
        ComplexNumber result = Calculator.invertSign(a);
        assertEquals(new BigDecimal("0"), result.getReal().add(a.getReal()).add(result.getImaginary().add(a.getImaginary())));
    }
    
    @Test
    public void testInvertSignZero() {
        System.out.println("invertSign");
        ComplexNumber a = new ComplexNumber("0", "0");
        ComplexNumber result = Calculator.invertSign(a);
        assertEquals(new BigDecimal("0"), result.getReal().add(a.getReal()).add(result.getImaginary().add(a.getImaginary())));
    }
    
    @Test
    public void testInvertSignNull() {
        System.out.println("invertSign");
        ComplexNumber a = null;
        ComplexNumber result = Calculator.invertSign(a);
        assertEquals(a, result);
    }
    
}
