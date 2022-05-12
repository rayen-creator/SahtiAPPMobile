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
import com.mycompany.myapp.Forgetpwd;
import entity.Client;
import utils.Statics;

/**
 *
 * @author Rayen
 */
public class resetpwd {
    
      public static resetpwd instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    private resetpwd() {
        req = new ConnectionRequest();
    }

    public static resetpwd getInstance() {
        if (instance == null) {
            instance = new resetpwd();
        }
        return instance;
    }
    
        public boolean Forgetpwd(String mail) {
        System.out.println("********");
        String url = Statics.BASE_URL + "forgetpwd";
        req.setUrl(url);
        req.setPost(false);
        req.addArgument("email", mail);
      
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
