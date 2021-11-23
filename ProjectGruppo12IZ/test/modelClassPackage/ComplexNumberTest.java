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
 * @author nando
 */
public class ComplexNumberTest {

     @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }


   @BeforeClass
    public static void setUpClass() throws Exception {
    }

    /**
     * Test of create method, of class ComplexNumber.
     */
    @Test
    public void testCreate() {
        System.out.println("create in Cartesian Notation (+x+j)");
        String complexNumber = "+5+7j";
        ComplexNumber expResult = new ComplexNumber("5", "7");
        ComplexNumber result = ComplexNumber.create(complexNumber);
        assertEquals(expResult, result);
    }

   

    /**
     * Test of create method with Cartesian Notation +x-j
     */
    @Test
    public void testCreateCartPlusMinus() {
        System.out.println("Cartesian Notation (+x-j)");
        String complexNumber = "+5-7j";
        ComplexNumber expResult = new ComplexNumber("5", "-7");
        ComplexNumber result = ComplexNumber.create(complexNumber);
        assertEquals(expResult, result);
    }

    /**
     * Test of create method with Cartesian Notation -x-j
     */
    @Test
    public void testCreateCartMinusMinus() {
        System.out.println("Cartesian Notation (-x-j)");
        String complexNumber = "-5-7j";
        ComplexNumber expResult = new ComplexNumber("-5", "-7");
        ComplexNumber result = ComplexNumber.create(complexNumber);
        assertEquals(expResult, result);
    }

    /**
     * Test of create method with Cartesian Notation -x+j
     */
    @Test
    public void testCreateCartMinusPlus() {
        System.out.println("Cartesian Notation (-x+j)");
        String complexNumber = "-5+7j";
        ComplexNumber expResult = new ComplexNumber("-5", "+7");
        ComplexNumber result = ComplexNumber.create(complexNumber);
        assertEquals(expResult, result);
    }

    /**
     * Test of create method with Cartesian Notation -x
     */
    @Test
    public void testCreateCartMinusZero() {
        System.out.println("Cartesian Notation (-x)");
        String complexNumber = "-5";
        ComplexNumber expResult = new ComplexNumber("-5", "0");
        ComplexNumber result = ComplexNumber.create(complexNumber);
        assertEquals(expResult, result);
    }

    /**
     * Test of create method with Cartesian Notation +x
     */
    @Test
    public void testCreateCartPlusZero() {
        System.out.println("Cartesian Notation (+x)");
        String complexNumber = "+5";
        ComplexNumber expResult = new ComplexNumber("5", "0");
        ComplexNumber result = ComplexNumber.create(complexNumber);
        assertEquals(expResult, result);
    }

    /**
     * Test of create method with Cartesian Notation +j
     */
    @Test
    public void testCreateCartZeroPlus() {
        System.out.println("Cartesian Notation (+j)");
        String complexNumber = "+7j";
        ComplexNumber expResult = new ComplexNumber("0", "7");
        ComplexNumber result = ComplexNumber.create(complexNumber);
        assertEquals(expResult, result);
    }

    /**
     * Test of create method with Cartesian Notation -j
     */
    @Test
    public void testCreateCartZeroMinus() {
        System.out.println("Cartesian Notation (-j)");
        String complexNumber = "-7j";
        ComplexNumber expResult = new ComplexNumber("0", "-7");
        ComplexNumber result = ComplexNumber.create(complexNumber);
        assertEquals(expResult, result);
    }

    /**
     * Test of create method with Cartesian Notation j
     */
    @Test
    public void testCreateCartZeroNone() {
        System.out.println("Cartesian Notation (j)");
        String complexNumber = "7j";
        ComplexNumber expResult = new ComplexNumber("0", "7");
        ComplexNumber result = ComplexNumber.create(complexNumber);
        assertEquals(expResult, result);
    }

    /**
     * Test of create method with Cartesian Notation x
     */
    @Test
    public void testCreateCartNoneZero() {
        System.out.println("Cartesian Notation (x)");
        String complexNumber = "5";
        ComplexNumber expResult = new ComplexNumber("5", "0");
        ComplexNumber result = ComplexNumber.create(complexNumber);
        assertEquals(expResult, result);
    }
    /**
     * Test of create method with Cartesian Notation x
     */
    @Test
    public void testCreateNotInCart() {
        System.out.println("Cartesian Notation (j+7)");
        String complexNumber = "5j+7";
        ComplexNumber expResult = null;
        ComplexNumber result = ComplexNumber.create(complexNumber);
        assertEquals(expResult, result);
    }
     /**
     * Test of create method with Cartesian Notation x
     */
    @Test
    public void testCreateNotANumber() {
        System.out.println("Not a number ");
        String complexNumber = "test";
        ComplexNumber expResult = null;
        ComplexNumber result = ComplexNumber.create(complexNumber);
        assertEquals(expResult, result);
    }
    /**
     * Test of create method with Cartesian Notation x
     */
    @Test
    public void testCreateNotWithJ() {
        System.out.println("Not with j ");
        String complexNumber = "5+7i";
        ComplexNumber expResult = null;
        ComplexNumber result = ComplexNumber.create(complexNumber);
        assertEquals(expResult, result);
    }

    /**
     * Test of getReal method, of class ComplexNumber.
     */
    @Test
    public void testGetReal() {
        System.out.println("getReal");
        ComplexNumber instance = new ComplexNumber("7","8");
        BigDecimal expResult = new BigDecimal("7");
        BigDecimal result = instance.getReal();
        assertEquals(expResult, result);
    }

    /**
     * Test of getImaginary method, of class ComplexNumber.
     */
    @Test
    public void testGetImaginary() {
        System.out.println("getImaginary");
        ComplexNumber instance = new ComplexNumber("7","8");
        BigDecimal expResult = new BigDecimal("8");
        BigDecimal result = instance.getImaginary();
        assertEquals(expResult, result);
    }

    

    /**
     * Test of equals method, of class ComplexNumber.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        ComplexNumber instance = new ComplexNumber("5","8");
        boolean expResult = true;
        boolean result = instance.equals(new ComplexNumber("5.0","8.00"));
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class ComplexNumber.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        ComplexNumber instance = new ComplexNumber("5","8");
        String expResult = "ComplexNumber{real=5, imaginary=8}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    
    
    
    
    

}
