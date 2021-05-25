package com.rentcar.Controllers;

import com.rentcar.Models.*;
import com.rentcar.Wrapper.TableViewCars;
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

public class Cars {

    class Wrapper {
        private Personne personne;
    }

    UserSession session = UserSession.getSession();

    @FXML private TextField search_input;
    @FXML private ComboBox filters;
    @FXML private TableView<TableViewCars> table;
    @FXML private Pane editor;
    @FXML private TextField brand;
    @FXML private TextField model;
    @FXML private TextField km;
    @FXML private CheckBox auto;
    @FXML private CheckBox climatisation;
    @FXML private TextField immatriculation;
    @FXML private ComboBox category;
    @FXML private ComboBox fuel;
    @FXML private Label erreur;

    @FXML
    public void initialize() {
        if(session.getUser().getHoteAccueil() || session.isAdmin()) {
            editor.setVisible(true);
        }

        filters.getSelectionModel().selectFirst();
        category.getSelectionModel().selectFirst();
        fuel.getSelectionModel().selectFirst();

        TableColumn<TableViewCars, TextFieldTableCell> immatriculation = new TableColumn<>("Immatriculation");
        immatriculation.setCellValueFactory(new PropertyValueFactory<>("Immatriculation"));

        TableColumn<TableViewCars, TextFieldTableCell> marque = new TableColumn<>("Marque");
        marque.setCellValueFactory(new PropertyValueFactory<>("Marque"));

        TableColumn<TableViewCars, TextFieldTableCell> modele = new TableColumn<>("Modèle");
        modele.setCellValueFactory(new PropertyValueFactory<>("Modele"));

        TableColumn<TableViewCars, TextFieldTableCell> km = new TableColumn<>("Kilomètrage");
        km.setCellValueFactory(new PropertyValueFactory<>("Km"));

        TableColumn<TableViewCars, Boolean> auto = new TableColumn<>("Automatique");
        auto.setCellValueFactory(new PropertyValueFactory<>("Auto"));

        TableColumn<TableViewCars, TextFieldTableCell> climatisation = new TableColumn<>("Climatisation");
        climatisation.setCellValueFactory(new PropertyValueFactory<>("Climatisation"));

        TableColumn<TableViewCars, TextFieldTableCell> carburant = new TableColumn<>("Carburant");
        carburant.setCellValueFactory(new PropertyValueFactory<>("Carburant"));

        TableColumn<TableViewCars, TextFieldTableCell> categorie = new TableColumn<>("Catégorie");
        categorie.setCellValueFactory(new PropertyValueFactory<>("Categorie"));

        table.getColumns().addAll(immatriculation,marque,modele,km,auto,climatisation,carburant,categorie);

        EntityManager entityManager = initEntityManager();
        List<Vehicule> voitures = (List<Vehicule>) entityManager.createQuery("FROM Vehicule ").getResultList();
        insertTable(voitures);
        table.layout();
        table.getColumns().forEach(column -> column.setMinWidth(125));
        entityManager.close();
    }

    public void add_entry() {
        System.out.println(auto.selectedProperty().get());
        EntityManager entityManager = initEntityManager();
        Integer imt = Integer.parseInt(immatriculation.getText());
        Integer kilometre = Integer.parseInt(km.getText());
//        CategorieVehicule cat = (CategorieVehicule) entityManager.createQuery("FROM CategorieVehicule WHERE idCatvehicule = :id").setParameter("id");
//        Vehicule voiture = new Vehicule(imt, brand.getText(), model.getText(),kilometre,auto.selectedProperty().get(),climatisation.selectedProperty().get(),fuel.getValue());
//
//        try {
//            entityManager.getTransaction().begin();
//            entityManager.persist(voiture);
//            entityManager.getTransaction().commit();
//
//            TableViewCars tableview = new TableViewCars(voiture);
//            table.getItems().add(tableview);
//        } catch (Exception error) {
//            erreur.setText(error.getMessage());
//        }

        entityManager.close();
    }

    public void delete_entry() {
//        EntityManager entityManager = initEntityManager();
//        entityManager.getTransaction().begin();
//        TableViewCustomers tableview = table.getSelectionModel().getSelectedItem();
//        table.getItems().remove(tableview);
//        Personne personne = tableview.getPersonne();
//        entityManager.createQuery("delete from Client where personneByIdPersonne = :idPersonne")
//                .setParameter("idPersonne",personne).executeUpdate();
//        entityManager.getTransaction().commit();
//        entityManager.close();
    }

    public void edit_entry() {
//        EntityManager entityManager = initEntityManager();
//        entityManager.getTransaction().begin();
//        TableViewCustomers tableview = table.getSelectionModel().getSelectedItem();
//        Personne personne = entityManager.find(Personne.class, tableview.getPersonne().getIdPersonne());
//        Adresse adresse = entityManager.find(Adresse.class, tableview.getAdresse().getIdAdresse());
//        Client client = entityManager.find(Client.class, tableview.getClient().getIdClient());
//        personne.setNom(familyname.getText());
//        personne.setPrenom(name.getText());
//        personne.setMail(mail.getText());
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
        List<Vehicule> voitures;
        switch (filters.getSelectionModel().getSelectedIndex()) {
            case 0:
                if(search_input.getText()=="") {
                    voitures = (List<Vehicule>) entityManager.createQuery("FROM Vehicule ").getResultList();
                    insertTable(voitures);
                } else {
                    voitures = (List<Vehicule>) entityManager.createQuery("FROM Vehicule WHERE UPPER(marque) LIKE upper( '%'||:marque||'%' ) ")
                            .setParameter("marque",search_input.getText())
                            .getResultList();
                    insertTable(voitures);
                }
                break;
            case 1:
                voitures = (List<Vehicule>) entityManager.createQuery("SELECT v FROM Vehicule v JOIN Devis d ON v.immatriculation = d.immatriculation WHERE current_date BETWEEN d.datedebut AND d.datefin")
                        .getResultList();
                insertTable(voitures);
                break;
            case 2:
                voitures = (List<Vehicule>) entityManager.createQuery("SELECT v FROM Vehicule v JOIN CategorieVehicule c ON c.idCatvehicule = v.categorieVehiculeByIdCatvehicule WHERE c.idCatvehicule = 3")
                        .getResultList();
                insertTable(voitures);
                break;
            case 3:
                voitures = (List<Vehicule>) entityManager.createQuery("SELECT v FROM Vehicule v JOIN CategorieVehicule c ON c.idCatvehicule = v.categorieVehiculeByIdCatvehicule WHERE c.idCatvehicule = 2")
                        .getResultList();
                insertTable(voitures);
                break;
            case 4:
                voitures = (List<Vehicule>) entityManager.createQuery("SELECT v FROM Vehicule v JOIN CategorieVehicule c ON c.idCatvehicule = v.categorieVehiculeByIdCatvehicule WHERE c.idCatvehicule = 1")
                        .getResultList();
                insertTable(voitures);
                break;
        }
    }

    private void insertTable(List<Vehicule> voitures){
        for(Vehicule voiture: voitures) {
            TableViewCars tableview = new TableViewCars(voiture);
            table.getItems().add(tableview);
        }
    }
}
