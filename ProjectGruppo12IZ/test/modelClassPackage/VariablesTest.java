/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelClassPackage;

import javafx.collections.ObservableMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Gruppo 12 IZ
 */
public class VariablesTest {
    
    public VariablesTest() {
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
    public void testCheckRange() {
        System.out.println("checkRange with correct length");
        String s = "a";
        Variables instance = new Variables();
        boolean expResult = true;
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
    public void testGetValue() {
        System.out.println("getValue with a contained key");
        String key = "a";
        Variables instance = new Variables();
        ComplexNumber value = new ComplexNumber("-4","3");
        instance.put(key, value);
        ComplexNumber expResult = value;
        ComplexNumber result = instance.getValue(key);
        assertEquals(expResult, result);
    }
  
    /**
     * Test of SaveToVariables method, of class Variables, with correct entry.
     */
    @Test
    public void testSaveToVariable() {
        System.out.println("insert a complex Number correctly created");
        ComplexNumber a = new ComplexNumber("1000", "1000");
        Variables instance = new Variables();
        instance.saveToVariable("a", a);
        System.out.println(instance.toString());
        assertEquals(a, instance.getValue("a"));
    }
    
    /**
     * Test of SaveToVariables method, of class Variables, with wrong null CompplexNumber as entry.
     */
    @Test
    public void testSaveToVariablesNullNumber() {
        System.out.println("insert a complex Number equal to null");
        ComplexNumber a = null;
        Variables instance = new Variables();
        instance.saveToVariable("a", a);
        assertEquals(null, instance.getValue("a"));
    }
    
    /**
     * Test of SaveToVariables method, of class Variables, with wrong key as entry.
     */
    
    @Test
    public void testSaveToVariablesWrongKey() {
        System.out.println("insert a complex Number correctly created");
        ComplexNumber a = new ComplexNumber("1000", "1000");
        Variables instance = new Variables();
        instance.saveToVariable("8", a);
        assertEquals(null, instance.getValue("8"));
    }
    
    /**
     * Test of SaveToVariables method, of class Variables, with replace the value in a setted variable.
     */
    
    @Test
    public void testSaveToVariablesReplace() {
        System.out.println("setValue with the replacement of the value");
        String key = "b";
        ComplexNumber newValue = new ComplexNumber("-3.4", "0.9");
        ComplexNumber oldValue = new ComplexNumber("4.3", "-6.5");
        Variables instance = new Variables();
        instance.saveToVariable(key, oldValue);
        instance.saveToVariable(key, newValue);
        ComplexNumber retValue = instance.getValue(key);
        assertEquals(retValue, newValue); 
    }
    
    /**
     * Test of SaveFromVariable method, of class Variables, analyzing the case with a variable correctly written and initialized.
     */
    @Test
    public void testSaveFromVariable() {
        System.out.println("save from a variable correctly written and initialized");
        ComplexNumber a = new ComplexNumber("1000", "1000");
        Variables instance = new Variables();
        instance.saveToVariable("c", a);
        assertEquals(a, instance.saveFromVariable("c"));
    }
    
    /**
     * Test of SaveFromVariable method, of class Variables, analyzing the case with a variable not correctly written.
     */
    @Test
    public void testSaveFromVariableNotCorrectlyWrittenVariable() {
        System.out.println("save from a variable not correctly written");
        ComplexNumber a = new ComplexNumber("1000", "1000");
        Variables instance = new Variables();
        instance.saveToVariable("8", a);
        assertEquals(null, instance.saveFromVariable("8"));
    }
    
    /**
     * Test of SaveFromVariable method, of class Variables, analyzing the case with a variable not correctly initialized.
     */
    @Test
    public void testSaveFromVariableNotInitializedVariable() {
        System.out.println("save from a variable not correctly initialized");
        Variables instance = new Variables();
        assertEquals(null, instance.saveFromVariable("c"));
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
    public void testSubtractToVariable() {
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
    
 /**
     * Test of addToVariable method, of class Variables.
     * Correct test case.
     */
    @Test
    public void testAddToVariable() {
        System.out.println("Add To Variable test");
        ComplexNumber a = new ComplexNumber("157", "192");
        Variables instance = new Variables();
        instance.saveToVariable("a", a);
        ComplexNumber toAdd = new ComplexNumber("19", "12");
        instance.addToVariable("a", toAdd);
        ComplexNumber expResult = Calculator.addiction(a, toAdd);
        ComplexNumber result = instance.getValue("a");
        assertEquals(expResult, result);
    }
    /**
     * Test of addToVariable method, of class Variables.
     * Value to add is null
     */
    @Test
    public void testAddToVariableAddNull() {
        System.out.println("Add to var a Null value");
        ComplexNumber a = new ComplexNumber("157", "192");
        Variables instance = new Variables();
        instance.saveToVariable("a", a);
        ComplexNumber toAdd = null;
        Boolean expResult = false;
        Boolean result = instance.addToVariable("a", toAdd);
        assertEquals(expResult, result);
    }
     /**
     * Test of addToVariable method, of class Variables.
     * Var value is never setted. (is null) 
     */
    @Test
    public void testAddToVariableVarNull() {
        System.out.println("add to a Null variable ");
        Variables instance = new Variables();
        ComplexNumber toAdd = new ComplexNumber("157", "192");
        Boolean expResult = false;
        Boolean result = instance.addToVariable("a", toAdd);
        assertEquals(expResult, result);
    }
     /**
     * Test of addToVariable method, of class Variables.
     * Both value are null
     */
    @Test
    public void testAddToVariableBothNull() {
        System.out.println("add to a Null variable ");
        Variables instance = new Variables();
        ComplexNumber toAdd = null;
        Boolean expResult = false;
        Boolean result = instance.addToVariable("a", toAdd);
        assertEquals(expResult, result);
    }
    /**
     * Test of getMyVariables method, of class Variables.
     */
    @Test
    public void testGetMyVariables() {
        System.out.println("getMyVariables");
        Variables instance = new Variables();
        instance.put("a", new ComplexNumber("3", "2"));
        ObservableMap<String, ComplexNumber> expResult = instance.getMyVariables();
        ObservableMap<String, ComplexNumber> result = instance.getMyVariables();
        assertEquals(expResult, result);
    }

    /**
     * Test of put method, of class Variables.
     */
    @Test
    public void testPut() {
        System.out.println("put");
        String key = "a";
        ComplexNumber value = new ComplexNumber("3", "2");
        Variables instance = new Variables();
        int length = instance.getMyVariables().size();
        instance.put(key, value);
        assertEquals(length +1 , instance.getMyVariables().size());
    }

    /**
     * Test of saveVariablesIntoStack method, of class Variables.
     */
    @Test
    public void testSavevariablesIntoStack() {
        System.out.println("SavevariablesIntoStack");
        Variables instance = new Variables();
        instance.put("a", new ComplexNumber("3", "2"));
        instance.put("b", new ComplexNumber("0", "2"));
        instance.saveVariablesIntoStack();
        
        ObservableMap<String, ComplexNumber> expResult = instance.getMyVariables();
        instance.restoreVariablesFromStack();
        ObservableMap<String, ComplexNumber> result = instance.getMyVariables();
        assertEquals(expResult, result);
    }

    /**
     * Test of restoreVariablesFromStack method, of class Variables.
     */
    @Test
    public void testRestoreVariablesFromStack() {
        System.out.println("restoreVariablesFromStack");
        Variables instance = new Variables();
        instance.put("a", new ComplexNumber("3", "2"));
        instance.put("b", new ComplexNumber("0", "2"));
        instance.saveVariablesIntoStack();
        instance.put("c", new ComplexNumber("0", "2"));
        ObservableMap<String, ComplexNumber> expResult = instance.getMyVariables();
        instance.restoreVariablesFromStack();
        ObservableMap<String, ComplexNumber> result = instance.getMyVariables();
        assertNotEquals(expResult, result);
    }
    /**
     * Test of restoreVariablesFromStack method, of class Variables.
     */
    @Test
    public void testRestoreFromNullStack() {
        System.out.println("RestoreFromNullStack");
        Variables instance = new Variables();
        instance.put("a", new ComplexNumber("3", "2"));
        instance.put("b", new ComplexNumber("0", "2"));
        instance.put("c", new ComplexNumber("0", "2"));
        boolean expResult = false;
        boolean result = instance.restoreVariablesFromStack();
        assertEquals(expResult, result);
    }
     /**
     * Test of restoreVariablesFromStack method, of class Variables.
     */
    @Test
    public void testSaveNullIntoStack() {
        System.out.println("SaveNullIntoStack");
        Variables instance = new Variables();
        boolean expResult = false;
        boolean result = instance.saveVariablesIntoStack();
        assertEquals(expResult, result);
    }

    
}
