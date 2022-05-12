/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.programmeentraineur;
import services.serviceprogrammeentraineur;

/**
 *
 * @author abdou
 */

    public class editprogrammeentraineurform extends Form {

    public static programmeentraineur currentprogrammeentraineur = null;
    Button addBtn;
    Label dateLabel, typeLabel, titreLabel, messageLabel;
    Button editBtn, deleteBtn;

    Container btnsContainer;

    public editprogrammeentraineurform(Form previous, programmeentraineur rec) {
        //dateTF = PickerComponent.createDate(null).label("Date");
        setTitle("Modifier programmeentraineur");
        setLayout(BoxLayout.y());

        TextField idexercice = new TextField(rec.getIdexercice(), "idexercice");
        TextField nompack = new TextField(rec.getNompack(), "nompack");
        TextField type = new TextField(rec.getType(), "type");
 

        Button btnValider = new Button("Modifier Reclamation");
        btnValider.addActionListener(action -> {
            //if (controleDeSaisie()) {
            programmeentraineur r = new programmeentraineur(rec.getId(), idexercice.getText(), nompack.getText(), type.getText());
            if (!serviceprogrammeentraineur.getInstance().edit(r)) {
                Dialog.show("Success", "Modifier avec succées", new Command("OK"));
            } else {
                Dialog.show("ERROR", "Server error", new Command("OK"));
            }

            //}
        });

        addAll(idexercice, nompack, type, btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }

}
    