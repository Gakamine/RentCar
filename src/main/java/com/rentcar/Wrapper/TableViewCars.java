package com.rentcar.Wrapper;

import com.rentcar.Models.CategorieCarburant;
import com.rentcar.Models.CategorieVehicule;
import com.rentcar.Models.Vehicule;

import java.math.BigDecimal;

public class TableViewCars {
    private Vehicule car;
    private CategorieVehicule category;
    private CategorieCarburant fuel;

    public TableViewCars(Vehicule car) {
        this.car = car;
        this.category = car.getCategorieVehiculeByIdCatvehicule();
        this.fuel = car.getCategorieCarburantByIdCarburant();
    }

    public int getImmatriculation() {
        return car.getImmatriculation();
    }

    public String getMarque() {
        return  car.getMarque();
    }

    public String getModele() {
        return car.getModele();
    }

    public BigDecimal getKm() {
        return car.getKm();
    }

    public Boolean getAuto() {
        return car.getTypeAuto();
    }

    public Boolean getClimatisation() {
        return car.getClimatisation();
    }

    public String getCarburant() {
        return fuel.getType();
    }

    public String getCategorie() {
        return category.getType();
    }

    public Vehicule getCar() { return car; }
}
