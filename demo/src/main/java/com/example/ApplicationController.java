package com.example;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;

public class ApplicationController {
    @FXML
    private DatePicker addTransactionDatePicker;

    @FXML
    private TextField addTransactionCategory;

    @FXML
    private ToggleGroup transactionType;

    @FXML
    private ToggleGroup isRecurring;

    @FXML
    private Group recurringTransactionDatePickers;

    @FXML
    private Group nonRecurringTransactionDatePicker;

    @FXML
    private TextField addTransactionAmountDollars;

    @FXML
    private TextField addTransactionAmountCents;

    public void addTransaction(ActionEvent e) {
        System.out.println("test");
        System.out.println(addTransactionDatePicker.getValue());
        System.out.println(addTransactionCategory.getText());
        System.out.println(transactionType.getSelectedToggle());
    }

    public void onIsRecurringChanged(ActionEvent e) {
        boolean isRecurringVisible = ((RadioButton) (isRecurring.getSelectedToggle())).getText().equals("Yes");
        recurringTransactionDatePickers.setVisible(isRecurringVisible);
        nonRecurringTransactionDatePicker.setVisible(!isRecurringVisible);
    }
}
