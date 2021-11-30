/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgruppo12iz;

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

/**
 *
 * @author t440
 */
public class FXMLDocumentController implements Initializable {

    MyOperandCollection collector = new MyOperandCollection(12);
    PauseTransition pause = new PauseTransition(Duration.seconds(5));
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
    private Button EnterOperation;
    @FXML
    private Button executeTextArea;
    @FXML
    private Button deleteOperation;
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


    @FXML
    private void pushIntoStack(ActionEvent event) {
    }

    @FXML
    private void putIntoStack(ActionEvent event) {
    }

    @FXML
    private void subtractionFromStack(ActionEvent event) {
    }

    @FXML
    private void addFromStack(ActionEvent event) {
    }
  
    @FXML
    private void clear(ActionEvent event) {
    }

    @FXML
    private void over(ActionEvent event) {
         if (!collector.over()) {
            showAlert("There aren't least elements for over operation!\n");
        } else {
            showAlert("Over operation execute!");
             OperandsTable.refresh();
        }
    }

    @FXML
    private void drop(ActionEvent event) {
         if (!collector.drop()) {
            showAlert("There aren't at least element for drop operation!\n");
        } else {
            showAlert("Dropped last item!");
             OperandsTable.refresh();
        }
    }

    @FXML
    private void dup(ActionEvent event) {
    }

    @FXML
    private void swap(ActionEvent event) {
    }

    @FXML
    private void variableToggleButton(ActionEvent event) {
    }

    @FXML
    private void showOperation(ActionEvent event) {
    }

    @FXML
    private void UserToggleButton(ActionEvent event) {
    }

}
