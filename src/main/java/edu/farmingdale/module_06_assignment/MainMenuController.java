package edu.farmingdale.module_06_assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;

public class MainMenuController {
    @FXML
    void goToRegistration(ActionEvent event) throws IOException {
        HelloApplication.setRoot("hello-view");
    }
}
