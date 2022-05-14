/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import java.io.IOException;

/**
 * GUI builder created Form
 *
 * @author Rayen
 */
public class SignupMainpage extends com.codename1.ui.Form {

    Form current = new Form("Sign UP", new FlowLayout(CENTER, CENTER));

    public SignupMainpage() {
        current = this; //Back 
        setTitle("Sign UP");

        Login l = new Login();
        Container cnimg = new Container(BoxLayout.xRight());
        Container cnbtn = new Container(BoxLayout.x());

        Image imgc = null;
        ImageViewer ivimgc = new ImageViewer();
        try {
            imgc = Image.createImage("/signup.png");
            ivimgc.setImage(imgc);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        add(new Label("Create new  account" ));

       
        Button signupclient = new Button("Signup client");
        Button signupcoach = new Button("Signup coach");
        Button signupnutri = new Button("Signup nutristioniste");

        signupclient.addActionListener(e -> new SignupClient(current).show());
        signupcoach.addActionListener(e -> new SignupCoach(current).show());
        signupnutri.addActionListener(e -> new SignupNutri(current).show());

        cnimg.add(ivimgc);
     
        cnbtn.add(signupclient);
        cnbtn.add(signupcoach);
        cnbtn.add(signupnutri);

        addAll(cnimg, cnbtn);

        getToolbar()
                .addMaterialCommandToLeftBar("HOME", FontImage.MATERIAL_HOME, e
                        -> new HOME().show());

    }

    public SignupMainpage(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("SignupMainpage");
        setName("SignupMainpage");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
