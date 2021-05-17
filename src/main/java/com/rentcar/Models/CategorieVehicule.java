package com.rentcar.Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "categorie_vehicule", schema = "public", catalog = "postgres")
public class CategorieVehicule {
    private int idCatvehicule;
    private String type;
    private Object tarif;

    @Id
    @Column(name = "id_catvehicule", nullable = false)
    public int getIdCatvehicule() {
        return idCatvehicule;
    }

    public void setIdCatvehicule(int idCatvehicule) {
        this.idCatvehicule = idCatvehicule;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 50)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "tarif", nullable = true)
    public Object getTarif() {
        return tarif;
    }

    public void setTarif(Object tarif) {
        this.tarif = tarif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategorieVehicule that = (CategorieVehicule) o;
        return idCatvehicule == that.idCatvehicule && Objects.equals(type, that.type) && Objects.equals(tarif, that.tarif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCatvehicule, type, tarif);
    }
}
