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
public class Nutritioniste {

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

    public Nutritioniste() {
    }

    public Nutritioniste(String nom, String prenom, String email, String passwd,String adresse, String bio, String certification, String img) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.passwd = passwd;
        this.adresse = adresse;
        this.bio = bio;
        this.certification = certification;
        this.img = img;
    }
    
       public Nutritioniste(String nom, String prenom, String email, String passwd,String adresse, String bio, String certification) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.passwd = passwd;
        this.adresse = adresse;
        this.bio = bio;
        this.certification = certification;
    }



    public Nutritioniste(String nom, String prenom, String email, String passwd, String adresse, String bio, String certification, String img, Boolean IsBlocked,int IsMyClient) {
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

public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
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

    public String getCertification() {
        return certification;
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

    public void setCertification(String certification) {
        this.certification = certification;
    }

    @Override
        public String toString() {
        return "Nutritioniste{" + "nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", certification=" + certification + '}';
    }

}
