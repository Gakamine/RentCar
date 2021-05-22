package com.rentcar.Models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Facture {
    private int idfacture;
    private Integer numDevis;
    private Date dateRendu;
    private BigDecimal carburantconsomme;
    private Boolean memeEtat;

    @Id
    @Column(name = "idfacture", nullable = false)
    public int getIdfacture() {
        return idfacture;
    }

    public void setIdfacture(int idfacture) {
        this.idfacture = idfacture;
    }

    @Basic
    @Column(name = "num_devis", nullable = true)
    public Integer getNumDevis() {
        return numDevis;
    }

    public void setNumDevis(Integer numDevis) {
        this.numDevis = numDevis;
    }

    @Basic
    @Column(name = "date_rendu", nullable = true)
    public Date getDateRendu() {
        return dateRendu;
    }

    public void setDateRendu(Date dateRendu) {
        this.dateRendu = dateRendu;
    }

    @Basic
    @Column(name = "carburantconsomme", nullable = true, precision = 2)
    public BigDecimal getCarburantconsomme() {
        return carburantconsomme;
    }

    public void setCarburantconsomme(BigDecimal carburantconsomme) {
        this.carburantconsomme = carburantconsomme;
    }

    @Basic
    @Column(name = "meme_etat", nullable = true)
    public Boolean getMemeEtat() {
        return memeEtat;
    }

    public void setMemeEtat(Boolean memeEtat) {
        this.memeEtat = memeEtat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facture facture = (Facture) o;
        return idfacture == facture.idfacture && Objects.equals(numDevis, facture.numDevis) && Objects.equals(dateRendu, facture.dateRendu) && Objects.equals(carburantconsomme, facture.carburantconsomme) && Objects.equals(memeEtat, facture.memeEtat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idfacture, numDevis, dateRendu, carburantconsomme, memeEtat);
    }
}
