package com.rentcar.Models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Personne {
    private int idPersonne;
    private String nom;
    private String prenom;
    private String mail;
    private String numtelephone;
    private Adresse adresseByIdAdresse;

    public Personne() {
    }

    public Personne(String nom, String prenom, String mail, String numtelephone, Adresse adresseByIdAdresse) {
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.numtelephone = numtelephone;
        this.adresseByIdAdresse = adresseByIdAdresse;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personne", nullable = false)
    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    @Basic
    @Column(name = "nom", nullable = true, length = 50)
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom", nullable = true, length = 50)
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "mail", nullable = true)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Basic
    @Column(name = "numtelephone", nullable = true, length = 50)
    public String getNumtelephone() {
        return numtelephone;
    }

    public void setNumtelephone(String numtelephone) {
        this.numtelephone = numtelephone;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return idPersonne == personne.idPersonne && Objects.equals(nom, personne.nom) && Objects.equals(prenom, personne.prenom) && Objects.equals(mail, personne.mail) && Objects.equals(numtelephone, personne.numtelephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersonne, nom, prenom, mail, numtelephone);
    }

    @ManyToOne
    @JoinColumn(name = "id_adresse", referencedColumnName = "id_adresse")
    public Adresse getAdresseByIdAdresse() {
        return adresseByIdAdresse;
    }

    public void setAdresseByIdAdresse(Adresse adresseByIdAdresse) {
        this.adresseByIdAdresse = adresseByIdAdresse;
    }

}
