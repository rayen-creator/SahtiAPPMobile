/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.Date;

/**
 *
 * @author Rayen
 */
public class Client {

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String passwd;
    private String adresse;
    private String DateNaiss;
    public String img;
    private String IsBlocked;

//    public String Age;
    public Client() {

    }

    public Client(String email) {
        this.email = email;
    }

    public Client(String email, String passwd) {
        this.email = email;
        this.passwd = passwd;
    }

    public Client(int id, String nom, String prenom, String email, String passwd, String adresse, String DateNaiss, String img, String IsBlocked) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.passwd = passwd;
        this.adresse = adresse;
        this.DateNaiss = DateNaiss;
        this.img = img;
        this.IsBlocked = IsBlocked;
    }

    public Client(String nom, String prenom, String email, String passwd, String adresse, String DateNaiss, String img) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.passwd = passwd;
        this.adresse = adresse;
        this.DateNaiss = DateNaiss;
        this.img = img;

    }
    
    public Client(String nom, String prenom, String email, String passwd, String adresse, String DateNaiss) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.passwd = passwd;
        this.adresse = adresse;
        this.DateNaiss = DateNaiss;

    }

    public void setIsBlocked(String IsBlocked) {
        this.IsBlocked = IsBlocked;
    }

    public String getIsBlocked() {
        return IsBlocked;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setDateNaiss(String DateNaiss) {
        this.DateNaiss = DateNaiss;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswd() {
        return passwd;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getDateNaiss() {
        return DateNaiss;
    }

//    public String getAge() {
//        Age = DateNaiss.substring(DateNaiss.length() - 4);
//        return Age;
//    }
//    public String getAge() {
//
//        return DateNaiss.substring(DateNaiss.length() - 4);
//    }
    @Override
    public String toString() {
        return "Client{" + "nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", DateNaiss=" + DateNaiss + '}';
    }

}
