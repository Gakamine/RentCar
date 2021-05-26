package com.rentcar.Controllers;

import com.rentcar.Models.*;
import com.rentcar.Wrapper.TableViewCars;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.List;

public class Cars {

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

    public void add_entry() throws ParseException {

        Vehicule car;

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator('.');
        String pattern = "#,##0.0#";
        DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
        decimalFormat.setParseBigDecimal(true);

        EntityManager entityManager = initEntityManager();
        Integer imt = Integer.parseInt(immatriculation.getText());

        BigDecimal kilometre = null;
        try {
            kilometre = (BigDecimal) decimalFormat.parse(km.getText());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        CategorieVehicule cat = (CategorieVehicule) entityManager.createQuery("FROM CategorieVehicule WHERE idCatvehicule = :id").setParameter("id", category.getSelectionModel().getSelectedIndex()).getSingleResult();
        CategorieCarburant cat_fuel = (CategorieCarburant) entityManager.createQuery("FROM CategorieCarburant WHERE idCarburant = :id").setParameter("id", fuel.getSelectionModel().getSelectedIndex()).getSingleResult();

        car = new Vehicule(imt, brand.getText(), model.getText(), kilometre, auto.selectedProperty().get(), climatisation.selectedProperty().get(), cat, cat_fuel);

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(car);
            entityManager.getTransaction().commit();

            TableViewCars tableview = new TableViewCars(car);
            table.getItems().add(tableview);
        } catch (Exception error) {
            System.out.println(error);
            erreur.setText(error.getMessage());
        }

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

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator('.');
        String pattern = "#,##0.0#";
        DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
        decimalFormat.setParseBigDecimal(true);

        EntityManager entityManager = initEntityManager();
        entityManager.getTransaction().begin();
        TableViewCars tableview = table.getSelectionModel().getSelectedItem();
        Vehicule vehicule = entityManager.find(Vehicule.class, tableview.getCar());
        vehicule.setMarque(brand.getText());
        vehicule.setModele(model.getText());

        Integer imt = Integer.parseInt(immatriculation.getText());
        vehicule.setImmatriculation(imt);
        vehicule.setClimatisation(climatisation.selectedProperty().get());
        vehicule.setTypeAuto(auto.selectedProperty().get());
        CategorieVehicule cat = (CategorieVehicule) entityManager.createQuery("FROM CategorieVehicule WHERE idCatvehicule = :id").setParameter("id", category.getSelectionModel().getSelectedIndex()).getSingleResult();
        CategorieCarburant cat_fuel = (CategorieCarburant) entityManager.createQuery("FROM CategorieCarburant WHERE idCarburant = :id").setParameter("id", fuel.getSelectionModel().getSelectedIndex()).getSingleResult();
        vehicule.setCategorieVehiculeByIdCatvehicule(cat);
        vehicule.setCategorieCarburantByIdCarburant(cat_fuel);
        BigDecimal kilometre = null;
        try {
            kilometre = (BigDecimal) decimalFormat.parse(km.getText());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        vehicule.setKm(kilometre);
        entityManager.getTransaction().commit();
        entityManager.close();
        table.getItems().remove(tableview);
        TableViewCars tableView = new TableViewCars(vehicule);
        table.getItems().add(tableView);
    }

    public void set_entry() {
        TableViewCars tableview = table.getSelectionModel().getSelectedItem();
        if(tableview!=null) {
            brand.setText(tableview.getMarque());
            model.setText(tableview.getModele());
            immatriculation.setText(String.valueOf(tableview.getImmatriculation()));
            km.setText(String.valueOf(tableview.getKm()));
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
