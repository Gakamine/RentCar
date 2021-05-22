package com.rentcar.Controllers;

import com.rentcar.Models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class Customers {

    UserSession session = UserSession.getSession();
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @FXML
    private TableView table;

    @FXML
    private Pane editor;

    @FXML
    private TextField name;

    @FXML
    private TextField familyname;

    @FXML
    private TextField phone;

    @FXML
    private TextField mail;

    @FXML
    private TextField postalcode;

    @FXML
    private TextField address;

    @FXML
    private DatePicker date;

    @FXML
    private MenuButton program;

    @FXML
    public void initialize() {
        if(!session.isEmploye() || !session.isAdmin()) {
            editor.setVisible(true);

//            List<ProgrammeFidelite> programmeFidelites = (List<ProgrammeFidelite>) entityManager.createQuery("FROM ProgrammeFidelite ").getResultList();
//            for (ProgrammeFidelite pgr: programmeFidelites) {
//                program.getItems().add()
//            }
        }

        List<Client> clients = (List<Client>) entityManager.createQuery("FROM Client ").getResultList();
        for(Client client: clients) {
            System.out.println("ok");
//            table.getColumns().add(client);
//            for (TableColumn column: columns) {
//                column.cellFactoryProperty();
//            }
//
            Personne personne = client.getPersonneByIdPersonne();
            Adresse adresse = personne.getAdresseByIdAdresse();
            ObservableList<TableView_Customers> rows = FXCollections.observableArrayList(
                    new TableView_Customers(client.getIdClient(),personne.getPrenom(),personne.getNom(),personne.getNumtelephone(),personne.getMail(),adresse.getCodePostal(),adresse.getRue(),null,null)
            );
            table.setItems(rows);
        }
    }

    public void add_entry() {
        Adresse adresse = new Adresse(address.getText(),postalcode.getText());
        Personne personne = new Personne(familyname.getText(),name.getText(),mail.getText(),phone.getText(),adresse);
        Client client = new Client(date.getValue(),personne);

        entityManager.getTransaction().begin();
        entityManager.persist(adresse);
        entityManager.persist(personne);
        entityManager.persist(client);
        entityManager.getTransaction().commit();
    }
}
