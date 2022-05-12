/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.reclamations;

import com.codename1.components.InteractionDialog;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import sahtiMobile.entities.Reclamations;
import sahtiMobile.services.ServiceReclamation;


/**
 *
 * @author Akrimi
 */
public class editReclamation extends Form {

    public static Reclamations currentReclamation = null;
    Button addBtn;
    Label dateLabel, typeLabel, titreLabel, messageLabel;
    Button editBtn, deleteBtn;

    Container btnsContainer;

    public editReclamation(Form previous, Reclamations rec) {
        //dateTF = PickerComponent.createDate(null).label("Date");
        setTitle("Modifier Reclamation");
        setLayout(BoxLayout.y());

        TextField numReclamation = new TextField(rec.getNumReclamation(), "Numéro réclamation");
        TextField titre = new TextField(rec.getTitre(), "Titre");
        TextField type = new TextField(rec.getType(), "Type");
        TextArea message = new TextArea(rec.getMessage(), 5, 5);

        Button btnValider = new Button("Modifier Reclamation");
        btnValider.addActionListener(action -> {
            //if (controleDeSaisie()) {
            Reclamations r = new Reclamations(rec.getId(), numReclamation.getText(), titre.getText(), type.getText(), message.getText());
            if (!ServiceReclamation.getInstance().edit(r)) {
                Dialog.show("Success", "Modifier avec succées", new Command("OK"));
            } else {
                Dialog.show("ERROR", "Server error", new Command("OK"));
            }

            //}
        });

        addAll(numReclamation, titre, type, message, btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
        
    }

}
