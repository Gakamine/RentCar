package com.rentcar.Models;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../Views/Login.fxml"));
        primaryStage.setTitle("RentCar");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 300, 150));
        primaryStage.show();
    }

    public static void main(String[] args) {
//        Personne personne = new Personne();
//        personne.setName("Antoine");
//        personne.setId(2);
//
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(personne);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//        entityManagerFactory.close();

        launch(args);
    }
}
