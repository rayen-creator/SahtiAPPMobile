/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import entity.Entraineur;
import entity.Nutritioniste;
import java.util.ArrayList;
import services.Listavailable;

/**
 * GUI builder created Form
 *
 * @author Rayen
 */
public class listavailablenutri extends com.codename1.ui.Form {

    public listavailablenutri(Form previous) {
        setTitle("List Nutri");

        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

        ArrayList<Nutritioniste> List = new ArrayList<Nutritioniste>();
        List = Listavailable.getInstance().getAllnutri();

        for (Nutritioniste n : List) {
            addButton(n);
        }

    }

    private void addButton(Nutritioniste n) {
        Label nom = new Label("nom :" + n.getNom());
        Label prenom = new Label("prenom :" + n.getPrenom());
        Label email = new Label("prenom :" + n.getEmail());
        Label addr = new Label("Address :" + n.getAdresse());
        Label bio = new Label("Bio :" + n.getBio());
        Label cert = new Label("Certification :" + n.getCertification());

        Label line = new Label("____________________________________________");
        Button workwith = new Button("Work With");
        workwith.addActionListener(l -> {

            Dialog.show("Verification", "Are you sure you want to work with this  nutrionist :" + n.getId(), "OK", null);

        });

        add(nom);
        add(prenom);
        add(email);
        add(addr);
        add(bio);
        add(cert);
        add(workwith);

        add(line);
    }

    public listavailablenutri(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//////////-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("listavailablenutri");
        setName("listavailablenutri");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
