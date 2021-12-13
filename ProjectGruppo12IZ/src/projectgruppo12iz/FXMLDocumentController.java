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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.MapChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.control.ButtonType;
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

    private final MyOperandCollection collector = new MyOperandCollection(12);
    private final Variables vars = new Variables();
    private final HashCommandTable userCommand = new HashCommandTable(collector, vars);
    private final PauseTransition pause = new PauseTransition(Duration.seconds(5));
    private final Invoker inv = new Invoker();
    private final FadeTransition fadeIn = new FadeTransition(Duration.millis(1000));
    private State state;
    private final ObservableList<String> varKeys = FXCollections.observableArrayList();
    private final ObservableList<String> operationKeys = FXCollections.observableArrayList();
    private ObservableList<ComplexNumber> latestOperands;
    private final ArrayList<ButtonBase> myButtonArray = new ArrayList<>();
    private final ArrayList<ToggleButton> myToggleButtonArray = new ArrayList<>();

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
    @FXML
    private TableView<String> tableOpVar;
    @FXML
    private TableColumn<String, String> nameClm;
    @FXML
    private TableColumn<String, ComplexNumber> contentClm;
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
    @FXML
    private ToggleButton standardsToggle;
    @FXML
    private ToggleButton variablesToggle;
    @FXML
    private ToggleButton operationsToggle;
    @FXML
    private ToggleButton transcendentalToggle;

    /**
     * <p>
     * This function create a TranslateTransition that move the "varAnchorPane"
     * in base of value flag.
     *
     * </p>
     * <!-- -->
     *
     * @param flag if true move the anchor pane in the screen, else it take it
     * outside.
     */
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
            slide.setRate(1);
            slide.play();
            slide.setOnFinished((ActionEvent event) -> {
                variableButton.setVisible(true);
            });

        }

    }

    /**
     * <p>
     * This function create a TranslateTransition that move the "externalVBox"
     * and a TranslateTransition to move "operationVBox" in base of value flag.
     *
     * </p>
     * <!-- -->
     *
     * @param anchorFlag if true move the two VBox in the screen, else it takes
     * it outside.
     */
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

    /**
     * <p>
     * This function create a TranslateTransition that move the
     * "bottomAnchorPane" in base of value flag.
     *
     * </p>
     * <!-- -->
     *
     * @param anchorFlag if true move the "bottomAnchorPane" in the screen, else
     * it takes it outside.
     */
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

    /**
     * <p>
     * This function create a TranslateTransition that move the "textArea" in
     * base of value flag.
     *
     * </p>
     * <!-- -->
     *
     * @param anchorFlag if true move the "textArea" down, else in original
     * place.
     */
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
            slide.setOnFinished((ActionEvent event) -> {
                enterButton.setVisible(true);
            });
        }
    }

    /**
     * <p>
     * This function show the buttons. All the buttons are contained in an
     * array. Hide the buttons which indexes is contained in the array passed
     *
     * </p>
     * <!-- -->
     *
     * @param index An array that contain the indexes of buttons that need to
     * hide
     */
    public void showButton(int[] index) {
        for (int i = 0; i < index.length; i++) {
            myButtonArray.get(index[i]).setVisible(true);
        }
    }

    /**
     * <p>
     * This function hide the buttons. All the buttons are contained in an
     * array. Show the button which index is contained in the array passed
     *
     * </p>
     * <!-- -->
     *
     * @param index An array that contain the indexes of buttons that need to
     * show
     */
    public void hideButton(int[] index) {
        for (int i = 0; i < index.length; i++) {
            myButtonArray.get(index[i]).setVisible(false);
        }
    }

    /**
     * <p>
     * change the text of errorLabel for 5 seconds and after set it to null
     * </p>
     * <!-- -->
     *
     * @param error the strings that need to be displayed in errorLabel
     */
    public void showAlert(String error) {
        errorLabel.setText(error);
        pause.stop();
        pause.setOnFinished(e -> errorLabel.setText(null));
        pause.play();
    }

    public void changeToggleButton(ToggleButton toNotChange) {
        myToggleButtonArray.stream().filter(x -> (x != toNotChange)).forEachOrdered(x -> {
            x.setSelected(false);
        });
    }

    /**
     * <p>
     * It insert the element passed as param in the collection if is possible.
     * </p>
     * <!-- -->
     *
     * @param num ComplexNumber to push into stack
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
        myToggleButtonArray.add(standardsToggle);
        myToggleButtonArray.add(variablesToggle);
        myToggleButtonArray.add(operationsToggle);
        myToggleButtonArray.add(transcendentalToggle);
        myButtonArray.add(ShowBottomAnchorPane);
        ShowBottomAnchorPane.setVisible(false);
        latestOperands = FXCollections.observableList(collector.getL());
        OperandsClm.setCellValueFactory(new PropertyValueFactory<>("complexString"));
        OperandsTable.setItems(latestOperands);

        variableButton.setOnMouseClicked(event -> {

            moveAnchor(true);

        });
        ShowBottomAnchorPane.setOnMouseClicked(event -> {

            moveBottomAnchorPane(!ShowBottomAnchorPane.isSelected());

        });

        textArea.setOnKeyPressed((KeyEvent ke) -> {
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
        });
        nameOperationTextArea.setOnKeyPressed((KeyEvent ke) -> {
            if (ke.getCode().equals(KeyCode.ENTER)) {
                //"press" execute button only in stateOperations
                if (state instanceof StateOperations) {
                    ((StateOperations) state).onButtonThree();
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

    /**
     * <p>
     * It calls the method implemented in the classes State named onButtonOne(),
     * the execution of this method depends on the current state. So for the
     * StateStandard the MultiplyCommand will be executed if possible, for the
     * StateVariables the SaveToVariableCommand will be executed if possible for
     * the StateOperations the Delete of the specified operation will be
     * performed if possible.
     * </p>
     * <!-- --> @param event it registers the event of the click of the button
     * in first position.
     *
     * @see StateOperations, StateStandard, StateVariables
     */
    @FXML
    private void onButtonOne(ActionEvent event) {
        this.state.onButtonOne();
    }

    /**
     * <p>
     * It calls the method implemented in the classes State named onButtonTwo(),
     * the execution of this method depends on the current state. So for the
     * StateStandard the AddCommand will be executed if possible, for the
     * StateVariables this button is not shown so it could not be pressed for
     * the StateOperations the UserDefined operation specified will be executed
     * if possible.
     * </p>
     * <!-- --> @param event it registers the event of the click of the button
     * in fourth position
     *
     * @see StateOperations, StateStandard, StateVariables
     */
    @FXML
    private void onButtonTwo(ActionEvent event) throws InterruptedException {
        if (this.state instanceof StateOperations) {
            ((StateOperations) this.state).onButtonTwo();
        } else {
            ((StateStandard) this.state).onButtonTwo();
        }
    }

    /**
     * <p>
     * It calls the method implemented in the classes State named
     * onButtonThree(), the execution of this method depends on the current
     * state. So for the StateStandard the SwapCommand will be executed if
     * possible, for the StateVariables the SaveFromVariableCommand will be
     * executed if possible for the StateOperations the Show of the operation
     * will be performed if possible.
     * </p>
     * <!-- --> @param event it registers the event of the click of the button
     * in Third position
     *
     * @see StateOperations, StateStandard, StateVariables
     */
    @FXML
    private void onButtonThree(ActionEvent event) {
        this.state.onButtonThree();
    }

    /**
     * <p>
     * It calls the method implemented in the classes State named
     * onButtonFour(), the execution of this method depends on the current
     * state. So for the StateStandard the DivisionCommand will be executed if
     * possible, for the StateVariables the AddToVariableCommand will be
     * executed if possible for the StateOperations this button is not shown so
     * it could not be pressed.
     * </p>
     * <!-- --> @param event it registers the event of the click of the button
     * in fourth position
     *
     * @see StateOperations, StateStandard, StateVariables
     */
    @FXML
    private void onButtonFour(ActionEvent event) {
        if (this.state instanceof StateVariables) {
            ((StateVariables) this.state).onButtonFour();
        } else {
            ((StateStandard) this.state).onButtonFour();
        }
    }

    /**
     * <p>
     * It create a new sqrtCommand and calls the execute method on it if it is
     * possible. If the Operation could not be performed because there aren't
     * any operands an error message will be shown.
     *
     * @param event the event of the presses of the button sqrt.
     * </p>
     * <!-- --> @see SquareRootCommand
     */
    @FXML
    private void onButtonFive(ActionEvent event) {
        SquareRootCommand sqrtComm = new SquareRootCommand(collector);
        if (sqrtComm != null && commandExecute(sqrtComm)) {
            showAlert("Square Root done succesfully!");
            refresh();
        } else {
            showAlert("Square Root cannot be performed!\nHave you insert at least one operand?");
        }
    }

    /**
     * <p>
     * It calls the method implemented in the classes State named onButtonSix(),
     * the execution of this method depends on the current state. So for the
     * StateStandard the DropCommand will be executed if possible, for the
     * StateVariables the SubtractToVariableCommand will be executed if possible
     * for the StateOperations this button is not shown so it could not be
     * pressed.
     * </p>
     * <!-- --> @param event it registers the event of the click of the button
     * in sixth position
     *
     * @see StateOperations, StateStandard, StateVariables
     */
    @FXML
    private void onButtonSix(ActionEvent event) {
        if (this.state instanceof StateVariables) {
            ((StateVariables) this.state).onButtonSix();
        } else {
            ((StateStandard) this.state).onButtonSix();
        }
    }

    /**
     * <p>
     * It create a new SubtractCommand and calls the execute method on it if it
     * is possible. If the Operation could not be performed because there are
     * not at least two operands an error message will be shown.
     *
     * @param event the event of the presses of the button sub.
     * </p>
     * <!-- --> @see SubCommand
     */
    @FXML
    private void onButtonSeven(ActionEvent event) {
        SubtractCommand subComm = new SubtractCommand(collector);
        if (subComm != null && commandExecute(subComm)) {
            showAlert("Subtract done succesfully!");
            refresh();
        } else {
            showAlert("Subtract cannot be performed!\nHave you insert at least two operands?");
        }
    }

    /**
     * <p>
     * It create a new InvertSignCommand and calls the execute method on it if
     * it is possible. If the Operation could not be performed because there are
     * no operand inserted an error message will be shown.
     *
     * @param event the event of the presses of the button invertSign.
     * </p>
     * <!-- --> @see InvertSignCommand
     */
    @FXML
    private void onButtonEight(ActionEvent event) {
        InvertSignCommand invsignComm = new InvertSignCommand(collector);
        if (invsignComm != null && commandExecute(invsignComm)) {
            showAlert("Invert Sign done succesfully!");
            refresh();
        } else {
            showAlert("Invert Sign cannot be performed!\nHave you insert at least one operands?");
        }
    }

    /**
     * <p>
     * It create a new OverCommand and calls the execute method on it if it is
     * possible. If the Operation could not be performed because there not at
     * least two operands an error message will be shown.
     *
     * @param event the event of the presses of the button over.
     * </p>
     * <!-- --> @see OverCommand
     */
    @FXML
    private void onButtonNine(ActionEvent event) {
        OverCommand overComm = new OverCommand(this.collector);
        if (overComm != null && commandExecute(overComm)) {
            showAlert("Over Operation done succesfully!");
            refresh();
        } else {
            showAlert("Over operation cannot be performed!\nHave you inserted at least two operands?");
        }
    }

    /**
     * <p>
     * It create a new DupCommand and calls the execute method on it if it is
     * possible. If the Operation could not be performed because there not at
     * least one operand an error message will be shown.
     *
     * @param event the event of the presses of the button dup.
     * </p>
     * <!-- --> @see DupCommand
     */
    @FXML
    private void onButtonTen(ActionEvent event) {
        DupCommand dupComm = new DupCommand(this.collector);
        if (dupComm != null && commandExecute(dupComm)) {
            showAlert("Dup Operation done succesfully!");
            refresh();
        } else {
            showAlert("Dup operation cannot be performed!\nHave you inserted any operand?");
        }
    }

    /**
     * <p>
     * It create a new ClearCommand and calls the execute method on it if it is
     * possible. If the Operation could not be performed because there are no
     * operands an error message will be shown.
     *
     * @param event the event of the presses of the button clear.
     * </p>
     * <!-- --> @see ClearCommand
     */
    @FXML
    private void onButtonEleven(ActionEvent event) {
        ClearCommand clearComm = new ClearCommand(this.collector);
        if (clearComm != null && commandExecute(clearComm)) {
            showAlert("Clear Operation done succesfully!");
            refresh();
        } else {
            showAlert("Clear operation cannot be performed!\nHave you inserted any operand?");
        }
    }

    /**
     * <p>
     * When the button is pressed the last command will be undo
     * </p>
     * <!-- --> @param event it registers the event of the click of the button
     *
     * @see Command
     */
    @FXML
    private void onButtonTwelve(ActionEvent event) {
        inv.undoLast();
        System.out.println(this.collector.getL().toString());
        refresh();
    }

    /**
     * <p>
     * It calls the method for save the variables save at that moment into the
     * variableStack, if it is possible. If the Operation could not be performed
     * an error message will be shown.
     *
     * @param event the event of the presses of the button clear.
     * </p>
     * <!-- --> @see Variables
     */
    @FXML
    private void saveVariablesIntoStack(ActionEvent event) {
        if (vars.saveVariablesIntoStack()) {
            showAlert("Variables saved into stack!");
        } else {
            showAlert("Some problems occours\nDid you save at least one variables?");
        }
    }

    /**
     * <p>
     * It calls the method for save the user defined operation memoraized in the
     * current session into a file passed in FileChooser mode, if it is possible
     * with a different thread. If the Operation could not be performed an error
     * message will be shown.
     *
     * @param event the event of the presses of the button clear.
     * </p>
     * <!-- --> @see HashCommandTable,SaveService
     */
    @FXML
    private void saveUserOperationToFile(ActionEvent event) {
        FileChooser fc = new FileChooser();
        fc.setTitle("Open ");
        File file = fc.showSaveDialog(this.baseAnchorPane.getScene().getWindow());
        SaveService thread = new SaveService(file, this.userCommand);
        thread.setOnSucceeded(e -> this.showAlert("Operations saved successfully"));
        thread.setOnFailed(e -> this.showAlert("Operations not saved"));
        thread.start();
    }

    /**
     * <p>
     * It calls the method for restore the last variables saved into the
     * variableStack, if it is possible. If the Operation could not be performed
     * an error message will be shown.
     *
     * @param event the event of the presses of the button clear.
     * </p>
     * <!-- --> @see Variables
     */
    @FXML
    private void restoreVariablesFromStack(ActionEvent event) {
        if (vars.restoreVariablesFromStack()) {
            showAlert("Variables restored from stack!");
            tableOpVar.refresh();
        } else {
            showAlert("Some problems occours\nDid you save somethings in the stack?");
        }
    }

    /**
     * <p>
     * It create a new FileChooser and open the Dialog on the base anchor pane.
     * From it the user can choose the origin file from which to restore the
     * user's operations defined in a previous usage session. Before it a
     * message is shown to user in ordere to comunicate that the operation
     * defined in the current usage remains and that if there are some
     * operations defined in the current usage with same name of some in the
     * file, these will be replaced. The chosen file is then passed to a service
     * whose work is to read the operations from the specified file. If the
     * operation can be performed a confirmation message will be shown to User
     * otherwise an error message is shown.
     *
     * </p>
     * <!-- --> @param event it registers the event of the click of the button
     * for restore User Operations
     *
     * @see CommandRetrievingService, HashhCommandTable
     */
    @FXML
    private void restoreUserOperationFromFile(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Restoring operations from File");
        alert.setHeaderText("This means the current operation will be kept!");
        alert.setContentText("If you have defined some with the same name, it will be replaced!");
        Optional<ButtonType> option = alert.showAndWait();
        if (alert.getResult() == ButtonType.OK) {
            FileChooser fc = new FileChooser();
            fc.setTitle("Open ");
            File file = fc.showOpenDialog(this.baseAnchorPane.getScene().getWindow());
            CommandRetrievingService commandRetr = new CommandRetrievingService(file, userCommand);
            commandRetr.start();
            commandRetr.setOnSucceeded(event1 -> showAlert("Restore operation done successfully!"));
            commandRetr.setOnFailed(event1 -> showAlert("Restore operation cannot be performed!"));
        } else {
            showAlert("Restore operation will not be performed!");
        }
    }

    /**
     * <p>
     * Open the github's project link, if it is possible.
     * </p>
     * <!-- --> @param event it registers the event of the click of the button
     *
     * @see URISyntaxException
     */
    @FXML
    private void about(ActionEvent event) {
        try {
            Desktop.getDesktop().browse(new URL("https://github.com/CamillaSpi/ProjectGruppo12IZ").toURI());
        } catch (IOException | URISyntaxException e) {
        }
    }

    /**
     * <p>
     * When the button is pressed call onButtonEnter methods depending on the
     * state but catch what was written in the apposit text area. The button can
     * be pressed only in state operations, standard and transcendental
     * </p>
     * <!-- --> @param event it registers the event of the click of the button
     *
     * @see StateOperations, StateStandard, StateTranscendental
     */
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

    /**
     * <p>
     * When the button is pressed change the state in Standard state.
     * </p>
     * <!-- --> @param event registers the event of the click of the button
     *
     * @see CommandRetrievingService, HashCommandTable
     */
    @FXML
    private void showStandard(ActionEvent event) {
        clearText();
        changeToggleButton(standardsToggle);
        moveAnchor(false);
        moveAnchorOperation(false);
        ShowBottomAnchorPane.setSelected(false);
        moveBottomAnchorPane(!ShowBottomAnchorPane.isSelected());
        moveTextArea(false);
        this.state.setStateStandard();
    }

    /**
     * <p>
     * When the button is pressed change the state in Variables state.
     * </p>
     * <!-- --> @param event registers the event of the click of the button
     *
     * @see CommandRetrievingService, HashCommandTable
     */
    @FXML
    private void showVariables(ActionEvent event) {
        clearText();
        changeToggleButton(variablesToggle);
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

    /**
     * <p>
     * When the button is pressed changes the state in Operations state.
     * </p>
     * <!-- --> @param event registers the event of the click of the button
     *
     * @see CommandRetrievingService, HashCommandTable
     */
    @FXML
    private void showOperations(ActionEvent event) {
        clearText();
        changeToggleButton(operationsToggle);
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

    /**
     * <p>
     * When the button is pressed changes the state in transcendental state.
     * </p>
     * <!-- --> @param event it registers the event of the click of the button
     *
     * @see CommandRetrievingService, HashCommandTable
     */
    @FXML
    private void showTranscendental(ActionEvent event) {
        clearText();
        changeToggleButton(transcendentalToggle);
        moveAnchor(false);
        moveAnchorOperation(false);
        ShowBottomAnchorPane.setSelected(false);
        moveBottomAnchorPane(!ShowBottomAnchorPane.isSelected());
        moveTextArea(false);
        this.state.setStateTranscendetal();
    }

    /**
     * <p>
     * This method refresh the OperandsTable
     * </p>
     * <!-- --> @see ComplexNumber
     */
    public void refresh() {
        OperandsTable.refresh();
    }

    /**
     * <p>
     * This method returns the text in textArea
     * </p>
     * <!-- --> 
     * @return strings contained in textArea
     */
    public String getText() {
        return this.textArea.getText();
    }

    /**
     * <p>
     * This method sets the text in textArea
     * </p>
     * <!-- --> 
     * @param value the text to set in textArea
     */
    public void setText(String value) {
        this.textArea.setText(value);
    }

    /**
     * <p>
     * This method takes the text in nameOperationTextArea
     * </p>
     * <!-- --> 
     * @return string contained in nameOperationTextArea
     */
    public String getOperationName() {
        return this.nameOperationTextArea.getText();
    }

    /**
     * <p>
     * This method returns the userCommands
     * </p>
     * <!-- -->
     *
     * @return HashCommandTable object
     */
    public HashCommandTable getuserCommand() {
        return this.userCommand;
    }

    /**
     * <p>
     * Clear the textArea to enter numbers.
     * </p>
     * <!-- -->
     */
    public void clearText() {
        textArea.clear();
    }

    /**
     * <p>
     * Clear the nameOperationTextArea
     * </p>
     * <!-- -->
     */
    public void clearNameText() {
        nameOperationTextArea.clear();
    }

    /**
     * <p>
     * returns the Variables value
     * </p>
     * <!-- --> 
     * @return Variables object
     */
    public Variables getVariables() {
        return this.vars;
    }

    /**
     * <p>
     * Change the text in a button
     * </p>
     * <!-- --> 
     * @param index the index of button to change
     *
     * @param value the text to set
     */
    public void changeButtonText(int index, String value) {
        myButtonArray.get(index).setText(value);
    }

    /**
     * <p>
     * Return the Invoker
     * </p>
     * <!-- --> 
     * @return the invoker object
     */
    public Invoker getInvoker() {
        return this.inv;
    }

    /**
     * <p>
     * Set the state
     * </p>
     * <!-- --> 
     * @param state the state that need to be setted.
     */
    public void setState(State state) {
        this.state = state;
    }

    /**
     * <p>
     * Calls execute method in invoker class
     * </p>
     * <!-- -->
     * @param command the command to execute
     *
     * @return true if the command is executed successfully otherwise false
     */
    public boolean commandExecute(Command command) {
        return inv.execute(command);
    }

    /**
     * <p>
     * This methods refresh the tableOpVar
     * </p>
     * <!-- -->
     */
    public void refreshVarsOp() {
        this.tableOpVar.refresh();
    }

    /**
     * <p>
     * Return the value of MyOperandCollection
     * </p>
     * <!-- --> 
     * @return MyOperandCollection object
     */
    public MyOperandCollection getCollector() {
        return collector;
    }

    /**
     * <p>
     * When the button is pressed, the application will close
     * </p>
     * <!-- --> 
     * @param event it registers the event of the click of the button
     */
    @FXML
    private void handleCloseButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    /**
     * <p>
     * When the button is pressed, the side menu will close
     * </p>
     * <!-- -->
     *
     * @param event it registers the event of the click of the button
     */
    @FXML
    private void closeSideMenu(ActionEvent event) {
        moveAnchor(false);
    }
}
