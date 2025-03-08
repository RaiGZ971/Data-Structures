package com.fishdev.datastructure.controllers;

import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import com.fishdev.datastructure.DataStructures.*;

public class LinkedListPageController{

    @FXML
    private MFXTextField deleteIndex, deleteValue, insertValue;

    LinkedList myObject;

    @FXML
    void displayLinkedList(ActionEvent event) {
        System.out.println("\t\t\t-Run Display");
        myObject.display();

    }

    @FXML
    void createLinkedList(ActionEvent event) {
        System.out.println("\t\tCreating linked list...");
        myObject = new LinkedList();
    }

    @FXML
    void clickedInsert(ActionEvent event) {
        myObject.insert(insertValue.getText());
    }

    @FXML
    void clickedDelete(ActionEvent event) {
        System.out.println("\t\t\t-Run Delete");
        myObject.delete(deleteValue.getText());

    }

    @FXML
    void clickedReverseLinkedList(ActionEvent event) {
        System.out.println("\t\t\t-Run Reverse Linked List");
        myObject.reverse();
    }

    @FXML
    void clickedRemovedDuplicate(ActionEvent event) {
        System.out.println("\t\t\t-Run Remove Duplicate");
        myObject.removeDuplicate();

    }
}
