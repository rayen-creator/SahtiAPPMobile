/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import entity.Client;
import entity.Entraineur;
import entity.Nutritioniste;
import utils.Statics;

/**
 *
 * @author Rayen
 */
public class Signup {

    public static Signup instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private Signup() {
        req = new ConnectionRequest();
    }

    public static Signup getInstance() {
        if (instance == null) {
            instance = new Signup();
        }
        return instance;
    }

    public boolean Signupclient(Client c) {
        System.out.println(c);
        System.out.println("********");
        String url = Statics.BASE_URL + "newclient";

        req.setUrl(url);
        req.setPost(false);
        req.addArgument("nom", c.getNom());
        req.addArgument("prenom", c.getPrenom());
        req.addArgument("email", c.getEmail());
        req.addArgument("passwd", c.getPasswd());
        req.addArgument("adresse", c.getAdresse());
        req.addArgument("datenaiss", c.getDateNaiss());

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
                if (resultOK == true) {
                    System.out.println("HTTP 200 OK");
                }
                else {
                    System.out.println("500 Internal Server Error");
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public boolean Signupcoach(Entraineur e) {
        System.out.println(e);
        System.out.println("********");
        String url = Statics.BASE_URL + "newcoach";

        req.setUrl(url);
        req.setPost(false);
        req.addArgument("nom", e.getNom());
        req.addArgument("prenom", e.getPrenom());
        req.addArgument("email", e.getEmail());
        req.addArgument("passwd", e.getPasswd());
        req.addArgument("adresse", e.getAdresse());
        req.addArgument("bio", e.getBio());
        req.addArgument("certification", e.getCertification());

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
                if (resultOK == true) {
                    System.out.println("HTTP 200 OK");
                }
                else {
                    System.out.println("500 Internal Server Error");
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public boolean Signupnutri(Nutritioniste n) {
        System.out.println(n);
        System.out.println("********");
        String url = Statics.BASE_URL + "newnutri";

        req.setUrl(url);
        req.setPost(false);
        req.addArgument("nom", n.getNom());
        req.addArgument("prenom", n.getPrenom());
        req.addArgument("email", n.getEmail());
        req.addArgument("passwd", n.getPasswd());
        req.addArgument("adresse", n.getAdresse());
        req.addArgument("bio", n.getBio());
        req.addArgument("certification", n.getCertification());

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
                if (resultOK == true) {
                    System.out.println("HTTP 200 OK");
                }
                else {
                    System.out.println("500 Internal Server Error");
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

}
