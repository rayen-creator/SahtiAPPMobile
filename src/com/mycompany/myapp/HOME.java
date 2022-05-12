/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.mycompany.myapp.Login;
import com.mycompany.myapp.Login;
import com.mycompany.myapp.SignupClient;
import com.mycompany.myapp.SignupCoach;
import com.mycompany.myapp.SignupNutri;
import com.mycompany.myapp.listavailablecoach;
import com.codename1.components.ImageViewer;
import com.codename1.io.Log;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import java.io.IOException;

/**
 * GUI builder created Form
 *
 * @author Rayen
 */
public class HOME extends com.codename1.ui.Form {

    Form current = new Form("HOME", new FlowLayout(CENTER, CENTER));

    public HOME() {
        current = this; //Back 
        setTitle("Welcome");
        setLayout(BoxLayout.y());
        //toolbar
        Login l = new Login(current);
        SignupMainpage signup = new SignupMainpage();

        current.getToolbar().addCommandToSideMenu("Login", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                l.show();
            }
        });
        current.getToolbar().addCommandToSideMenu("Sign up", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                signup.showBack();
            }
        });
        //toolbar

        Image img = null;
        ImageViewer ivimg = new ImageViewer();

        try {
            img = Image.createImage("/SAHTI Logo with BG.png");
            ivimg.setImage(img);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        add(new Label("Weclome to SAHTI APP "));
        Button login = new Button("Login");
        Button signupp = new Button("Signup");
        Button a =new Button("adminlist");
        Button s = new Button("list");

        s.addActionListener(e -> new SignupMainpage().show());
        login.addActionListener(e -> new Login(current).show());
        signupp.addActionListener(e -> new SignupMainpage().show());
        a.addActionListener(e -> new AdminUserListForm().show());

        addAll(ivimg, login, signupp,a);

//        current.add(login);
//        current.add(signupclient);
//        current.add(signupcoach);
//        current.add(signupnutri);
    }

    public HOME(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("HOME");
        setName("HOME");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
