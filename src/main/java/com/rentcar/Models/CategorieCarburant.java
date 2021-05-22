package com.rentcar.Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "categorie_carburant", schema = "public", catalog = "postgres")
public class CategorieCarburant {
    private int idCarburant;
    private String type;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_carburant", nullable = false)
    public int getIdCarburant() {
        return idCarburant;
    }

    public void setIdCarburant(int idCarburant) {
        this.idCarburant = idCarburant;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 50)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategorieCarburant that = (CategorieCarburant) o;
        return idCarburant == that.idCarburant && Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCarburant, type);
    }
}
