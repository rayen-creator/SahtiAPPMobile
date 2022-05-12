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
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.mycompany.entities.Produit;
import utils.Statics;

/**
 *
 * @author HP
 */
public class ServiceProduit {
    public ArrayList<Produit> produit = new ArrayList<>();

    public static ServiceProduit instance = null;
    public boolean resultOK;
    private ConnectionRequest req;

    public ServiceProduit() {
        req = new ConnectionRequest();
    }

    public static ServiceProduit getInstance() {
        if (instance == null) {
            instance = new ServiceProduit();
        }
        return instance;
    }

    public boolean addProduit(Produit a) {
        System.out.println(a);
        System.out.println("********");
        //String url = Statics.BASE_URL + "create?name=" + t.getName() + "&status=" + t.getStatus();
        String url = Statics.BASE_URL + "addProduitMobile";

        req.setUrl(url);
        req.setPost(false);
        req.addArgument("nom", a.getNom() + "");
        req.addArgument("prix", a.getPrix() + "");
        req.addArgument("image", a.getImage() + "");
        req.addArgument("quantite", a.getQuantite() + "");
        req.addArgument("descProd", a.getDescprod()+ "");
        req.addArgument("idCat", a.getIdCat() + "");
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

    public ArrayList<Produit> getAllProduits() {
        ArrayList<Produit> result = new ArrayList<>();

        String url = Statics.BASE_URL + "liste";
        req.setUrl(url);

        req.addResponseListener((NetworkEvent evt) -> {
            JSONParser jsonp;
            jsonp = new JSONParser();
            
            try {
                Map<String, Object> mapReservation = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                
                List<Map<String, Object>> listOfMaps = (List<Map<String, Object>>) mapReservation.get("root");
                
                for (Map<String, Object> obj : listOfMaps) {
                    Produit t = new Produit();
                    float id = Float.parseFloat(obj.get("idProd").toString());
                    t.setIdProd((int) id);
                    t.setNom(obj.get("nom").toString());
                    t.setPrix(Float.parseFloat(obj.get("prix").toString()));
                    t.setImage(obj.get("image").toString());
                    float qte = Float.parseFloat(obj.get("quantite").toString());
                    t.setQuantite((int) qte);
                    t.setDescprod(obj.get("descprod").toString());                  
//                    float idcat = Float.parseFloat(obj.get("idCat").toString());
//                    t.setIdCat((int) idcat);
//                    
                    produit.add(t);
                    
                }
                
            } catch (Exception ex) {
                
                ex.printStackTrace();
            }
        });

        NetworkManager.getInstance().addToQueueAndWait(req);//execution requete else nothing pass

        return produit;

    }
     public boolean deleteProduit(int id ) {
        String url = Statics.BASE_URL +"deleteProduitMobile?idProd="+id;    
        req.setUrl(url);      
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                   
                    req.removeResponseCodeListener(this);
            }
        });
       
        NetworkManager.getInstance().addToQueueAndWait(req);
        return  resultOK;
    }
     //id_Prod=29&nom=acil&prix=55&image=acil.gpeg&quantite=8&descProd=rahma&idcat=1
      public boolean Modifier(Produit r) {
        System.out.println(r);
        System.out.println("********");
       String url = Statics.BASE_URL + "updateProduitMobile?id_Prod=" 
               + r.getIdProd()+
               "&nom=" + r.getNom()+ 
               "&prix=" + r.getPrix()+
               "&image=" + r.getImage()+ 
               "&quantite=" + r.getQuantite()+ 
               "&descProd=" + r.getDescprod()+ 
               "&idCat=" + r.getIdCat();
   
       req.setUrl(url);
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
////    public ArrayList<Produit> parseProduit(String jsonText){
////        try {
////            produit=new ArrayList<>();
////            JSONParser j = new JSONParser();
////            Map<String,Object> tasksListJson =
////               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
////           
////            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
////            for(Map<String,Object> obj : list){
////                Produit t = new Produit();
////                float id = Integer.parseInt(obj.get("id_Prod").toString());
////                    t.setId_prod((int)id);
////                    t.setNom(obj.get("nom").toString());     
////                    t.setPrix(Float.parseFloat(obj.get("prix").toString()));     
////                    t.setImage(obj.get("image").toString());     
////                    t.setQuantite(Integer.parseInt(obj.get("quantite").toString()));     
////                    t.setDescProd(obj.get("descProd").toString());
////                    t.setIdCat(Integer.parseInt(obj.get("idCat").toString()));
////                produit.add(t);
////            }
////           
////           
////        } catch (IOException ex) {
////           
////        }
////        return produit;
////    }
////   
////    public ArrayList<Produit> getAllProduits(){
////        req = new ConnectionRequest();
////        String url = Statics.BASE_URL+"/tasks/";
////      //  String url = Statics.BASE_URL+"/liste";
////        System.out.println("===>"+url);
////        req.setUrl(url);
////        req.setPost(false);
////        req.addResponseListener(new ActionListener<NetworkEvent>() {
////            @Override
////            public void actionPerformed(NetworkEvent evt) {
////                produit = parseProduit(new String(req.getResponseData()));
////                req.removeResponseListener(this);
////            }
////        });
////        NetworkManager.getInstance().addToQueueAndWait(req);
////        return produit;
////    }
}
