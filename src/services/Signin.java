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
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import entity.Admin;
import entity.Client;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import utils.Statics;

/**
 *
 * @author Rayen
 */
public class Signin {

    public ArrayList<Client> Client;
    public boolean clientloginstate;
    public static Signin instance = null;
    public boolean resultOK;
    public boolean resultOKClient;
    private ConnectionRequest req;

    private Signin() {
        req = new ConnectionRequest();
    }

    public static Signin getInstance() {
        if (instance == null) {
            instance = new Signin();
        }
        return instance;
    }

    public boolean signinAdmin(Admin a) {
//        String url = Statics.BASE_URL+"jsonloginAdmin?email="+email+"&passwd="+password;
        String url = Statics.BASE_URL + "jsonloginadmin";

        req.setUrl(url);
        req.setPost(false);
        req.addArgument("email", a.getEmail());
        req.addArgument("passwd", a.getPasswd());
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String json = new String(req.getResponseData());
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
                if ("true".equals(json)) {
                    System.out.println("Admin Login " + json);
                    resultOK = true;
                }
                else {
                    System.out.println("500 Internal Server Error");
                    resultOK = false;
                }

            }

        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

    public boolean signinClient(Client c) {
//        String url = Statics.BASE_URL+"jsonloginAdmin?email="+email+"&passwd="+password;
        String url = Statics.BASE_URL + "jsonloginclient";

        req.setUrl(url);
        req.setPost(false);
        req.addArgument("email", c.getEmail());
        req.addArgument("passwd", c.getPasswd());
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                String json = new String(req.getResponseData());
                resultOKClient = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
               boolean loginstate=Signin.getInstance().clientstate(c);
                if (("true".equals(json)) && (loginstate==false ) ) {
//                if (("true".equals(json))) {
                    System.out.println("Client Login valid " + json);
                    resultOKClient = true;
                }
                else if (("true".equals(json)) && (loginstate==true )) {
                    System.out.println(" You're banned Contact us for more infos.");
                    resultOKClient = false;
                }else{
                       System.out.println(" 500 Internal Server Error");
                    resultOKClient = false;
                }

            }

        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOKClient;
    }
    
     public boolean clientstate(Client c) {
//        String url = Statics.BASE_URL+"jsonloginAdmin?email="+email+"&passwd="+password;
        String url = Statics.BASE_URL + "loggedinblocked";

        req.setUrl(url);
        req.setPost(false);
        req.addArgument("email", c.getEmail());
        req.addArgument("passwd", c.getPasswd());
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
           public void actionPerformed(NetworkEvent evt) {
                String json = new String(req.getResponseData());
                clientloginstate = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
                if ("true".equals(json)) {
                    System.out.println("Client state " + json);
                    clientloginstate = false;
                }
                else {
                    System.out.println("Client state " + json);
                    clientloginstate = true;
                }

            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return clientloginstate;
    }

 
}
