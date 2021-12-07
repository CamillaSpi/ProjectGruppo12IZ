/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateClassPackage;


import commandClassPackage.MultiplyCommand;
import commandClassPackage.SubtractCommand;
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
     * It create a new MultiplyCommand Operation and calls the method execute on it if it is possible.
     * If the operation could not be performed, because there are not enough operands for example,
     * an error message will be shown. 
     * @see FXMLDocumentController, MultiplicationCommand
     */
    @Override
    public void onButtonOne() {
        MyOperandCollection collector = controller.getCollector();
        MultiplyCommand mulComm = new MultiplyCommand(collector);
        if(mulComm != null && mulComm.execute()){
            controller.showAlert("Multiplication done succesfully!");
            controller.refresh();
        }
        else
            controller.showAlert("Multiplication cannot be performed!");
    }

     /**
     * It create a new SubtractCommand Operation and calls the method execute on it if it is possible.
     * If the operation could not be performed, because there are not enough operands for example,
     * an error message will be shown. 
     * @see FXMLDocumentController, SubtractCommand
     */
    @Override
    public void onButtonThree() {
        MyOperandCollection collector = controller.getCollector();
        SubtractCommand subComm = new SubtractCommand(collector);
        if(subComm != null && subComm.execute()){
            controller.showAlert("Division done succesfully!");
            controller.refresh();
        }
        else
            controller.showAlert("Division cannot be performed!");
        
    }

     /**
     * This method do not perform operation because it only leaves the context in the same state where it already is.
     * 
     */
    @Override
    public void setStateStandard() {}

     /**
     * It changes the State of the controller to that of StateVariables,
     * sets this state into the controller and make visible only the buttons 
     * necessary to perform operations on variables.
     * @see FXMLDocumentController
     */
    @Override
    public void setStateVariables() {
        controller.changeButtonText(0, ">x");
        controller.changeButtonText(2, "<x");
        controller.changeButtonText(3, "+x");
        controller.changeButtonText(5, "-x");
        controller.hideButton(new int[] {1, 4, 6, 7, 8, 9, 10, 11, 12});
        controller.setState(new StateVariables(controller)); 
    }

    /**
     * It changes the State of the controller to that of StateOperations,
     * sets this state into the controller and make visible only the buttons 
     * necessary to perform on user defined operations.
     * @see FXMLDocumentController
     */
    @Override
    public void setStateOperations() {
        controller.changeButtonText(0, "DELETE");
        controller.changeButtonText(1, "SHOW");
        controller.changeButtonText(2, "EXECUTE");
        controller.hideButton(new int[] {3, 4, 5, 6, 7, 8, 9, 10, 11});
        controller.setState(new StateOperations(controller));  
    }
    
    
    
    
    
}
