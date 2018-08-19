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

    private static final String C_T_F_TEXT = "Celcius to Fahrenhite";
    private static final String F_T_C_TEXT = "Fahrenhite to Celcius";

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //add choice Box items
        choiceBox.getItems().add(C_T_F_TEXT);
        choiceBox.getItems().add(F_T_C_TEXT);
        //set default value
        choiceBox.setValue(C_T_F_TEXT);
        //add change event listener
        choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                System.out.println(newValue);
            }
        });

        convertButton.setOnAction(event -> {
            System.out.println("button clicked");
        });

    }
}
