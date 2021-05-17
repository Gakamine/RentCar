package com.rentcar.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Devis {
    private int numDevis;

    @Id
    @Column(name = "num_devis", nullable = false)
    public int getNumDevis() {
        return numDevis;
    }

    public void setNumDevis(int numDevis) {
        this.numDevis = numDevis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Devis devis = (Devis) o;
        return numDevis == devis.numDevis;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numDevis);
    }
}
