/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entities;

/**
 *
 * @author HP
 */
public class Produit {
    private int idProd;
    private String nom;
    private Float prix; 
    private String image;
    private int quantite;
    private String descprod;
    private int idCat;

    public Produit()  {
    }

    public Produit(int idProd, String nom, Float prix, String image, int quantite, String descprod, int idCat) {
        this.idProd = idProd;
        this.nom = nom;
        this.prix = prix;
        this.image = image;
        this.quantite = quantite;
        this.descprod = descprod;
        this.idCat = idCat;
    }

    public Produit(String nom, Float prix, String image, int quantite, String descprod, int idCat) {
        this.nom = nom;
        this.prix = prix;
        this.image = image;
        this.quantite = quantite;
        this.descprod = descprod;
        this.idCat = idCat;
    }

    public Produit(String nom, Float prix, String image, int quantite, String descprod) {
        this.nom = nom;
        this.prix = prix;
        this.image = image;
        this.quantite = quantite;
        this.descprod = descprod;
    }

    @Override
    public String toString() {
        return "Produit{" + "idProd=" + idProd + ", nom=" + nom + ", prix=" + prix + ", image=" + image + ", quantite=" + quantite + ", descprod=" + descprod + ", idCat=" + idCat + '}';
    }

    public int getIdProd() {
        return idProd;
    }

    public void setIdProd(int idProd) {
        this.idProd = idProd;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getDescprod() {
        return descprod;
    }

    public void setDescprod(String descprod) {
        this.descprod = descprod;
    }

    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }
    

    
    
    
}

   