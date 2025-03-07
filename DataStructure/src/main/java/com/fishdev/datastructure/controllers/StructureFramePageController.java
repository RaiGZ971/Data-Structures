package com.fishdev.datastructure.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import javafx.scene.Parent;

import java.util.Objects;

public class StructureFramePageController extends GlobalController {

    @FXML
    private Label structureFrameTitle;

    @FXML
    private VBox structureFrameContainer;

    @FXML
    void clickedBack(MouseEvent event) throws Exception {
        setScene(event, "homepage");
    }

    void setStructureFrame(String structure, String title) throws Exception{
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource( "/com/fishdev/datastructure/" + structure + ".fxml")));
        structureFrameTitle.setText(title);
        structureFrameContainer.getChildren().add(root);
    }
}
