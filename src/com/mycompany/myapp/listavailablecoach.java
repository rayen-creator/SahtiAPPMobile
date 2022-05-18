/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.table.DefaultTableModel;
import com.codename1.ui.table.Table;
import com.codename1.ui.table.TableModel;
import entity.Client;
import entity.Entraineur;
import java.util.ArrayList;
import services.ListAdminPanel;
import services.Listavailable;

/**
 * GUI builder created Form
 *
 * @author Rayen
 */
public class listavailablecoach extends com.codename1.ui.Form {

    public listavailablecoach(Form previous) {
        setTitle("List coach");
//        SpanLabel sp = new SpanLabel();
//        sp.setText(Listavailable.getInstance().getAllcoach().toString());
//        add(sp);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

        ArrayList<Entraineur> List = new ArrayList<Entraineur>();
        List = Listavailable.getInstance().getAllcoach();

        for (Entraineur e : List) {
            addButton(e);
        }
    }

    private void addButton(Entraineur e) {
        Label nom = new Label("nom :" + e.getNom());
        Label prenom = new Label("prenom :" + e.getPrenom());
        Label email = new Label("prenom :" + e.getEmail());
        Label addr = new Label("Address :" + e.getAdresse());
        Label bio = new Label("Bio :" + e.getBio());
        Label cert = new Label("Certification :" + e.getCertification());

        Label line = new Label("____________________________________________");
        Button workwith = new Button("Work With");
        workwith.addActionListener(l -> {
                Dialog.show("Verification", "Are you sure you want to work with this coach :" + e.getId(), "OK", null);
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

    public listavailablecoach(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//////////////////////////-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("listavailablecoach");
        setName("listavailablecoach");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
