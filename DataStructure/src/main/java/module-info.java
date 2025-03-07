module com.fishdev.datastructure {

    requires net.synedra.validatorfx;
    requires MaterialFX;


    opens com.fishdev.datastructure to javafx.fxml;
    exports com.fishdev.datastructure;
    exports com.fishdev.datastructure.controllers;
    opens com.fishdev.datastructure.controllers to javafx.fxml;
}