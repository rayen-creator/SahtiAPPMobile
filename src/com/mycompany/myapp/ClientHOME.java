/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;

/**
 * GUI builder created Form
 *
 * @author Rayen
 */
public class ClientHOME extends com.codename1.ui.Form {

    Form current;

    public ClientHOME() {
        current = this; //Back 

        setTitle("Welcome Client");
        setLayout(BoxLayout.y());
        add(new Label("Weclome back Client !"));

        Image imgc = null;
        ImageViewer ivimgc = new ImageViewer();
        try {
            imgc = Image.createImage("/user.png");
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
                        Dialog.show("Logout", "Logging out now  ! ", "OK", "");
                        l.show();
                    }
                ;
        });
                        
       getToolbar().addCommandToSideMenu("Available coach", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                listavailablecoach a = new listavailablecoach(current);
                a.show();
            }
        ;
        });
       getToolbar().addCommandToSideMenu("Available nutri", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                listavailablenutri b = new listavailablenutri(current);
                b.show();
            }
        });

    }

    public ClientHOME(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

////////////////////-- DON'T EDIT BELOW THIS LINE!!!


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
