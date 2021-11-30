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
 * @author Gruppo 12 IZ
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
     * Test of checkRange method, of class Variables, analyzing the case with a String's legth equal to 0.
     */
    @Test
    public void testCheckRangeLowerLength() {
        System.out.println("checkRange with length less than one");
        String s = "";
        Variables instance = new Variables();
        boolean expResult = false;
        boolean result = instance.checkRange(s);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of checkRange method, of class Variables, analyzing the case with a String's legth greater than one.
     */
    @Test
    public void testCheckRangeHigherLength() {
        System.out.println("checkRange with length greater than one");
        String s = "prova";
        Variables instance = new Variables();
        boolean expResult = false;
        boolean result = instance.checkRange(s);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of checkRange method, of class Variables, analyzing the case with a String's legth greater than one.
     */
    @Test
    public void testCheckRangeCorrectLength() {
        System.out.println("checkRange with correct length");
        String s = "a";
        Variables instance = new Variables();
        boolean expResult = true;
        boolean result = instance.checkRange(s);
        assertEquals(expResult, result);
    }
    
        /**
     * Test of checkRange method, of class Variables, analyzing the case with a String's legth greater than one.
     */
    @Test
    public void testCheckRangeNull() {
        System.out.println("checkRange with a string that is null");
        String s = null;
        Variables instance = new Variables();
        boolean expResult = false;
        boolean result = instance.checkRange(s);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of checkRange method, of class Variables, analyzing the case with a String of the correct length but out of range.
     */
    @Test
    public void testCheckRangeOut1() {
        System.out.println("checkRange with correct length");
        String s = "1";
        Variables instance = new Variables();
        boolean expResult = false;
        boolean result = instance.checkRange(s);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of checkRange method, of class Variables, analyzing the case with a String of the correct length but out of range.
     */
    @Test
    public void testCheckRangeOut2() {
        System.out.println("checkRange with correct length");
        String s = "}";
        Variables instance = new Variables();
        boolean expResult = false;
        boolean result = instance.checkRange(s);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of checkRange method, of class Variables, analyzing the case with a String of the correct length and in the correct range.
     */
    @Test
    public void testCheckRangeCorrect1() {
        System.out.println("checkRange with correct length");
        String s = "z";
        Variables instance = new Variables();
        boolean expResult = true;
        boolean result = instance.checkRange(s);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of checkRange method, of class Variables, analyzing the case with a String of the correct length and in the correct range.
     */
    @Test
    public void testCheckRangeCorrect2() {
        System.out.println("checkRange with correct length");
        String s = "l";
        Variables instance = new Variables();
        boolean expResult = true;
        boolean result = instance.checkRange(s);
        assertEquals(expResult, result);
    }

    
    /**
     * Test of toString method, of class Variables.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Variables instance = new Variables();
        ComplexNumber a = new ComplexNumber("-3.5", "8.9");
        ComplexNumber b = new ComplexNumber("5.3", "-9.8");
        instance.saveToVariable("a", a);
        instance.saveToVariable("b", b);
        String expResult = "(a, " + a.toString() + "), (b, " + b.toString() + ")" ;
        String result = instance.toString();
        assertEquals(expResult, result);
    }


    /**
     * Test of getValue method, of class Variables, analyzing the case with a key not contained in the Map.
     */
    @Test
    public void testGetValueNotContainedKey() {
        System.out.println("getValue with a not contained key");
        String key = "a";
        Variables instance = new Variables();
        ComplexNumber expResult = null;
        ComplexNumber result = instance.getValue(key);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of getValue method, of class Variables, analyzing the case with a contained key in the Map.
     */
    @Test
    public void testGetValueContainedKey() {
        System.out.println("getValue with a contained key");
        String key = "a";
        Variables instance = new Variables();
        ComplexNumber value = new ComplexNumber("-4","3");
        instance.getMyVariables().put(key, value);
        ComplexNumber expResult = value;
        ComplexNumber result = instance.getValue(key);
        assertEquals(expResult, result);
    }

   
  
    /**
     * Test of insert method, of class OperandCollection.
     */
    @Test
    public void testSaveToVariablesCorrectNumber() {
        System.out.println("insert a complex Number correctly created");
        ComplexNumber a = new ComplexNumber("1000", "1000");
        Variables instance = new Variables();
        instance.saveToVariable("a", a);
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
        instance.saveToVariable("a", a);
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
        instance.saveToVariable("8", a);
        assertEquals(null, instance.getMyVariables().get("8"));
    }
    
    /**
     * Test of setValue method, of class Variables, analyzing the case in which the key has already a value associated.
     */
    @Test
    public void testSetValueReplace() {
        System.out.println("setValue with the replacement of the value");
        String key = "b";
        ComplexNumber newValue = new ComplexNumber("-3.4", "0.9");
        ComplexNumber oldValue = new ComplexNumber("4.3", "-6.5");
        Variables instance = new Variables();
        instance.saveToVariable(key, oldValue);
        instance.saveToVariable(key, newValue);
        ComplexNumber retValue = instance.getMyVariables().get(key);
        assertEquals(retValue, newValue);   
    }
    
    
    /**
     * Test of subtractToVariable method, of class Variables, analyzing the case in which the key is not in the correct range.
     */
    @Test
    public void testSubtractToVariableOutCondition() {
        System.out.println("subtractToVariable outOfRange key and a null subtracting");
        String key = "0";
        ComplexNumber subtracting = null;
        Variables instance = new Variables();
        boolean ret = instance.subtractToVariable(key, subtracting);
        boolean expRet = false;
        assertEquals(ret, expRet); 
    }
    
    /**
     * Test of subtractToVariable method, of class Variables, analyzing the case in which the key is not in the correct range.
     */
    @Test
    public void testSubtractToVariableOutRage() {
        System.out.println("subtractToVariable outOfRange key");
        String key = "9";
        ComplexNumber subtracting = null;
        Variables instance = new Variables();
        boolean ret = instance.subtractToVariable(key, subtracting);
        boolean expRet = false;
        assertEquals(ret, expRet); 
    }
    /**
     * Test of subtractToVariable method, of class Variables, analyzing the case in which the key is not in the correct range.
     */
    @Test
    public void testSubtractToVariableInvalidSubtracting() {
        System.out.println("subtractToVariable null subtracting");
        String key = "a";
        ComplexNumber subtracting = null;
        ComplexNumber value = new ComplexNumber("-3.4", "0.9");
        Variables instance = new Variables();
        instance.saveToVariable(key, value);
        boolean ret = instance.subtractToVariable(key, subtracting);
        boolean expRet = false;
        assertEquals(ret, expRet); 
    }
    
    /**
     * Test of subtractToVariable method, of class Variables, analyzing the case in which the key has not an already associated value.
     */
    @Test
    public void testSubtractToVariableNoSavedValue() {
        System.out.println("subtractToVariable no associated value to the key");
        String keyA = "a";
        String keyB = "b";
        ComplexNumber valueA = new ComplexNumber("-3.4", "0.9");
        ComplexNumber valueB = new ComplexNumber("4.3", "-6.5");
        Variables instance = new Variables();
        instance.saveToVariable(keyA, valueA);
        instance.saveToVariable(keyB, valueB);
        ComplexNumber subtracting = new ComplexNumber("-4", "9");
        boolean ret = instance.subtractToVariable("c", subtracting);
        boolean expRet = false;
        assertEquals(ret, expRet); 
    }
    
    /**
     * Test of subtractToVariable method, of class Variables, analyzing the case in which the key as an already value associated and the subtracting is not null.
     */
    @Test
    public void testSubtractToVariableCorrectCase() {
        System.out.println("subtractToVariable already associated value to key and correct subtracting");
        String keyA = "a";
        String keyB = "b";
        ComplexNumber valueA = new ComplexNumber("-3.4", "0.9");
        ComplexNumber valueB = new ComplexNumber("4.3", "-6.5");
        Variables instance = new Variables();
        instance.saveToVariable(keyA, valueA);
        instance.saveToVariable(keyB, valueB);
        ComplexNumber subtracting = new ComplexNumber("-4", "9");
        boolean ret = instance.subtractToVariable("b", subtracting);
        boolean expRet = true;
        assertEquals(ret, expRet); 
    }
    

    

  
}
