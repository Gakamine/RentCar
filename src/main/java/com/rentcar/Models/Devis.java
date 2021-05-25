package com.rentcar.Models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Devis {
    private int numDevis;
    private Integer idClient;
    private Date datedebut;
    private Date datefin;
    private Integer immatriculation;
    private Integer agencedepart;
    private Integer agencearrivee;
    private BigDecimal prix;

    @Id
    @Column(name = "num_devis", nullable = false)
    public int getNumDevis() {
        return numDevis;
    }

    public void setNumDevis(int numDevis) {
        this.numDevis = numDevis;
    }

    @Basic
    @Column(name = "id_client", nullable = true)
    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    @Basic
    @Column(name = "datedebut", nullable = true)
    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    @Basic
    @Column(name = "datefin", nullable = true)
    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    @Basic
    @Column(name = "immatriculation", nullable = true)
    public Integer getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(Integer immatriculation) {
        this.immatriculation = immatriculation;
    }

    @Basic
    @Column(name = "agencedepart", nullable = true)
    public Integer getAgencedepart() {
        return agencedepart;
    }

    public void setAgencedepart(Integer agencedepart) {
        this.agencedepart = agencedepart;
    }

    @Basic
    @Column(name = "agencearrivee", nullable = true)
    public Integer getAgencearrivee() {
        return agencearrivee;
    }

    public void setAgencearrivee(Integer agencearrivee) {
        this.agencearrivee = agencearrivee;
    }

    @Basic
    @Column(name = "prix", nullable = true)
    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Devis devis = (Devis) o;
        return numDevis == devis.numDevis && Objects.equals(idClient, devis.idClient) && Objects.equals(datedebut, devis.datedebut) && Objects.equals(datefin, devis.datefin) && Objects.equals(immatriculation, devis.immatriculation) && Objects.equals(agencedepart, devis.agencedepart) && Objects.equals(agencearrivee, devis.agencearrivee) && Objects.equals(prix, devis.prix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numDevis, idClient, datedebut, datefin, immatriculation, agencedepart, agencearrivee, prix);
    }
}
