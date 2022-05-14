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
import com.codename1.ui.util.Resources;
import entity.Client;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import utils.Statics;

/**
 *
 * @author Rayen
 */
public class ListAdminPanel {

    public ArrayList<Client> clients;
    public Resources res;
    public static ListAdminPanel instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ListAdminPanel() {
        req = new ConnectionRequest();
    }

    public static ListAdminPanel getInstance() {
        if (instance == null) {
            instance = new ListAdminPanel();
        }
        return instance;
    }

    public ArrayList<Client> Allclients() {
        req = new ConnectionRequest();
        ArrayList<Client> result = new ArrayList<>();
        String url = Statics.BASE_URL + "adminlistclient";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp;
                jsonp = new JSONParser();
                try {
                    Map<String, Object> clients = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));

                    List<Map<String, Object>> listOfMaps = (List<Map<String, Object>>) clients.get("root");

                    for (Map<String, Object> obj : listOfMaps) {
                        Client re = new Client();
                        String id = obj.get("id").toString();
                        String nom = obj.get("nom").toString();
                        String prenom = obj.get("prenom").toString();
                        String email = obj.get("email").toString();
                        String addr = obj.get("adresse").toString();
//                        String birthday = obj.get("datenaiss").toString();
                        String blocked = obj.get("isblocked").toString();
                        
                        float idclient = Float.parseFloat(obj.get("id").toString());
                        re.setId((int) idclient);

                        if (obj.get("nom") == null) {
                            re.setNom("null");
                        }
                        else {
                            re.setNom(nom);
                        }
                        if (obj.get("prenom") == null) {
                            re.setPrenom("null");
                        }
                        else {
                            re.setPrenom(prenom);
                        }
                        if (obj.get("email") == null) {
                            re.setEmail("null");
                        }
                        else {
                            re.setEmail(email);
                        }
                        if (obj.get("adresse") == null) {
                            re.setAdresse("null");
                        }
                        else {
                            re.setAdresse(addr);
                        }
//                        if (obj.get("datenaiss") == null) {
//                            re.setDateNaiss("null");
//                        }
//                        else {
//                            re.setDateNaiss(birthday);
//                        }
                        if (obj.get("isblocked") == null) {
                            re.setIsBlocked("null");
                        }
                        else {
                            re.setIsBlocked(blocked);
                        }
                        result.add(re);
                    }

                }
                catch (Exception ex) {

                    ex.printStackTrace();
                }
            }
        }
        );
        NetworkManager.getInstance()
                .addToQueueAndWait(req);
        return result;
    }

    public boolean remove(int id) {
        String url = Statics.BASE_URL + "admin/deleteclientjson?id=" + id;
        req.setUrl(url);

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this);
                System.out.println("Client deleted successfully ");

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public boolean ban(int id) {

        String url = Statics.BASE_URL + "admin/banclientjson?id=" + id;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this);
                System.out.println("Client banned successfully ");

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public boolean unban(int id) {

        String url = Statics.BASE_URL + "admin/unbanclientjson?id=" + id; //création de l'URL  TODO
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200;
                req.removeResponseListener(this);
                System.out.println("Client unbanned successfully ");

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

}
