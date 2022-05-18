/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.ImageViewer;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.CENTER;
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
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import entity.Admin;
import entity.Client;
import entity.Entraineur;
import entity.Nutritioniste;
import java.io.IOException;
import services.Signin;

/**
 * GUI builder created Form
 *
 * @author Rayen
 */
public class Login extends com.codename1.ui.Form {

    Form current;

    public Login() {
        current = this; //Back 

        setTitle("Login");
        setLayout(BoxLayout.y());
        Container cn = new Container(BoxLayout.y());

        TextField tfLogin = new TextField("", "Email");
        Button btnResetpwd = new Button("Forget Password ");
        TextField tfPwd = new TextField("", "Password");
        tfPwd.setConstraint(TextField.PASSWORD);

        Image imgc = null;
        ImageViewer ivimgc = new ImageViewer();
        try {
            imgc = Image.createImage("/login.png");
            ivimgc.setImage(imgc);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        Button btnLogin = new Button("Login");
        btnResetpwd.addActionListener(e -> new Forgetpwd(current).show());
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfLogin.getText() != "") && (tfPwd.getText() != "")) {

                    Admin a = new Admin(tfLogin.getText(), tfPwd.getText());
                    Client c = new Client(tfLogin.getText(), tfPwd.getText());
                    Entraineur e = new Entraineur(tfLogin.getText(), tfPwd.getText());
                    Nutritioniste n = new Nutritioniste(tfLogin.getText(), tfPwd.getText());

                    if (Signin.getInstance().signinAdmin(a) == true) {
                        Dialog.show("Success", "Welcome " + tfLogin.getText(), new Command("OK"));
                        AdminPannelHOME admin = new AdminPannelHOME();
                        admin.show();
                    }
                    else if (Signin.getInstance().signinClient(c) == true) {
                        Dialog.show("Success", "Welcome " + tfLogin.getText(), new Command("OK"));
                        ClientHOME ch = new ClientHOME();
                        ch.show();
                    }
                    else if (Signin.getInstance().signinCoach(e) == true) {
                        Dialog.show("Success", "Welcome " + tfLogin.getText(), new Command("OK"));
                        CoachHOME co = new CoachHOME();
                        co.show();
                    }
                    else if (Signin.getInstance().signinNutri(n) == true) {
                        Dialog.show("Success", "Welcome " + tfLogin.getText(), new Command("OK"));
                        NutriHOME nh = new NutriHOME();
                        nh.show();
                    }
                    else {
                        Dialog.show("Login failed ", " Either your banned or password incorrect .. please try again", new Command("OK"));
                    }
                }
                else {
                    ToastBar.showErrorMessage("Fill all blanks", 20);

                }
            }
        }
        );

        cn.add(ivimgc);
        add(new Label("Login to your account"));

        cn.add(tfLogin);

        cn.add(tfPwd);

        cn.add(btnLogin);

        cn.add(btnResetpwd);

        addAll(cn);

        getToolbar()
                .addMaterialCommandToLeftBar("HOME", FontImage.MATERIAL_HOME, e
                        -> new HOME().show());

    }

    public Login(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("Login");
        setName("Login");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
