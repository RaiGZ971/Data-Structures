package com.fishdev.datastructure.controllers;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.*;

import java.util.Objects;

public class GlobalController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void setScene(Event event, String structure) throws Exception{
        System.out.println("Running setScene()...");

        if(structure.equals("homepage")){
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/fishdev/datastructure/homepage.fxml")));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
        }else if(structure.equals("exit")) {
            Platform.exit();
        }else{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/fishdev/datastructure/structureFramePage.fxml"));
            root = loader.load();
            scene = new Scene(root);

            StructureFramePageController structureFrameController = loader.getController();

            switch (structure){
                case "arrayPage":
                    structureFrameController.setStructureFrame(structure, "Array Structure");
                    break;
                case "linkedListPage":
                    structureFrameController.setStructureFrame(structure, "Linked List Structure");
                    break;
                case "stackPage":
                    structureFrameController.setStructureFrame(structure, "Stack Structure");
                    break;
                case "queuePage":
                    structureFrameController.setStructureFrame(structure, "Queue Structure");
                    break;
                case "binaryTreePage":
                    structureFrameController.setStructureFrame(structure, "Binary Tree Structure");
                    break;
                default:
                    System.out.println("No Page Found");
                    break;
            }
        }
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/com/fishdev/datastructure/Application.css")).toExternalForm());
        stage.setScene(scene);
    }
}
