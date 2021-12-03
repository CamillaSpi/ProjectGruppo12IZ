/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgruppo12iz;

import commandClassPackage.Command;
import commandClassPackage.ConcreteCommandPersonalized;
import commandClassPackage.HashCommandTable;
import commandClassPackage.Invoker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import modelClassPackage.Calculator;
import modelClassPackage.ComplexNumber;
import modelClassPackage.MyOperandCollection;
import modelClassPackage.Variables;

/**
 *
 * @author Gruppo 12 IZ
 */
public class FXMLDocumentController implements Initializable {

    MyOperandCollection collector = new MyOperandCollection(12);
    HashCommandTable userCommand = new HashCommandTable(collector);
    PauseTransition pause = new PauseTransition(Duration.seconds(5));
    Variables vars= new Variables();  
    Invoker inv = new Invoker();
    int last = 0;
    private Label label;
    @FXML
    private TextArea textArea;
    @FXML
    private TableView<ComplexNumber> OperandsTable;
    @FXML
    private TableColumn<ComplexNumber, String> OperandsClm;
    @FXML
    private Button sumButton;
    @FXML
    private Button subButton;
    @FXML
    private Button molButton;
    @FXML
    private Button divButton;
    @FXML
    private Button sqrtButton;
    @FXML
    private Button invertSignButton;
    @FXML
    private Label errorLabel;

    private ObservableList<ComplexNumber> latestOperands;
    @FXML
    private AnchorPane operationAnchorPane;
    @FXML
    private ToggleButton operationToggleButton;
    @FXML
    private ToggleButton UserToggleButton;
    @FXML
    private ToggleButton VariableToggleButton;
    @FXML
    private AnchorPane varAnchorPane;
    @FXML
    private TextArea varTextArea;
    @FXML
    private TextArea nameOperationTextArea;
    @FXML
    private TextArea operationTextArea;
    @FXML
    private AnchorPane baseAnchorPane;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World! test 5");
    }

    private void showAlert(String error) {
        errorLabel.setText(error);
        pause.stop();
        pause.setOnFinished(e -> errorLabel.setText(null));
        pause.play();
    }
    
    /**
    * It insert the element passed as param in the collection.
    * <p> <!-- -->
    * @param num it's the ComplexNumber to insert in the collection
    * @return true if the element was add, otherwise false
    * @see MyOperandCollection
    */
    public boolean pushIntoStack(ComplexNumber num) {
        int length = collector.collectionLength();
        collector.insert(num);
        OperandsTable.refresh();
        return true;

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        latestOperands = FXCollections.observableList(collector.getL());
        OperandsClm.setCellValueFactory(new PropertyValueFactory<>("complexString"));
        setOpView(latestOperands);
        VariableToggleButton.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition(Duration.seconds(0.4), varAnchorPane);

            if (VariableToggleButton.isSelected()) {
                slide.setFromX(-170);
                slide.setToX(0);

                slide.setRate(1);
                slide.play();
            } else {
                slide.setFromX(0);
                slide.setToX(-170);

                slide.setRate(1);
                slide.play();
            }

        });
        operationToggleButton.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition(Duration.seconds(0.4), operationAnchorPane);

            if (operationToggleButton.isSelected()) {
                slide.setFromY(70);
                slide.setToY(0);
                slide.setRate(1);
                slide.play();
            } else {
                slide.setFromY(0);
                slide.setToY(70);
                slide.setRate(1);
                slide.play();
            }

        });
