/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.reclamations;

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
import sahtiMobile.entities.Reclamations;
import sahtiMobile.services.ServiceReclamation;
//import com.mycompany.myapp.services.ServiceTask;

/**
 *
 * @author Akrimi
 */
public class addReclamation extends Form {

    public addReclamation(Form previous) {
        setTitle("Ajouter Reclamation");
        setLayout(BoxLayout.y());

        TextField numReclamation = new TextField("", "Numéro réclamation");
        TextField titre = new TextField("", "Titre");
        TextField type = new TextField("", "Type");
        TextArea message = new TextArea(5, 5);

        //TextField image= new TextField("", "image");
        //TextField dateReclamation= new TextField("", "Status");
        Button btnValider = new Button("Ajouter Reclamation");

        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((numReclamation.getText().length() == 0) || (titre.getText().length() == 0) || (type.getText().length() == 0) || (message.getText().length() == 0)) {
                    Dialog.show("Alert", "Please fill all the fields", "OK", "");
                } else {

                    Reclamations r = new Reclamations(numReclamation.getText(), titre.getText(), type.getText(), message.getText());
                    if (!ServiceReclamation.getInstance().addReclamation(r)) {
                        Dialog.show("Success", "Ajout avec succées", "OK", "");
                    } else 
                        Dialog.show("ERROR", "Server error", "OK", "");                    
                }
            }
        });
        addAll(numReclamation, titre, type, message, btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }
}
