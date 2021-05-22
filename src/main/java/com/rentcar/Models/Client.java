package com.rentcar.Models;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Entity
public class Client {
    private int idClient;
    private LocalDate dateSouscription;
    private Personne idPersonne;

    public Client(LocalDate dateSouscription, Personne idPersonne) {
        this.dateSouscription = dateSouscription;
        this.idPersonne = idPersonne;
    }

    public Client() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_client", nullable = false)
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    @Column(name = "date_souscription", nullable = true)
    public LocalDate getDateSouscription() {
        return dateSouscription;
    }

    public void setDateSouscription(LocalDate dateSouscription) {
        this.dateSouscription = dateSouscription;
    }

    @ManyToOne
    @JoinColumn(name = "id_personne", referencedColumnName = "id_personne")
    public Personne getPersonneByIdPersonne() {
        return idPersonne;
    }

    public void setPersonneByIdPersonne(Personne personneByIdPersonne) {
        this.idPersonne = personneByIdPersonne;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return idClient == client.idClient;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient);
    }
}
