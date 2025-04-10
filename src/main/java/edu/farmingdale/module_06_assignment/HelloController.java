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
// Initializable needed to implement initialize
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
    boolean firstNameBool, lastNameBool, dobBool, emailBool, zipcodeBool = false;
    boolean canRegister = false;

    // Name field can only contain alphabetical characters and must be a length 2-25
    Pattern namePattern = Pattern.compile("^[a-zA-Z]{2,25}$");
    // Date of birth must be in format MM/DD/YYYY
    Pattern dobPattern = Pattern.compile("^(0[1-9]|1[0-2])/([0][1-9]|[12][0-9]|3[01])/\\d{4}$");
    // Email must contain @farmingdale.edu
    Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9._%+-]{1,25}@farmingdale\\.edu$");
    // Zipcode must be a number with 5 digits
    Pattern zipcodePattern = Pattern.compile("^\\d{5}$");

    /**
     * Only if all text fields are valid, you can go to the next page.
     * @param event the action event caused by clicking the register button
     * @throws IOException if page2 cannot be loaded
     */
    @FXML
    void goToPage(ActionEvent event) throws IOException {
        if (canRegister == true){
            HelloApplication.setRoot("page2");
        }
    }

    /**
     * Checks if every text field is valid and changes their emoji from x to a checkmark.
     */
    void checkIfCorrect(){
        if (namePattern.matcher(firstName.getText()).matches()){
            firstNameCheck.setText("✅");
            firstNameBool = true;
        }
        else {
            firstNameCheck.setText("❌");
            firstNameBool = false;
        }
        if (namePattern.matcher(lastName.getText()).matches()){
            lastNameCheck.setText("✅");
            lastNameBool = true;
        }
        else {
            lastNameCheck.setText("❌");
            lastNameBool = false;
        }
        if (dobPattern.matcher(dob.getText()).matches()){
            dobCheck.setText("✅");
            dobBool = true;
        }
        else {
            dobCheck.setText("❌");
            dobBool = false;
        }
        if (emailPattern.matcher(email.getText()).matches()){
            emailCheck.setText("✅");
            emailBool = true;
        }
        else {
            emailCheck.setText("❌");
            emailBool = false;
        }
        if (zipcodePattern.matcher(zipcode.getText()).matches()){
            zipcodeCheck.setText("✅");
            zipcodeBool = true;
        }
        else {
            zipcodeCheck.setText("❌");
            zipcodeBool = false;
        }
    }

    /**
     * If every field is valid, the canRegister is set to true.
     * If not, it is set to false.
     */
    void setRegisterButton(){
        if (firstNameBool == true
                && lastNameBool == true
                && dobBool == true
                && emailBool == true
                && zipcodeBool == true){
            canRegister = true;
        }
        else {
            canRegister = false;
        }
    }

    /**
     * If every text field is valid, the button will change from grey to green.
     */
    void changeColor(){
        if (canRegister){
            registerButton.setStyle("-fx-background-color: #24ff2b; -fx-text-fill: white;");
        }
        else {
            registerButton.setStyle("-fx-background-color: #a9a9a9;; -fx-text-fill: white;");
        }
    }

    /**
     * Method that runs when the file screen is showing.
     * When a text field is clicked on, it will check if
     * it is correct, check if the register button should be
     * enabled, and change the color of the button if
     * every text field is correct.
     * @param url location of the root object
     * @param resourceBundle resources used to find the root object
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        TextField[] fields = { firstName, lastName, email, dob, zipcode };

        /*
        After each text field is clicked on, every
        field will be checked if it is correct.
         */
        for (TextField field : fields) {
            field.setOnMouseClicked(e -> {
                checkIfCorrect();
                setRegisterButton();
                changeColor();
            });
        }
    }
}