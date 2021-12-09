/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgruppo12iz;

import commandClassPackage.ClearCommand;
import commandClassPackage.*;
import commandClassPackage.HashCommandTable;
import commandClassPackage.Invoker;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import modelClassPackage.ComplexNumber;
import modelClassPackage.MyOperandCollection;
import modelClassPackage.Variables;
import stateClassPackage.State;
import stateClassPackage.StateOperations;
import stateClassPackage.StateStandard;
import stateClassPackage.StateTranscendental;
import stateClassPackage.StateVariables;

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
    State state;
    int last = 0;
    @FXML
    private AnchorPane baseAnchorPane;
    @FXML
    private TextField textArea;
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
    private Button variableButton;
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
    private TextField nameOperationTextArea;
    @FXML
    private VBox operationVBox;

    ArrayList<ButtonBase> myButtonArray = new ArrayList<>();
    @FXML
    private TableView<String> tableOpVar;
    @FXML
    private TableColumn<String, String> nameClm;
    @FXML
    private TableColumn<String, ComplexNumber> contentClm;

    ObservableList<String> varKeys = FXCollections.observableArrayList();
    ObservableList<String> operationKeys = FXCollections.observableArrayList();
    @FXML
    private AnchorPane bottomAnchorPane;
    @FXML
    private ToggleButton ShowBottomAnchorPane;
    @FXML
    private TableColumn<String, ConcreteCommandPersonalized> operationClm;
    @FXML
    private Button openMenuButton;
    @FXML
    private Button closeButton;

    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");

    }

    public MyOperandCollection getCollector() {
        return collector;
    }

    private void moveAnchor(boolean flag) {
        TranslateTransition slide = new TranslateTransition(Duration.seconds(0.4), varAnchorPane);
        if (flag) {
            slide.setFromX(varAnchorPane.getTranslateX());
            slide.setToX(200);
            slide.setRate(1);
            slide.play();
            variableButton.setVisible(false);
        } else {
            slide.setFromX(varAnchorPane.getTranslateX());
            slide.setToX(0);
            variableButton.setText("");
            variableButton.setPrefSize(24, 33);
            slide.setRate(1);
            slide.play();
            slide.setOnFinished(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    variableButton.setVisible(true);
                }
            });

        }

    }

    private void moveAnchorOperation(boolean anchorFlag) {
        TranslateTransition slide = new TranslateTransition(Duration.seconds(0.4), externalVBox);
        TranslateTransition slide2 = new TranslateTransition(Duration.seconds(0.4), operationVBox);
        if (anchorFlag) {
            slide.setFromY(externalVBox.getTranslateY());
            slide.setToY(60);
            slide2.setFromY(operationVBox.getTranslateY());
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

    private void moveBottomAnchorPane(boolean anchorFlag) {
        TranslateTransition slide = new TranslateTransition(Duration.seconds(0.4), bottomAnchorPane);
        if (anchorFlag) {
            slide.setFromY(bottomAnchorPane.getTranslateY());
            slide.setToY(350);
            slide.setRate(1);
            slide.play();

        } else {
            slide.setFromY(bottomAnchorPane.getTranslateY());
            slide.setToY(0);
            slide.setRate(1);
            slide.play();

        }
    }

    private void moveTextArea(boolean anchorFlag) {
        TranslateTransition slide = new TranslateTransition(Duration.seconds(0.4), textArea);
        if (anchorFlag) {
            slide.setFromX(textArea.getTranslateX());
            slide.setToX(40);
            slide.setRate(1);
            slide.play();

        } else {
            slide.setFromX(textArea.getTranslateX());
            slide.setToX(0);
            slide.setRate(1);
            slide.play();

        }
    }

    public void showButton(int[] index) {
        ButtonBase myBtn;
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
        ButtonBase myBtn;
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
        bottomAnchorPane.setTranslateY(350);
        state = new StateStandard(this);
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
        myButtonArray.add(ShowBottomAnchorPane);
        ShowBottomAnchorPane.setVisible(false);
        latestOperands = FXCollections.observableList(collector.getL());
        OperandsClm.setCellValueFactory(new PropertyValueFactory<>("complexString"));
        setOpView(latestOperands);

        variableButton.setOnMouseClicked(event -> {

            moveAnchor(true);

        });
        ShowBottomAnchorPane.setOnMouseClicked(event -> {

            moveBottomAnchorPane(!ShowBottomAnchorPane.isSelected());

        });
        textArea.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    //"press" enter button for staetOperations or Standard
                    if (state instanceof StateOperations) {
                        ((StateOperations) state).onButtonEnter();
                    } else if (state instanceof StateStandard) {
                        ((StateStandard) state).onButtonEnter();
                    } else {
                        ((StateTranscendental) state).onButtonEnter();
                    }
                }

            }
        });
        nameOperationTextArea.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    //"press" execute button only in stateOperations
                    if (state instanceof StateOperations) {
                        ((StateOperations) state).onButtonThree();
                    }
                }
            }
        });

        vars.getMyVariables().addListener((MapChangeListener.Change<? extends String, ? extends ComplexNumber> change) -> {
            boolean removed = change.wasRemoved();
            if (removed != change.wasAdded()) {
                // no put for existing key
                if (removed) {
                    varKeys.remove(change.getKey());
                } else {
                    varKeys.add(change.getKey());
                }
            }
        });
        userCommand.getMyCommandHash().addListener((MapChangeListener.Change<? extends String, ? extends ConcreteCommandPersonalized> change) -> {
            boolean removed = change.wasRemoved();
            if (removed != change.wasAdded()) {
                // no put for existing key
                if (removed) {
                    operationKeys.remove(change.getKey());
                } else {
                    operationKeys.add(change.getKey());
                }
            }
        });

        nameClm.setCellValueFactory(cd -> Bindings.createStringBinding(() -> cd.getValue()));

        contentClm.setCellValueFactory(cd -> Bindings.valueAt(vars.getMyVariables(), cd.getValue()));
        operationClm.setCellValueFactory(cd -> Bindings.valueAt(userCommand.getMyCommandHash(), cd.getValue().toString()));
        tableOpVar.getColumns().setAll(nameClm, contentClm, operationClm);
        nameOperationTextArea.setPromptText("Name");
    }

    public void setOpView(ObservableList<ComplexNumber> latestOperands) {
        OperandsTable.setItems(latestOperands);

    }

    /**
     * It calls the method implemented in the classes State named onButtonTwo(),
     * the execution of this method depends on the current state. So for the
     * StateStandard the AddCommand will be executed if possible, for the
     * StateVariables this button is not shown so it could not be pressed for
     * the StateOperations the UserDefined operation specified will be executed
     * if possible.
     * <p>
     * <!-- --> @param event it registers the event of the click of the button
     * in fourth position
     *
     * @see StateOperations, StateStandard, StateVariables
     */
    @FXML
    private void add(ActionEvent event) throws InterruptedException {
        if (this.state instanceof StateOperations) {
            ((StateOperations) this.state).onButtonTwo();
        } else {
            ((StateStandard) this.state).onButtonTwo();
        }
    }

    /**
     * It create a new SubtractCommand and calls the execute method on it if it
     * is possible. If the Operation could not be performed because there are
     * not at least two operands an error message will be shown.
     *
     * @param event the event of the presses of the button sub.
     * <p>
     * <!-- --> @see SubCommand
     */
    @FXML
    private void sub(ActionEvent event) {
        SubtractCommand subComm = new SubtractCommand(collector);
        if (subComm != null && commandExecute(subComm)) {
            showAlert("Subtract done succesfully!");
            refresh();
        } else {
            showAlert("Subtract cannot be performed,\nhave you insert at least two operands?");
        }
    }

    /**
     * It calls the method implemented in the classes State named onButtonOne(),
     * the execution of this method depends on the current state. So for the
     * StateStandard the MultiplyCommand will be executed if possible, for the
     * StateVariables the SaveToVariableCommand will be executed if possible for
     * the StateOperations the Delete of the specified operation will be
     * performed if possible.
     * <p>
     * <!-- --> @param event it registers the event of the click of the button
     * in first position
     *
     * @see StateOperations, StateStandard, StateVariables
     */
    @FXML
    private void multiply(ActionEvent event) {
        this.state.onButtonOne();
    }

    /**
     * It calls the method implemented in the classes State named
     * onButtonFour(), the execution of this method depends on the current
     * state. So for the StateStandard the DivisionCommand will be executed if
     * possible, for the StateVariables the AddToVariableCommand will be
     * executed if possible for the StateOperations this button is not shown so
     * it could not be pressed.
     * <p>
     * <!-- --> @param event it registers the event of the click of the button
     * in fourth position
     *
     * @see StateOperations, StateStandard, StateVariables
     */
    @FXML
    private void division(ActionEvent event) {
        if (this.state instanceof StateVariables) {
            ((StateVariables) this.state).onButtonFour();
        } else if (this.state instanceof StateTranscendental) {
            ((StateTranscendental) this.state).onButtonFour();
        } else {
            ((StateStandard) this.state).onButtonFour();
        }
    }

    /**
     * It create a new sqrtCommand and calls the execute method on it if it is
     * possible. If the Operation could not be performed because there aren't
     * any operands an error message will be shown.
     *
     * @param event the event of the presses of the button sqrt.
     * <p>
     * <!-- --> @see DropCommand
     */
    @FXML
    private void sqrt(ActionEvent event) {
        ((StateStandard) this.state).onButtonFive();
    }

    /**
     * It create a new InvertSignCommand and calls the execute method on it if
     * it is possible. If the Operation could not be performed because there are
     * no operand inserted an error message will be shown.
     *
     * @param event the event of the presses of the button invertSign.
     * <p>
     * <!-- --> @see InvertSignCommand
     */
    @FXML
    private void invertSign(ActionEvent event) {
        InvertSignCommand invsignComm = new InvertSignCommand(collector);
        if (invsignComm != null && commandExecute(invsignComm)) {
            showAlert("Square Root done succesfully!");
            refresh();
        } else {
            showAlert("Square Root cannot be performed,\nhave you insert at least one operands?");
        }
    }

    /**
     * It create a new ClearCommand and calls the execute method on it if it is
     * possible. If the Operation could not be performed because there are no
     * operands an error message will be shown.
     *
     * @param event the event of the presses of the button clear.
     * <p>
     * <!-- --> @see ClearCommand
     */
    @FXML
    private void clear(ActionEvent event) {
        ClearCommand clearComm = new ClearCommand(this.collector);
        if (clearComm != null && commandExecute(clearComm)) {
            showAlert("Clear Operation done succesfully!");
            refresh();
        } else {
            showAlert("Clear operation cannot be performed!\n Have you inserted any operand?");
        }
    }

    /**
     * It create a new OverCommand and calls the execute method on it if it is
     * possible. If the Operation could not be performed because there not at
     * least two operands an error message will be shown.
     *
     * @param event the event of the presses of the button over.
     * <p>
     * <!-- --> @see OverCommand
     */
    @FXML
    private void over(ActionEvent event) {
        OverCommand overComm = new OverCommand(this.collector);
        if (overComm != null && commandExecute(overComm)) {
            showAlert("Over Operation done succesfully!");
            refresh();
        } else {
            showAlert("Over operation cannot be performed!\n Have you inserted at least two operands?");
        }
    }

    /**
     * It calls the method implemented in the classes State named onButtonSix(),
     * the execution of this method depends on the current state. So for the
     * StateStandard the SquareRootCommand will be executed if possible, for the
     * StateVariables the SubtractToVariableCommand will be executed if possible
     * for the StateOperations this button is not shown so it could not be
     * pressed.
     * <p>
     * <!-- --> @param event it registers the event of the click of the button
     * in sixth position
     *
     * @see StateOperations, StateStandard, StateVariables
     */
    @FXML
    private void drop(ActionEvent event) {
        if (this.state instanceof StateVariables) {
            ((StateVariables) this.state).onButtonSix();
        } else if (this.state instanceof StateTranscendental) {
            ((StateTranscendental) this.state).onButtonSix();
        } else {
            DropCommand dropComm = new DropCommand(this.collector);
            if (dropComm != null && commandExecute(dropComm)) {
                showAlert("Drop Operation done succesfully!");
                refresh();
            } else {
                showAlert("Drop operation cannot be performed!\n Have you inserted any operand?");
            }
        }

    }

    /**
     * It create a new DupCommand and calls the execute method on it if it is
     * possible. If the Operation could not be performed because there not at
     * least one operand an error message will be shown.
     *
     * @param event the event of the presses of the button dup.
     * <p>
     * <!-- --> @see DupCommand
     */
    @FXML
    private void dup(ActionEvent event) {
        DupCommand dupComm = new DupCommand(this.collector);
        if (dupComm != null && commandExecute(dupComm)) {
            showAlert("Dup Operation done succesfully!");
            refresh();
        } else {
            showAlert("Dup operation cannot be performed!\n Have you inserted any operand?");
        }
    }

    /**
     * It calls the method implemented in the classes State named
     * onButtonThree(), the execution of this method depends on the current
     * state. So for the StateStandard the AddCommand will be executed if
     * possible, for the StateVariables the SaveFromVariableCommand will be
     * executed if possible for the StateOperations the Show of the operation
     * will be performed if possible.
     * <p>
     * <!-- --> @param event it registers the event of the click of the button
     * in Third position
     *
     * @see StateOperations, StateStandard, StateVariables
     */
    @FXML
    private void swap(ActionEvent event) {
        this.state.onButtonThree();
    }

    @FXML
    private void saveVariablesIntoStack(ActionEvent event) {
        if (vars.saveVariablesIntoStack()) {
            showAlert("Tt appsot");
        } else {
            showAlert("idk what is success");
        }
    }

    @FXML
    private void saveUserOperationToFile(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Open ");
        File file = fc.showOpenDialog(this.baseAnchorPane.getScene().getWindow());
        SaveService thread = new SaveService(file, this.userCommand);
        thread.setOnSucceeded(e -> this.showAlert("operations saved successfully"));
        thread.setOnFailed(e -> this.showAlert("operations not saved"));
        thread.start();
    }

    @FXML
    private void restoreVariablesFromStack(ActionEvent event) {
        if (vars.restoreVariablesFromStack()) {
            showAlert("Tt appsot");
            tableOpVar.refresh();
        } else {
            showAlert("idk what is success");
        }
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
        if (state instanceof StateOperations) {
            ((StateOperations) state).onButtonEnter();
        } else if (state instanceof StateStandard) {
            ((StateStandard) state).onButtonEnter();
        } else {
            ((StateTranscendental) state).onButtonEnter();
        }
    }

    @FXML
    private void undo(ActionEvent event) {
        inv.undoLast();
        refresh();
    }

    @FXML
    private void showStandard(ActionEvent event) {

        moveAnchor(false);
        moveAnchorOperation(false);
        ShowBottomAnchorPane.setSelected(false);
        moveBottomAnchorPane(!ShowBottomAnchorPane.isSelected());
        moveTextArea(false);
        this.state.setStateStandard();
    }

    @FXML
    private void showVariables(ActionEvent event) {
        moveAnchor(false);
        moveTextArea(true);
        moveAnchorOperation(false);
        tableOpVar.setItems(varKeys);
        operationClm.setVisible(false);
        contentClm.setVisible(true);

        ShowBottomAnchorPane.setSelected(false);
        moveBottomAnchorPane(!ShowBottomAnchorPane.isSelected());
        this.state.setStateVariables();
    }

    @FXML
    private void showOperations(ActionEvent event) {
        moveAnchor(false);
        moveAnchorOperation(true);
        moveTextArea(false);
        tableOpVar.setItems(operationKeys);
        operationClm.setVisible(true);
        contentClm.setVisible(false);

        ShowBottomAnchorPane.setSelected(false);
        moveBottomAnchorPane(!ShowBottomAnchorPane.isSelected());

        this.state.setStateOperations();
    }

    @FXML
    private void showTranscendental(ActionEvent event) {
        moveAnchor(false);
        moveAnchorOperation(false);
        ShowBottomAnchorPane.setSelected(false);
        moveBottomAnchorPane(!ShowBottomAnchorPane.isSelected());
        moveTextArea(false);
        this.state.setStateTranscendetal();
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

    public Invoker getInvoker() {
        return this.inv;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean commandExecute(Command command) {
        return inv.execute(command);
    }

    public void refreshVarsOp() {
        this.tableOpVar.refresh();
    }

    @FXML
    private void closeSideMenu(ActionEvent event) {
        moveAnchor(false);
    }

    @FXML
    private void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