// to fix
        UserToggleButton.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition(Duration.seconds(0.4), operationAnchorPane);
           
            if (UserToggleButton.isSelected()) {
                if (operationToggleButton.isSelected()) {
                    slide.setFromY(120);
                    slide.setToY(0);
                    last = 0;
                    slide.setRate(1);
                    slide.play();
                } else {
                    slide.setFromY(120);
                    slide.setToY(70);
                    last = 70;
                    slide.setRate(1);
                    slide.play();
                }
            } else {

                slide.setFromY(last);
                slide.setToY(120);
                slide.setRate(1);
                slide.play();
            }

        });

        //Building the sublist of the first twelve elements of the operands collection and adding it in the operands table.
        //OperandsTable.setItems(FXCollections.observableList(collector.subList(0, 11)));  
    }

    public void setOpView(ObservableList<ComplexNumber> latestOperands) {
        OperandsTable.setItems(latestOperands);

    }

    @FXML
    private void handleEnterAction(ActionEvent event) {
        String text = textArea.getText();
        if ("".equals(text)) {
            showAlert("Write a complex number before press enter!");
        } else {
            ComplexNumber checkNum = ComplexNumber.create(text);
            if (checkNum != null) {
                if (this.pushIntoStack(checkNum)) {
                    showAlert("Number entered correctl");
                    textArea.clear();
                } else {
                    showAlert("the number to be entered is not stored correctly");
                }
            } else {
                showAlert("the number to be entered was not written correctly");
            }
        }
    }

    @FXML
    private void add(ActionEvent event) throws InterruptedException {
        if (collector.collectionLength() < 2) {
            showAlert("You didn't insert at least two operands ");
            return;
        }
        ComplexNumber result = Calculator.addiction(collector.remove(), collector.remove());
        if (result != null) {
            pushIntoStack(result);
            showAlert("Addiction done succesfully!\n");

        } else {
            showAlert("Error during Addiction!");
        }

    }
    
    /**
    * It allows the calls to the subtraction operation of the class Calculator pushing the result into the stack.
    * <p> <!-- -->
    * @param event it registers the event
    * @see MyOperandCollection
    */
    @FXML
    private void sub(ActionEvent event) {
        if (collector.collectionLength() < 2) {
            showAlert("You didn't insert at least two operands ");
        } else {
            ComplexNumber b = collector.remove();
            ComplexNumber a = collector.remove();
            ComplexNumber result = Calculator.subtraction(a, b);
            boolean tmp = pushIntoStack(result);
            if (tmp == false) {
                showAlert("Error during subtraction!");
            } else {
                showAlert("Subtraction done succesfully!\n");

            }
        }
    }

    @FXML
    private void multiply(ActionEvent event) {
        if (collector.collectionLength() < 2) {
            showAlert("You didn't insert at least two operands ");
            return;
        }
        ComplexNumber result = Calculator.multiplication(collector.remove(), collector.remove());
        if (result != null) {
            pushIntoStack(result);
            showAlert("Multiplication done succesfully!\n");

        } else {
            showAlert("Error during Multiplication!");
        }
    }

    @FXML
    private void division(ActionEvent event) {
        if (collector.collectionLength() < 2) {
            showAlert("You didn't insert at least two operands ");
            return;
        }
        ComplexNumber divisor = collector.remove();
        ComplexNumber result = Calculator.division(collector.remove(), divisor);
        if (result != null) {
            pushIntoStack(result);
            showAlert("Division done succesfully!\n");

        } else {
            showAlert("Error during Division!");
        }
    }

    @FXML
    private void sqrt(ActionEvent event) {
        if (collector.collectionLength() < 1) {
            showAlert("You didn't insert at least one operands ");
            return;
        }
        ComplexNumber result = Calculator.squareRoot(collector.remove());
        if (result != null) {
            pushIntoStack(result);
            showAlert("Square Root done succesfully!\n");

        } else {
            showAlert("Error during Square Root!");
        }
    }
    
    /**
    * It allows the calls to the Invert sign operation of the class Calculator pushing the result into the stack.
    * <p> <!-- -->
    * @param event its register the event
    * @see MyOperandCollection
    */
    @FXML
    private void invertSign(ActionEvent event) {
        if (collector.collectionLength() < 1) {
            showAlert("You didn't insert at least one operands ");
            return;
        }
        ComplexNumber result = Calculator.invertSign(collector.remove());
        if (result != null) {
            pushIntoStack(result);
            showAlert("Invert sign done succesfully!");

        } else {
            showAlert("Error during Square Root!");
        }
    }


  
    /**
    * It call the MyOperandCollection's clear function, 
    * if the function returns false the collection is already empty and
    * an error message is shown, otherwise, if it is not empty, a confirmation message is shown.
    * @param event An Event representing some type of action.
    * <p> <!-- -->
    */
    @FXML
    private void clear(ActionEvent event) {
        if(!collector.clear()) {
            showAlert("Collection already empty!\n");
        } else {
            showAlert("Clear operation executed succesfully!");
            OperandsTable.refresh();
        }
    }
    
    /**
    * It call the MyOperandCollection's over function, 
    * if the function returns 
    * an error message is shown.
    * @param event An Event representing some type of action.
    * <p> <!-- -->
    */
    @FXML
    private void over(ActionEvent event) {
         if (!collector.over()) {
            showAlert("Not enough inserted operands!\n");
        } else {
            showAlert("Over operation executed succesfully!");
             OperandsTable.refresh();
        }
    }
    /**
    * It call the MyOperandCollection's drop function, 
    * if the function returns false
    * an error message is shown.
    * @param event An Event representing some type of action.
    * <p> <!-- -->
    */
    @FXML
    private void drop(ActionEvent event) {
         if (!collector.drop()) {
            showAlert("Not enough inserted operands!\n");
        } else {
            showAlert("Drop operation executed succesfully!");
             OperandsTable.refresh();
        }
    }
    
    /**
    * It duplicate the last number inserted inside the collection.
    * <p> <!-- -->
    * @param event its register the event
    * @return true if the element was add, otherwise false
    * @see MyOperandCollection
    */
    @FXML
    private void dup(ActionEvent event) {
        if (!collector.dup()) {
            showAlert("Not enough inserted operands!\n");
        } else {
            showAlert("Dup operation executed succesfully!");
            OperandsTable.refresh();
        }
    }
    
    /**
    * It calls the swap operation of MyOperandCollection and check the boolean returned.
    * If the value returned from the called function is true, it means the operation has been perfrormed correctly and so a message will be shown to user.
    * If the value returned from the called function is false, it means the operation has not been performed and so an error message will be shown to user. 
    * <p> <!-- -->
    * @param event the event of the presses of the button swap.
    * @see OperandCollection
    */
    @FXML
    private void swap(ActionEvent event) {
        if (!collector.swap()){
            showAlert("Not enough inserted operands!");
        }
        else {
            showAlert("Swap operation completed successfully!");
            OperandsTable.refresh();
        }
        
    }

    /**
    * This function is associated with the button for saving the last operand in a variable writed in the user interface
    * It check: if there is an operand in the stack and takes the text from the variable's text area and checks if it's not null, after it calls the saveToVariable 
    * method of class variables passing it the text (the variable written). If the variable is written correctly and
    * the associated value exists, it is pushed into the variable
    * otherwise error messages will be shown. 
    * <p> <!-- -->
    * @param event the event of the presses of the button to save from a variable.
    * @see OperandCollection
    */
    @FXML
    private void saveToVariable(ActionEvent event) {
        ComplexNumber tmp = this.collector.last();
        if(tmp != null){
            String variable = varTextArea.getText();
            if(!("".equals(variable))){
                if(!this.vars.saveToVariable(variable, tmp))
                    showAlert("the operation is failed!\n");
                else{
                    showAlert("the last operand is saved in the writed variable!\n");
                    this.collector.remove();
                    OperandsTable.refresh();
                }
            }else
                showAlert("write the variable where save the values!\n");
        }else
            showAlert("insert at least an operand before execute this operation!\n");
            
    }
    
    /**
    * This function is associated with the button for saving from a variable of the user interface
    * It takes the text from the variable's text area and checks if it's not null, after it calls the saveFromVariable method of class variables
    * passing it the text (the variable written). If the variable is written correctly and the associated value exists, it is pushed into the stack
    * otherwise error messages will be shown. 
    * <p> <!-- -->
    * @param event the event of the presses of the button to save from a variable.
    * @see OperandCollection
    */
    @FXML
    private void saveFromVariable(ActionEvent event) {
        String text = varTextArea.getText();
        if ("".equals(text)) {
            showAlert("Write a variable before press this button!");
        } else {
            ComplexNumber topush = vars.saveFromVariable(text);
            if(topush == null)
                showAlert("This variable can't be used, it is not correct or initialized!");
            else{
                pushIntoStack(topush);
                showAlert("Value from variable inserted correctly");
            }                
        }
    }
    
    
    /**
    * This function is associated with the button to subtract from a variable 
    * written in the text area of the user interface the value of the last inserted operand
    * if there is at least one, and if the specified variable has a value already associated
    * It takes the text from the variable's text area and checks if it's not null, after it calls the subtractToVariable method of class Variables
    * passing it. If the operation could be performed, the last operand is removed from the stack,
    * otherwise error messages will be shown. 
    * <p> <!-- -->
    * @param event the event of the presses of the button to subtract to a variable the value of the last inserted operand.
    * @see OperandCollection, CompelxNumber
    */
    @FXML
    private void subtractToVariable(ActionEvent event) {
        ComplexNumber subtracting = collector.last();
        if(subtracting != null){
            String v = varTextArea.getText();
            if(!("".equals(v))){
                if(!vars.subtractToVariable(v, subtracting))
                    showAlert("the operation is failed");
                else{
                    showAlert("the result will be saved in the variable " + v);
                    this.collector.remove();
                    OperandsTable.refresh();
                }
            }else
                showAlert("Specify a variable before click this button!");
        }else
            showAlert("Insert at least an operand to execute this operation!");
    }
    /**
    * This function is associated with the button to add to a variable 
    * written in the text area of the user interface the value of the last inserted operand
    * if there is at least one, and if the specified variable has a value already associated
    * It takes the text from the variable's text area and checks if it's not null, after it calls the addToVariable method of class Variables
    * passing it. If the operation could be performed, the last operand is removed from the stack,
    * otherwise error messages will be shown. 
    * <p> <!-- -->
    * @param event the event of the presses of the button to add to a variable the value of the last inserted operand.
    * @see OperandCollection, CompelxNumber
    */
    @FXML
    private void addToVariable(ActionEvent event) {
         ComplexNumber adding = collector.last();
        if(adding != null){
            String v = varTextArea.getText();
            if(!("".equals(v))){
                if(!vars.addToVariable(v, adding))
                    showAlert("the operation is failed");
                else{
                    showAlert("the result will be saved in the variable " + v);
                    this.collector.remove();
                    OperandsTable.refresh();
                }
            }
            else
                showAlert("Specify a variable before click this button!");
        }
        else
            showAlert("Insert at least an operand to execute this operation!");
    }

    @FXML
    private void executeOperation(ActionEvent event) {
        String OpName = nameOperationTextArea.getText();
        if ("".equals(OpName))
            showAlert("Write the name of the operation to execute");
        else{
            Command currcomm = userCommand.getUserCommand(OpName);
            if(currcomm == null)
                showAlert("Operation not exists");
            else{
                boolean res = inv.execute(currcomm);
                if(!res){
                    showAlert("Operation can't be performed");
                }
                else
                    showAlert("Operation done succesfully");
            }
        }
    }

    

    /**
    * This function is associated with the button enter operation in order to avoid the user to store
    * a personalized operation defining its name and its definition. 
    * <p> <!-- -->
    * @param event the event of the presses of the button to save a new user defined operation.
    * @see HashCommandTable
    */
    @FXML
    private void enterOperation(ActionEvent event) {
        String operationName = nameOperationTextArea.getText();
        String sequenceDefinition = operationTextArea.getText();
        if(operationName.matches("[a-zA-Z0-9]*")){
            
                
            if(userCommand.createPersonalizedCommand(sequenceDefinition, operationName)){
                showAlert("Operation saved succesfully");
                operationTextArea.clear();
            }
            else
                showAlert("The operation could not be saved");
        }
        else
            showAlert("The name inserted for the operation is not correct");
    }

    @FXML
    private void deleteOperation(ActionEvent event) {
        String OpName = nameOperationTextArea.getText();
        if ("".equals(OpName))
            showAlert("Write the name of the operation to delete");
        else{
           if(userCommand.delete(OpName))
            showAlert("Operation delete succesfully");
           else{
               showAlert("Operation not found");
           }
        }
    }

    /**
    * This function allows to show in the apposit text area the operations that compose 
    * the operation writes in relative text area so you can view modify that(if exists).
    * <p> <!-- -->
    * @param event the event of the presses of the button to save a new user defined operation.
    * @see HashCommandTable
    */
    @FXML
    private void showOperation(ActionEvent event) {
        String operationName = nameOperationTextArea.getText();
        ConcreteCommandPersonalized command = (ConcreteCommandPersonalized)userCommand.getUserCommand(operationName);
        if(command != null)
            operationTextArea.setText(command.getCommands());       
        else
            showAlert("Operation not found");
    }


}
