package com.rentcar.Controllers;

import com.rentcar.Models.Client;
import com.rentcar.Models.Vehicule;
import com.rentcar.Wrapper.TableViewCustomers;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Circuit {

    @FXML private TableView table;

    @FXML
    public void initialize() {
        TableColumn<Vehicule, TextFieldTableCell> immatriculation = new TableColumn<>("Immatriculation");
        immatriculation.setCellValueFactory(new PropertyValueFactory<>("immatriculation"));
        immatriculation.setPrefWidth(250);

        TableColumn<Vehicule, TextFieldTableCell> depart = new TableColumn<>("Agence de départ");
        depart.setCellValueFactory(new PropertyValueFactory<>("depart"));
        depart.setPrefWidth(250);

        TableColumn<Vehicule, TextFieldTableCell> arrivee = new TableColumn<>("Agence d'arrivée");
        arrivee.setCellValueFactory(new PropertyValueFactory<>("km"));
        arrivee.setPrefWidth(250);

        TableColumn<Vehicule, TextFieldTableCell> date = new TableColumn<>("Date de prochaine réservation");
        date.setCellValueFactory(new PropertyValueFactory<>("auto"));
        date.setPrefWidth(250);

        table.getColumns().addAll(immatriculation,depart,arrivee,date);

        EntityManager entityManager = initEntityManager();
        List<Client> clients = (List<Client>) entityManager.createQuery("FROM Client ").getResultList();
    }

    public EntityManager initEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }

    private void insertTable(List<Client> clients) {
        for(Client client: clients) {
            TableViewCustomers tableview = new TableViewCustomers(client);
            table.getItems().add(tableview);
        }
    }
}
