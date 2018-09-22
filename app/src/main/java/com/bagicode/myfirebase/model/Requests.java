package com.bagicode.myfirebase.model;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;

@IgnoreExtraProperties
public class Requests implements Serializable{

    private String nama;
    private String email;
    private String desk;

    private String key;

    public Requests(){

    }

    public Requests(String nama, String email, String desk) {
        this.nama = nama;
        this.email = email;
        this.desk = desk;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesk() {
        return desk;
    }

    public void setDesk(String desk) {
        this.desk = desk;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return " "+nama+"\n" +
                " "+email+"\n" +
                " "+desk;
    }

}
