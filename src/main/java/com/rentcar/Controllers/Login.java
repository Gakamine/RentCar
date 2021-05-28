package com.rentcar.Controllers;

import com.rentcar.Models.Employe;
import com.rentcar.Models.UserSession;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Login {

    private  UserSession session = UserSession.getSession();

    @FXML private TextField loginInput;

    @FXML private PasswordField passwordInput;

    @FXML private Text error;

    @FXML
    private void Login() {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            Employe personne = (Employe) entityManager.createQuery("FROM Employe WHERE login = :login").setParameter("login", loginInput.getText()).getSingleResult();
            if (personne.authenticate(passwordInput.getText())) {
                session.setSession(personne);
                Scene scene = loginInput.getScene();
                Text status = (Text) scene.lookup("#status");
                Pane subframe = (Pane) scene.lookup("#subframe");
                status.setText("Logout");
                subframe.getChildren().clear();
                subframe.getChildren().add(FXMLLoader.load(getClass().getResource("Views/Home.fxml")));
                ButtonBar menu = (ButtonBar) scene.lookup("#bb");
                menu.setVisible(true);
                if(session.getUser().getChauffeur() || session.getUser().getAdmin()) {
                    Button circuit = (Button) scene.lookup("#circuit");
                    circuit.setVisible(true);
                }
            } else {
                error.setText("Utilisateur inexistant ou mot de passe incorrect");
            }
        } catch (Exception e) {
            System.out.println(e);
            error.setText("Utilisateur inexistant ou mot de passe incorrect");
        } finally {
            entityManager.close();
        }
    }
}
