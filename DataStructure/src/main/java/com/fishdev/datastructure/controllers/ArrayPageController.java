package com.fishdev.datastructure.controllers;

import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import com.fishdev.datastructure.DataStructures.*;

public class ArrayPageController extends GlobalController {

    @FXML
    private MFXTextField arraySize, deleteValue, insertValue, insertIndex;

    Array myObject;

    @FXML
    void displayArray(ActionEvent event) {
        System.out.println("\t\t\t-Run Display");
        myObject.display();
    }

    @FXML
    void createArray(ActionEvent event) {
        System.out.println("\t\tCreating linked list...");
        myObject = new Array();
        myObject.configArray(Integer.parseInt(arraySize.getText()));
    }

    @FXML
    void clickedInsert(ActionEvent event) {
        if(insertIndex.getText().isEmpty()){
            myObject.insert(Integer.parseInt(insertValue.getText()));
            return;
        }
        myObject.insert(Integer.parseInt(insertValue.getText()), Integer.parseInt(insertIndex.getText()));
    }

    @FXML
    void clickedDelete(ActionEvent event) {
        System.out.println("\t\t\t-Run Delete");
        myObject.delete(Integer.parseInt(deleteValue.getText()));
    }

    @FXML
    void clickedAscending(ActionEvent event) {
        System.out.println("\t\t\t-Run Ascending Order");
        myObject.ascendingOrder();
    }

    @FXML
    void clickedDescending(ActionEvent event) {
        System.out.println("\t\t\t-Run Descending Order");
        myObject.descendingOrder();
    }
}
