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
 * @author GRUPPO 12 IZ
 */
public class StateVariables extends State {

    /**
     * <p>
     * It create a new object StateVariables calling the constructor method of
     * the super class.
     *</p> <!-- -->
     * @param controller The DocumentController object
     * @see FXMLDocumentController
     */
    public StateVariables(FXMLDocumentController controller) {
        super(controller);
    }

    /**<p>
     * It create a new SaveToVariable and calls the method execute on it if it
     * is possible. If the operation could not be performed an error message
     * will be shown and the operation will not be performed.
     *</p> <!-- -->
     * @see FXMLDocumentController SaveToVariable
     */
    @Override
    public void onButtonOne() {
        if (this.controller.getCollector().last() != null) {
            String variable = this.controller.getText();
            if (!("".equals(variable))) {
                SaveToVariableCommand cmd = new SaveToVariableCommand(this.controller.getCollector(), this.controller.getVariables(), variable);
                if (!controller.commandExecute(cmd)) {
                    this.controller.showAlert("The operation is failed, are you sure you write a variable a-z?!\n");
                } else {
                    this.controller.showAlert("The last operand is saved in the written variable!\n");
                    this.controller.refresh();
                    this.controller.refreshVarsOp();
                }
            } else {
                this.controller.showAlert("Write the variable where save the values!\n");
            }
        } else {
            this.controller.showAlert("Insert at least an operand before execute this operation!\n");
        }
    }

    /**<p>
     * It create a new SaveFromVariable and calls the method execute on it if it
     * is possible. If the operation could not be performed an error message
     * will be shown and the operation will not be performed.
     *</p> <!-- -->
     * @see FXMLDocumentController SaveFromVariable
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
                    this.controller.showAlert("Operation failed, set a value to the specified variable");
                } else {
                    this.controller.showAlert("Value from variable inserted correctly\n");
                    this.controller.refresh();
                    this.controller.refreshVarsOp();
                }
            } else {
                this.controller.showAlert("The operation is failed\n");
            }
        }
    }

    /**<p>
     * It create a new AddToVariable and calls the method execute on it if it is
     * possible. If the operation could not be performed an error message will
     * be shown and the operation will not be performed.
     *</p> <!-- -->
     * @see FXMLDocumentController AddToVariable
     */
    public void onButtonFour() {
        ComplexNumber adding = this.controller.getCollector().last();
        if (adding != null) {
            String variable = this.controller.getText();
            if (!("".equals(variable))) {
                AddToVariableCommand cmd = new AddToVariableCommand(this.controller.getCollector(), this.controller.getVariables(), variable);
                if (cmd != null) {
                    if (!controller.commandExecute(cmd)) {
                        this.controller.showAlert("Operation failed, set a value to the specified variable");
                    } else {
                        this.controller.showAlert("The result will be saved in the variable " + variable);
                        this.controller.refresh();
                        this.controller.refreshVarsOp();
                    }
                } else {
                    this.controller.showAlert("The operation is failed\n");
                }
            } else {
                this.controller.showAlert("Specify a variable before click this button!");
            }
        } else {
            this.controller.showAlert("Insert at least an operand to execute this operation!");
        }
    }

    /**<p>
     * It create a new SubtractToVariable and calls the method execute on it if
     * it is possible. If the operation could not be performed an error message
     * will be shown and the operation will not be performed.
     *</p> <!-- -->
     * @see FXMLDocumentController SubtractToVariable
     */
    public void onButtonSix() {
        ComplexNumber subtracting = this.controller.getCollector().last();
        if (subtracting != null) {
            String variable = this.controller.getText();
            if (!("".equals(variable))) {
                SubtractToVariableCommand cmd = new SubtractToVariableCommand(this.controller.getCollector(), this.controller.getVariables(), variable);
                if (cmd != null) {
                    if (!controller.commandExecute(cmd)) {
                        this.controller.showAlert("Operation failed, set a value to the specified variable");
                    } else {
                        this.controller.showAlert("The result will be saved in the variable " + variable);
                        this.controller.refresh();
                        this.controller.refreshVarsOp();
                    }
                } else {
                    this.controller.showAlert("The operation is failed\n");
                }
            } else {
                this.controller.showAlert("Specify a variable before click this button!");
            }
        } else {
            this.controller.showAlert("Insert at least an operand to execute this operation!");
        }
    }

    /**<p>
     * It changes the State of the controller to StateStandard, setting its into
     * the controller and makes visible only the buttons necessary in this
     * state.
     *</p> <!-- -->
     * @see FXMLDocumentController
     */
    @Override
    public void setStateStandard() {
        this.controller.showButton(new int[]{1, 4, 6, 7, 8, 9, 10, 11});
        this.controller.changeButtonText(0, "MOL");
        this.controller.changeButtonText(2, "SWAP");
        this.controller.changeButtonText(3, "DIV");
        this.controller.changeButtonText(5, "DROP");
        this.controller.hideButton(new int[]{13});
        this.controller.setState(new StateStandard(controller));
    }

    /**<p>
     * This method do not perform operation because it only leaves the context
     * in the same state where it already is.
     * </p> <!-- -->
     */
    @Override
    public void setStateVariables() {
    }

    /**<p>
     * It changes the State of the controller to StateOperations, setting its
     * into the controller and makes visible only the buttons necessary in this
     * state.
     *</p> <!-- -->
     * @see FXMLDocumentController
     */
    @Override
    public void setStateOperations() {
        this.controller.showButton(new int[]{1, 13});
        this.controller.hideButton(new int[]{3, 5});
        this.controller.changeButtonText(0, "DELETE");
        this.controller.changeButtonText(1, "SHOW");
        this.controller.changeButtonText(2, "EXECUTE");
        this.controller.changeButtonText(3, "DIV");
        this.controller.changeButtonText(5, "DROP");
        this.controller.setState(new StateOperations(controller));
    }

    /**<p>
     * It changes the State of the controller to StateTranscendetal, setting its
     * into the controller and makes visible only the buttons necessary in this
     * state.
     *</p> <!-- -->
     * @see FXMLDocumentController
     */
    @Override
    public void setStateTranscendetal() {
        controller.changeButtonText(0, "MOD");
        controller.changeButtonText(2, "ARG");
        controller.hideButton(new int[]{3, 5, 13});

        controller.setState(new StateTranscendental(controller));
    }

}
