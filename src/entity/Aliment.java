/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidevv.sahti.entities;

/**
 *
 * @author user
 */
public class Aliment {
    private int idAliment;
    private String nom;
    private String type;
    private String image;
    private int calories;
    private String description;

    public Aliment() {
    }

    public int getIdAliment() {
        return idAliment;
    }

    public void setIdAliment(int idAliment) {
        this.idAliment = idAliment;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Aliment(int idAliment, String nom, String type, String image, int calories, String description) {
        this.idAliment = idAliment;
        this.nom = nom;
        this.type = type;
        this.image = image;
        this.calories = calories;
        this.description = description;
    }

    public Aliment(String nom, String type, String image, int calories, String description) {
        this.nom = nom;
        this.type = type;
        this.image = image;
        this.calories = calories;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Aliment{" + "idAliment=" + idAliment + ", nom=" + nom + ", type=" + type + ", image=" + image + ", calories=" + calories + ", description=" + description + '}';
    }
    
    
    
}
