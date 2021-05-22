package com.rentcar.Models;

public class UserSession {
    private static UserSession instance = new UserSession();
    private Employe utilisateur;

    public void setSession(Employe utilisateur) {
        this.utilisateur = utilisateur;
    }

    public static UserSession getSession() {
        return instance;
    }

    public Employe getUser() {
        return this.utilisateur;
    }

    public void clearSession() {
        this.utilisateur = null;
    }

    public Boolean isAdmin() {
        return this.utilisateur.getAdmin();
    }

    public Boolean isEmploye() {
        if(this.utilisateur.getChauffeur() || this.utilisateur.getHoteAccueil()) {
            return true;
        } else {
            return false;
        }
    }
}
