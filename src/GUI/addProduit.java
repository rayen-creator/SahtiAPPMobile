/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;


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
import com.mycompany.entities.Categorie;
import com.mycompany.entities.Produit;
import services.ServiceProduit;


/**
 *
 * @author HP
 */
public class addProduit extends Form {
       public addProduit(Form previous) {
        setTitle("Ajouter produit");
        setLayout(BoxLayout.y());

        TextField nom = new TextField("", "nom produit");
        TextField prix = new TextField("", "prix");
        TextField image = new TextField("", "image");
        TextField quantite = new TextField("", "quantite");
        TextArea descprod = new TextArea(5, 5);
        TextField idCat = new TextField("", "categorie");
        //TextField image= new TextField("", "image");
        //TextField dateReclamation= new TextField("", "Status");
        Button btnValider = new Button("Ajouter produit");

        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((nom.getText().length() == 0) || (image.getText().length() == 0) || (prix.getText().length() == 0) || (quantite.getText().length() == 0)|| (descprod.getText().length() == 0)|| (idCat.getText().length() == 0)) {
                    Dialog.show("Alert", "Please fill all the fields", "OK", "");
                } else {
                    Categorie c = new Categorie();
                    Produit r = new Produit(nom.getText(),Float.parseFloat(prix.getText()), image.getText(), Integer.parseInt(quantite.getText()), descprod.getText(), Integer.parseInt(idCat.getText()));
                    
                    if (ServiceProduit.getInstance().addProduit(r)) {
                        Dialog.show("Success", "Connection acceptem!d", "OK", "");
                    } else {
                        Dialog.show("ERROR", "Server error", "OK", "");
                    }
                }

            }

        
        });
      
        addAll(nom,prix, image, quantite,descprod,idCat, btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }

    

    
}

