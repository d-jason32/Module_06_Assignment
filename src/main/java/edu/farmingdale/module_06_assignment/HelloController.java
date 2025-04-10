package edu.farmingdale.module_06_assignment;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import java.util.regex.*;

import java.io.IOException;

public class HelloController {


    Pattern name = Pattern.compile("^[a-zA-Z]{2,25}$");

    Pattern dob = Pattern.compile("^(0[1-9]|1[0-2])/([0][1-9]|[12][0-9]|3[01])/\\d{4}$");

    Pattern email = Pattern.compile("^[a-zA-Z0-9._%+-]{1,25}@farmingdale\\.edu$");

    Pattern zipcode = Pattern.compile("^\\d{5}$");

    Matcher m = dob.matcher("Now is the time"); // entire string

    //Matcher a = dob.find("Now is the time");

    @FXML
    void goToPage(ActionEvent event) throws IOException {
        HelloApplication.setRoot("page2");
    }

    // First and Last name: A-Z only, 2-25 inclusive
    // DOB MM/DD/YYYY
    //Email only accept farmingdale email address
    // zipcode numbers 5 digits
}