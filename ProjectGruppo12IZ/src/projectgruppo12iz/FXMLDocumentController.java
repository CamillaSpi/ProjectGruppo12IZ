/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projectgruppo12iz;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
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
import modelClassPackage.Calculator;
import modelClassPackage.ComplexNumber;
import modelClassPackage.MyOperandCollection;

/**
 *
 * @author t440
 */
public class FXMLDocumentController implements Initializable {
    
    MyOperandCollection collector = new MyOperandCollection();
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
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World! test 5");
    }
    
    public boolean pushIntoStack(ComplexNumber num){
        int length = collector.collectionLength();
        collector.insert(num) ;
        return length < collector.collectionLength();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Building the sublist of the first twelve elements of the operands collection and adding it in the operands table.
        //OperandsTable.setItems(FXCollections.observableList(collector.subList(0, 11)));
    }    

    @FXML
    private void handleEnterAction(ActionEvent event) {
    }

    @FXML
    private void add(ActionEvent event) {
        if (collector.collectionLength() < 2){
            System.out.println("You didn't insert 2 elements!");
        }
         System.out.println("NOT IMPLEMENTED!");
        return ;
        
    }

    @FXML
    private void sub(ActionEvent event) {
    }

    @FXML
    private void multiply(ActionEvent event) {
    }

    @FXML
    private void division(ActionEvent event) {
    }

    @FXML
    private void sqrt(ActionEvent event) {
    }

    @FXML
    private void invertSign(ActionEvent event) {
    }

    
    
}
