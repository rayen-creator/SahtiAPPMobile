/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.ui.Button;
import com.codename1.ui.Calendar;
import com.codename1.ui.CheckBox;

import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;

import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.table.TableLayout;

import com.mycompany.entities.Produit;
import services.ServiceProduit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author HP
 */
public class ModifierForm extends Form {

    Form current;

    public ModifierForm(Map l) throws ParseException {
        current = this;
        // super((String) l.get("nom"), new TableLayout(10, 2));

        setTitle((String) l.get("nom"));
        Label space = new Label();
        Label space2 = new Label();
        Label noml = new Label("Nom de l'produit");
        Label prixl = new Label("prix de l'produit");
        Label imagel = new Label("image de l'produit");
        Label quantitel = new Label("quantite de l'produit");
        Label descl = new Label("Description de l'produit");
        Label idcatl = new Label("categorie de l'produit");
        Button Modifier = new Button("Modifier");
        Button Supprimer = new Button("Supprimer");

        Produit p = new Produit();

        if (l.get("nom") != null) {
            String nom = l.get("nom").toString();
            TextField nomt = new TextField(nom);
            p.setNom(nomt.getText());
            add(noml);
            add(nomt);

        }
        if (l.get("prix") != null) {
            float prix = Float.parseFloat(l.get("prix").toString());
            TextField prixt = new TextField(String.valueOf(prix));
            p.setPrix(Float.parseFloat(prixt.getText()));
            add(prixl);
            add(prixt);

        }
        if (l.get("image") != null) {
            String image = (String) l.get("image");
            TextField imaget = new TextField(image);
            p.setImage(imaget.getText());
            add(imagel);
            add(imaget);
        }
        if (l.get("quantite") != null) {
            Float quantite = Float.parseFloat(l.get("quantite").toString());
            TextField quantitet = new TextField(String.valueOf(quantite));
             float qtef = Float.parseFloat(quantitet.getText());
             int  qte = (int) qtef;           
             p.setQuantite(qte);
            add(quantitel);
            add(quantitet);
        }
        if (l.get("descprod") != null) {
            String desc = (String) l.get("descprod");
            TextArea descprodt = new TextArea(desc);
            p.setDescprod(descprodt.getText());
            add(descl);
            add(descprodt);
        }
//        if (l.get("idCat") != null) {
//            float catigorie = Float.parseFloat(l.get("idCat").toString());
//            TextField idCatt = new TextField(String.valueOf(catigorie));
////            float catf = Float.parseFloat(idCatt.getText());
////            int  cat = (int) catf;
//            p.setIdCat((int)catigorie);
//            add(idcatl);
//            add(idCatt);
//
//        }
        
        
    
             float idp = Float.parseFloat(l.get("idProd").toString());
             int  id = (int) idp;
             p.setIdProd(id);
             
        
        

        
        Modifier.addActionListener(e -> {
       //   Produit p = new Produit(id, nomt.getText(), Float.parseFloat(prixt.getText()), imaget.getText(), Integer.parseInt(quantitet.getText()), descprodt.getText(), Integer.parseInt(idCatt.getText()));
            ServiceProduit.getInstance().Modifier(p);
        });
        Supprimer.addActionListener(e -> {
            ServiceProduit.getInstance().deleteProduit(id);

        });

        add(Modifier);
        add(Supprimer);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> new HomeFormProduit().show());

    }
}
