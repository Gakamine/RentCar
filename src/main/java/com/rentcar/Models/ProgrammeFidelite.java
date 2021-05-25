package com.rentcar.Models;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Objects;

@Entity
@Table(name = "programme_fidelite", schema = "public", catalog = "postgres")
public class ProgrammeFidelite {
    private int idProgramme;
    private Integer duree;
    private String description;
    private BigDecimal prix;
    private BigDecimal tauxReduction;
    private String typedeprogramme;

    @Id
    @Column(name = "id_programme", nullable = false)
    public int getIdProgramme() {
        return idProgramme;
    }

    public void setIdProgramme(int idProgramme) {
        this.idProgramme = idProgramme;
    }

    @Basic
    @Column(name = "duree", nullable = true)
    public Integer getDuree() {
        return duree;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 50)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "prix", nullable = true)
    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    @Basic
    @Column(name = "taux_reduction", nullable = true, precision = 2)
    public BigDecimal getTauxReduction() {
        return tauxReduction;
    }

    public void setTauxReduction(BigDecimal tauxReduction) {
        this.tauxReduction = tauxReduction;
    }

    @Basic
    @Column(name = "typedeprogramme", nullable = true, length = 50)
    public String getTypedeprogramme() {
        return typedeprogramme;
    }

    public void setTypedeprogramme(String typedeprogramme) {
        this.typedeprogramme = typedeprogramme;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProgrammeFidelite that = (ProgrammeFidelite) o;
        return idProgramme == that.idProgramme && Objects.equals(duree, that.duree) && Objects.equals(description, that.description) && Objects.equals(prix, that.prix) && Objects.equals(tauxReduction, that.tauxReduction) && Objects.equals(typedeprogramme, that.typedeprogramme);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProgramme, duree, description, prix, tauxReduction, typedeprogramme);
    }
}
