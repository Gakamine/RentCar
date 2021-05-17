package com.rentcar.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;

public class Login {
    @FXML
    private TextField email;
    @FXML
    private PasswordField password;

    @FXML
    private void login() throws Exception {
        System.out.println(email.getText());
        System.out.println(password.getText());
        Stage currentwindow = (Stage) email.getScene().getWindow();
        currentwindow.close();
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Main.fxml"));
        Stage stage = new Stage();
        stage.setTitle("RentCar");
        stage.setScene(new Scene(root, 450, 450));
        stage.show();
    }

}
