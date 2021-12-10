/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stateClassPackage;

import commandClassPackage.Command;
import commandClassPackage.ConcreteCommandPersonalized;
import commandClassPackage.HashCommandTable;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import projectgruppo12iz.FXMLDocumentController;

/**
 *
 * @author GRUPPO 12 IZ
 */
public class StateOperations extends State {

    private final HashCommandTable userCommand;

     /**
     * It create a new object StateStandard calling the constructor method of the super class.
     * @param controller
     * @see FXMLDocumentController
     */
    public StateOperations(FXMLDocumentController controller) {
        super(controller);
        this.userCommand = this.controller.getuserCommand();

    }
     /**
    * This function is associated with the button enter operation in order to avoid the user to store
    * a personalized operation defining its name and its definition.
    * If the operation name already exists it will be asked to user if he is sure to update the operation 
    * and all the operation that uses it.
    * <p> <!-- -->
    * @see HashCommandTable
    */
    public void onButtonEnter() {
        String operationName = this.controller.getOperationName();
        String sequenceDefinition = this.controller.getText();
        if (operationName.matches("[a-zA-Z0-9]*")) {
            if (this.userCommand.getUserCommand(operationName) != null) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Updating \"" + operationName + "\" operation");
                alert.setHeaderText("Are you sure?");
                alert.setContentText("This means the updating of all the operation that uses it!!!");

                Optional<ButtonType> option = alert.showAndWait();

                if (option.get() == null || alert.getResult() == ButtonType.CANCEL) {
                    this.controller.showAlert("The operation will not be updated");
                    return;
                }
            }
            if (userCommand.createPersonalizedCommand(sequenceDefinition, operationName)) {
                this.controller.showAlert("Operation saved succesfully");
                this.controller.clearText();
            } else {
                this.controller.showAlert("The operation could not be saved");
            }
        } else {
            this.controller.showAlert("The name inserted for the operation is not correct");
        }
    }

    /**
    * This function allows to delete an previously defined user operation and all the
    * other user operation that contains this one.
    * <p> <!-- -->
    */
    @Override
    public void onButtonOne() {
        String OpName = this.controller.getOperationName();
        if ("".equals(OpName)) {
            this.controller.showAlert("Write the name of the operation to delete");
        } else {
            if (userCommand.getUserCommand(OpName) != null) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Deleting \"" + OpName + "\" operation");
                alert.setHeaderText("Are you sure?");
                alert.setContentText("This involve the delete of all operation that include this one!!!");

                Optional<ButtonType> option = alert.showAndWait();

                if (option.get() == null || option.get() == ButtonType.CANCEL) {
                    this.controller.showAlert("Deletion canceled");
                    this.controller.clearText();
                    this.controller.clearNameText();
                } else if (option.get() == ButtonType.OK) {
                    if (userCommand.delete(OpName)) {
                        this.controller.showAlert("Operation delete succesfully");
                        this.controller.clearText();
                        this.controller.clearNameText();
                    } else {
                        this.controller.showAlert("Operation not found");
                    }
                }
            } else {
                this.controller.showAlert("Operation not found");
            }

        }

    }
    /**
    * This function allows to show in the apposit text area the operations that compose 
    * the operation writes in relative text area so you can view modify that(if exists).
    * <p> <!-- -->
    * @see HashCommandTable
    */
    public void onButtonTwo() {
        //show
        String operationName = this.controller.getOperationName();
        ConcreteCommandPersonalized command = (ConcreteCommandPersonalized) userCommand.getUserCommand(operationName);
        if (command != null) {
            this.controller.setText(command.getCommands());
        } else {
            this.controller.showAlert("Operation not found");
        }
    }
    /**
    * This function is associated with the button execute operation in order to give 
    * the possibility to the user to execute a personalized operation writing its name in the nameOperationTextArea. 
    * <p> <!-- -->
    * @see HashCommandTable,ConcreteCommandPersonalized,Invoker,Command
    */
    @Override
    public void onButtonThree() {
         String OpName = this.controller.getOperationName();
        if ("".equals(OpName))
             this.controller.showAlert("Write the name of the operation to execute");
        else{
            Command getcomm = userCommand.getUserCommand(OpName);
            if(getcomm == null)
                 this.controller.showAlert("Operation not exists");
            else{
                ConcreteCommandPersonalized concrete = new ConcreteCommandPersonalized((ConcreteCommandPersonalized) getcomm);
                boolean res = this.controller.getInvoker().execute(concrete);
                if(!res){
                     this.controller.showAlert("Operation can't be performed");
                }
                else{
                     this.controller.showAlert("Operation done succesfully");
                     this.controller.refresh();
                     this.controller.clearText();
                }
            }
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
        this.controller.showButton(new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11,12});
        this.controller.changeButtonText(0, "MOL");
        this.controller.changeButtonText(1, "SUM");
        this.controller.changeButtonText(2, "SWAP");
        this.controller.hideButton(new int[]{13});
        controller.setState(new StateStandard(controller)); 
    }
    
    /**
     * It changes the State of the controller to that of StateVariables,
     * sets this state into the controller and make visible only the buttons 
     * necessary to perform on user defined operations.
     * @see FXMLDocumentController
     */
    @Override
    public void setStateVariables() {
        this.controller.showButton(new int[]{3, 5,13});
        this.controller.changeButtonText(0, ">x");
        this.controller.changeButtonText(2, "<x");
        this.controller.changeButtonText(1, "SUM");
        this.controller.changeButtonText(3, "+x");
        this.controller.changeButtonText(5, "-x");
        this.controller.hideButton(new int[]{1,12});
        controller.setState(new StateVariables(controller)); 
    }

    @Override
    public void setStateOperations() {

    }

    @Override
    public void setStateTranscendetal() {
    this.controller.showButton(new int[]{3, 5,12});
        controller.changeButtonText(0, "MOD");
        controller.changeButtonText(2, "ARG");
        controller.changeButtonText(1, "SUM");
        controller.changeButtonText(3, "POW");
        controller.changeButtonText(5, "EXP");
        this.controller.hideButton(new int[]{1,13});
        controller.setState(new StateTranscendental(controller)); 
    
    }
}
