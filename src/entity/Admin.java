/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Rayen
 */
public class Admin {

    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String passwd;

    public Admin() {

    }

    public Admin(String email, String passwd) {
        this.email = email;
        this.passwd = passwd;
    }

    public Admin(int id, String nom, String prenom, String email, String passwd) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.passwd = passwd;
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

}
