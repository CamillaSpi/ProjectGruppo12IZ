/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package commandClassPackage;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import modelClassPackage.ComplexNumber;
import modelClassPackage.MyOperandCollection;
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
    public HashCommandTableTest() {
        collector = new MyOperandCollection(12);
        collector.insert(new ComplexNumber("2", "3"));
        collector.insert(new ComplexNumber("4", "5"));
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
        HashCommandTable instance = new HashCommandTable(collector);
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
    public void testCreatePersonalizedCommandIncorrectDefinition(){
        System.out.println("createPersonalizedCommand with an incorrect definition");
        String sequenceDefinition = "+ !";
        String operationName = "myOp";
        HashCommandTable instance = new HashCommandTable(collector);
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
        HashCommandTable instance = new HashCommandTable(collector);
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
        HashCommandTable instance = new HashCommandTable(collector);
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
        HashCommandTable instance = new HashCommandTable(collector);
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
        HashCommandTable instance = new HashCommandTable(collector);
        instance.createPersonalizedCommand(sequenceDefinition1, operationName1);
        Command command1 = instance.getUserCommand(operationName1);
        assertEquals(command1.getClass(),ConcreteCommandPersonalized.class);   
    }
    
        /**
     * Test of getUserCommand method, with a correct key 
     */
    @Test
    public void testgetUserCommandIncorrect() {
        System.out.println("getUserCommand with an incorrect key");
        String sequenceDefinition1 = "+ swap";
        String operationName1 = "myOp";
        HashCommandTable instance = new HashCommandTable(collector);
        instance.createPersonalizedCommand(sequenceDefinition1, operationName1);
        Command command1 = instance.getUserCommand("myOp2");
        assertEquals(command1, null);   
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
        HashCommandTable instance = new HashCommandTable(collector);
        instance.createPersonalizedCommand("+", "toAdd");
        instance.createPersonalizedCommand("toAdd", "toAdd1");
        
        System.out.println(instance.delete("toAdd"));
     
        Command result = instance.getUserCommand("toAdd1");
        
        boolean expResult = false;
        assertEquals(null, result);
    }
    
}


