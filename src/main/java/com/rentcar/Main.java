package com.rentcar;

import com.rentcar.Controllers.MainFrame;
import com.rentcar.Models.Adresse;
import com.rentcar.Models.Employe;
import com.rentcar.Models.Personne;
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
//
//        Adresse adresse = new Adresse("Villejuif", "94076");
//        Personne personne = new Personne("admin", "admin", "admin@rent.car", "111222333", adresse);
//        Employe employe = new Employe("admin", "admin", personne);
//
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
//
//        EntityManager entityManager1 = entityManagerFactory.createEntityManager();
//        entityManager1.getTransaction().begin();
//        entityManager1.persist(adresse);
//        entityManager1.getTransaction().commit();
//
//        EntityManager entityManager2 = entityManagerFactory.createEntityManager();
//        entityManager2.getTransaction().begin();
//        entityManager2.persist(personne);
//        entityManager2.getTransaction().commit();
//
//        EntityManager entityManager3 = entityManagerFactory.createEntityManager();
//        entityManager3.getTransaction().begin();
//        entityManager3.persist(employe);
//        entityManager3.getTransaction().commit();
//
//        entityManager1.close();
//        entityManager2.close();
//        entityManager3.close();
//        entityManagerFactory.close();

        launch(args);
    }
}
