/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateClassPackage;

import commandClassPackage.ArgCommand;
import commandClassPackage.ModCommand;
import modelClassPackage.ComplexNumber;
import modelClassPackage.MyOperandCollection;
import projectgruppo12iz.FXMLDocumentController;

/**
 *
 * @author GRUPPO 12 IZ
 */
public class StateTranscendental extends State {

     /**<p>
     * It create a new object StateTranscendental calling the constructor method of
     * the super class.
     *</p> <!-- -->
     * @param controller The DocumentController object
     * @see FXMLDocumentController
     */
    public StateTranscendental(FXMLDocumentController controller) {
        super(controller);
    }

     /**<p>
     * It try to insert a new Complex Operand on which to perform operations.
     * If the text written in the specific textArea correspond to a ComplexNumber it will
     * be stored, otherwise an error message will be shown.
     * </p> <!-- -->
     * @see FXMLDocumentController, ComplexNumber
     */
    public void onButtonEnter() {
        String text = controller.getText();
        if ("".equals(text)) {
            controller.showAlert("You must write a Complex Number!");
        } else {
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
     * It create a new ModCommand and calls the method execute on it if it
     * is possible. If the operation could not be performed an error message will be shown and
     * the operation will not be performed.
     *</p> <!-- -->
     * @see FXMLDocumentController, MultiplyCommand
     */
    @Override
    public void onButtonOne() {
        MyOperandCollection collector = controller.getCollector();
        //MOD
        ModCommand ModComm = new ModCommand(collector);
        if (ModComm != null && controller.commandExecute(ModComm)) {
            controller.showAlert("Module done succesfully!");
            controller.refresh();
        } else {
            controller.showAlert("Module cannot be performed!\nHave you inserted at least one operand?");
        }
    }

    /**<p>
     * It create a new ArgCommand and calls the method execute on it if it
     * is possible. If the operation could not be performed an error message will be shown and
     * the operation will not be performed.
     *</p> <!-- -->
     * @see FXMLDocumentController, SaveFromVariable
     */
    @Override
    public void onButtonThree() {
        MyOperandCollection collector = controller.getCollector();
        //MOD
        ArgCommand ArgComm = new ArgCommand(collector);
        if (ArgComm != null && controller.commandExecute(ArgComm)) {
            controller.showAlert("Argument done succesfully!");
            controller.refresh();
        } else {
            controller.showAlert("Argument cannot be performed!\nHave you inserted at least one operand?");
        }
    }

   /**<p>
     * It changes the State of the controller to StateStandard,
     * setting its into the controller and makes visible only the buttons 
     * necessary in this state.
     * 
     * </p> <!-- -->
     * @see FXMLDocumentController
     */
    @Override
    public void setStateStandard() {
        this.controller.showButton(new int[]{1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
        this.controller.changeButtonText(0, "MOL");
        this.controller.changeButtonText(2, "SWAP");
        this.controller.changeButtonText(3, "DIV");
        this.controller.changeButtonText(5, "DROP");
        this.controller.hideButton(new int[]{13});
        this.controller.setState(new StateStandard(controller));
    }

  /**<p>
     * It changes the State of the controller to StateVariables,
     * setting its into the controller and makes visible only the buttons 
     * necessary in this state.
     * </p> <!-- -->
     * @see FXMLDocumentController
     */
    @Override
    public void setStateVariables() {
        controller.changeButtonText(0, ">x");
        controller.changeButtonText(2, "<x");
        controller.changeButtonText(3, "+x");
        controller.changeButtonText(5, "-x");
        controller.showButton(new int[]{3,5,13});
        controller.hideButton(new int[]{12});
        controller.setState(new StateVariables(controller));
    }

  /**<p>
     * It changes the State of the controller to StateOperations,
     * setting its into the controller and makes visible only the buttons 
     * necessary in this state.
     * </p> <!-- -->
     * @see FXMLDocumentController
     */
    @Override
    public void setStateOperations() {
        this.controller.showButton(new int[]{1, 12, 13});
        this.controller.hideButton(new int[]{3, 4, 5});
        this.controller.changeButtonText(0, "DELETE");
        this.controller.changeButtonText(1, "SHOW");
        this.controller.changeButtonText(2, "EXECUTE");
        this.controller.changeButtonText(3, "DIV");
        this.controller.setState(new StateOperations(controller));
    }
    
     /**
      * <p>
     * This method do not perform operation because it only leaves the context
     * in the same state where it already is.
     * </p> <!-- -->
     */
    @Override
    public void setStateTranscendetal() {
    }

}
