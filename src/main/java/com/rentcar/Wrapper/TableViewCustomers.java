package com.rentcar.Wrapper;

import com.rentcar.Controllers.Customers;
import com.rentcar.Models.Adresse;
import com.rentcar.Models.Client;
import com.rentcar.Models.Personne;
import com.rentcar.Models.ProgrammeFidelite;

import java.time.LocalDate;

public class TableViewCustomers {
    private Personne personne;
    private Adresse adresse;
    private Client client;
    private ProgrammeFidelite pgr;

    public TableViewCustomers(Client client) {
        this.personne = client.getPersonneByIdPersonne();
        this.adresse = personne.getAdresseByIdAdresse();
        this.client = client;
        this.pgr = client.getIdProgramme();
    }

    public Personne getPersonne() {
        return personne;
    }

    public Adresse getAdresse() { return adresse; }

    public Client getClient() { return client; }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setPgr(ProgrammeFidelite pgr) {
        this.pgr = pgr;
    }

    public Integer getId() {
        return personne.getIdPersonne();
    }

    public String getNom() {
        return personne.getNom();
    }

    public String getPrenom() { return personne.getPrenom(); }

    public String getMail() { return personne.getMail(); }

    public String getNumtelephone() { return personne.getNumtelephone(); }

    public String getCodepostal() {
        return adresse.getCodePostal();
    }

    public String getRue() { return adresse.getRue(); }

    public LocalDate getDatesouscription() { return client.getDateSouscription(); }

    public String getProgramme() {
        if(pgr!=null) {
            return pgr.getTypedeprogramme();
        } else {
            return null;
        }
    }

}
