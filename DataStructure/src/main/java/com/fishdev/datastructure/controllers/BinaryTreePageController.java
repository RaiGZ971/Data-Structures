package com.fishdev.datastructure.controllers;

import com.fishdev.datastructure.DataStructures;
import io.github.palexdev.materialfx.controls.MFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import com.fishdev.datastructure.DataStructures.*;


public class BinaryTreePageController {

    @FXML
    private MFXTextField insertValue, deleteValue;

    @FXML
    private TextArea structureArea;

    BinaryTree myObject;

    @FXML
    void displayBinaryTree(ActionEvent event) {
        System.out.println("\t\t\t-Run Display");
        myObject.display();
    }

    @FXML
    void createBinaryTree(ActionEvent event) {
        System.out.println("\t\tCreating Binary Tree...");
        myObject = new BinaryTree();
    }

    @FXML
    void clickedInsert(ActionEvent event) {
        System.out.println("\t\t\t-Run Insert");
        myObject.insert(Integer.parseInt(insertValue.getText()));
    }

    @FXML
    void clickedDelete(ActionEvent event) {
        System.out.println("\t\t\t-Run Delete");
        myObject.delete(Integer.parseInt(deleteValue.getText()));
    }

    @FXML
    void clickedTreeStructure(ActionEvent event) {
        System.out.println("\t\t\t-Run Tree Structure");
        myObject.treeStructure();
    }


}
