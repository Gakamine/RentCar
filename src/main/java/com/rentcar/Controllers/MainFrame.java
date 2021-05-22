package com.rentcar.Controllers;

import com.rentcar.Models.UserSession;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ButtonBar;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.io.IOException;

public class MainFrame {

    UserSession session = UserSession.getSession();

    @FXML
    private Text status;

    @FXML
    private Pane subframe;

    @FXML
    private ButtonBar bb_default;

    @FXML
    private ButtonBar bb_employe;

    @FXML
    private ButtonBar bb_admin;

    @FXML
    public void initialize() throws IOException {
        subframe.getChildren().add(FXMLLoader.load(getClass().getResource("../Views/Home.fxml")));
    }

    @FXML
    public void Home() throws IOException {
        subframe.getChildren().clear();
        subframe.getChildren().add(FXMLLoader.load(getClass().getResource("../Views/Home.fxml")));
    }

    @FXML
    public void goLoginpage() throws IOException {
        if(session.getUser() == null) {
            subframe.getChildren().clear();
            subframe.getChildren().add(FXMLLoader.load(getClass().getResource("../Views/Login.fxml")));
        } else {
            bb_admin.setVisible(false);
            bb_employe.setVisible(false);
            bb_default.setVisible(false);
            status.setText("Login");
            session.clearSession();
            subframe.getChildren().clear();
            subframe.getChildren().add(FXMLLoader.load(getClass().getResource("../Views/Home.fxml")));
        }
    }

    @FXML
    public void goCarpage() throws IOException {
        subframe.getChildren().clear();
        subframe.getChildren().add(FXMLLoader.load(getClass().getResource("../Views/Cars.fxml")));
    }

    @FXML
    public void goCustomerpage() throws IOException {
        subframe.getChildren().clear();
        subframe.getChildren().add(FXMLLoader.load(getClass().getResource("../Views/Customers.fxml")));
    }



}
