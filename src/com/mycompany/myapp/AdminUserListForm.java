/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp;

import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Dialog;
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
        setLayout(BoxLayout.y());
        add(new Label("********************Client's list************ "));
        add(new Label("____________________________________________ "));

        current.getToolbar().addCommandToSideMenu("Login", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
//                l.show();
            }
        ;
        });
        current.getToolbar().addCommandToSideMenu("Sign up", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
//                signup.showBack();
            }
        });
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
//            Update_userForm a = new Update_userForm(theme, usr.getId());
//            a.show();
            Dialog.show("success", "Attempt to delete :" + c.getId(), "OK", null);

        });
//        Button update=new Button("update");
//        update.addActionListener(l->{
////        Update_userForm a=new Update_userForm(theme,usr.getId());
////        a.show();
//        });
//        Button ban=new Button("ban");
//              ban.addActionListener(l->{
//              if(UserService.getInstance().ban(usr.getId()))
//                      {
//                          Dialog.show("Banned","you have banned :"+usr.getUsername(), "OK",null);
//                          UserListAdmin a=new UserListAdmin(theme);
//                          a.show();
//                      }
//              });
//        Button unban=new Button("unban");
//            unban.addActionListener(l->{
//              if(UserService.getInstance().unban(usr.getId()))
//                      {
//                          Dialog.show("UnBanned","you have Unbanned :"+usr.getUsername(), "OK",null);
//                          UserListAdmin a=new UserListAdmin(theme);
//                          a.show();
//                      }
//              });
//        
//        

        add(nom);
        add(prenom);
        add(email);
        add(addr);
        add(Birthday);
        add(isblocked);
        add(remove);

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

//////////////////////////-- DON'T EDIT BELOW THIS LINE!!!


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
