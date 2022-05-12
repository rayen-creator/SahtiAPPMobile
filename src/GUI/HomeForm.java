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
import com.codename1.ui.FontImage;
import com.mycompany.myapp.HOME;




/**
 *
 * @author Akrimi
 */
public class HomeForm extends Form{
    Form current;
    public HomeForm() {
        current=this; //Back 
        
          getToolbar()
                .addMaterialCommandToLeftBar("HOME", FontImage.MATERIAL_HOME, e
                        -> new HOME().show());
        
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
