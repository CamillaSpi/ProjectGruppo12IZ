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

    private HashCommandTable userCommand;

     /**
     * It create a new object StateStandard calling the constructor method of the super class.
     * @param collector
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
        String OpName = this.controller.getText();
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
    @Override
    public void onButtonTwo() {
        //show
        String operationName = this.controller.getText();
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
    public void onButtonThree() {
         String OpName =  this.controller.getText();
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

    @Override
    public void setStateStandard() {
        this.controller.showButton(new int[]{3, 4, 5, 6, 7, 8, 9, 10, 11,12});
        this.controller.changeButtonText(0, "MOL");
        this.controller.changeButtonText(1, "SUM");
        this.controller.changeButtonText(2, "SWAP");
        controller.setState(new StateStandard(controller)); 
    }

    @Override
    public void setStateVariables() {
        // save >x 
        // <x
        // +x 
        // -x

        this.controller.showButton(new int[]{3, 4});
        this.controller.changeButtonText(0, ">x");
        this.controller.changeButtonText(1, "<x");
        this.controller.changeButtonText(2, "SWAP");
        this.controller.changeButtonText(3, "+x");
        this.controller.changeButtonText(4, "-x");
        this.controller.hideButton(new int[]{2,12});
        controller.setState(new StateVariables(controller)); 
    }

    @Override
    public void setStateOperations() {

    }
}
