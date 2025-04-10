package edu.farmingdale.module_06_assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.*;
// Initializable needed to implement initializable
import javafx.fxml.Initializable;
import java.io.IOException;

public class HelloController implements Initializable{
    @FXML
    private TextField dob;
    @FXML
    private TextField email;
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private StackPane loginBox;
    @FXML
    private Button registerButton;
    @FXML
    private TextField zipcode;
    @FXML
    private Label dobCheck;
    @FXML
    private Label emailCheck;
    @FXML
    private Label firstNameCheck;
    @FXML
    private Label lastNameCheck;
    @FXML
    private Label zipcodeCheck;

    // Name field can only contain alphabetical characters and must be a length 2-25
    Pattern namePattern = Pattern.compile("^[a-zA-Z]{2,25}$");
    // Date of birth must be in format MM/DD/YYYY
    Pattern dobPattern = Pattern.compile("^(0[1-9]|1[0-2])/([0][1-9]|[12][0-9]|3[01])/\\d{4}$");
    // Email must contain @farmingdale.edu
    Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9._%+-]{1,25}@farmingdale\\.edu$");
    // Zipcode must be a number with 5 digits
    Pattern zipcodePattern = Pattern.compile("^\\d{5}$");


    @FXML
    void goToPage(ActionEvent event) throws IOException {
        HelloApplication.setRoot("page2");
    }

    void checkIfCorrect(){
        if (namePattern.matcher(firstName.getText()).matches()){
            firstNameCheck.setText("✅");
        }
        else {
            firstNameCheck.setText("❌");
        }
        if (namePattern.matcher(lastName.getText()).matches()){
            lastNameCheck.setText("✅");
        }
        else {
            lastNameCheck.setText("❌");
        }
        if (dobPattern.matcher(dob.getText()).matches()){
            dobCheck.setText("✅");
        }
        else {
            dobCheck.setText("❌");
        }
        if (emailPattern.matcher(email.getText()).matches()){
            emailCheck.setText("✅");
        }
        else {
            emailCheck.setText("❌");
        }
        if (zipcodePattern.matcher(zipcode.getText()).matches()){
            zipcodeCheck.setText("✅");
        }
        else {
            zipcodeCheck.setText("❌");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TextField[] fields = { firstName, lastName, email, dob, zipcode };

        for (TextField field : fields) {
            field.setOnMouseClicked(e -> {
                checkIfCorrect();
            });
        }
    }

    // inform the validity of each input when they move focus to the next field
    // enable add button only if all fields contain correct data otherwise it remains greyed out
    // only once everything is validated allow user to click on add button
}