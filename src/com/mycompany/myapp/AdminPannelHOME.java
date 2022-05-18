/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import GUI.HomeForm;
import GUI.HomeFormProduit;
import com.codename1.components.ImageViewer;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.FlowLayout;
import java.io.IOException;

/**
 * GUI builder created Form
 *
 * @author Rayen
 */
public class AdminPannelHOME extends com.codename1.ui.Form {

    Form current = new Form("Admin panel", new FlowLayout(CENTER, CENTER));

    public AdminPannelHOME() {
        current = this; //Back 
        setTitle("Admin Panel");
        add(new Label("Weclome back Admin !"));

        Image imgc = null;
        ImageViewer ivimgc = new ImageViewer();
        try {
            imgc = Image.createImage("/superadmin.png");
            ivimgc.setImage(imgc);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        addAll(ivimgc);
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
        
         HomeForm h = new HomeForm();
        HomeFormProduit hp = new HomeFormProduit();
        AdminUserListForm adminuser = new AdminUserListForm();

        current.getToolbar().addMaterialCommandToSideMenu("Admin panel ", FontImage.MATERIAL_ADMIN_PANEL_SETTINGS, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                adminuser.show();
            }
        });

        current.getToolbar().addMaterialCommandToSideMenu("Manage feedbacks", FontImage.MATERIAL_REVIEWS, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                h.show();
            }
        ;
        });
        current.getToolbar().addMaterialCommandToSideMenu("Products", FontImage.MATERIAL_SHOP, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                hp.show();
            }
        });
    }

    public AdminPannelHOME(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

////////////////////-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("AdminPannelHOME");
        setName("AdminPannelHOME");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
