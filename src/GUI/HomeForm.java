/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import GUI.reclamations.ListReclamationsForm;
import GUI.reclamations.addReclamation;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import GUI.reclamations.editReclamation;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.AdminPannelHOME;
import com.mycompany.myapp.AdminUserListForm;
import com.mycompany.myapp.HOME;
import com.mycompany.myapp.Login;
import services.ListAdminPanel;




/**
 *
 * @author Akrimi
 */
public class HomeForm extends Form{
    Form current;
    public HomeForm() {
        current=this; //Back 
               getToolbar()
                .addMaterialCommandToLeftBar("Back", FontImage.MATERIAL_ARROW_BACK, e -> new AdminPannelHOME().show());
        
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
         
        
        setTitle("Menu");
        setLayout(BoxLayout.y());
        
        add(new Label("Choisir option"));
        Button btnAddTask = new Button("Ajouter Reclamation");
        Button btnListTasks = new Button("Afficher reclamations");        
        btnAddTask.addActionListener(e-> new addReclamation(current).show());
        btnListTasks.addActionListener(e-> new ListReclamationsForm(current));
        addAll(btnAddTask,btnListTasks);
        
        
    }
    
}
