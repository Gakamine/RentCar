package com.rentcar.Models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Personne {
    private int idPersonne;
    private String nom;
    private String prenom;
    private String mail;
    private String numtelephone;
    private String login;
    private String mdp;

    @Id
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
    @Column(name = "mail", nullable = true, length = 50)
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

    @Basic
    @Column(name = "login", nullable = true, length = 50)
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Basic
    @Column(name = "mdp", nullable = true, length = 50)
    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return idPersonne == personne.idPersonne && Objects.equals(nom, personne.nom) && Objects.equals(prenom, personne.prenom) && Objects.equals(mail, personne.mail) && Objects.equals(numtelephone, personne.numtelephone) && Objects.equals(login, personne.login) && Objects.equals(mdp, personne.mdp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPersonne, nom, prenom, mail, numtelephone, login, mdp);
    }
}
