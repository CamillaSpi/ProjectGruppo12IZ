/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateClassPackage;

import commandClassPackage.AddCommand;
import commandClassPackage.DivideCommand;
import commandClassPackage.DropCommand;
import commandClassPackage.EnterCommand;
import commandClassPackage.MultiplyCommand;
import commandClassPackage.SwapCommand;
import modelClassPackage.ComplexNumber;
import modelClassPackage.MyOperandCollection;
import projectgruppo12iz.FXMLDocumentController;

/**
 *
 * @author GRUPPO 12 IZ
 */
public class StateStandard extends State {

    /**
     * <p>
     * It create a new object StateStandard calling the constructor method of
     * the super class.
     * </p> <!-- -->
     *
     * @param controller The DocumentController object
     * @see FXMLDocumentController
     */
    public StateStandard(FXMLDocumentController controller) {
        super(controller);
    }

    /**
     * <p>
     * It try to insert a new Complex Operand on which to perform operations. If
     * the text written in the specific textArea correspond to a ComplexNumber
     * it will be stored, otherwise an error message will be shown.
     * </p> <!-- -->
     *
     * @see FXMLDocumentController ComplexNumber
     */
    public void onButtonEnter() {
        String text = controller.getText();
        if ("".equals(text)) {
            controller.showAlert("You must write a Complex Number!");
        } else {
            ComplexNumber checkNum = ComplexNumber.create(text);
            if (checkNum != null) {
                MyOperandCollection collector = controller.getCollector();
                EnterCommand enterComm = new EnterCommand(collector, checkNum);
                if (enterComm != null && controller.commandExecute(enterComm)) {
                    controller.showAlert("Number inserted correctly!");
                    controller.refresh();
                    this.controller.clearText();
                } else {
                    controller.showAlert("Operand not saved!");
                }
            } else {
                controller.showAlert("Operand not written correctly!");
            }
        }

    }

    /**
     * <p>
     * It create a new MultiplyCommand and calls the method execute on it if it
     * is possible. If the operation could not be performed an error message
     * will be shown and the operation will not be performed.
     * </p> <!-- -->
     *
     * @see FXMLDocumentController MultiplyCommand
     */
    @Override
    public void onButtonOne() {
        MyOperandCollection collector = controller.getCollector();
        MultiplyCommand mulComm = new MultiplyCommand(collector);
        if (mulComm != null && controller.commandExecute(mulComm)) {
            controller.showAlert("Multiplication done succesfully!");
            controller.refresh();
        } else {
            controller.showAlert("Multiplication cannot be performed!\nHave you inserted at least two operands?");
        }
    }

    /**
     * <p>
     * It create a new AddCommand and calls the method execute on it if it is
     * possible. If the operation could not be performed an error message will
     * be shown and the operation will not be performed.
     * </p> <!-- -->
     *
     * @see FXMLDocumentController AddCommand
     */
    public void onButtonTwo() {
        MyOperandCollection collector = controller.getCollector();
        AddCommand addComm = new AddCommand(collector);
        if (addComm != null && controller.commandExecute(addComm)) {
            controller.showAlert("Addiction done succesfully!");
            controller.refresh();
        } else {
            controller.showAlert("Addiction cannot be performed!\nHave you insert at least two operands?");
        }

    }

    /**
     * <p>
     * It create a new SwapCommand and calls the method execute on it if it is
     * possible. If the operation could not be performed an error message will
     * be shown and the operation will not be performed.
     * </p> <!-- -->
     *
     * @see FXMLDocumentController SwapCommand
     */
    @Override
    public void onButtonThree() {
        MyOperandCollection collector = controller.getCollector();
        SwapCommand swapComm = new SwapCommand(collector);
        if (swapComm != null && controller.commandExecute(swapComm)) {
            controller.showAlert("Swap Operation done succesfully!");
            controller.refresh();
        } else {
            controller.showAlert("Swap operation cannot be performed!\nHave you inserted at least two operands?");
        }

    }

    /**
     * <p>
     * It create a new DivideCommand and calls the method execute on it if it is
     * possible. If the operation could not be performed an error message will
     * be shown and the operation will not be performed.
     * </p> <!-- -->
     *
     * @see FXMLDocumentController DivideCommand
     */
    public void onButtonFour() {
        MyOperandCollection collector = controller.getCollector();
        DivideCommand divComm = new DivideCommand(collector);
        if (divComm != null && controller.commandExecute(divComm)) {
            controller.showAlert("Division done succesfully!");
            controller.refresh();
        } else {
            controller.showAlert("Division cannot be performed!\nHave you insert at least two operands?");
        }

    }

    /**
     * <p>
     * It create a new DropCommand and calls the method execute on it if it is
     * possible. If the operation could not be performed an error message will
     * be shown and the operation will not be performed.
     * </p> <!-- -->
     *
     * @see FXMLDocumentController DropCommand
     */
    public void onButtonSix() {
        MyOperandCollection collector = controller.getCollector();
        DropCommand dropComm = new DropCommand(collector);
        if (dropComm != null && controller.commandExecute(dropComm)) {
            controller.showAlert("Drop Operation done succesfully!");
            controller.refresh();
        } else {
            controller.showAlert("Drop operation cannot be performed!\nHave you inserted any operand?");
        }
    }

    /**
     * <p>
     * This method do not perform operation because it only leaves the context
     * in the same state where it already is.
     * </p> <!-- -->
     */
    @Override
    public void setStateStandard() {
    }

    /**
     * <p>
     * It changes the State of the controller to StateVariables, setting its
     * into the controller and makes visible only the buttons necessary in this
     * state.
     * </p> <!-- -->
     *
     * @see FXMLDocumentController
     */
    @Override
    public void setStateVariables() {
        controller.changeButtonText(0, ">x");
        controller.changeButtonText(2, "<x");
        controller.changeButtonText(3, "+x");
        controller.changeButtonText(5, "-x");
        controller.hideButton(new int[]{1, 4, 6, 7, 8, 9, 10, 11, 12});
        controller.showButton(new int[]{13});

        controller.setState(new StateVariables(controller));
    }

    /**
     * <p>
     * It changes the State of the controller to StateOperations, setting its
     * into the controller and makes visible only the buttons necessary in this
     * state.
     * </p> <!-- -->
     *
     * @see FXMLDocumentController
     */
    @Override
    public void setStateOperations() {
        controller.changeButtonText(0, "DELETE");
        controller.changeButtonText(1, "SHOW");
        controller.changeButtonText(2, "EXECUTE");
        controller.hideButton(new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11});
        controller.showButton(new int[]{13});
        controller.setState(new StateOperations(controller));
    }

    /**
     * <p>
     * It changes the State of the controller to StateTranscendetal, setting its
     * into the controller and makes visible only the buttons necessary in this
     * state.
     * </p> <!-- -->
     *
     * @see FXMLDocumentController
     */
    @Override
    public void setStateTranscendetal() {
        controller.changeButtonText(0, "MOD");
        controller.changeButtonText(2, "ARG");
        controller.hideButton(new int[]{1, 3, 4, 5, 6, 7, 8, 9, 10, 11});
        controller.showButton(new int[]{12});

        controller.setState(new StateTranscendental(controller));

    }

}
