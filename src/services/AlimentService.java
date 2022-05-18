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
import com.codename1.io.MultipartRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.pidevv.sahti.entities.Aliment;
import utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author user
 */
public class AlimentService {

    public static AlimentService instance = null;
    public int resultCode;
    private ConnectionRequest cr;
    private ArrayList<Aliment> listAliment;

    private AlimentService() {
        cr = new ConnectionRequest();
    }

    public static AlimentService getInstance() {
        if (instance == null) {
            instance = new AlimentService();
        }
        return instance;
    }

    public ArrayList<Aliment> getAll() {
        listAliment = new ArrayList<>();

        cr = new ConnectionRequest();
        cr.setUrl(Statics.BASE_URL + "mobile/aliment");
        cr.setHttpMethod("GET");

        cr.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {

                if (cr.getResponseCode() == 200) {
                    listAliment = getList();
                }

                cr.removeResponseListener(this);
            }
        });

        try {
            cr.setDisposeOnCompletion(new InfiniteProgress().showInfiniteBlocking());
            NetworkManager.getInstance().addToQueueAndWait(cr);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return listAliment;
    }

    private ArrayList<Aliment> getList() {
        try {
            Map<String, Object> parsedJson = new JSONParser().parseJSON(new CharArrayReader(
                    new String(cr.getResponseData()).toCharArray()
            ));
            List<Map<String, Object>> list = (List<Map<String, Object>>) parsedJson.get("root");

            for (Map<String, Object> obj : list) {
                Aliment aliment = new Aliment();
//                        (int) Float.parseFloat(obj.get("idAliment").toString()),
//                        (String) obj.get("nom"),
//                        (String) obj.get("type"),
//                        (String) obj.get("image"),
//                        (int) Float.parseFloat(obj.get("calories").toString()),
//                        (String) obj.get("description")
                //);
                float idAliment = Float.parseFloat(obj.get("idAliment").toString());
//                float idAliment = obj.get("idAliment").toString();
                String nom = obj.get("nom").toString();
                String type = obj.get("type").toString();
                String img = obj.get("image").toString();
                String desc = obj.get("description").toString();

                float calories = Float.parseFloat(obj.get("calories").toString());

                aliment.setIdAliment((int) idAliment);

                if (obj.get("idAliment") == null) {
                    aliment.setIdAliment(0);
                }
                else {
                    aliment.setIdAliment((int) idAliment);
                }
                if (obj.get("nom") == null) {
                    aliment.setNom("null");
                }
                else {
                    aliment.setNom(nom);
                }
                if (obj.get("type") == null) {
                    aliment.setType("null");
                }
                else {
                    aliment.setType(type);
                }
                if (obj.get("image") == null) {
                    aliment.setImage("null");
                }
                else {
                    aliment.setImage(img);
                }
                if (obj.get("description") == null) {
                    aliment.setDescription("null");
                }
                else {
                    aliment.setDescription(desc);
                }
                if (obj.get("calories") == null) {
                    aliment.setCalories(0);
                }
                else {
                    aliment.setCalories((int) calories);
                }
                listAliment.add(aliment);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return listAliment;
    }

    public int add(Aliment aliment) {
        return manage(aliment, false, true);
    }

    public int edit(Aliment aliment, boolean imageEdited) {
        return manage(aliment, true, imageEdited);
    }

    public int manage(Aliment aliment, boolean isEdit, boolean imageEdited) {

        MultipartRequest cr = new MultipartRequest();
        cr.setFilename("file", "Aliment.jpg");

        cr.setHttpMethod("POST");
        if (isEdit) {
            cr.setUrl(Statics.BASE_URL + "aliment/edit");
            cr.addArgumentNoEncoding("idAliment", String.valueOf(aliment.getIdAliment()));
        }
        else {
            cr.setUrl(Statics.BASE_URL + "mobile/aliment/add");
        }

        if (imageEdited) {
            try {
                cr.addData("file", aliment.getImage(), "image/jpeg");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            cr.addArgumentNoEncoding("image", aliment.getImage());
        }

        cr.addArgumentNoEncoding("nom", aliment.getNom());

        cr.addArgumentNoEncoding("type", aliment.getType());
        cr.addArgumentNoEncoding("image", aliment.getImage());
        cr.addArgumentNoEncoding("calories", String.valueOf(aliment.getCalories()));
        cr.addArgumentNoEncoding("description", aliment.getDescription());

        cr.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultCode = cr.getResponseCode();
                cr.removeResponseListener(this);
            }
        });
        try {
            cr.setDisposeOnCompletion(new InfiniteProgress().showInfiniteBlocking());
            NetworkManager.getInstance().addToQueueAndWait(cr);
        }
        catch (Exception ignored) {

        }
        return resultCode;
    }

    public int delete(int IdAliment) {
        cr = new ConnectionRequest();
        cr.setUrl(Statics.BASE_URL + "mobile/aliment/delete");
        cr.setHttpMethod("POST");
        cr.addArgument("idAliment", String.valueOf(IdAliment));

        cr.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                cr.removeResponseListener(this);
            }
        });

        try {
            cr.setDisposeOnCompletion(new InfiniteProgress().showInfiniteBlocking());
            NetworkManager.getInstance().addToQueueAndWait(cr);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return cr.getResponseCode();
    }
}
