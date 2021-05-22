package com.rentcar.Models;

import com.amdelamar.jhash.Hash;
import com.amdelamar.jhash.algorithms.Type;
import com.amdelamar.jhash.exception.InvalidHashException;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Employe {
    private int idEmployes;
    private Boolean admin;
    private Boolean hoteAccueil;
    private Boolean chauffeur;
    private String login;
    private String mdp;
    private Personne id_personne;

    public Employe(String login, String mdp, Personne idPersonne) {
        this.admin = false;
        this.hoteAccueil = false;
        this.chauffeur = false;
        this.login = login;
        this.mdp = hashPassword(mdp);
        this.id_personne = idPersonne;
    }

    public Employe() {

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

    private void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void changeMdp(String mdp) {
        this.mdp = hashPassword(mdp);
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
        Employe employe = (Employe) o;
        return idEmployes == employe.idEmployes && Objects.equals(admin, employe.admin) && Objects.equals(hoteAccueil, employe.hoteAccueil) && Objects.equals(chauffeur, employe.chauffeur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmployes, admin, hoteAccueil, chauffeur);
    }

    public Boolean authenticate(String mdp) throws InvalidHashException {
        return Hash.password(mdp.toCharArray()).verify(this.mdp);
    }

    public String hashPassword(String mdp) {
        char[] password = mdp.toCharArray();
        return Hash.password(password).algorithm(Type.BCRYPT).create();
    }

    @ManyToOne
    @JoinColumn(name = "id_personne", referencedColumnName = "id_personne")
    public Personne getPersonneByIdPersonne() {
        return id_personne;
    }

    public void setPersonneByIdPersonne(Personne personneByIdPersonne) {
        this.id_personne = personneByIdPersonne;
    }
}
