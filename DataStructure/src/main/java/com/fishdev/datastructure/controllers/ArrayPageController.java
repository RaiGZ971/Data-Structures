package com.fishdev.datastructure.controllers;

import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ArrayPageController extends GlobalController {

    @FXML
    private MFXTextField arrayDeleteIndex, arrayDeleteValue, arrayInsertValue;

    @FXML
    void clickedArrayAscending(ActionEvent event) {
        System.out.println("[Running ascending order]");

    }

    @FXML
    void clickedArrayDescending(ActionEvent event) {
        System.out.println("[Running descending order]");
    }

    @FXML
    void clickedArrayInsert(ActionEvent event) {
        System.out.println("[Running insert value]");

    }

    @FXML
    void clickedArrayDelete(ActionEvent event) {
        System.out.println("[Running delete value]");

    }

}
