/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelClassPackage;

import java.math.BigDecimal;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gruppo 12 IZ
 */
public class CalculatorTest {

    public CalculatorTest() {
    }

    /**
     * Test of addiction method, of class Calculator, having concordant operands
     * both positive.
     */
    @Test
    public void testAddictionConcordantPositive() {
        System.out.println("addiction with concordant positive operands");
        ComplexNumber a = new ComplexNumber(new BigDecimal("7.2"), new BigDecimal("8.4"));
        ComplexNumber b = new ComplexNumber("5.68", "10.85");
        ComplexNumber expResult = new ComplexNumber("12.88", "19.25");
        ComplexNumber result = Calculator.addiction(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of addiction method, of class Calculator, having concordant operands
     * both negative.
     */
    @Test
    public void testAddictionConcordantNegative() {
        System.out.println("addiction with concordant negative operands");
        ComplexNumber a = new ComplexNumber("-11.30", "-4.50");
        ComplexNumber b = new ComplexNumber("-4.86", "-15.79");
        ComplexNumber expResult = new ComplexNumber("-16.16", "-20.29");
        ComplexNumber result = Calculator.addiction(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of addiction method, of class Calculator, having discordant real
     * part.
     */
    @Test
    public void testAddictionDiscordantReal() {
        System.out.println("addiction with discordant real part");
        ComplexNumber a = new ComplexNumber("-12.45", "-14.55");
        ComplexNumber b = new ComplexNumber("9.58", "-1.98");
        ComplexNumber expResult = new ComplexNumber("-2.87", "-16.53");
        ComplexNumber result = Calculator.addiction(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of addiction method, of class Calculator, having discordant
     * imaginary part.
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
     * Test of addiction method, of class Calculator, having one operand with
     * only imaginary part.
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
     * Test of addiction method, of class Calculator, having one operand with
     * only real part.
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
        ComplexNumber b = new ComplexNumber("3.5", "-4.2");
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
     * Test of subtraction method, of class Calculator, having concordant
     * minuend and subtrahend both positive.
     */
    @Test
    public void testSubtractionConcordantPositive() {
        System.out.println("subtraction with concordant positive minuend and subtrahend");
        ComplexNumber a = new ComplexNumber("3.4", "2.43");
        ComplexNumber b = new ComplexNumber("10.1", "6.1");
        ComplexNumber expResult = new ComplexNumber("-6.7", "-3.67");
        ComplexNumber result = Calculator.subtraction(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of subtraction method, of class Calculator, having concordant
     * minuend and subtrahend both negative.
     */
    @Test
    public void testSubtractionConcordantNegative() {
        System.out.println("subtraction with concordant negative minuend and subtrahend");
        ComplexNumber a = new ComplexNumber("-6.4", "-7.63");
        ComplexNumber b = new ComplexNumber("-11.2", "-8.1");
        ComplexNumber expResult = new ComplexNumber("4.8", "0.47");
        ComplexNumber result = Calculator.subtraction(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of subtraction method, of class Calculator, having discordant real
     * part.
     */
    @Test
    public void testSubtractionDiscordantReal() {
        System.out.println("subtraction with discordant real part");
        ComplexNumber a = new ComplexNumber("-1.45", "-14.55");
        ComplexNumber b = new ComplexNumber("2.88", "-1.98");
        ComplexNumber expResult = new ComplexNumber("-4.33", "-12.57");
        ComplexNumber result = Calculator.subtraction(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of subtraction method, of class Calculator, having discordant
     * imaginary part.
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
     * Test of subtraction method, of class Calculator, having only imaginary
     * part.
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
     * Test of subtraction method, of class Calculator, having both operands
     * null.
     */
    @Test
    public void testSubtractionBothNull() {
        System.out.println("subtraction with both operands null");
        ComplexNumber result = Calculator.addiction(null, null);
        assertEquals(null, result);
    }

    /**
     * Test of multiplication method, of class Calculator, having factors both
     * positive.
     */
    @Test
    public void testMultiplicationConcordantPositive() {
        System.out.println("multiplication with both factors concordant positive");
        ComplexNumber a = new ComplexNumber("1.23", "12.2");
        ComplexNumber b = new ComplexNumber("2.34", "1.11");
        ComplexNumber expResult = new ComplexNumber("-10.6638", "29.9133");
        ComplexNumber result = Calculator.multiplication(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of multiplication method, of class Calculator, having factors both
     * negative.
     */
    @Test
    public void testMultiplicationConcordantNegative() {
        System.out.println("multiplication with both factors concordant negative");
        ComplexNumber a = new ComplexNumber("-2.4", "-3.03");
        ComplexNumber b = new ComplexNumber("-1.2", "-3.1");
        ComplexNumber expResult = new ComplexNumber("-6.513", "11.076");
        ComplexNumber result = Calculator.multiplication(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of multiplication method, of class Calculator, having discordant
     * real part.
     */
    @Test
    public void testMultiplicationDiscordantReal() {
        System.out.println("multiplication with discordant real part");
        ComplexNumber a = new ComplexNumber("-1.55", "2.65");
        ComplexNumber b = new ComplexNumber("1.48", "3.98");
        ComplexNumber expResult = new ComplexNumber("-12.841", "-2.247");
        ComplexNumber result = Calculator.multiplication(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of multiplication method, of class Calculator, having discordant
     * imaginary part.
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
     * Test of multiplication method, of class Calculator, having only imaginary
     * part.
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
     * Test of multiplication method, of class Calculator, having only real
     * part.
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
     * Test of multiplication method, of class Calculator, having one factor
     * null.
     */
    @Test
    public void testMultiplicationNull() {
        System.out.println("multiplication with one operand null");
        ComplexNumber a = new ComplexNumber("1.2", "1");
        ComplexNumber result = Calculator.multiplication(a, null);
        assertEquals(null, result);
    }

    /**
     * Test of multiplication method, of class Calculator, having both factors
     * null.
     */
    @Test
    public void testMultiplicationBothNull() {
        System.out.println("multiplication with both operands null");
        ComplexNumber result = Calculator.multiplication(null, null);
        assertEquals(null, result);
    }

    /**
     * Test of division method, of class Calculator, having concordant operands
     * both positive.
     */
    @Test
    public void testDivisionConcordantPositive() {
        System.out.println("division with concordant positive operands");
        ComplexNumber a = new ComplexNumber("8.2", "7.8");
        ComplexNumber b = new ComplexNumber("6.47", "8.1167");
        ComplexNumber expResult = new ComplexNumber("1.080029734", "-0.1493473481");
        ComplexNumber result = Calculator.division(a, b);

        assertEquals(expResult, result);
    }

    /**
     * Test of division method, of class Calculator, having concordant operands
     * both negative.
     */
    @Test
    public void testDivisionConcordantNegative() {
        System.out.println("division with concordant negative operands");
        ComplexNumber a = new ComplexNumber("-9.30", "-4.50");
        ComplexNumber b = new ComplexNumber("-6.5", "-18.9");
        ComplexNumber expResult = new ComplexNumber("0.3642417263", "-0.3667951735");
        ComplexNumber result = Calculator.division(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of division method, of class Calculator, having discordant real
     * part.
     */
    @Test
    public void testDivisionDiscordantReal() {
        System.out.println("division with discordant real part");
        ComplexNumber a = new ComplexNumber("-12.45", "-4.15");
        ComplexNumber b = new ComplexNumber("6.76", "-11.7");
        ComplexNumber expResult = new ComplexNumber("-0.1950132430", "-0.9514282459");
        ComplexNumber result = Calculator.division(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of division method, of class Calculator, having discordant imaginary
     * part.
     */
    @Test
    public void testDivisionDiscordantImag() {
        System.out.println("division with discordant imaginary part");
        ComplexNumber a = new ComplexNumber("2.76", "-8.95");
        ComplexNumber b = new ComplexNumber("8.47", "1.98");
        ComplexNumber expResult = new ComplexNumber("0.07475684399", "-1.074146228");
        ComplexNumber result = Calculator.division(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of division method, of class Calculator, with imaginary operands.
     */
    @Test
    public void testDivisionNoReal() {
        System.out.println("division with imaginary operands");
        ComplexNumber a = new ComplexNumber("0", "4.95");
        ComplexNumber b = new ComplexNumber("0", "15.85");
        ComplexNumber expResult = new ComplexNumber("0.3123028391", "0");
        ComplexNumber result = Calculator.division(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of addiction method, of class Calculator, with real operands.
     */
    @Test
    public void testDivisionNoImag() {
        System.out.println("division with imaginary real operands");
        ComplexNumber a = new ComplexNumber("-1.65", "0");
        ComplexNumber b = new ComplexNumber("5.53", "0");
        ComplexNumber expResult = new ComplexNumber("-0.2983725136", "0");
        ComplexNumber result = Calculator.division(a, b);
        assertEquals(expResult, result);
    }

    /**
     * Test of division method, of class Calculator, having divisor equal to
     * zero.
     */
    @Test
    public void testDivisionNoDivisor() {
        System.out.println("division with the divisor equal to zero");
        ComplexNumber a = new ComplexNumber("4.5", "-3.2");
        ComplexNumber b = new ComplexNumber("0", "0");
        ComplexNumber result = Calculator.division(a, b);
        assertEquals(null, result);
    }

    /**
     * Test of division method, of class Calculator, having one operand null.
     */
    @Test
    public void testDivisionNull() {
        System.out.println("division with one operand null");
        ComplexNumber b = new ComplexNumber("4.5", "-3.2");
        ComplexNumber result = Calculator.division(null, b);
        assertEquals(null, result);
    }

    /**
     * Test of division method, of class Calculator, having both operands null.
     */
    @Test
    public void testDivisionBothNull() {
        System.out.println("division with both operands null");
        ComplexNumber result = Calculator.division(null, null);
        assertEquals(null, result);
    }

    /**
     * Test of squareRoot method, of class Calculator.
     */
    @Test
    public void testSquareRootPosPos() {
        System.out.println("squareRoot positive positive");
        ComplexNumber a = new ComplexNumber("2.8", "12.9");
        ComplexNumber expResult = new ComplexNumber("-2.828460605", "-2.280392377");
        ComplexNumber result = Calculator.squareRoot(a);
        assertEquals(expResult, result);
    }

    /**
     * Test of squareRoot method, of class Calculator.
     */
    @Test
    public void testSquareRootPosNeg() {
        System.out.println("squareRoot positive negative");
        ComplexNumber a = new ComplexNumber("154.8", "-1.9");
        ComplexNumber expResult = new ComplexNumber("-12.44209909", "0.07635367576");
        ComplexNumber result = Calculator.squareRoot(a);
        assertEquals(expResult, result);
    }

    /**
     * Test of squareRoot method, of class Calculator.
     */
    @Test
    public void testSquareRootNegNeg() {
        System.out.println("squareRoot negative negative");
        ComplexNumber a = new ComplexNumber("-47.8", "-25.9");
        ComplexNumber expResult = new ComplexNumber("1.811889903", "7.147233382");
        ComplexNumber result = Calculator.squareRoot(a);
        assertEquals(expResult, result);
    }

    /**
     * Test of squareRoot method, of class Calculator.
     */
    @Test
    public void testSquareRootNegPos() {
        System.out.println("squareRoot negative positive");
        ComplexNumber a = new ComplexNumber("-154.8", "1.9");
        ComplexNumber expResult = new ComplexNumber("-0.07635367576", "12.44209909");
        ComplexNumber result = Calculator.squareRoot(a);
        assertEquals(expResult, result);
    }

    /**
     * Test of squareRoot method, of class Calculator.
     */
    @Test
    public void testSquareRootPosZero() {
        System.out.println("squareRoot negative positive");
        ComplexNumber a = new ComplexNumber("+118.8", "0");
        ComplexNumber expResult = new ComplexNumber("10.89954127", "0");
        ComplexNumber result = Calculator.squareRoot(a);
        assertEquals(expResult, result);
    }

    /**
     * Test of squareRoot method, of class Calculator.
     */
    @Test
    public void testSquareRootNegZero() {
        System.out.println("squareRoot negative positive");
        ComplexNumber a = new ComplexNumber("-69.8", "0");
        ComplexNumber expResult = new ComplexNumber("0", "8.354639430");
        ComplexNumber result = Calculator.squareRoot(a);
        assertEquals(expResult, result);
    }

    /**
     * Test of squareRoot method, of class Calculator.
     */
    @Test
    public void testSquareRootZeroPos() {
        System.out.println("squareRoot negative positive");
        ComplexNumber a = new ComplexNumber("0", "77.785");
        ComplexNumber expResult = new ComplexNumber("-6.236385171", "-6.236385171");
        ComplexNumber result = Calculator.squareRoot(a);
        assertEquals(expResult, result);
    }

    /**
     * Test of squareRoot method, of class Calculator.
     */
    @Test
    public void testSquareRootZeroNeg() {
        System.out.println("squareRoot negative positive");
        ComplexNumber a = new ComplexNumber("0", "-124.24");
        ComplexNumber expResult = new ComplexNumber("-7.881624198", "7.881624198");
        ComplexNumber result = Calculator.squareRoot(a);
        assertEquals(expResult, result);
    }

    /**
     * Test of squareRoot method, of class Calculator.
     */
    @Test
    public void testSquareRootZeroZero() {
        System.out.println("squareRoot negative positive");
        ComplexNumber a = new ComplexNumber("0", "0");
        ComplexNumber expResult = new ComplexNumber("0", "0");
        ComplexNumber result = Calculator.squareRoot(a);
        assertEquals(expResult, result);
    }

    /**
     * Test of squareRoot method, of class Calculator.
     */
    @Test
    public void testSquareRootNull() {
        System.out.println("squareRoot null");
        ComplexNumber result = Calculator.squareRoot(null);
        assertEquals(null, result);
    }

    /**
     * Test of invertSign method, of class Calculator.
     */
    @Test
    public void testInvertSignPosPos() {
        System.out.println("invertSign positive positive");
        ComplexNumber a = new ComplexNumber("3", "5");
        ComplexNumber result = Calculator.invertSign(a);
        assertEquals(new BigDecimal("0"), result.getReal().add(a.getReal()).add(result.getImaginary().add(a.getImaginary())));
    }

    /**
     * Test of invertSign method, of class Calculator.
     */
    @Test
    public void testInvertSignNegPos() {
        System.out.println("invertSign negative positive");
        ComplexNumber a = new ComplexNumber("-3", "5");
        ComplexNumber result = Calculator.invertSign(a);
        assertEquals(new BigDecimal("0"), result.getReal().add(a.getReal()).add(result.getImaginary().add(a.getImaginary())));
    }

    /**
     * Test of invertSign method, of class Calculator.
     */
    @Test
    public void testInvertSignPosNeg() {
        System.out.println("invertSign positive negative");
        ComplexNumber a = new ComplexNumber("3", "-5");
        ComplexNumber result = Calculator.invertSign(a);
        assertEquals(new BigDecimal("0"), result.getReal().add(a.getReal()).add(result.getImaginary().add(a.getImaginary())));
    }

    /**
     * Test of invertSign method, of class Calculator.
     */
    @Test
    public void testInvertSignNegNeg() {
        System.out.println("invertSign negative negative");
        ComplexNumber a = new ComplexNumber("-3", "-5");
        ComplexNumber result = Calculator.invertSign(a);
        assertEquals(new BigDecimal("0"), result.getReal().add(a.getReal()).add(result.getImaginary().add(a.getImaginary())));
    }

    @Test
    public void testInvertSignZero() {
        System.out.println("invertSign zero");
        ComplexNumber a = new ComplexNumber("0", "0");
        ComplexNumber result = Calculator.invertSign(a);
        assertEquals(new BigDecimal("0"), result.getReal().add(a.getReal()).add(result.getImaginary().add(a.getImaginary())));
    }

    @Test
    public void testInvertSignNull() {
        System.out.println("invertSign null");
        ComplexNumber a = null;
        ComplexNumber result = Calculator.invertSign(a);
        assertEquals(a, result);
    }

    /**
     * Test of Conjugate method, of class Calculator. positive imaginary to
     * negative
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
     * Test of Conjugate method, of class Calculator. Negative imaginary to
     * positive
     */
    @Test
    public void testConjugatedNeg() {
        System.out.println("Conjugate negative imaginary to positive ");
        ComplexNumber a = new ComplexNumber("5", "-7");
        ComplexNumber b = new ComplexNumber("5", "7");
        ComplexNumber result = Calculator.conjugated(b);
        assertEquals(a, result);
    }
    /**
     * Test of Conjugate method, of class Calculator. Negative imaginary to
     * positive
     */
    @Test
    public void testConjugatedNull() {
        System.out.println("Conjugate null ");
        ComplexNumber result = Calculator.conjugated(null);
        assertEquals(null, result);
    }

    /**
     * Test of mod method, of class Calculator, with positive real and imaginary parts.
     */
    @Test
    public void testModPositiveParts() {
        System.out.println("mod with positive real and imaginary parts");
        ComplexNumber num = new ComplexNumber("3","1");
        ComplexNumber expResult = new ComplexNumber("3.162277660","0");
        ComplexNumber result = Calculator.mod(num);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of mod method, of class Calculator, with negative real and imaginary parts.
     */
    @Test
    public void testModNegativeParts() {
        System.out.println("mod with negative real and imaginary parts");
        ComplexNumber num = new ComplexNumber("-2","-1");
        ComplexNumber expResult = new ComplexNumber("2.236067977","0");
        ComplexNumber result = Calculator.mod(num);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of mod method, of class Calculator, with zero real and imaginary parts.
     */
    @Test
    public void testModZeroParts() {
        System.out.println("mod with zero real and imaginary parts");
        ComplexNumber num = new ComplexNumber("0","0");
        ComplexNumber expResult = new ComplexNumber("0","0");
        ComplexNumber result = Calculator.mod(num);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of mod method, of class Calculator, with null.
     */
    @Test
    public void testModNull() {
        System.out.println("mod with null");
        ComplexNumber result = Calculator.mod(null);
        assertEquals(null, result);
    }

    /**
     * Test of arg method, of class Calculator, with real part 0 and imaginary part positive.
     */
    @Test
    public void testArgZeroPos() {
        System.out.println("arg zero positive");
        ComplexNumber a = new ComplexNumber("0", "2");
        ComplexNumber expResult = new ComplexNumber("1.570796327", "0");
        ComplexNumber result = Calculator.arg(a);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of arg method, of class Calculator, with real part 0 and imaginary part negative.
     */
    @Test
    public void testArgZeroNeg() {
        System.out.println("arg zero negative");
        ComplexNumber a = new ComplexNumber("0", "-2");
        ComplexNumber expResult = new ComplexNumber("-1.570796327", "0");
        ComplexNumber result = Calculator.arg(a);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of arg method, of class Calculator, with real and imaginary part 0.
     */
    @Test
    public void testArgZeroZero() {
        System.out.println("arg zero zero");
        ComplexNumber a = new ComplexNumber("0", "0");
        ComplexNumber expResult = null;
        ComplexNumber result = Calculator.arg(a);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of arg method, of class Calculator, with real and imaginary part positive.
     */
    @Test
    public void testArgPosPos() {
        System.out.println("arg positive positive");
        ComplexNumber a = new ComplexNumber("2", "5");
        ComplexNumber expResult = new ComplexNumber("1.190289950", "0");
        ComplexNumber result = Calculator.arg(a);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of arg method, of class Calculator, with real part positive and imaginary part negative.
     */
    @Test
    public void testArgPosNeg() {
        System.out.println("arg positive negative");
        ComplexNumber a = new ComplexNumber("2", "-5");
        ComplexNumber expResult = new ComplexNumber("-1.190289950", "0");
        ComplexNumber result = Calculator.arg(a);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of arg method, of class Calculator, with real part negative and imaginary part positive.
     */
    @Test
    public void testArgNegPos() {
        System.out.println("arg neg positive");
        ComplexNumber a = new ComplexNumber("-2", "5");
        ComplexNumber expResult = new ComplexNumber("1.951302704", "0");
        ComplexNumber result = Calculator.arg(a);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of arg method, of class Calculator, with real part negative and imaginary part negative.
     */
    @Test
    public void testArgNegNeg() {
        System.out.println("arg neg neg");
        ComplexNumber a = new ComplexNumber("-2", "-5");
        ComplexNumber expResult = new ComplexNumber("-1.951302704", "0");
        ComplexNumber result = Calculator.arg(a);
        assertEquals(expResult, result);
    }
}
