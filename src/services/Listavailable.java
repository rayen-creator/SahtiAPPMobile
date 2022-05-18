/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import entity.Entraineur;
import entity.Nutritioniste;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.Statics;

/**
 *
 * @author Rayen
 */
public class Listavailable {

    public ArrayList<Entraineur> coach;
    public ArrayList<Nutritioniste> nutri;

    public static Listavailable instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private Listavailable() {
        req = new ConnectionRequest();
    }

    public static Listavailable getInstance() {
        if (instance == null) {
            instance = new Listavailable();
        }
        return instance;
    }

    public ArrayList<Entraineur> parseTasks(String jsonText) {
        try {
            coach = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> ListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) ListJson.get("root");

            for (Map<String, Object> obj : list) {
                Entraineur e = new Entraineur();

                if (obj.get("nom") == null) {
                    e.setNom("null");
                }
                else {
                    e.setNom(obj.get("nom").toString());
                }

                if (obj.get("prenom") == null) {
                    e.setPrenom("null");
                }
                else {
                    e.setPrenom(obj.get("prenom").toString());
                }

                if (obj.get("adresse") == null) {
                    e.setAdresse("null");
                }
                else {
                    e.setAdresse(obj.get("adresse").toString());
                }
                if (obj.get("certification") == null) {
                    e.setNom("null");
                }
                else {
                    e.setCertification(obj.get("certification").toString());
                }

                coach.add(e);
            }

        }
        catch (IOException ex) {

        }
        return coach;
    }

    public ArrayList<Entraineur> getAllcoach() {
        req = new ConnectionRequest();
        String url = Statics.BASE_URL + "availablecoach";

        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                coach = parseTasks(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return coach;
    }

    //**********************************************************************
    public ArrayList<Nutritioniste> parseTasks2(String jsonText) {
        try {
            nutri = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> ListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) ListJson.get("root");

            for (Map<String, Object> obj : list) {
                Nutritioniste n = new Nutritioniste();

                if (obj.get("nom") == null) {
                    n.setNom("null");
                }
                else {
                    n.setNom(obj.get("nom").toString());
                }

                if (obj.get("prenom") == null) {
                    n.setPrenom("null");
                }
                else {
                    n.setPrenom(obj.get("prenom").toString());
                }

                if (obj.get("adresse") == null) {
                    n.setAdresse("null");
                }
                else {
                    n.setAdresse(obj.get("adresse").toString());
                }
                if (obj.get("certification") == null) {
                    n.setNom("null");
                }
                else {
                    n.setCertification(obj.get("certification").toString());
                }

                nutri.add(n);
            }

        }
        catch (IOException ex) {

        }
        return nutri;
    }

    public ArrayList<Nutritioniste> getAllnutri() {
        req = new ConnectionRequest();
        String url = Statics.BASE_URL + "availablenutri";

        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                nutri = parseTasks2(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return nutri;
    }
}
