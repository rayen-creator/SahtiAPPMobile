/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.back;

import GUI.back.aliment.ShowAll;
import com.codename1.components.ImageViewer;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

        /**
 *
 * @author user
 */
public class AccueilBack extends Form {

    Resources theme = UIManager.initFirstTheme("/theme");
    Label label;

    public AccueilBack() {
        super("Menu", new BoxLayout(BoxLayout.Y_AXIS));
        addGUIs();
    }

    private void addGUIs() {
       
        Container menuContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        menuContainer.addAll(
                
                makeAlimentsButton(), 
                makeRegimesButton(), 
                makeRepasButton()
                
        );

        this.add(menuContainer);
    }



    private Button makeAlimentsButton() {
        Button button = new Button("Aliments");
        button.setUIID("buttonMenu");
        //button.setMaterialIcon(FontImage.MATERIAL_BOOKMARK);
        button.addActionListener(action -> new ShowAll(this).show());
        return button;
    }
    private Button makeRegimesButton() {
        Button button = new Button("Regime");
        button.setUIID("buttonMenu");
        //button.setMaterialIcon(FontImage.MATERIAL_BOOKMARK);
       // button.addActionListener(action -> new com.pidevv.sahti.gui.back.regime.ShowAll(this).show());
        return button;
    }
    private Button makeRepasButton() {
        Button button = new Button("Repas");
        button.setUIID("buttonMenu");
        //button.setMaterialIcon(FontImage.MATERIAL_BOOKMARK);
       // button.addActionListener(action -> new com.example.gzone.gui.back.happyHour.ShowAll(this).show());
        return button;
    }
    
    
}
