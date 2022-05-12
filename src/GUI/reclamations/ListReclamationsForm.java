/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.reclamations;

import com.codename1.components.ImageViewer;
import com.codename1.components.InteractionDialog;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import sahtiMobile.entities.Reclamations;
import sahtiMobile.services.ServiceReclamation;

/**
 *
 * @author Akrimi
 */
public class ListReclamationsForm extends Form {

    public static Reclamations currentReclamation = null;

    public ListReclamationsForm(Form previous) {
//        setTitle("Liste des réclamations");
//
//        SpanLabel sp = new SpanLabel();
//        sp.setText(S.toString());
//        add(sp);
//        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

        Form hi = new Form("Liste des réclamations", BoxLayout.y());

        List<Reclamations> myList = ServiceReclamation.getInstance().getAllReclamations();

        Container cnReclamation = null;
        for (Reclamations r : myList) {
            cnReclamation = new Container(BoxLayout.x());

            //Image img = Image.createImage(t.getImg());
            //ImageViewer iv = new ImageViewer(img);
            Label lbReclamation = new Label(r.getNumReclamation());
            lbReclamation.addPointerReleasedListener((e) -> {
                Form teamDetails = new Form(r.getNumReclamation(), BoxLayout.y());
                //Image img2;

                //img2 = Image.createImage(t.getImg());
                //ImageViewer iv2 = new ImageViewer(img2);
                Label lbnum = new Label("Numéro réclamation");
                SpanLabel numReclamation = new SpanLabel(r.getNumReclamation());
                Label lbTitre = new Label("Titre");
                SpanLabel titre = new SpanLabel(r.getTitre());
                Label lbType = new Label("Type réclamation");
                SpanLabel type = new SpanLabel(r.getType());
                Label lbMessage = new Label("Message");
                SpanLabel message = new SpanLabel(r.getMessage());

                //teamDetails.add(iv2);
                teamDetails.add(lbnum);
                teamDetails.add(numReclamation);
                teamDetails.add(lbTitre);
                teamDetails.add(titre);
                teamDetails.add(lbType);
                teamDetails.add(type);
                teamDetails.add(lbMessage);
                teamDetails.add(message);

                teamDetails.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, g -> hi.showBack());

                teamDetails.show();
            });

            //cnReclamation.add(iv);
            cnReclamation.add(lbReclamation);

            Button editBtn = new Button("Modifier");
            editBtn.setUIID("buttonMain");
            editBtn.addActionListener(action -> {
                currentReclamation = r;
                new editReclamation(this, currentReclamation).show();
            });

            cnReclamation.add(editBtn);
            Button deleteBtn = new Button("Supprimer");
            deleteBtn.setUIID("buttonDanger");
            deleteBtn.addActionListener(action -> {
                InteractionDialog dlg = new InteractionDialog("Confirmer la suppression");
                dlg.setLayout(new BorderLayout());
                dlg.add(BorderLayout.CENTER, new Label("Voulez vous vraiment supprimer ce reclamation ?"));
                Button btnClose = new Button("Annuler");
               
                btnClose.addActionListener((ee) -> dlg.dispose());
                Button btnConfirm = new Button("Confirmer");
                
                deleteBtn.addActionListener(actionConf -> {
                   if (ServiceReclamation.getInstance().delete(r.getId())!=1) {
                        Dialog.show("Success", "Supprimer avec succées", new Command("OK"));
                    } else 
                        Dialog.show("ERROR", "Server error", new Command("OK"));

                    
                });
            });
                cnReclamation.add(deleteBtn);
                //addAll(cnReclamation);
                hi.add(cnReclamation);
                hi.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

            }
            hi.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
            hi.show();
        }
   


    }
