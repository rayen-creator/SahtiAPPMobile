/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.capture.Capture;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import entity.Client;
import services.Signup;

/**
 * GUI builder created Form
 *
 * @author Rayen
 */
public class SignupClient extends com.codename1.ui.Form {

    public SignupClient(Form previous) {
        setTitle("Sign up as Client");
        setLayout(BoxLayout.y());

        TextField nom = new TextField("", "First name", 40, TextArea.ANY);
        TextField prenom = new TextField("", "Last name", 40, TextArea.ANY);
        TextField email = new TextField("", "Email", 40, TextArea.EMAILADDR);
        TextField passwd = new TextField("", "Password", 20, TextArea.PASSWORD);
        TextField verifypassword = new TextField("", "Confirm Password", 20, TextArea.PASSWORD);
        TextField address = new TextField("", "Address", 40, TextArea.ANY);
        Label bd = new Label("Birthday");
        Picker birthday = new Picker();
        Label pic = new Label("Profile pictrue", "WelcomeBlue");
        Button profilepic = new Button("Upload");
        Label profilePicLabel = new Label();
        Button submitpic = new Button("Save");

        Button btn = new Button("Signup");

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                try {
                    if ((nom.getText() != "") && (prenom.getText() != "") && (email.getText() != "") && (passwd.getText() != "") && (address.getText() != "") && (verifypassword.getText() != "")) {
                        if (passwd.getText().equals(verifypassword.getText())) {
                            Client c = new Client(nom.getText(), prenom.getText(), email.getText(), passwd.getText(), address.getText(), birthday.getText());
                            if (Signup.getInstance().Signupclient(c)) {
                                Dialog.show("Success", "Account created successfully ", new Command("OK"));
                                Login l = new Login();
                                l.show();
                            }
                            else {
                                Dialog.show("ERROR", "Server error", new Command("OK"));
                            }
                        }
                        else {
                            Dialog.show("ERROR", "Make sure of your password verification", new Command("OK") );
                        }
                    }
                    else {
                        ToastBar.showErrorMessage("Fill all blanks", 20);
                    }
                }
                catch (NumberFormatException e) {
                    Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                }
            }
        });

        addAll(nom, prenom, email, passwd, verifypassword, address, bd, birthday, btn);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

    }

    public SignupClient(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

////////////////////////////////////////////////-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("SignupClient");
        setName("SignupClient");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
