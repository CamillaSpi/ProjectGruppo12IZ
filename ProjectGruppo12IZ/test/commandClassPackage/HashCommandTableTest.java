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
    
    public HashCommandTableTest() {
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
     * Test of ciaooo method, of class HashCommandTable.
     */
    @Test
    public void testCiaooo() throws Exception {
        System.out.println("ciaooo");
        HashCommandTable instance = new HashCommandTable();
    }

    /**
     * Test of createPersonalizedCommand method, of class HashCommandTable.
     */
    @Test
    public void testCreatePersonalizedCommand() throws Exception {
        System.out.println("createPersonalizedCommand");
        MyOperandCollection collector = null;
        String userString = "";
        HashCommandTable instance = new HashCommandTable();
        instance.createPersonalizedCommand(collector, userString);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
    public void testDelete() {
        System.out.println("delete");
        String name = "";
        HashCommandTable instance = new HashCommandTable();
        HashMap<String, ConcreteCommandPersonalized> toOperate = instance.getConcreteCommandHash();
        MyOperandCollection collector = new MyOperandCollection(12);
        collector.insert(new ComplexNumber("-7","78"));
        collector.insert(new ComplexNumber("-7","14"));
        List<Command> myCommand = new LinkedList<>();
        myCommand.add(new AddCommand(collector));
        ConcreteCommandPersonalized concrete1 = new ConcreteCommandPersonalized("toAdd",myCommand);
        toOperate.put("toAdd", concrete1);
        
        List<Command> myCommand2 = new LinkedList<>();
        myCommand2.add(concrete1);
        ConcreteCommandPersonalized concrete2 = new ConcreteCommandPersonalized("toAdd1",myCommand2);
        toOperate.put("toAdd1", concrete2);
        
       
        System.out.println(toOperate.get("toAdd"));
        System.out.println(toOperate.get("toAdd1"));
        System.out.println(instance.delete("toAdd"));
        System.out.println(toOperate.get("toAdd"));
        System.out.println(toOperate.get("toAdd1"));
        ConcreteCommandPersonalized result = toOperate.get("toAdd1");
        
        boolean expResult = false;
        assertEquals(null, result);
    }
    
}
