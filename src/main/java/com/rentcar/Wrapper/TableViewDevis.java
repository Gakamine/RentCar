package com.rentcar.Wrapper;

import com.rentcar.Models.Devis;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

public class TableViewDevis {
    private Devis devis;

    public TableViewDevis(Devis devis){
        this.devis=devis;
    }

    public Devis getDevis() {
        return devis;
    }
    public void setDevis(Devis devis){
        this.devis=devis;
    }

    public int getNumDevis(){ return devis.getNumDevis(); }
    public int getIdClient(){ return devis.getIdClient();}
    public Date getDateDebut(){return devis.getDatedebut();}
    public Date getDateFin(){return devis.getDatefin();}
    public int getImmatriculation(){return devis.getImmatriculation();}
    public int getAgenceD(){return devis.getAgencedepart();}
    public int getAgenceQ(){return devis.getAgencearrivee();}
    public BigDecimal getPrix(){return devis.getPrix();}

}