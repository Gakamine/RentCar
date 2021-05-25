package com.rentcar;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Optional;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Views/Main.fxml"));
        primaryStage.setTitle("RentCar");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 1000, 900));

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                ButtonType button_yes = new ButtonType("Oui");
                ButtonType button_no = new ButtonType("Non");
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Voulez-vous fermer l'application ?", button_yes, button_no);
                Optional<ButtonType> result = alert.showAndWait();
                alert.show();
                if (result.get() == button_yes) {
                    primaryStage.close();
                }
                alert.close();
                event.consume();
            }
        });

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
