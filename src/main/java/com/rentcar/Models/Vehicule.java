package com.rentcar.Models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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

    @Id
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
}
