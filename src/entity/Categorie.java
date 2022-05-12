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
public class Categorie {
   
    private int id_cat;
    private String titre;
    private String img_cat;

    public Categorie() {
    }

    public Categorie(int id_cat, String titre, String img_cat) {
        this.id_cat = id_cat;
        this.titre = titre;
        this.img_cat = img_cat;
    }

    public Categorie(String titre, String img_cat) {
        this.titre = titre;
        this.img_cat = img_cat;
    }

    public int getId_cat() {
        return id_cat;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getImg_cat() {
        return img_cat;
    }

    public void setImg_cat(String img_cat) {
        this.img_cat = img_cat;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id_cat=" + id_cat + ", titre=" + titre + ", img_cat=" + img_cat + '}';
    }
    
}
