/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author abdou
 */
public class programmeentraineur {
   
     private  int id;
    private  String idexercice;
    private  String nompack;
    private  String type;

    public programmeentraineur() {
    }
    
    public programmeentraineur(int id, String idexercice, String nompack, String type) {
        this.id = id;
        this.idexercice = idexercice;
        this.nompack = nompack;
        this.type = type;
    }
    
    public programmeentraineur(String idexercice, String nompack, String type) {
        this.idexercice = idexercice;
        this.nompack = nompack;
        this.type = type;
    }

    public  int getId() {
        return id;
    }

    public  void setId(int id) {
        this.id = id;
    }

    public  String getIdexercice() {
        return idexercice;
    }

    public  void setIdexercice(String idexercice) {
        this.idexercice = idexercice;
    }

    public  String getNompack() {
        return nompack;
    }

    public  void setNompack(String nompack) {
        this.nompack = nompack;
    }

    public  String getType() {
        return type;
    }

    public  void setType(String type) {
        this.type = type;
    }

     @Override
    public String toString() {
        return "ProgrammeEntraineur{" + "id=" + id + ", idexercice=" + idexercice + ", nompack=" + nompack + ", type=" + type + '}';
    }
    
    
    
    
}


