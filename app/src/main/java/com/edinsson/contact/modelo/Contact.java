package com.edinsson.contact.modelo;

import java.io.Serializable;

public class Contact implements Serializable {

    private String name;
    private String date;
    private String phone;
    private String mail;
    private String contactDescrition;

    public Contact(String name, String date, String phone, String mail, String contactDescrition) {
        this.name = name;
        this.date = date;
        this.phone = phone;
        this.mail = mail;
        this.contactDescrition = contactDescrition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public String getContactDescrition() {
        return contactDescrition;
    }

    public void setContactDescrition(String contactDescrition) {
        this.contactDescrition = contactDescrition;
    }
}
