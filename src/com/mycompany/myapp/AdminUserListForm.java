/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import GUI.HomeForm;
import GUI.HomeFormProduit;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import entity.Client;
import java.util.ArrayList;
import services.ListAdminPanel;

/**
 * GUI builder created Form
 *
 * @author Rayen
 */
public class AdminUserListForm extends com.codename1.ui.Form {

    Form current = new Form("Admin panel", new FlowLayout(CENTER, CENTER));

    public AdminUserListForm() {
        current = this; //Back 

        setTitle("Admin Panel");

        getToolbar()
                .addMaterialCommandToRightBar("Logout", FontImage.MATERIAL_LOGOUT, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        Login l = new Login();
                        Dialog.show("Logout", "Logging out now  ! ", "OK", null);

                        l.show();
                    }
                ;
        });
                     getToolbar()
                .addMaterialCommandToLeftBar("Back", FontImage.MATERIAL_ARROW_BACK, e -> new AdminPannelHOME().show());     
     
        setLayout(BoxLayout.y());

        add(new Label("********************Client's list************ "));
        add(new Label("____________________________________________ "));
//        HomeForm h = new HomeForm();
//        HomeFormProduit hp = new HomeFormProduit();
//        current.getToolbar().addCommandToSideMenu("Manage feedbacks", null, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                h.show();
//            }
//        ;
//        });
//        current.getToolbar().addCommandToSideMenu("Products", null, new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//                hp.show();
//            }
//        });
        //toolbar
        ArrayList<Client> List = new ArrayList<Client>();
        List = ListAdminPanel.getInstance().Allclients();

        for (Client c : List) {

            addButton(c);

        }
    }

    private void addButton(Client c) {
        Label nom = new Label("nom :" + c.getNom());
        Label prenom = new Label("prenom :" + c.getPrenom());
        Label email = new Label("Email :" + c.getEmail());
        Label Birthday = new Label("Birthday :" + c.getDateNaiss());
        Label addr = new Label("Address :" + c.getAdresse());
        Label isblocked = new Label("Is blocked? :" + c.getIsBlocked());
        Label line = new Label("____________________________________________");
        Button remove = new Button("remove");
        remove.addActionListener(l -> {
            if (ListAdminPanel.getInstance().remove(c.getId())) {
                Dialog.show("success", "Delete was a success :" + c.getId(), "OK", null);
                AdminUserListForm a = new AdminUserListForm();
                a.show();
            }
        });
        Button Ban = new Button("Ban");
        Ban.addActionListener(l -> {
            if (ListAdminPanel.getInstance().ban(c.getId())) {
                Dialog.show("success", "you have banned  :" + c.getEmail(), "OK", null);
                AdminUserListForm a = new AdminUserListForm();
                a.show();
            }
        });
        Button Unban = new Button("Unban");
        Unban.addActionListener(l -> {
            if (ListAdminPanel.getInstance().unban(c.getId())) {
                Dialog.show("success", "you have unbanned  :" + c.getEmail(), "OK", null);
                AdminUserListForm a = new AdminUserListForm();
                a.show();
            }
        });

        add(nom);
        add(prenom);
        add(email);
        add(addr);
        add(Birthday);
        add(isblocked);
        add(remove);
        add(Ban);
        add(Unban);

//        if(usr.getIsbanned().equals("false"))
//        {
//        add(BoxLayout.encloseX(isverified,update,ban)) ; //todo add remove
//        }else
//        {
//        add(BoxLayout.encloseX(isverified,update,unban)) ; //todo add remove
//
//        }   
        add(line);

    }

    public AdminUserListForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("AdminUserListForm");
        setName("AdminUserListForm");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
