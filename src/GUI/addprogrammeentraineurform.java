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
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import entity.programmeentraineur;
import services.serviceprogrammeentraineur;

/**
 *
 * @author abdou
 */
public class addprogrammeentraineurform extends Form{

    public addprogrammeentraineurform(Form previous) {
        setTitle("Add a new programmeentraineur");
        setLayout(BoxLayout.y());
        
        TextField tfIdEexercice = new TextField("","programme entraineur description");
        TextField tfNomPack = new TextField("","programme entraineur nompack");
        TextField tfType = new TextField("","programme entraineur type");
        Button btnValider = new Button("Add programmeentraineur");
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfIdEexercice.getText().length()==0)||(tfNomPack.getText().length()==0)||(tfType.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        programmeentraineur t = new programmeentraineur(tfIdEexercice.getText().toString(),tfNomPack.getText().toString(),tfType.getText().toString());
                        if( !serviceprogrammeentraineur.getInstance().addprogrammeentraineur(t))
                        {
                           Dialog.show("Success","programme entraineur ajoutée",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(tfIdEexercice,tfNomPack,tfType,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }
    
    
}
