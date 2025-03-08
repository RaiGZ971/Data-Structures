package com.fishdev.datastructure.controllers;

import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import com.fishdev.datastructure.DataStructures.*;


public class QueuePageController {
    @FXML
    private MFXTextField enqueueValue;

    Queue myObject;

    @FXML
    void displayQueue(ActionEvent event) {
        System.out.println("\t\t\t-Run Display");
        myObject.display();
    }

    @FXML
    void createQueue(ActionEvent event) {
        System.out.println("\t\tCreating linked list...");
        myObject = new Queue();
    }

    @FXML
    void clickedEnqueue(ActionEvent event) {
        System.out.println("\t\t\t-Run Enqueue");
        myObject.insert(enqueueValue.getText());
    }

    @FXML
    void clickedDequeue(ActionEvent event) {
        System.out.println("\t\t\t-Run Dequeue");
        myObject.dequeue();
    }

    @FXML
    void clickedHighlightFront(ActionEvent event) {
        System.out.println("\t\t\t-Run Highlight Front");
        myObject.highlightFront();
    }

    @FXML
    void clickedHighlightRear(ActionEvent event) {
        System.out.println("\t\t\t-Run Highlight Rear");
        myObject.highlightRear();
    }

}
