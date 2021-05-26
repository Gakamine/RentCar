package com.rentcar.Models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Vehicule {
    private int immatriculation;
    private String marque;
    private String modele;
    private BigDecimal km;
    private Boolean typeAuto;
    private Boolean climatisation;
    private CategorieVehicule categorieVehiculeByIdCatvehicule;
    private CategorieCarburant categorieCarburantByIdCarburant;

    public Vehicule(int immatriculation, String marque, String modele, BigDecimal km, Boolean typeAuto, Boolean climatisation, CategorieVehicule categorieVehiculeByIdCatvehicule, CategorieCarburant categorieCarburantByIdCarburant) {
        this.immatriculation = immatriculation;
        this.marque = marque;
        this.modele = modele;
        this.km = km;
        this.typeAuto = typeAuto;
        this.climatisation = climatisation;
        this.categorieVehiculeByIdCatvehicule = categorieVehiculeByIdCatvehicule;
        this.categorieCarburantByIdCarburant = categorieCarburantByIdCarburant;
    }

    public Vehicule() {
    }

    public Vehicule(Integer imt, String text, String text1, BigDecimal kilometre, boolean b, boolean b1, Object value) {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "immatriculation", nullable = false)
    public int getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(int immatriculation) {
        this.immatriculation = immatriculation;
    }

    @Basic
    @Column(name = "marque", nullable = true, length = 50)
    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    @Basic
    @Column(name = "modele", nullable = true, length = 50)
    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    @Basic
    @Column(name = "km", nullable = true, precision = 2)
    public BigDecimal getKm() {
        return km;
    }

    public void setKm(BigDecimal km) {
        this.km = km;
    }

    @Basic
    @Column(name = "type_auto", nullable = true)
    public Boolean getTypeAuto() {
        return typeAuto;
    }

    public void setTypeAuto(Boolean typeAuto) {
        this.typeAuto = typeAuto;
    }

    @Basic
    @Column(name = "climatisation", nullable = true)
    public Boolean getClimatisation() {
        return climatisation;
    }

    public void setClimatisation(Boolean climatisation) {
        this.climatisation = climatisation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicule vehicule = (Vehicule) o;
        return immatriculation == vehicule.immatriculation && Objects.equals(marque, vehicule.marque) && Objects.equals(modele, vehicule.modele) && Objects.equals(km, vehicule.km) && Objects.equals(typeAuto, vehicule.typeAuto) && Objects.equals(climatisation, vehicule.climatisation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(immatriculation, marque, modele, km, typeAuto, climatisation);
    }

    @ManyToOne
    @JoinColumn(name = "id_catvehicule", referencedColumnName = "id_catvehicule", nullable = false)
    public CategorieVehicule getCategorieVehiculeByIdCatvehicule() {
        return categorieVehiculeByIdCatvehicule;
    }

    public void setCategorieVehiculeByIdCatvehicule(CategorieVehicule categorieVehiculeByIdCatvehicule) {
        this.categorieVehiculeByIdCatvehicule = categorieVehiculeByIdCatvehicule;
    }

    @ManyToOne
    @JoinColumn(name = "id_carburant", referencedColumnName = "id_carburant", nullable = false)
    public CategorieCarburant getCategorieCarburantByIdCarburant() {
        return categorieCarburantByIdCarburant;
    }

    public void setCategorieCarburantByIdCarburant(CategorieCarburant categorieCarburantByIdCarburant) {
        this.categorieCarburantByIdCarburant = categorieCarburantByIdCarburant;
    }
}
