package com.fishdev.datastructure.controllers;

import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LinkedListPageController extends GlobalController {
    @FXML
    private MFXTextField deleteIndex, deleteValue, insertValue;

    @FXML
    void displayLinkedList(ActionEvent event) {
        System.out.println("[Displaying linked list]");
    }

    @FXML
    void createLinkedList(ActionEvent event) {
        System.out.println("[Creating linked list]");
    }

    @FXML
    void clickedInsert(ActionEvent event) {
        System.out.println("[Running insert value]");
    }

    @FXML
    void clickedDelete(ActionEvent event) {
        System.out.println("[Running delete value]");

    }

    @FXML
    void clickedRemovedDuplicate(ActionEvent event) {
        System.out.println("[Running removed duplicate]");

    }

    @FXML
    void clickedReverseLinkedList(ActionEvent event) {
        System.out.println("[Running reverse linked list]");

    }
}
