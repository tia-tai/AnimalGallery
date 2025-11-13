package com.example.animalgallery;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class AnimalGalleryController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}
