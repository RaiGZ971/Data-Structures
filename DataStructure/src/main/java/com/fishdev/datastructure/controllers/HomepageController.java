package com.fishdev.datastructure.controllers;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class HomepageController extends GlobalController {

    @FXML
    void clickedExit(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void clickedSceneArray(ActionEvent event) throws Exception {
        setScene(event, "arrayPage");
    }

    @FXML
    void clickedSceneBinaryTree(ActionEvent event) throws Exception{
        setScene(event, "binaryTreePage");
    }

    @FXML
    void clickedSceneLinkedList(ActionEvent event) throws Exception{
        setScene(event, "linkedListPage");
    }

    @FXML
    void clickedSceneQueue(ActionEvent event) throws Exception{
        setScene(event, "queuePage");
    }

    @FXML
    void clickedSceneStack(ActionEvent event) throws Exception{
        setScene(event, "stackPage");
    }
}
