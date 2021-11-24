/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgruppo12iz;

import java.net.URL;
import java.util.ResourceBundle;
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
 * @author anton
 */
public class FXMLDocumentControllerTest {
    
    public FXMLDocumentControllerTest() {
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
     * Test of initialize method, of class FXMLDocumentController.
     */
    @Test
    public void testInitialize() {
        System.out.println("initialize");
        URL url = null;
        ResourceBundle rb = null;
        FXMLDocumentController instance = new FXMLDocumentController();
        instance.initialize(url, rb);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pushIntoStack method, of class FXMLDocumentController.
     */
    @Test
    public void testPushIntoStackCorrectNum() {
        System.out.println("push into stack a correct ComplexNumber");
        ComplexNumber num = new ComplexNumber("5", "10");
        FXMLDocumentController instance = new FXMLDocumentController();
        boolean expResult = true;
        assertEquals(expResult, instance.pushIntoStack(num));
    }
    
    /**
     * Test of pushIntoStack method, of class FXMLDocumentController.
     */
    @Test
    public void testPushIntoStackIncorrectIncorrectNum() {
        System.out.println("push into stack an incorrect ComplexNumber");
        ComplexNumber num = null;
        FXMLDocumentController instance = new FXMLDocumentController();
        boolean expResult = false;
        assertEquals(expResult, instance.pushIntoStack(num));
    }
    
    /**
     * Test of sub method, of class FXMLDocumentController.
     */
    @Test
    public void testSub() {
        System.out.println("push into stack an incorrect ComplexNumber");
        ComplexNumber num = null;
        FXMLDocumentController instance = new FXMLDocumentController();
        boolean expResult = false;
        assertEquals(expResult, instance.pushIntoStack(num));
    }

}
