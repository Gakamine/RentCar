package com.rentcar.Models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Employes {
    private int idEmployes;
    private Boolean admin;
    private Boolean hoteAccueil;
    private Boolean chauffeur;

    @Id
    @Column(name = "id_employes", nullable = false)
    public int getIdEmployes() {
        return idEmployes;
    }

    public void setIdEmployes(int idEmployes) {
        this.idEmployes = idEmployes;
    }

    @Basic
    @Column(name = "admin", nullable = true)
    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @Basic
    @Column(name = "hote_accueil", nullable = true)
    public Boolean getHoteAccueil() {
        return hoteAccueil;
    }

    public void setHoteAccueil(Boolean hoteAccueil) {
        this.hoteAccueil = hoteAccueil;
    }

    @Basic
    @Column(name = "chauffeur", nullable = true)
    public Boolean getChauffeur() {
        return chauffeur;
    }

    public void setChauffeur(Boolean chauffeur) {
        this.chauffeur = chauffeur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employes employes = (Employes) o;
        return idEmployes == employes.idEmployes && Objects.equals(admin, employes.admin) && Objects.equals(hoteAccueil, employes.hoteAccueil) && Objects.equals(chauffeur, employes.chauffeur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmployes, admin, hoteAccueil, chauffeur);
    }
}
