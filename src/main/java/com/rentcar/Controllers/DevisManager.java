package com.rentcar.Controllers;

import com.rentcar.Models.*;
import com.rentcar.Wrapper.TableViewCustomers;
import com.rentcar.Wrapper.TableViewDevis;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class DevisManager {

    UserSession session = UserSession.getSession();

    @FXML
    private TableView<TableViewDevis> table;
    @FXML
    private Pane editor;
    @FXML
    private TextField idCLient;
    @FXML
    private TextField StartDate;
    @FXML
    private TextField EndDate;
    @FXML
    private TextField immatriculation;
    @FXML
    private TextField StartAgency;
    @FXML
    private TextField EndAgency;
    @FXML
    private TextField Price;
    @FXML
    private CheckBox Assurance;
    @FXML
    private Label erreur;

    @FXML
    public void initialize() {
        if (session.getUser().getHoteAccueil() || session.isAdmin()) {
            editor.setVisible(true);
        }
        TableColumn<TableViewDevis, TextFieldTableCell> idClient = new TableColumn<>("idCLient");
        idClient.setCellValueFactory(new PropertyValueFactory<>("idCLient"));

        TableColumn<TableViewDevis, TextFieldTableCell> StartDate = new TableColumn<>("Date de départ");
        StartDate.setCellValueFactory(new PropertyValueFactory<>("Date de départ"));

        TableColumn<TableViewDevis, TextFieldTableCell> EndDate = new TableColumn<>("Date de fin");
        EndDate.setCellValueFactory(new PropertyValueFactory<>("Date de Fin"));

        TableColumn<TableViewDevis, TextFieldTableCell> immatriculation = new TableColumn<>("Immatriculation");
        immatriculation.setCellValueFactory(new PropertyValueFactory<>("Immatriculation"));

        TableColumn<TableViewDevis, TextFieldTableCell> StartAgency = new TableColumn<>("Agence de départ");
        StartAgency.setCellValueFactory(new PropertyValueFactory<>("Agence de départ"));

        TableColumn<TableViewDevis, TextFieldTableCell> EndAgency = new TableColumn<>("Agence de fin");
        EndAgency.setCellValueFactory(new PropertyValueFactory<>("Agence de fin"));

        TableColumn<TableViewDevis, TextFieldTableCell> Price = new TableColumn<>("Prix");
        Price.setCellValueFactory(new PropertyValueFactory<>("Prix"));

        TableColumn<TableViewDevis, CheckBox> Assurance = new TableColumn<>("Assurance");
        Assurance.setCellValueFactory(new PropertyValueFactory<>("Assurance"));

        table.getColumns().addAll(idClient, StartDate, EndDate, immatriculation, StartAgency, EndAgency, Price, Assurance);

        EntityManager entityManager = initEntityManager();
        List<Devis> devis = (List<Devis>) entityManager.createQuery("FROM Devis ").getResultList();
        insertTable(devis);
        table.layout();
        table.getColumns().forEach(column -> column.setMinWidth(125));
        entityManager.close();
    }


    public EntityManager initEntityManager() {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        return entityManager;
    }

    private void insertTable(List<Devis> listDevis){
//        for(Devis devis: listDevis) {
//            TableViewDevis tableview = new TableViewDevis(devis);
//            table.getItems().add(tableview);
//        }
    }

    public void add_entry() {
//        EntityManager entityManager = initEntityManager();
//
//        Adresse adresse = new Adresse(address.getText(),postalcode.getText());
//        Personne personne = new Personne(familyname.getText(),name.getText(),mail.getText(),phone.getText(),adresse);
//        Client client;
//
//        if(program.getSelectionModel().getSelectedIndex()!=0 && date.getValue()!=null) {
//            ProgrammeFidelite pgr = (ProgrammeFidelite) entityManager.createQuery("FROM ProgrammeFidelite WHERE idProgramme = :id")
//                    .setParameter("id", program.getSelectionModel().getSelectedIndex()).getSingleResult();
//            client = new Client(date.getValue(),pgr,personne);
//        } else{
//            client = new Client(personne);
//        }
//
//        try {
//            entityManager.getTransaction().begin();
//            entityManager.persist(adresse);
//            entityManager.persist(personne);
//            entityManager.persist(client);
//            entityManager.getTransaction().commit();
//
//            TableViewCustomers tableview = new TableViewCustomers(client);
//            table.getItems().add(tableview);
//        } catch (Exception error) {
//            erreur.setText(error.getMessage());
//        }
//
//        entityManager.close();
    }

    public void delete_entry() {
//        EntityManager entityManager = initEntityManager();
//        entityManager.getTransaction().begin();
//        TableViewDevis tableview = table.getSelectionModel().getSelectedItem();
//        table.getItems().remove(tableview);
//        Devis devis = tableview.getDevis();
//        entityManager.createQuery("delete from devis where num_devis = :idDevis")
//                .setParameter("idDevis",devis).executeUpdate();
//        entityManager.getTransaction().commit();
//        entityManager.close();
    }

    public void edit_entry() throws ParseException {
//        EntityManager entityManager = initEntityManager();
//        entityManager.getTransaction().begin();
//        TableViewDevis tableview = table.getSelectionModel().getSelectedItem();
//        Devis devis = entityManager.find(Devis.class, tableview.getDevis().getNumDevis());
//        devis.setIdClient(Integer.parseInt(idClient.getText()));
//        Date startdate = new SimpleDateFormat("yyyy-MM-dd").parse(StartDate.getText());
//        devis.setDatedebut((java.sql.Date) startdate);
//        Date enddate = new SimpleDateFormat("yyyy-MM-dd").parse(EndDate.getText())
//        devis.setDatefin(EndDate.getText());
//        personne.setNumtelephone(phone.getText());
//        adresse.setCodePostal(postalcode.getText());
//        adresse.setRue(address.getText());
//        if(program.getSelectionModel().getSelectedIndex()!=0 && date.getValue()!=null) {
//            ProgrammeFidelite pgr = (ProgrammeFidelite) entityManager.createQuery("FROM ProgrammeFidelite WHERE idProgramme = :id")
//                    .setParameter("id", program.getSelectionModel().getSelectedIndex()).getSingleResult();
//            client.setDateSouscription(date.getValue());
//            client.setIdProgramme(pgr);
//        } else{
//            client.setDateSouscription(null);
//            client.setIdProgramme(null);
//        }
//        entityManager.getTransaction().commit();
//        entityManager.close();
//        table.getItems().remove(tableview);
//        TableViewCustomers tableView = new TableViewCustomers(client);
//        table.getItems().add(tableView);
    }

    public void set_entry() {
//        TableViewCustomers tableview = table.getSelectionModel().getSelectedItem();
//        if(tableview!=null) {
//            familyname.setText(tableview.getNom());
//            name.setText(tableview.getPrenom());
//            mail.setText(tableview.getMail());
//            phone.setText(tableview.getNumtelephone());
//            postalcode.setText(tableview.getCodepostal());
//            address.setText(tableview.getRue());
//        }
//    }
}