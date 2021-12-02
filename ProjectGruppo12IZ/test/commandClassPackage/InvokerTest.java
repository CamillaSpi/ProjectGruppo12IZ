/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package commandClassPackage;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vitot
 */
public class InvokerTest {
    
    public InvokerTest() {
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
     * Test of execute method, of class Invoker.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        Command command = null;
        Invoker instance = new Invoker();
        instance.execute(command);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of undoLast method, of class Invoker.
     */
    @Test
    public void testUndoLast() {
        System.out.println("undoLast");
        Invoker instance = new Invoker();
        instance.undoLast();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
