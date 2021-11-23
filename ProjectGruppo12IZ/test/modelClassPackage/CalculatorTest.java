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
     * Test of subtraction method, of class Calculator, having concordant minuend and subtrahend both positive.
     */
    @Test
    public void testSubtractionConcordantPositive() {
        System.out.println("subtraction with concordant positive minuend and subtrahend");
        ComplexNumber a = new ComplexNumber("3.4","2.43");
        ComplexNumber b = new ComplexNumber("10.1","6.1");
        ComplexNumber expResult = new ComplexNumber("-6.7","-3.67");
        ComplexNumber result = Calculator.subtraction(a, b);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of subtraction method, of class Calculator, having concordant minuend and subtrahend both negative.
     */
    @Test
    public void testSubtractionConcordantNegative() {
        System.out.println("subtraction with concordant negative minuend and subtrahend");
        ComplexNumber a = new ComplexNumber("-6.4","-7.63");
        ComplexNumber b = new ComplexNumber("-11.2","-8.1");
        ComplexNumber expResult = new ComplexNumber("4.8","0.47");
        ComplexNumber result = Calculator.subtraction(a, b);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of subtraction method, of class Calculator, having discordant real part.
     */
    @Test
    public void testSubtractionDiscordantReal() {
        System.out.println("subtraction with discordant real part");
        ComplexNumber a = new ComplexNumber("-1.45","-14.55");
        ComplexNumber b = new ComplexNumber("2.88", "-1.98");
        ComplexNumber expResult = new ComplexNumber("-4.33", "-12.57");
        ComplexNumber result = Calculator.subtraction(a, b);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of subtraction method, of class Calculator, having discordant imaginary part.
     */
    @Test
    public void testSubtractionDiscordantImag() {
        System.out.println("subtraction with discordant imaginary part");
        ComplexNumber a = new ComplexNumber("2.47", "-14.55");
        ComplexNumber b = new ComplexNumber("8.53", "13.98");
        ComplexNumber expResult = new ComplexNumber("-6.06", "-28.53");
        ComplexNumber result = Calculator.subtraction(a, b);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of subtraction method, of class Calculator, having only imaginary part.
     */
    @Test
    public void testSubtractionNoReal() {
        System.out.println("subtraction with real part equal to 0");
        ComplexNumber a = new ComplexNumber("0", "3.08");
        ComplexNumber b = new ComplexNumber("0", "1.11");
        ComplexNumber expResult = new ComplexNumber("0", "1.97");
        ComplexNumber result = Calculator.subtraction(a, b);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of subtraction method, of class Calculator, having only real part.
     */
    @Test
    public void testSubtractionNoImag() {
        System.out.println("subtraction with imaginary part equal to 0");
        ComplexNumber a = new ComplexNumber("23.2", "0");
        ComplexNumber b = new ComplexNumber("-7.6", "0");
        ComplexNumber expResult = new ComplexNumber("30.8", "0");
        ComplexNumber result = Calculator.subtraction(a, b);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of subtraction method, of class Calculator, having one operand null.
     */
    @Test
    public void testSubtractionNull() {
        System.out.println("subtraction with one operand null");
        ComplexNumber a = new ComplexNumber("1.2", "0");
        ComplexNumber result = Calculator.subtraction(a, null);
        assertEquals(null, result);
    }
    
    /**
     * Test of subtraction method, of class Calculator, having both operands null.
     */
    @Test
    public void testSubtractionBothNull() {
        System.out.println("subtraction with both operands null");
        ComplexNumber result = Calculator.addiction(null, null);
        assertEquals(null, result);
    }
    
    /**
     * Test of multiplication method, of class Calculator, having factors both positive.
     */
    @Test
    public void testMultiplicationConcordantPositive() {
        System.out.println("multiplication with both factors concordant positive");
        ComplexNumber a = new ComplexNumber("1.23","12.2");
        ComplexNumber b = new ComplexNumber("2.34","1.11");
        ComplexNumber expResult = new ComplexNumber("-10.6638","29.9133");
        ComplexNumber result = Calculator.multiplication(a, b);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of multiplication method, of class Calculator, having factors both negative.
     */
    @Test
    public void testMultiplicationConcordantNegative() {
        System.out.println("multiplication with both factors concordant negative");
        ComplexNumber a = new ComplexNumber("-2.4","-3.03");
        ComplexNumber b = new ComplexNumber("-1.2","-3.1");
        ComplexNumber expResult = new ComplexNumber("-6.513","11.076");
        ComplexNumber result = Calculator.multiplication(a, b);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of multiplication method, of class Calculator, having discordant real part.
     */
    @Test
    public void testMultiplicationDiscordantReal() {
        System.out.println("multiplication with discordant real part");
        ComplexNumber a = new ComplexNumber("-1.55","2.65");
        ComplexNumber b = new ComplexNumber("1.48", "3.98");
        ComplexNumber expResult = new ComplexNumber("-12.841", "-2.247");
        ComplexNumber result = Calculator.multiplication(a, b);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of multiplication method, of class Calculator, having discordant imaginary part.
     */
    @Test
    public void testMultiplicationDiscordantImag() {
        System.out.println("multiplication with discordant imaginary part");
        ComplexNumber a = new ComplexNumber("-6.67", "1.45");
        ComplexNumber b = new ComplexNumber("-8.83", "-3.89");
        ComplexNumber expResult = new ComplexNumber("64.5366", "13.1428");
        ComplexNumber result = Calculator.multiplication(a, b);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of multiplication method, of class Calculator, having only imaginary part.
     */
    @Test
    public void testMultiplicationNoReal() {
        System.out.println("multiplication with real part equal to 0");
        ComplexNumber a = new ComplexNumber("0", "-6.08");
        ComplexNumber b = new ComplexNumber("0", "-1.21");
        ComplexNumber expResult = new ComplexNumber("-7.3568", "0");
        ComplexNumber result = Calculator.multiplication(a, b);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of multiplication method, of class Calculator, having only real part.
     */
    @Test
    public void testMultiplicationNoImag() {
        System.out.println("multiplication with imaginary part equal to 0");
        ComplexNumber a = new ComplexNumber("13.02", "0");
        ComplexNumber b = new ComplexNumber("6", "0");
        ComplexNumber expResult = new ComplexNumber("78.12", "0");
        ComplexNumber result = Calculator.multiplication(a, b);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of multiplication method, of class Calculator, having one factor null.
     */
    @Test
    public void testMultiplicationNull() {
        System.out.println("multiplication with one operand null");
        ComplexNumber a = new ComplexNumber("1.2", "1");
        ComplexNumber result = Calculator.multiplication(a, null);
        assertEquals(null, result);
    }
    
    /**
     * Test of multiplication method, of class Calculator, having both factors null.
     */
    @Test
    public void testMultiplicationBothNull() {
        System.out.println("multiplication with both operands null");
        ComplexNumber result = Calculator.multiplication(null, null);
        assertEquals(null, result);
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
     /**
     * Test of Conjugate method, of class Calculator. positive imaginary to negative
     */
    @Test
    public void testConjugatedPos() {
        System.out.println("Conjugate positive imaginary to negative ");
        ComplexNumber a = new ComplexNumber("5", "+7");
        ComplexNumber b = new ComplexNumber("5", "-7");
        ComplexNumber result = Calculator.conjugated(b);
        assertEquals(a, result);
    }
     /**
     * Test of Conjugate method, of class Calculator. Negative imaginary to positive 
     */
    @Test
    public void testConjugatedNeg() {
        System.out.println("Conjugate negative imaginary to positive ");
        ComplexNumber a = new ComplexNumber("5", "-7");
        ComplexNumber b = new ComplexNumber("5", "7");
        ComplexNumber result = Calculator.conjugated(b);
        assertEquals(a, result);
    }
    
    
}
