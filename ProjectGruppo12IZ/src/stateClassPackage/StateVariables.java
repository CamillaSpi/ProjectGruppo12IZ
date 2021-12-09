/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateClassPackage;

import commandClassPackage.AddToVariableCommand;
import commandClassPackage.SaveFromVariableCommand;
import commandClassPackage.SaveToVariableCommand;
import commandClassPackage.SubtractToVariableCommand;
import modelClassPackage.ComplexNumber;
import projectgruppo12iz.FXMLDocumentController;

/**
 *
 * @author Mattia
 */
public class StateVariables extends State {

    public StateVariables(FXMLDocumentController controller) {
        super(controller);
    }

    /**
     * It create a new SaveToVariable and calls the method execute on it if it is possible.
     * If the operation could not be performed, because there are not at least two operands for example,
     * an error message will be shown and the operation will not be performed. 
     * @see FXMLDocumentController, SaveToVariable
     */
    @Override
    public void onButtonOne() {
        if (this.controller.getCollector().last() != null) {
            String variable = this.controller.getText();
            if (!("".equals(variable))) {
                SaveToVariableCommand cmd = new SaveToVariableCommand(this.controller.getCollector(), this.controller.getVariables(), variable);
                if (!controller.commandExecute(cmd)) {
                    this.controller.showAlert("the operation is failed, are you sure you write a varible a-z?!\n");
                } else {
                    this.controller.showAlert("the last operand is saved in the writed variable!\n");
                    this.controller.refresh();
                    this.controller.refreshVarsOp();
                }
            } else {
                this.controller.showAlert("write the variable where save the values!\n");
            }
        } else {
            this.controller.showAlert("insert at least an operand before execute this operation!\n");
        }
    }

    /**
     * It create a new SaveFromVariable and calls the method execute on it if it is possible.
     * If the operation could not be performed, because there are not at least two operands for example,
     * an error message will be shown and the operation will not be performed. 
     * @see FXMLDocumentController, SaveFromVariable
     */
    @Override
    public void onButtonThree() {
        String variable = this.controller.getText();
        if ("".equals(variable)) {
            this.controller.showAlert("Write a variable before press this button!");
        } else {
            SaveFromVariableCommand cmd = new SaveFromVariableCommand(this.controller.getCollector(), this.controller.getVariables(), variable);
            if (cmd != null) {
                if (!controller.commandExecute(cmd)) {
                    this.controller.showAlert("the operation is failed, are you sure have set the variable?\n");
                } else {
                    this.controller.showAlert("Value from variable inserted correctly\n");
                    this.controller.refresh();
                    this.controller.refreshVarsOp();
                }
            } else {
                this.controller.showAlert("the operation is failed\n");
            }
        }
    }

    /**
     */
    public void onButtonFour() {
        ComplexNumber adding = this.controller.getCollector().last();
        if (adding != null) {
            String variable = this.controller.getText();
            if (!("".equals(variable))) {
                AddToVariableCommand cmd = new AddToVariableCommand(this.controller.getCollector(), this.controller.getVariables(), variable);
                if (cmd != null) {
                    if (!controller.commandExecute(cmd)) {
                        this.controller.showAlert("the operation is failed, are you sure have set the variable?");
                    } else {
                        this.controller.showAlert("the result will be saved in the variable " + variable);
                        this.controller.refresh();
                        this.controller.refreshVarsOp();
                    }
                } else {
                    this.controller.showAlert("the operation is failed\n");
                }
            } else {
                this.controller.showAlert("Specify a variable before click this button!");
            }
        } else {
            this.controller.showAlert("Insert at least an operand to execute this operation!");
        }
    }

    /**
     * It create a new AddToVariable and calls the method execute on it if it is possible.
     * If the operation could not be performed, because there are not at least two operands for example,
     * an error message will be shown and the operation will not be performed. 
     * @see FXMLDocumentController, AddToVariable
     */
    public void onButtonSix() {
        ComplexNumber subtracting = this.controller.getCollector().last();
        if (subtracting != null) {
            String variable = this.controller.getText();
            if (!("".equals(variable))) {
                SubtractToVariableCommand cmd = new SubtractToVariableCommand(this.controller.getCollector(), this.controller.getVariables(), variable);
                if (cmd != null) {
                    if (!controller.commandExecute(cmd)) {
                        this.controller.showAlert("the operation is failed, are you sure have set the variable?");
                    } else {
                        this.controller.showAlert("the result will be saved in the variable " + variable);
                        this.controller.refresh();
                        this.controller.refreshVarsOp();
                    }
                } else {
                    this.controller.showAlert("the operation is failed\n");
                }
            } else {
                this.controller.showAlert("Specify a variable before click this button!");
            }
        } else {
            this.controller.showAlert("Insert at least an operand to execute this operation!");
        }
    }

    /**
     * It changes the State of the controller to that of StateStandard,
     * sets this state into the controller and make visible only the buttons 
     * necessary to perform operations on variables, .
     * @see FXMLDocumentController
     */
    @Override
    public void setStateStandard() {
        this.controller.showButton(new int[]{1, 4, 6, 7, 8, 9, 10, 11, 12});
        this.controller.changeButtonText(0, "MOL");
        this.controller.changeButtonText(2, "SWAP");
        this.controller.changeButtonText(3, "DIV");
        this.controller.changeButtonText(5, "DROP");
        this.controller.hideButton(new int[]{13});
        this.controller.setState(new StateStandard(controller));
    }

    @Override
    public void setStateVariables() {
    }

    /**
     * It create a new SubtractToVariable and calls the method execute on it if it is possible.
     * If the operation could not be performed, because there are not at least two operands for example,
     * an error message will be shown and the operation will not be performed. 
     * @see FXMLDocumentController, SubtractToVariable
     */
    @Override
    public void setStateOperations() {
    
        this.controller.changeButtonText(0, "DELETE");
        this.controller.changeButtonText(1, "SHOW");
        this.controller.changeButtonText(2, "EXECUTE");
        this.controller.changeButtonText(3, "DIV");
        this.controller.showButton(new int[]{1, 12, 13});
        this.controller.hideButton(new int[]{3, 5});
    }

    @Override
    public void setStateTranscendetal() {
        this.controller.showButton(new int[]{12});
        controller.changeButtonText(0, "MOD");
        controller.changeButtonText(1, "ARG");
        controller.changeButtonText(3, "POW");
        controller.changeButtonText(4, "EXP");
        controller.hideButton(new int[]{13});

        controller.setState(new StateTranscendental(controller));
    }

}
        
