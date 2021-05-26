package com.rentcar.Controllers;

import com.rentcar.Models.*;
import com.rentcar.Wrapper.TableViewCustomers;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Customers {

    UserSession session = UserSession.getSession();

    @FXML private TextField search_input;
    @FXML private ComboBox filters;
    @FXML private TableView<TableViewCustomers> table;
    @FXML private Pane editor;
    @FXML private TextField name;
    @FXML private TextField familyname;
    @FXML private TextField phone;
    @FXML private TextField mail;
    @FXML private TextField postalcode;
    @FXML private TextField address;
    @FXML private DatePicker date;
    @FXML private ComboBox program;
    @FXML private Label erreur;

    @FXML
    public void initialize() {
        if(session.getUser().getHoteAccueil() || session.isAdmin()) {
            editor.setVisible(true);
        }

        filters.getSelectionModel().selectFirst();
        program.getSelectionModel().selectFirst();

        TableColumn<TableViewCustomers, TextFieldTableCell> id = new TableColumn<>("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("Id"));

        TableColumn<TableViewCustomers, TextFieldTableCell> nom = new TableColumn<>("Nom");
        nom.setCellValueFactory(new PropertyValueFactory<>("Nom"));

        TableColumn<TableViewCustomers, TextFieldTableCell> prenom = new TableColumn<>("Prénom");
        prenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));

        TableColumn<TableViewCustomers, TextFieldTableCell> mail = new TableColumn<>("Mail");
        mail.setCellValueFactory(new PropertyValueFactory<>("Mail"));

        TableColumn<TableViewCustomers, TextFieldTableCell> telephone = new TableColumn<>("Téléphone");
        telephone.setCellValueFactory(new PropertyValueFactory<>("Numtelephone"));

        TableColumn<TableViewCustomers, TextFieldTableCell> codepostal = new TableColumn<>("Code postal");
        codepostal.setCellValueFactory(new PropertyValueFactory<>("Codepostal"));

        TableColumn<TableViewCustomers, TextFieldTableCell> rue = new TableColumn<>("Adresse");
        rue.setCellValueFactory(new PropertyValueFactory<>("Rue"));

        TableColumn<TableViewCustomers, TextFieldTableCell> date = new TableColumn<>("Date souscription");
        date.setCellValueFactory(new PropertyValueFactory<>("Datesouscription"));

        TableColumn<TableViewCustomers, TextFieldTableCell> pgr = new TableColumn<>("Programme fidélité");
        pgr.setCellValueFactory(new PropertyValueFactory<>("Programme"));

        table.getColumns().addAll(id,nom,prenom,mail,telephone,codepostal,rue,date,pgr);

        EntityManager entityManager = initEntityManager();
        List<Client> clients = (List<Client>) entityManager.createQuery("FROM Client ").getResultList();
        insertTable(clients);
        table.layout();
        table.getColumns().forEach(column -> column.setMinWidth(125));
        entityManager.close();
    }

    public void add_entry() {
        EntityManager entityManager = initEntityManager();

        Adresse adresse = new Adresse(address.getText(),postalcode.getText());
        Personne personne = new Personne(familyname.getText(),name.getText(),mail.getText(),phone.getText(),adresse);
        Client client;

        if(program.getSelectionModel().getSelectedIndex()!=0 && date.getValue()!=null) {
            ProgrammeFidelite pgr = (ProgrammeFidelite) entityManager.createQuery("FROM ProgrammeFidelite WHERE idProgramme = :id")
                    .setParameter("id", program.getSelectionModel().getSelectedIndex()).getSingleResult();
            client = new Client(date.getValue(),pgr,personne);
        } else{
            client = new Client(personne);
        }

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(adresse);
            entityManager.persist(personne);
            entityManager.persist(client);
            entityManager.getTransaction().commit();

            TableViewCustomers tableview = new TableViewCustomers(client);
            table.getItems().add(tableview);
        } catch (Exception error) {
            erreur.setText(error.getMessage());
        }

        entityManager.close();
    }

    public void delete_entry() {
        EntityManager entityManager = initEntityManager();
        entityManager.getTransaction().begin();
        TableViewCustomers tableview = table.getSelectionModel().getSelectedItem();
        table.getItems().remove(tableview);
        Personne personne = tableview.getPersonne();
        entityManager.createQuery("delete from Client where personneByIdPersonne = :idPersonne")
                .setParameter("idPersonne",personne).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void edit_entry() {
        EntityManager entityManager = initEntityManager();
        entityManager.getTransaction().begin();
        TableViewCustomers tableview = table.getSelectionModel().getSelectedItem();
        Personne personne = entityManager.find(Personne.class, tableview.getPersonne().getIdPersonne());
        Adresse adresse = entityManager.find(Adresse.class, tableview.getAdresse().getIdAdresse());
        Client client = entityManager.find(Client.class, tableview.getClient().getIdClient());
        personne.setNom(familyname.getText());
        personne.setPrenom(name.getText());
        personne.setMail(mail.getText());
        personne.setNumtelephone(phone.getText());
        adresse.setCodePostal(postalcode.getText());
        adresse.setRue(address.getText());
        if(program.getSelectionModel().getSelectedIndex()!=0 && date.getValue()!=null) {
            ProgrammeFidelite pgr = (ProgrammeFidelite) entityManager.createQuery("FROM ProgrammeFidelite WHERE idProgramme = :id")
                    .setParameter("id", program.getSelectionModel().getSelectedIndex()).getSingleResult();
            client.setDateSouscription(date.getValue());
            client.setIdProgramme(pgr);
        } else{
            client.setDateSouscription(null);
            client.setIdProgramme(null);
        }
        entityManager.getTransaction().commit();
        entityManager.close();
        table.getItems().remove(tableview);
        TableViewCustomers tableView = new TableViewCustomers(client);
        table.getItems().add(tableView);
    }

    public void set_entry() {
        TableViewCustomers tableview = table.getSelectionModel().getSelectedItem();
        if(tableview!=null) {
            familyname.setText(tableview.getNom());
            name.setText(tableview.getPrenom());
            mail.setText(tableview.getMail());
            phone.setText(tableview.getNumtelephone());
            postalcode.setText(tableview.getCodepostal());
            address.setText(tableview.getRue());
        }
    }

    public EntityManager initEntityManager() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }

    public void search() {
        EntityManager entityManager = initEntityManager();
        entityManager.getTransaction().begin();
        table.getItems().clear();
        List<Client> clients;
        switch (filters.getSelectionModel().getSelectedIndex()) {
            case 0:
                if(search_input.getText()=="") {
                    clients = (List<Client>) entityManager.createQuery("FROM Client").getResultList();
                    insertTable(clients);
                } else {
                    clients = (List<Client>) entityManager.createQuery("FROM Client WHERE UPPER(personneByIdPersonne.nom) LIKE upper( '%'||:nom||'%' ) ")
                            .setParameter("nom",search_input.getText())
                            .getResultList();
                    insertTable(clients);
                }
                break;
            case 1:
                clients = (List<Client>) entityManager.createQuery("SELECT c FROM Client c JOIN Devis d ON d.idClient = c.idClient JOIN Facture f ON d.numDevis=f.numDevis")
                    .getResultList();
                insertTable(clients);
                break;
            case 2:
                clients = (List<Client>) entityManager.createQuery("SELECT c FROM Client c JOIN Devis d ON d.idClient = c.idClient WHERE current_date BETWEEN d.datedebut AND d.datefin")
                        .getResultList();
                insertTable(clients);
                break;
            case 3:
                Integer immatriculation = Integer.parseInt(search_input.getText());
                clients = (List<Client>) entityManager.createQuery("SELECT c FROM Client c JOIN Devis d ON d.idClient = c.idClient WHERE d.immatriculation = :immatriculation")
                        .setParameter("immatriculation", immatriculation)
                        .getResultList();
                insertTable(clients);
                break;
        }
    }

    private void insertTable(List<Client> clients){
        for(Client client: clients) {
            TableViewCustomers tableview = new TableViewCustomers(client);
            table.getItems().add(tableview);
        }
    }
}
