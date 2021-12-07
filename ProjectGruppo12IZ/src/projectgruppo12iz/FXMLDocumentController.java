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
import java.awt.Desktop;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
    Variables vars = new Variables();
    HashCommandTable userCommand = new HashCommandTable(collector, vars);
    PauseTransition pause = new PauseTransition(Duration.seconds(5));
    Invoker inv = new Invoker();
    FadeTransition fadeIn = new FadeTransition(Duration.millis(1000));
    int last = 0;
    @FXML
    private AnchorPane baseAnchorPane;
    @FXML
    private TextArea textArea;
    @FXML
    private Button buttonTwo;
    @FXML
    private Button buttonFour;
    @FXML
    private Button buttonThree;
    @FXML
    private Button buttonOne;
    @FXML
    private Button buttonFive;
    @FXML
    private Button buttonSix;
    @FXML
    private Label errorLabel;

    private ObservableList<ComplexNumber> latestOperands;
    @FXML
    private AnchorPane varAnchorPane;
    @FXML
    private ToggleButton VariableToggleButton;
    @FXML
    private AnchorPane operationAnchorPane;
    @FXML
    private TableView<ComplexNumber> OperandsTable;
    @FXML
    private TableColumn<ComplexNumber, String> OperandsClm;
    @FXML
    private Button buttonSeven;
    @FXML
    private Button buttonEight;
    @FXML
    private Button buttonNine;
    @FXML
    private Button buttonTen;
    @FXML
    private Button buttonEleven;
    @FXML
    private Button buttonTwelve;
    @FXML
    private Button enterButton;
    @FXML
    private HBox fourthHBox;
    @FXML
    private HBox firstHBox;
    @FXML
    private HBox secondHBox;
    @FXML
    private HBox thirdHBox;
    @FXML
    private VBox externalVBox;
    @FXML
    private TextArea nameOperationTextArea;
    @FXML
    private VBox operationVBox;

    ArrayList<Button> myButtonArray = new ArrayList<>();

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");

    }

    public MyOperandCollection getCollector() {
        return collector;
    }

    private void moveAnchor(boolean flag) {
        TranslateTransition slide = new TranslateTransition(Duration.seconds(0.4), varAnchorPane);

        if (flag) {
            slide.setFromX(0);
            slide.setToX(200);
            slide.setRate(1);
            slide.play();

        } else {
            slide.setFromX(200);
            slide.setToX(0);

            slide.setRate(1);
            slide.play();

        }

    }

    private void moveAnchorOperation(boolean anchorFlag) {
        TranslateTransition slide = new TranslateTransition(Duration.seconds(0.4), externalVBox);
        TranslateTransition slide2 = new TranslateTransition(Duration.seconds(0.4), operationVBox);

        if (anchorFlag) {
            slide.setFromY(0);
            slide.setToY(60);
            slide2.setFromY(0);
            slide2.setToY(110);
            slide.setRate(1);
            slide.play();
            slide2.setRate(1);
            slide2.play();

        } else {
            slide.setFromY(externalVBox.getTranslateY());
            slide.setToY(0);
            slide2.setFromY(operationVBox.getTranslateY());
            slide2.setToY(0);
            slide.setRate(1);
            slide.play();
            slide2.setRate(1);
            slide2.play();

        }

    }

    public void showButton(int[] index) {
        Button myBtn;
        for (int i = 0; i < index.length; i++) {
            myBtn = myButtonArray.get(index[i]);
            System.out.print("forse show " + myBtn + myBtn.isVisible());
            if (!myBtn.isVisible()) {
                fadeIn.setRate(1);
                fadeIn.setFromValue(0);
                fadeIn.setToValue(1);
                fadeIn.setCycleCount(1);
                fadeIn.setNode(myBtn);
                fadeIn.play();
                myBtn.setVisible(true);
            } else {
                System.out.println("notshow");
            }
        }

    }

    public void hideButton(int[] index) {
        Button myBtn;
        for (int i = 0; i < index.length; i++) {
            myBtn = myButtonArray.get(index[i]);
            System.out.print("forse hide " + myBtn + myBtn.isVisible());
            if (myBtn.isVisible()) {
                fadeIn.setRate(1);
                fadeIn.setFromValue(1);
                fadeIn.setToValue(0);
                fadeIn.setNode(myBtn);
                fadeIn.play();
                myBtn.setVisible(false);
                System.out.println("hide");

            } else {
                System.out.println("npothide");
            }
        }
    }

    public void showAlert(String error) {
        errorLabel.setText(error);
        pause.stop();
        pause.setOnFinished(e -> errorLabel.setText(null));
        pause.play();
    }

    /**
     * It insert the element passed as param in the collection.
     * <p>
     * <!-- --> @param num it's the ComplexNumber to insert in the collection
     *
     * @return true if the element was add, otherwise false
     * @see MyOperandCollection
     */
    public boolean pushIntoStack(ComplexNumber num) {
        collector.insert(num);
        OperandsTable.refresh();
        return true;

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        myButtonArray.add(buttonOne);
        myButtonArray.add(buttonTwo);
        myButtonArray.add(buttonThree);
        myButtonArray.add(buttonFour);
        myButtonArray.add(buttonFive);
        myButtonArray.add(buttonSix);
        myButtonArray.add(buttonSeven);
        myButtonArray.add(buttonEight);
        myButtonArray.add(buttonNine);
        myButtonArray.add(buttonTen);
        myButtonArray.add(buttonEleven);
        myButtonArray.add(buttonTwelve);
        myButtonArray.add(enterButton);
        latestOperands = FXCollections.observableList(collector.getL());
        OperandsClm.setCellValueFactory(new PropertyValueFactory<>("complexString"));
        setOpView(latestOperands);

        VariableToggleButton.setOnMouseClicked(event -> {

            moveAnchor(VariableToggleButton.isSelected());

        });
    }

    public void setOpView(ObservableList<ComplexNumber> latestOperands) {
        OperandsTable.setItems(latestOperands);

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
     * It allows the calls to the subtraction operation of the class Calculator
     * pushing the result into the stack.
     * <p>
     * <!-- --> @param event it registers the event
     *
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
     * It allows the calls to the Invert sign operation of the class Calculator
     * pushing the result into the stack.
     * <p>
     * <!-- --> @param event its register the event
     *
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
     * It call the MyOperandCollection's clear function, if the function returns
     * false the collection is already empty and an error message is shown,
     * otherwise, if it is not empty, a confirmation message is shown.
     *
     * @param event An Event representing some type of action.
     * <p>
     * <!-- -->
     */
    @FXML
    private void clear(ActionEvent event) {
        if (!collector.clear()) {
            showAlert("Collection already empty!\n");
        } else {
            showAlert("Clear operation executed succesfully!");
            OperandsTable.refresh();
        }
    }

    /**
     * It call the MyOperandCollection's over function, if the function returns
     * an error message is shown.
     *
     * @param event An Event representing some type of action.
     * <p>
     * <!-- -->
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
     * It call the MyOperandCollection's drop function, if the function returns
     * false an error message is shown.
     *
     * @param event An Event representing some type of action.
     * <p>
     * <!-- -->
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
     * <p>
     * <!-- --> @param event its register the event
     *
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
     * It calls the swap operation of MyOperandCollection and check the boolean
     * returned. If the value returned from the called function is true, it
     * means the operation has been perfrormed correctly and so a message will
     * be shown to user. If the value returned from the called function is
     * false, it means the operation has not been performed and so an error
     * message will be shown to user.
     * <p>
     * <!-- --> @param event the event of the presses of the button swap.
     *
     * @see OperandCollection
     */
    @FXML
    private void swap(ActionEvent event) {
        if (!collector.swap()) {
            showAlert("Not enough inserted operands!");
        } else {
            showAlert("Swap operation completed successfully!");
            OperandsTable.refresh();
        }

    }

    @FXML
    private void saveVariablesIntoStack(ActionEvent event) {
    }

    @FXML
    private void saveUserOperationToFile(ActionEvent event) {
    }

    @FXML
    private void restoreVariablesFromStack(ActionEvent event) {
    }

    @FXML
    private void restoreUserOperationFromFile(ActionEvent event) {
    }

    @FXML
    private void about(ActionEvent event) {
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/CamillaSpi/ProjectGruppo12IZ").toURI());
        } catch (IOException | URISyntaxException e) {
        }
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
    private void undo(ActionEvent event) {
    }

    @FXML
    private void showStandard(ActionEvent event) {
        /*showButton(buttonEleven);
        showButton(buttonTwo);
        showButton(buttonFive);
        showButton(buttonTen);
        showButton(buttonEleven);
        showButton(buttonTwelve);
        showButton(buttonFour);
        showButton(buttonFive);
        showButton(buttonSix);
        showButton(buttonSeven);
        showButton(buttonEight);
        showButton(buttonNine);
*/
        showButton(new int[] {0,1,2,3,4,5,6,7,8,9,10,11});
        VariableToggleButton.setSelected(false);
        moveAnchor(VariableToggleButton.isSelected());
        System.out.println("\n\n");
        moveAnchorOperation(false);
    }

    @FXML
    private void showVariables(ActionEvent event) {
        /*showButton(buttonFour);
        showButton(buttonSix);
        hideButton(buttonTwo);
        hideButton(buttonFive);
        hideButton(buttonTen);
        hideButton(buttonEleven);
        hideButton(buttonTwelve);
        hideButton(buttonSeven);
        hideButton(buttonEight);
        hideButton(buttonNine);
*/
        
        hideButton(new int[] {1,4,6,7,8,9,10,11,12});
        VariableToggleButton.setSelected(false);
        moveAnchor(VariableToggleButton.isSelected());
        moveAnchorOperation(false);
        System.out.println("\n\n");
    }

    @FXML
    private void showOperations(ActionEvent event) {
       /* hideButton(buttonTen);
        hideButton(buttonEleven);
        hideButton(buttonTwelve);
        hideButton(buttonFour);
        hideButton(buttonFive);
        hideButton(buttonSix);
        hideButton(buttonSeven);
        hideButton(buttonEight);
        hideButton(buttonNine);
        showButton(buttonTwo);
*/
        showButton(new int[] {0,1,2});
        hideButton(new int[] {3,4,5,6,7,8,9,10,11});
        VariableToggleButton.setSelected(false);
        moveAnchor(VariableToggleButton.isSelected());
        System.out.println("\n\n");
        moveAnchorOperation(true);

    }

    public void refresh() {
        OperandsTable.refresh();
    }

    public String getText() {
        return this.textArea.getText();
    }
    public void setText(String value) {
        this.textArea.setText(value);
    }

    public String getOperationName() {
        return this.nameOperationTextArea.getText();
    }

    public HashCommandTable getuserCommand() {
        return this.userCommand;
    }

    public void clearText() {
        textArea.clear();
    }
    public void clearNameText() {
        nameOperationTextArea.clear();
    }

    public Variables getVariables() {
        return this.vars;
    }

    public void changeButtonText(int index, String value) {
        myButtonArray.get(index).setText(value);
    }
    public Invoker getInvoker(){
        return this.inv;
    }

}
