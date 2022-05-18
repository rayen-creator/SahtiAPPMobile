/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sahtiMobile.services;

import com.codename1.components.InfiniteProgress;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import sahtiMobile.entities.Reclamations;
import utils.Statics;

/**
 *
 * @author Akrimi
 */
public class ServiceReclamation {
    public ArrayList<Reclamations> reclamations;
    
    public static ServiceReclamation instance=null;
    public boolean resultOK;
    private boolean resultCode;
    private ConnectionRequest req;

    private ServiceReclamation() {
         req = new ConnectionRequest();
    }

    public static ServiceReclamation getInstance() {
        if (instance == null) {
            instance = new ServiceReclamation();
        }
        return instance;
    }

    public boolean addReclamation(Reclamations r) {
        System.out.println(r);
        System.out.println("********");
       //String url = Statics.BASE_URL + "create?name=" + t.getName() + "&status=" + t.getStatus();
       String url = Statics.BASE_URL + "reclam/add";
    
       req.setUrl(url);
       req.setPost(false);
       req.addArgument("numReclamation", r.getNumReclamation());
       req.addArgument("titre", r.getTitre()+"");
       req.addArgument("type", r.getType()+"");
       req.addArgument("message", r.getMessage()+"");
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

    public ArrayList<Reclamations> parseReclamations(String jsonText){
        try {
            reclamations=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Reclamations r = new Reclamations();
                float id = Float.parseFloat(obj.get("id").toString());
                r.setId((int)id);
                r.setNumReclamation(((obj.get("numreclamation").toString())));
                r.setTitre(((obj.get("titre").toString())));
                r.setType(((obj.get("type").toString())));
                r.setMessage(((obj.get("message").toString())));
//                if (obj.get("titre")==null)
//                    r.setTitre("iheb");
//                else
//                    r.setTitre(obj.get("titre").toString());
                reclamations.add(r);
            }
            
            
        } catch (IOException ex) {
            
        }
        return reclamations;
    }
    
    public ArrayList<Reclamations> getAllReclamations(){
        req = new ConnectionRequest();
        //String url = Statics.BASE_URL+"/tasks/";
        String url = Statics.BASE_URL+"reclam/liste";
        System.out.println("===>"+url);
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                reclamations = parseReclamations(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return reclamations;
    }
    
    
      public boolean edit(Reclamations reclamation) {

        req = new ConnectionRequest();
        String url = Statics.BASE_URL+"reclam/edit";
        req.setHttpMethod("POST");
        
        req.setUrl(url);
        req.addArgument("id", String.valueOf(reclamation.getId()));
      
        //cr.addArgument("date", new SimpleDateFormat("dd-MM-yyyy").format(reclamation.getDate()));
        req.addArgument("numreclamation", reclamation.getNumReclamation());
        req.addArgument("titre", reclamation.getTitre());
        req.addArgument("type", reclamation.getType());
        req.addArgument("message", reclamation.getMessage());

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        /*try {
            cr.setDisposeOnCompletion(new InfiniteProgress().showInfiniteBlocking());
            NetworkManager.getInstance().addToQueueAndWait(cr);
        } catch (Exception ignored) {

        }*/
        return resultCode;
    }
      public int delete(int reclamationId) {
        req = new ConnectionRequest();
        req.setUrl(Statics.BASE_URL + "reclam/delete");
        req.setHttpMethod("POST");
        req.addArgument("id", String.valueOf(reclamationId));

        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                req.removeResponseListener(this);
            }
        });

        try {
            req.setDisposeOnCompletion(new InfiniteProgress().showInfiniteBlocking());
            NetworkManager.getInstance().addToQueueAndWait(req);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return req.getResponseCode();
    }

}
