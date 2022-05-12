/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.table.TableLayout;
import services.ServiceProduit;

import utils.Statics;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author HP
 */
public class ModifierlistForm extends Form {

    Form current;
    private ConnectionRequest req = new ConnectionRequest();
    String json;

    public ModifierlistForm(Form previous) {
        current = this;

        Toolbar tb = new Toolbar(true);
        setToolbar(tb);

        tb.setTitle("Admin Space");
        tb.showToolbar();
        setTitle("List produit");
        String url = Statics.BASE_URL + "liste";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                json = new String(req.getResponseData());
                int json1 = req.getResponseData().length;
                JSONParser j = new JSONParser();

                System.out.println("Daaaaaaaaaaaaaaataaaaaaaaaa" + json);
                //  try {
                Map<String, Object> events;
                try {
                    events = j.parseJSON(new CharArrayReader(json.toCharArray()));
                    List<Map<String, Object>> list = (List<Map<String, Object>>) events.get("root");
                    System.out.println("Daaaaaaaaaaaaaaataaaaaaaaaa" + list.get(0));
                    for (Map<String, Object> l : list) {
                        Label noml = new Label((String) l.get("nom"));
                        Label prixl = new Label((String) l.get("prix "));
                        Label imagel = new Label((String) l.get("image "));
                        Label qtel = new Label((String) l.get("quantite "));
                        Label descl = new Label((String) l.get("descprod "));
                        Label catl = new Label((String) l.get("idcat "));
                        Button modifier = new Button("Modifier");
                        Button supprimer = new Button("supprimer");

                        add(noml);
                        add(prixl);
                        add(imagel);
                        add(qtel);
                        add(descl);
                        add(catl);
                        add(modifier);
                        add(supprimer);

                        float idp = Float.parseFloat(l.get("idProd").toString());
                        int id = (int) idp;

                        supprimer.addActionListener(e -> {
                            ServiceProduit.getInstance().deleteProduit(id);
                            Dialog.show("Success", "suppression ", "OK", "");
                            
                                new ModifierlistForm(current).showBack();
                            

                        });

                        modifier.addActionListener(e -> {

                            try {
                                new ModifierForm(l).show();
                            } catch (ParseException ex) {
                                System.out.println(ex.getMessage());
                            }
                        });

                    }

                } catch (IOException ex) {
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);

        // getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> new HomeForm().show());
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }

}
