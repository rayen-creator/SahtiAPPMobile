/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import entity.programmeentraineur;
import utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author abdou
 */
public class serviceprogrammeentraineur {

    public ArrayList<programmeentraineur> programmeentraineurs;

    public static serviceprogrammeentraineur instance = null;
    public boolean resultOK;
    private boolean resultCode;
    private ConnectionRequest req;

    private serviceprogrammeentraineur() {
        req = new ConnectionRequest();
    }

    public static serviceprogrammeentraineur getInstance() {
        if (instance == null) {
            instance = new serviceprogrammeentraineur();
        }
        return instance;
    }

    public boolean addprogrammeentraineur(programmeentraineur t) {
        System.out.println(t);
        System.out.println("********");
        //String url = Statics.BASE_URL + "create?name=" + t.getName() + "&status=" + t.getStatus();
        String url = Statics.BASE_URL + "addprogrammeentraineurjson";

        req.setUrl(url);
        req.setPost(false);
        req.addArgument("idexercice", t.getIdexercice());
        req.addArgument("nompack", t.getNompack() + "");
        req.addArgument("type", t.getType() + "");
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public ArrayList<programmeentraineur> parseprogrammeentraineur(String jsonText) {
        try {
            programmeentraineurs = new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String, Object> tasksListJson
                    = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
                programmeentraineur r = new programmeentraineur();
                float id = Float.parseFloat(obj.get("id").toString());
                r.setId((int) id);
                r.setIdexercice(((obj.get("idexercice").toString())));
                r.setNompack(((obj.get("nompack").toString())));
                r.setType(((obj.get("type").toString())));
//                if (obj.get("titre")==null)
//                    r.setTitre("iheb");
//                else
//                    r.setTitre(obj.get("titre").toString());
                programmeentraineurs.add(r);
            }

        }
        catch (IOException ex) {

        }
        return programmeentraineurs;
    }

    public ArrayList<programmeentraineur> getAllprogrammeentraineur() {
        req = new ConnectionRequest();
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL + "listprogrammeentraineurjson";
        System.out.println("===>" + url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                programmeentraineurs = parseprogrammeentraineur(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return programmeentraineurs;
    }

    public boolean edit(programmeentraineur programmeentraineur) {

        req = new ConnectionRequest();
        String url = Statics.BASE_URL + "editprogrammeentraineurjson";
        req.setHttpMethod("POST");

        req.setUrl(url);
        req.addArgument("id", String.valueOf(programmeentraineur.getId()));

        //cr.addArgument("date", new SimpleDateFormat("dd-MM-yyyy").format(reclamation.getDate()));
        req.addArgument("idexercice", programmeentraineur.getIdexercice());
        req.addArgument("nompack", programmeentraineur.getNompack());
        req.addArgument("type", programmeentraineur.getType());

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        /*
         * try { cr.setDisposeOnCompletion(new
         * InfiniteProgress().showInfiniteBlocking());
         * NetworkManager.getInstance().addToQueueAndWait(cr); } catch
         * (Exception ignored) {
         *
         * }
         */
        return resultCode;
    }

    public boolean delete(int id) {
        req = new ConnectionRequest();
        req.setUrl(Statics.BASE_URL + "deleteprogrammeentraineurjson?id=" + id);
//        req.setHttpMethod("POST");
//        req.addArgument("id", String.valueOf(id));

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this);
                System.out.println("program deleted successfully ");

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
//        req.addResponseListener(new ActionListener<NetworkEvent>() {
//            @Override
//            public void actionPerformed(NetworkEvent evt) {
//                req.removeResponseListener(this);
//            }
//        });
//
//        try {
//            req.setDisposeOnCompletion(new InfiniteProgress().showInfiniteBlocking());
//            NetworkManager.getInstance().addToQueueAndWait(req);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return req.getResponseCode();

}
