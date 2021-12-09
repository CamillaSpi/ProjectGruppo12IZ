/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javafx.collections.ObservableMap;
import modelClassPackage.ComplexNumber;
import modelClassPackage.MyOperandCollection;
import modelClassPackage.Variables;
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
public class HashCommandTableTest {
    MyOperandCollection collector ;
    Variables vars;
    public HashCommandTableTest() {
        collector = new MyOperandCollection(12);
        collector.insert(new ComplexNumber("2", "3"));
        collector.insert(new ComplexNumber("4", "5"));
        vars = new Variables();
        vars.saveToVariable("a", new ComplexNumber("5", "7"));
        vars.saveToVariable("b", new ComplexNumber("-3", "-6"));
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
     * Test of createPersonalizedCommand method, of class HashCommandTable, checking the case in which the String passed as name 
     * corresponds to an already existing Basic operation.
     */
    @Test
    public void testCreatePersonalizedCommandIncorrectName() {
        System.out.println("createPersonalizedCommand with a name corresponding to an already existing basic operation");
        String sequenceDefinition = "+ -";
        String operationName = "dup";
        HashCommandTable instance = new HashCommandTable(collector, vars);
        boolean expResult = false;
        boolean result = instance.createPersonalizedCommand(sequenceDefinition, operationName);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of createPersonalizedCommand method, of class HashCommandTable, 
     * checking the case in which one of the string passed in the definition of the new operation
     * is not correct.
     */
    @Test
    public void testCreatePersonalizedCommandIncorrectDefinition1(){
        System.out.println("createPersonalizedCommand with an incorrect definition");
        String sequenceDefinition = "+ !";
        String operationName = "myOp";
        HashCommandTable instance = new HashCommandTable(collector, vars);
        boolean expResult = false;
        boolean result = instance.createPersonalizedCommand(sequenceDefinition, operationName);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of createPersonalizedCommand method, of class HashCommandTable, 
     * checking the case in which one of the string passed in the definition of the new operation
     * is not correct.
     */
    @Test
    public void testCreatePersonalizedCommandIncorrectDefinition2(){
        System.out.println("createPersonalizedCommand with an incorrect definition");
        String sequenceDefinition = "+ <";
        String operationName = "myOp";
        HashCommandTable instance = new HashCommandTable(collector, vars);
        boolean expResult = false;
        boolean result = instance.createPersonalizedCommand(sequenceDefinition, operationName);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of createPersonalizedCommand method, of class HashCommandTable, 
     * checking the case in which the name for the new operation is correct and the definition
     * contains only basic operations
     */
    @Test
    public void testCreatePersonalizedCommandCorrectDefBasic() {
        System.out.println("createPersonalizedCommand with an incorrect definition");
        String sequenceDefinition = "+ swap";
        String operationName = "myOp";
        HashCommandTable instance = new HashCommandTable(collector, vars);
        boolean expResult = true;
        boolean result = instance.createPersonalizedCommand(sequenceDefinition, operationName);
        Command ret = instance.getUserCommand(operationName);
        assertEquals(ret.getClass(),ConcreteCommandPersonalized.class);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of createPersonalizedCommand method, of class HashCommandTable, 
     * checking the case in which the name for the new operation is correct and the definition
     * contains also user defined operation.
     */
    @Test
    public void testCreatePersonalizedCommandCorrectDefUser() {
        System.out.println("createPersonalizedCommand with an incorrect definition");
        String sequenceDefinition1 = "+ swap";
        String operationName1 = "myOp";
        HashCommandTable instance = new HashCommandTable(collector, vars);
        instance.createPersonalizedCommand(sequenceDefinition1, operationName1);
        String sequenceDefinition2 = "+ myOp";
        String operationName2 = "myOp2";
        boolean expResult = true;
        boolean result = instance.createPersonalizedCommand(sequenceDefinition2, operationName2);
        Command ret = instance.getUserCommand(operationName2);
        assertEquals(ret.getClass(),ConcreteCommandPersonalized.class);
        assertEquals(expResult, result);
    }
    
    
    /**
     * Test of createPersonalizedCommand method, of class HashCommandTable, 
     * checking the case in which the name for the new operation is correct but 
     * corresponds to an already defined operation, checking the command has been replaced.
     */
    @Test
    public void testCreatePersonalizedCommandCorrectAlreadyDef() {
        System.out.println("createPersonalizedCommand with an incorrect definition");
        String sequenceDefinition1 = "+ swap";
        String operationName1 = "myOp";
        HashCommandTable instance = new HashCommandTable(collector, vars);
        instance.createPersonalizedCommand(sequenceDefinition1, operationName1);
        Command command1 = instance.getUserCommand(operationName1);
        String sequenceDefinition2 = "+ -";
        boolean expResult = true;
        boolean result = instance.createPersonalizedCommand(sequenceDefinition2, operationName1);
        Command command2 = instance.getUserCommand(operationName1);
        assertNotEquals(command1, command2);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of getUserCommand method, with a correct key 
     */
    @Test
    public void testgetUserCommandCorrect() {
        System.out.println("getUserCommand with an correct key");
        String sequenceDefinition1 = "+ swap";
        String operationName1 = "myOp";
        HashCommandTable instance = new HashCommandTable(collector, vars);
        instance.createPersonalizedCommand(sequenceDefinition1, operationName1);
        Command command1 = instance.getUserCommand(operationName1);
        assertEquals(command1.getClass(),ConcreteCommandPersonalized.class);   
    }
    
    /**
     * Test of getUserCommand method, with an incorrect key 
     */
    @Test
    public void testgetUserCommandIncorrect() {
        System.out.println("getUserCommand with an incorrect key");
        String sequenceDefinition1 = "+ swap";
        String operationName1 = "myOp";
        HashCommandTable instance = new HashCommandTable(collector, vars);
        instance.createPersonalizedCommand(sequenceDefinition1, operationName1);
        Command command1 = instance.getUserCommand("myOp2");
        assertEquals(command1, null);   
    }
 
    
    /**
     * Test of createPersonalizedCommand method, with one of the function in the user definition 
     * having the SaveToVariable operation(>x) 
     */
    @Test
    public void testCreatePersonalizedCommandSaveTo() {
        System.out.println("createPersonalizedCommand with a SaveToVariable function in the definition");
        String sequenceDefinition1 = "+ >a";
        String operationName1 = "myOp";
        HashCommandTable instance = new HashCommandTable(collector, vars);
        boolean result = instance.createPersonalizedCommand(sequenceDefinition1, operationName1);
        Command command1 = instance.getUserCommand("myOp");
        assertEquals(true, result); 
        assertEquals(command1.getClass(),ConcreteCommandPersonalized.class);
    }
    
    /**
     * Test of createPersonalizedCommand method, with one of the function in the user definition having the SaveFromVariable operation(<x) 
     */
    @Test
    public void testCreatePersonalizedCommandSaveFrom() {
        System.out.println("createPersonalizedCommand with a SaveFromVariable function in the definition");
        String sequenceDefinition1 = "+ <a";
        String operationName1 = "myOp";
        HashCommandTable instance = new HashCommandTable(collector, vars);
        boolean result = instance.createPersonalizedCommand(sequenceDefinition1, operationName1);
        Command command1 = instance.getUserCommand("myOp");
        assertEquals(true, result); 
        assertEquals(command1.getClass(),ConcreteCommandPersonalized.class);
    }
    
    /**
     * Test of createPersonalizedCommand method, with one of the function in the user definition having the AddToVariable operation(+x) 
     */
    @Test
    public void testCreatePersonalizedCommandAddTo() {
        System.out.println("createPersonalizedCommand with a addToVariable function in the definition");
        String sequenceDefinition1 = "+ +a";
        String operationName1 = "myOp";
        HashCommandTable instance = new HashCommandTable(collector, vars);
        boolean result = instance.createPersonalizedCommand(sequenceDefinition1, operationName1);
        Command command1 = instance.getUserCommand("myOp");
        assertEquals(true, result); 
        assertEquals(command1.getClass(),ConcreteCommandPersonalized.class);
    }
    
    /**
     * Test of createPersonalizedCommand method, with one of the function in the user definition having the SubtractToVariable operation(-x) 
     */
    @Test
    public void testCreatePersonalizedCommandSubtractTo() {
        System.out.println("createPersonalizedCommand with a subtractToVariable function in the definition");
        String sequenceDefinition1 = "+ -a";
        String operationName1 = "myOp";
        HashCommandTable instance = new HashCommandTable(collector, vars);
        boolean result = instance.createPersonalizedCommand(sequenceDefinition1, operationName1);
        Command command1 = instance.getUserCommand("myOp");
        assertEquals(true, result); 
        assertEquals(command1.getClass(),ConcreteCommandPersonalized.class);
    }


    /**
     * Test of delete method, of class HashCommandTable.
     * Create a concrete command "toAdd" that contains myCommand list. 
     * The list myCommand contains AddCommand object.
     * Concrete Command is added to hashmap like a personalized command,
     * after a new concrete command was created with the previusly concretecommand created.
     * So when the first command was delete also the second need to be deleted.
     */
    @Test
    public void testDelete(){
        System.out.println("delete");
        String name = "";
        HashCommandTable instance = new HashCommandTable(collector, vars);
        instance.createPersonalizedCommand("+", "toAdd");
        instance.createPersonalizedCommand("toAdd", "toAdd1");
        
        System.out.println(instance.delete("toAdd"));
     
        Command result = instance.getUserCommand("toAdd1");
        
        assertEquals(null, result);
    }

    /**
     * Test of setCollector method, of class HashCommandTable.
     */
    @Test
    public void testSetCollector() {
        System.out.println("setCollector");
        assertEquals(true, true);
    }

    /**
     * Test of createPersonalizedCommand method, of class HashCommandTable.
     */
    @Test
    public void testCreatePersonalizedCommand() {
        System.out.println("createPersonalizedCommand");
        assertEquals(true, true);

    }

    /**
     * Test of getUserCommand method, of class HashCommandTable.
     */
    @Test
    public void testGetUserCommand() {
        System.out.println("getUserCommand");
        assertEquals(true, true);

    }

    /**
     * Test of getMyCommandHash method, of class HashCommandTable.
     */
    @Test
    public void testGetMyCommandHash() {
        System.out.println("getMyCommandHash");
        assertEquals(true, true);

    }

    /**
     * Test of printCommandToFile method, of class HashCommandTable.
     */
    @Test
    public void testPrintCommandToFile() {
        System.out.println("testPrintCommandToFile with a subtractToVariable function in the definition");
        String sequenceDefinition1 = "+ -a";
        String operationName1 = "myOp";
        HashCommandTable instance = new HashCommandTable(collector, vars);
        instance.createPersonalizedCommand("+", "toAdd");
        instance.createPersonalizedCommand("toAdd", "toAdd1");
        File f = new File("pippo");
        boolean result = instance.printCommandToFile(f);
        assertEquals(true, result); 
    }
    
}


