package com.rentcar.Models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Adresse {
    private int idAdresse;
    private String rue;
    private String codePostal;

    @Id
    @Column(name = "id_adresse", nullable = false)
    public int getIdAdresse() {
        return idAdresse;
    }

    public void setIdAdresse(int idAdresse) {
        this.idAdresse = idAdresse;
    }

    @Basic
    @Column(name = "rue", nullable = true, length = 50)
    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    @Basic
    @Column(name = "code_postal", nullable = true, length = 50)
    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Adresse adresse = (Adresse) o;
        return idAdresse == adresse.idAdresse && Objects.equals(rue, adresse.rue) && Objects.equals(codePostal, adresse.codePostal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAdresse, rue, codePostal);
    }
}
