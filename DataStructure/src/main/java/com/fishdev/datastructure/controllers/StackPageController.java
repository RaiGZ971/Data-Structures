package com.fishdev.datastructure.controllers;

import com.fishdev.datastructure.DataStructures;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import com.fishdev.datastructure.DataStructures.*;

public class StackPageController {

    @FXML
    private MFXTextField pushValue, modifyValue, modifyNewValue;

    Stack myObject;

    @FXML
    void displayStack(ActionEvent event) {
        System.out.println("\t\t\t-Run Display");
        myObject.display();
    }

    @FXML
    void createStack(ActionEvent event) {
        System.out.println("\t\tCreating Stack...");
        myObject = new Stack();
    }

    @FXML
    void clickedPush(ActionEvent event) {
        myObject.insert(Integer.parseInt(pushValue.getText()));
    }

    @FXML
    void clickedPop(ActionEvent event) {
        System.out.println("\t\t\t-Run Pop");
        myObject.pop();
    }

    @FXML
    void clickedModify(ActionEvent event) {
        System.out.println("\t\t\t-Run Modify");
        myObject.modify(Integer.parseInt(modifyValue.getText()), Integer.parseInt(modifyNewValue.getText()));
    }

}
