package com.rentcar.Models;

import java.time.LocalDate;

public class TableView_Customers {
    private Integer client_id;
    private String name;
    private String familyname;
    private String phone;
    private String mail;
    private String postalcode;
    private String address;
    private LocalDate date;
    private String programme;

    public TableView_Customers(Integer client_id, String name, String familyname, String phone, String mail, String postalcode, String address, LocalDate date, String programme) {
        this.client_id = client_id;
        this.name = name;
        this.familyname = familyname;
        this.phone = phone;
        this.mail = mail;
        this.postalcode = postalcode;
        this.address = address;
        this.date = date;
        this.programme = programme;
    }

    public Integer getClient_id() {
        return client_id;
    }

    public void setClient_id(Integer client_id) {
        this.client_id = client_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyname() {
        return familyname;
    }

    public void setFamilyname(String familyname) {
        this.familyname = familyname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getProgramme() {
        return programme;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }
}
