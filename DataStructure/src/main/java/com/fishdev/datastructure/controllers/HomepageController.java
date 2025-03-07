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
        System.out.println("\t[Open Array Page]");
    }

    @FXML
    void clickedSceneLinkedList(ActionEvent event) throws Exception{
        setScene(event, "linkedListPage");
        System.out.println("\t[Open Linked List Page]");
    }

    @FXML
    void clickedSceneStack(ActionEvent event) throws Exception{
        setScene(event, "stackPage");
        System.out.println("\t[Open Stack Page]");
    }

    @FXML
    void clickedSceneQueue(ActionEvent event) throws Exception{
        setScene(event, "queuePage");
        System.out.println("\t[Open Queue Page]");
    }

    @FXML
    void clickedSceneBinaryTree(ActionEvent event) throws Exception{
        setScene(event, "binaryTreePage");
        System.out.println("\t[Open Binary Tree Page]");
    }

}
