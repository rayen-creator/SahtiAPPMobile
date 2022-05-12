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
public class Entraineur {

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String passwd;
    private String adresse;
    private String bio;
    private String certification;
    private String img;
    private Boolean IsBlocked;
    private int IsMyClient;

    public Entraineur() {

    }
    
        public Entraineur(String nom, String prenom, String email, String passwd, String adresse, String bio, String certification) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.passwd = passwd;
        this.adresse = adresse;
        this.bio = bio;
        this.certification = certification;
    }

    public Entraineur(String nom, String prenom, String email, String passwd, String adresse, String bio, String certification, String img) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.passwd = passwd;
        this.adresse = adresse;
        this.bio = bio;
        this.certification = certification;
        this.img = img;
    }

    public Entraineur(String nom, String prenom, String email, String passwd, String adresse, String bio, String certification, String img, Boolean IsBlocked, int IsMyClient) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.passwd = passwd;
        this.adresse = adresse;
        this.bio = bio;
        this.certification = certification;
        this.img = img;
        this.IsBlocked = IsBlocked;
        this.IsMyClient = IsMyClient;
    }

    public void setIsBlocked(Boolean IsBlocked) {
        this.IsBlocked = IsBlocked;
    }

    public void setIsMyClient(int IsMyClient) {
        this.IsMyClient = IsMyClient;
    }

    public Boolean getIsBlocked() {
        return IsBlocked;
    }

    public int getIsMyClient() {
        return IsMyClient;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setCertification(String certification) {
        this.certification = certification;
    }

    public int getId() {
        return id;
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

    public String getBio() {
        return bio;
    }

    public String getCertification() {
        return certification;
    }

    @Override
    public String toString() {
        return "Entraineur{" + "nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", certification=" + certification + '}';
    }

}
