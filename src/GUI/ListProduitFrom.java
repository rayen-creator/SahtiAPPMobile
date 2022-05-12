/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;

import com.codename1.ui.FontImage;
import com.codename1.ui.Form;

import services.ServiceProduit;

/**
 *
 * @author HP
 */
public class ListProduitFrom extends Form {

   Form current;

    public ListProduitFrom(Form previous) {
             current = this;
        setTitle("List Produit");
        SpanLabel sp = new SpanLabel();
       System.out.println(ServiceProduit.getInstance().getAllProduits());
       sp.setText(ServiceProduit.getInstance().getAllProduits().toString());
        add(sp);
         

getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e->previous.showBack());


    }


    }


