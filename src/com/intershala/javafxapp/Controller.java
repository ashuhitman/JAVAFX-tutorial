package com.intershala.javafxapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public Label welcomeLabel;

    @FXML
    public ChoiceBox<String> choiceBox;

    @FXML
    public TextField inputField;

    @FXML
    public Button convertButton;

    private static final String C_TO_F_TEXT = "Celcius to Fahrenhite";
    private static final String F_TO_C_TEXT = "Fahrenhite to Celcius";
    private boolean isC_TO_F = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //add choice Box items
        choiceBox.getItems().add(C_TO_F_TEXT);
        choiceBox.getItems().add(F_TO_C_TEXT);
        //set default value
        choiceBox.setValue(C_TO_F_TEXT);
        //add change event listener
        choiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue.equals(C_TO_F_TEXT)){
                isC_TO_F = true;
            }else {
                isC_TO_F = false;
            }
        });

        convertButton.setOnAction(event -> {
            convert();
        });

    }

    private void convert() {
        String input = inputField.getText();
        float enteredTemp = 0.0f;
        try {
             enteredTemp = Float.parseFloat(input);
        }catch(Exception ex){
            warnUser();
            return;
        }

        float newTemp = 0.0f;
        if (isC_TO_F) {
            newTemp = (enteredTemp * 9/5) + 32;
        }else {
            newTemp = (enteredTemp - 32) * 5/9;
        }

        display(newTemp);
    }

    private void warnUser() {
        Alert errorAlert = new Alert(Alert.AlertType.ERROR);
        errorAlert.setTitle("Error occured");
        errorAlert.setHeaderText("Invalid Temperature Entered");
        errorAlert.setContentText("Please enter valid temperature");
        errorAlert.show();
    }

    private void display(float newTemp) {
        String unit = isC_TO_F? "F" : "C";
        //System.out.println("New Temperature is " + newTemp + unit);
        Alert alertDialoge = new Alert(Alert.AlertType.INFORMATION);
        alertDialoge.setTitle("Temperature Converter");

        alertDialoge.setContentText("New Temperature is "+newTemp+" "+unit);
        alertDialoge.show();
    }
}
