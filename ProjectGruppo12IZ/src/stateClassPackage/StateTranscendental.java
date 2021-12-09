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
 * @author nando
 * @time Dec 9, 2021 4:12:02 PM
 */
public class StateTranscendental extends State {

    
     public StateTranscendental(FXMLDocumentController controller) {
        super(controller);
    }
    /**
     * It insert a new Complex Operand on which to perfrom operations,
     * if it is write in the correct form in the corresponding text area the operand will be stored,
     * otherwise an error message will be shown and anithing new is inserted. 
     * @see FXMLDocumentController, ComplexNumber
     */
    public void onButtonEnter(){
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
     * It create a new MultiplyCommand and calls the method execute on it if it is possible.
     * If the operation could not be performed, because there are not at least two operands for example,
     * an error message will be shown and the operation will not be performed. 
     * @see FXMLDocumentController, MultiplyCommand
     */
    @Override
    public void onButtonOne() {
        MyOperandCollection collector = controller.getCollector();
        //MOD
        MultiplyCommand mulComm = new MultiplyCommand(collector);
        if(mulComm != null && controller.commandExecute(mulComm)){
            controller.showAlert("Multiplication done succesfully!");
            controller.refresh();
        }
        else
            controller.showAlert("Multiplication cannot be performed!\nHave you inserted at least two operands?");
    }
    
    /**
     * It changes the State of the controller to that of StateVariables, sets
     * this state into the controller and make visible only the buttons
     * necessary to perform operations on variables.
     *
     * @see FXMLDocumentController
     */
    @Override
    public void onButtonTwo() {
        this.controller.showAlert("Button need to be implements");
    }

    /**
     * It changes the State of the controller to that of StateVariables, sets
     * this state into the controller and make visible only the buttons
     * necessary to perform operations on variables.
     *
     * @see FXMLDocumentController
     */
    public void onButtonFour() {
       this.controller.showAlert("Button need to be implements");
    }

    /**
     * It changes the State of the controller to that of StateVariables, sets
     * this state into the controller and make visible only the buttons
     * necessary to perform operations on variables.
     *
     * @see FXMLDocumentController
     */
    public void onButtonFive() {
        this.controller.showAlert("Button need to be implements");
    }
     /**
     * This method do not perform operation because it only leaves the context in the same state where it already is.
     * 
     */
    @Override
    public void setStateStandard() {
        this.controller.showButton(new int[]{2, 5, 6, 7, 8, 9, 10, 11, 12});
        this.controller.changeButtonText(0, "MOL");
        this.controller.changeButtonText(1, "SUM");
        this.controller.changeButtonText(3, "DIV");
        this.controller.changeButtonText(4, "SQRT");
        this.controller.hideButton(new int[]{13});
        this.controller.setState(new StateStandard(controller));
    }

    
    
    /**
     * It changes the State of the controller to that of StateVariables,
     * sets this state into the controller and make visible only the buttons 
     * necessary to perform operations on variables, .
     * @see FXMLDocumentController
     */
    @Override
    public void setStateVariables() {
        controller.changeButtonText(0, ">x");
        controller.changeButtonText(1, "<x");
        controller.changeButtonText(3, "+x");
        controller.changeButtonText(4, "-x");
        controller.showButton(new int[] {13});
        controller.hideButton(new int[] {12});
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
        this.controller.showButton(new int[]{2, 12,13});
        this.controller.hideButton(new int[]{3, 4});
        this.controller.changeButtonText(0, "DELETE");
        this.controller.changeButtonText(1, "SHOW");
        this.controller.changeButtonText(2, "EXECUTE");
        this.controller.changeButtonText(3, "DIV");
        this.controller.changeButtonText(4, "SQRT");
        this.controller.setState(new StateOperations(controller)); 
    }


    @Override
    public void setStateTranscendetal() {
    }
    
    

}
