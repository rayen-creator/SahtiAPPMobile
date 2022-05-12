/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import entity.Client;
import entity.Entraineur;
import entity.Nutritioniste;
import services.Signup;

/**
 * GUI builder created Form
 *
 * @author Rayen
 */
public class SignupNutri extends com.codename1.ui.Form {

    public SignupNutri(Form previous) {
        setTitle("Sign up as nutritionniste");
        setLayout(BoxLayout.y());
        TextField nom = new TextField("", "First name", 40, TextArea.ANY);
        TextField prenom = new TextField("", "Last name", 40, TextArea.ANY);
        TextField email = new TextField("", "Email", 40, TextArea.EMAILADDR);
        TextField passwd = new TextField("", "Password", 20, TextArea.PASSWORD);
        TextField verifypassword = new TextField("", "Confirm Password", 20, TextArea.PASSWORD);
        TextField address = new TextField("", "address", 40, TextArea.ANY);
        TextField bio = new TextField("", "Bio", 60, TextArea.ANY);
        TextField cert = new TextField("", "Certification", 60, TextArea.ANY);

        Button btn = new Button("Signup");

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {

                try {
                    if ((nom.getText() != "") && (prenom.getText() != "") && (email.getText() != "") && (passwd.getText() != "") && (address.getText() != "") && (verifypassword.getText() != "")
                           &&  (bio.getText() != "") && (cert.getText() != "")) {
                        if (passwd.getText().equals(verifypassword.getText())) {
                            Nutritioniste n = new Nutritioniste(nom.getText(), prenom.getText(), email.getText(), passwd.getText(), address.getText(), bio.getText(), cert.getText());
                            if (Signup.getInstance().Signupnutri(n)) {
                                Dialog.show("Success", "Account created successfully ", new Command("OK"));
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

        addAll(nom, prenom, email, passwd,verifypassword, address, bio, cert, btn);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

    }

    public SignupNutri(com.codename1.ui.util.Resources resourceObjectInstance) {
        initGuiBuilderComponents(resourceObjectInstance);
    }

//////////////////-- DON'T EDIT BELOW THIS LINE!!!


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        setLayout(new com.codename1.ui.layouts.LayeredLayout());
        setInlineStylesTheme(resourceObjectInstance);
                setInlineStylesTheme(resourceObjectInstance);
        setTitle("SignupNutri");
        setName("SignupNutri");
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
}
