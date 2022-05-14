/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;

/**
 * GUI builder created Form
 *
 * @author Rayen
 */
public class ClientHOME extends com.codename1.ui.Form {

    public ClientHOME() {
        setTitle("Welcome Client");
        setLayout(BoxLayout.y());

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
                        
       getToolbar().addCommandToSideMenu("Manage feedbacks", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
            }
        ;
        });
       getToolbar().addCommandToSideMenu("Products", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
            }
        });

    }

    public ClientHOME(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

////-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("ClientHOME");
        setName("ClientHOME");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
