package com.rentcar.Models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Agence {
    private int idAgence;
    private String nom;
    private String numtelephone;
    private BigDecimal gpsLat;
    private BigDecimal gpsLong;
    private Adresse adresseByIdAdresse;
    private Integer idAdresse;
    private Integer nbmaxvehicule;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_agence", nullable = false)
    public int getIdAgence() {
        return idAgence;
    }

    public void setIdAgence(int idAgence) {
        this.idAgence = idAgence;
    }

    @Basic
    @Column(name = "nom", nullable = true, length = 50)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "numtelephone", nullable = true, length = 50)
    public String getNumtelephone() {
        return numtelephone;
    }

    public void setNumtelephone(String numtelephone) {
        this.numtelephone = numtelephone;
    }

    @Basic
    @Column(name = "gps_lat", nullable = true, precision = 2)
    public BigDecimal getGpsLat() {
        return gpsLat;
    }

    public void setGpsLat(BigDecimal gpsLat) {
        this.gpsLat = gpsLat;
    }

    @Basic
    @Column(name = "gps_long", nullable = true, precision = 2)
    public BigDecimal getGpsLong() {
        return gpsLong;
    }

    public void setGpsLong(BigDecimal gpsLong) {
        this.gpsLong = gpsLong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agence agence = (Agence) o;
        return idAgence == agence.idAgence && Objects.equals(nom, agence.nom) && Objects.equals(numtelephone, agence.numtelephone) && Objects.equals(gpsLat, agence.gpsLat) && Objects.equals(gpsLong, agence.gpsLong);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAgence, nom, numtelephone, gpsLat, gpsLong);
    }

    @ManyToOne
    @JoinColumn(name = "id_adresse", referencedColumnName = "id_adresse")
    public Adresse getAdresseByIdAdresse() {
        return adresseByIdAdresse;
    }

    public void setAdresseByIdAdresse(Adresse adresseByIdAdresse) {
        this.adresseByIdAdresse = adresseByIdAdresse;
    }

    @Basic
    @Column(name = "nbmaxvehicule", nullable = true)
    public Integer getNbmaxvehicule() {
        return nbmaxvehicule;
    }

    public void setNbmaxvehicule(Integer nbmaxvehicule) {
        this.nbmaxvehicule = nbmaxvehicule;
    }
}
