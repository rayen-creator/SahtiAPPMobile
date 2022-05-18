/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.components.InteractionDialog;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import entity.programmeentraineur;
import java.util.ArrayList;
import services.serviceprogrammeentraineur;
import java.util.List;

/**
 *
 * @author abdou
 */
public class listprogrammeentraineurform extends Form {

//    public static programmeentraineur currentprogrammeentraineur = null;
    Form current;

    public listprogrammeentraineurform(Form previous) {
        current = this; //Back 
        setTitle("List program");

        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());

        add(new Label("******************************** "));
        add(new Label("____________________________________________ "));
        ArrayList<programmeentraineur> List = new ArrayList<programmeentraineur>();

        List = serviceprogrammeentraineur.getInstance().getAllprogrammeentraineur();

        for (programmeentraineur p : List) {
            addButton(p);
        }
    }

    private void addButton(programmeentraineur p) {
        Label idex = new Label("idExercice :" + p.getIdexercice());
        Label nom = new Label("Nom pack :" + p.getNompack());
        Label type = new Label("Type :" + p.getType());

        Label line = new Label("____________________________________________");
        Button Modify = new Button("Modify");
        Modify.addActionListener(l -> {
          editprogrammeentraineurform e = new editprogrammeentraineurform(current,p);
          e.show();
        });
        Button Delete = new Button("Delete");
        Delete.addActionListener(l -> {
            if (serviceprogrammeentraineur.getInstance().delete(p.getId())) {
                Dialog.show("success", "Program will be deleted   ", "OK", null);
                listprogrammeentraineurform a = new listprogrammeentraineurform(current);
                a.show();
            }
        });

        add(idex);
        add(nom);
        add(type);
        add(Modify);
        add(Delete);

        add(line);

    }

}
//   setTitle("List programme entraineur");
// SpanLabel sp = new SpanLabel();
// sp.setText(serviceprogrammeentraineur.getInstance().getallprogrammeentraineur().toString());
// add(sp);
// getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
//        Form hii = new Form("Liste programme entraineur", BoxLayout.y());

//        List<programmeentraineur> myList = serviceprogrammeentraineur.getInstance().getAllprogrammeentraineur();
//
////        Container cnprogrammeentraineur = null;
//        for (programmeentraineur r : myList) {
//            
//                Label idexercice = new Label("nom :" + r.getIdexercice());
//        Label nompack = new Label("prenom :" +r.getNompack());
//        Label type = new Label("Email :" + r.getType());
//   
//            
////            cnprogrammeentraineur = new Container(BoxLayout.x());
//
//            Label lbprogrammeentraineur = new Label(r.getIdexercice());
//            lbprogrammeentraineur.addPointerReleasedListener((e) -> {
//                Form teamDetails = new Form(r.getIdexercice(), BoxLayout.y());
//
////                Label lbidexercice = new Label("Idexercice");
////                SpanLabel idexercice = new SpanLabel(r.getIdexercice());
////                Label lbnompack = new Label("Nompack");
////                SpanLabel nompack = new SpanLabel(r.getNompack());
////                Label lbtype = new Label("Type");
////                SpanLabel type = new SpanLabel(r.getType());
//
//                //teamDetails.add(iv2);
////                teamDetails.add(lbidexercice);
////                teamDetails.add(idexercice);
////                teamDetails.add(lbnompack);
////                teamDetails.add(nompack);
////                teamDetails.add(lbtype);
////                teamDetails.add(type);
////
////                teamDetails.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, g -> hii.showBack());
////
////                teamDetails.show();
////            });
//
////            cnprogrammeentraineur.add(lbprogrammeentraineur);
//
//            Button editBtn = new Button("Modifier");
//            editBtn.setUIID("buttonMain");
//            editBtn.addActionListener(action -> {
////                currentprogrammeentraineur = r;
//                new editprogrammeentraineurform(current, r).show();
//            });
//
////            cnprogrammeentraineur.add(editBtn);
//            Button deleteBtn = new Button("Supprimer");
//            deleteBtn.setUIID("buttonDanger");
//            deleteBtn.addActionListener(action -> {
//                InteractionDialog dlg = new InteractionDialog("Confirmer la suppression");
//                dlg.setLayout(new BorderLayout());
//                dlg.add(BorderLayout.CENTER, new Label("Voulez vous vraiment supprimer ce reclamation ?"));
//                Button btnClose = new Button("Annuler");
//
//                btnClose.addActionListener((ee) -> dlg.dispose());
//                Button btnConfirm = new Button("Confirmer");
//
//                deleteBtn.addActionListener(actionConf -> {
//                    if (serviceprogrammeentraineur.getInstance().delete(r.getId()) == 1) {
//                        Dialog.show("Success", "Supprimer avec succées", new Command("OK"));
//                    }
//                    else {
//                        Dialog.show("ERROR", "Server error", new Command("OK"));
//                    }
//
//                });
//            });
//
////            cnprogrammeentraineur.add(deleteBtn);
//        }
//        //addAll(cnReclamation);
////        hii.add(cnprogrammeentraineur);
//        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,
//                e -> previous.showBack());
//
//    }

