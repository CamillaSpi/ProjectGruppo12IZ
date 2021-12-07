/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateClassPackage;


import commandClassPackage.MultiplyCommand;
import modelClassPackage.ComplexNumber;
import modelClassPackage.MyOperandCollection;
import projectgruppo12iz.FXMLDocumentController;

/**
 *
 * @author GRUPPO 12 IZ
 */
public class StateStandard extends State{
    
    /**
     * It create a new object StateStandard calling the constructor method of the super class.
     * @param collector
     * @see FXMLDocumentController
     */
    public StateStandard(FXMLDocumentController controller) {
        super(controller);
    }
    
    /**
     * It insert a new Complex Operand on which to perfrom operations,
     * if it is write in the correct form in the corresponding text area, 
     * otherwise an error message will be shown. 
     * @see FXMLDocumentController, ComplexNumber
     */
    public void OnButtonEnter(){
        String text = controller.getText();
        if("".equals(text)){
            controller.showAlert("You must write a Complex Number!");
        }else {
            ComplexNumber checkNum = ComplexNumber.create(text);
            if (checkNum != null) {
                if (controller.pushIntoStack(checkNum)) {
                    controller.showAlert("Operand saved succesfully!");
                    controller.clearText();
                } else {
                    controller.showAlert("Operand not saved!");
                }
            } else {
                controller.showAlert("Operand not written correctly!");
            }
        }
            
    }
    
     /**
     * It create a new MultiplyCommand Operation and execute it if it is possible,
     * If the operation could not be performed, because there are not enough operands for example
     * an error message will be shown. 
     * @see FXMLDocumentController, ComplexNumber
     */
    @Override
    public void onButtonOne() {
        MyOperandCollection collector = controller.getCollector();
        MultiplyCommand addComm = new MultiplyCommand(collector);
        if(addComm.execute()){
            controller.showAlert("Multiplication done succesfully!");
            controller.refresh();
        }
        else
            controller.showAlert("Multiplication cannot be performed!");
    }

    @Override
    public void onButtonThree() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setStateStandard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setStateVariables() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setStateOperations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
