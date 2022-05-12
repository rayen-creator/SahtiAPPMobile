/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.ImageViewer;
import com.codename1.io.ConnectionRequest;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import entity.Client;
import java.io.IOException;
import services.Signup;
import services.resetpwd;

/**
 * GUI builder created Form
 *
 * @author Rayen
 */
public class Forgetpwd extends com.codename1.ui.Form {

    public Forgetpwd(Form previous) {

        //****************//
        setTitle("Forget Password");
        setLayout(BoxLayout.y());
        Container cn = new Container(BoxLayout.y());

        TextField mail = new TextField("", "Email");
        Button btnresetpwd = new Button("Reset Password");
        Image imgc = null;
        ImageViewer ivimgc = new ImageViewer();
        try {
            imgc = Image.createImage("/resetpwd.png");
            ivimgc.setImage(imgc);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        add(new Label("Please insert your email to reset your password "));

        cn.add(ivimgc);
        cn.add(mail);
        cn.add(btnresetpwd);
        btnresetpwd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
//                if ((tfName.getText().length()==0)||(tfStatus.getText().length()==0))
//                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
//                else
//                {
                try {
                    if (mail.getText() != "") {
                        if (resetpwd.getInstance().Forgetpwd(mail.getText())) {
                            Dialog.show("Success", "Check your email, to follow Reset instructions", "OK", null);
                            Login a = new Login(previous);
                            a.showBack();
                        }
                        else {
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                        }
                    }
                    else {
                        Dialog.show("Error", "Please insert your mail to reset your password", "OK", null);

                    }
                }
                catch (NumberFormatException e) {
                    Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                }

//                }
            }
        });

        addAll(cn);

        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }

    public Forgetpwd(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("Forgetpwd");
        setName("Forgetpwd");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
