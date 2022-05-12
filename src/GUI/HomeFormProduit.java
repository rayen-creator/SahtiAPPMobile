/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.HOME;

/**
 *
 * @author HP
 */
public class HomeFormProduit extends  Form {
        Form current;
        Resources res;
    public HomeFormProduit() {
         getToolbar()
                .addMaterialCommandToLeftBar("HOME", FontImage.MATERIAL_HOME, e
                        -> new HOME().show());
        current=this;
    setTitle("Home");
    setLayout(BoxLayout.y());
   
    add (new Label("Choose an option "));
    Button btnAddevent=new Button("Add Prod");
    Button btnListevent=new Button("List prod");
    Button btnmod=new Button("gestion produit");

    btnAddevent.addActionListener(e->new addProduit(current).show());
    btnListevent.addActionListener(e-> new ListProduitFrom(current).show());
    btnmod.addActionListener(e-> new ModifierlistForm(current).show());
    addAll(btnAddevent,btnListevent,btnmod);
 
}
}