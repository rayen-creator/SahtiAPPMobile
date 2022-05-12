/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.back.aliment;

import com.codename1.components.ImageViewer;
import com.codename1.components.InteractionDialog;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.pidevv.sahti.entities.Aliment;
import services.AlimentService;
import utils.Statics;
import java.util.ArrayList;

/**
 *
 * @author user
 */
public class ShowAll extends Form {

    Form previous;

    Resources theme = UIManager.initFirstTheme("/theme");

    public static Aliment currentAliment = null;
    Button addBtn;

    TextField searchTF;
    ArrayList<Component> componentModels;

    public ShowAll(Form previous) {
        super("Aliments", new BoxLayout(BoxLayout.Y_AXIS));
        this.previous = previous;

        addGUIs();
        addActions();

        super.getToolbar().addMaterialCommandToLeftBar("  ", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }

    public void refresh() {
        this.removeAll();
        addGUIs();
        addActions();
        this.refreshTheme();
    }

    private void addGUIs() {
        addBtn = new Button("Ajouter");
        addBtn.setUIID("buttonWhiteCenter");
        this.add(addBtn);

        ArrayList<Aliment> listAliment = AlimentService.getInstance().getAll();
        componentModels = new ArrayList<>();

        searchTF = new TextField("", "Chercher Aliment par Nom");
        searchTF.addDataChangedListener((d, t) -> {
            if (componentModels.size() > 0) {
                for (Component componentModel : componentModels) {
                    this.removeComponent(componentModel);
                }
            }
            componentModels = new ArrayList<>();
            for (Aliment aliment : listAliment) {
                if (aliment.getNom().toLowerCase().startsWith(searchTF.getText().toLowerCase())) {
                    Component model = makeAlimentModel(aliment);
                    this.add(model);
                    componentModels.add(model);
                }
            }
            this.revalidate();
        });
        this.add(searchTF);

        if (listAliment.size() > 0) {
            for (Aliment aliment : listAliment) {
                Component model = makeAlimentModel(aliment);
                this.add(model);
                componentModels.add(model);
            }
        } else {
            this.add(new Label("Aucune donnée"));
        }
    }

    private void addActions() {
        addBtn.addActionListener(action -> {
            currentAliment = null;
            new Manage(this).show();
        });

    }
    Label nomLabel, typeLabel, imageLabel, caloriesLabel, descriptionLabel;

    ImageViewer imageIV;

    private Container makeModelWithoutButtons(Aliment aliment) {
        Container alimentModel = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        alimentModel.setUIID("containerRounded");

        nomLabel = new Label("Name : " + aliment.getNom());
        nomLabel.setUIID("labelDefault");
        typeLabel = new Label("Type : " + aliment.getType());
        typeLabel.setUIID("labelDefault");
        imageLabel = new Label("Image : " + aliment.getImage());
        imageLabel.setUIID("labelDefault");
        caloriesLabel = new Label("Calories : " + aliment.getCalories());
        caloriesLabel.setUIID("labelDefault");
        descriptionLabel = new Label("Description : " + aliment.getDescription());
        descriptionLabel.setUIID("labelDefault");

        System.out.println(Statics.ALIMENT_IMAGE_URL
        );

//        if (aliment.getImage() != null) {
//            String url = Statics.ALIMENT_IMAGE_URL + aliment.getImage();
////            Image image = URLImage.createToStorage(
////                    EncodedImage.createFromImage(theme.getImage("default.jpg").fill(1100, 500), false),
////                    url,
////                    url,
////                    URLImage.RESIZE_SCALE
////            );
//          //  imageIV = new ImageViewer(image);
//        } else {
//            imageIV = new ImageViewer(theme.getImage("default.jpg").fill(1100, 500));
//        }
//        imageIV.setFocusable(false);

        alimentModel.addAll(
               // imageIV,
                nomLabel, descriptionLabel,
                caloriesLabel,
                typeLabel
        );

        return alimentModel;
    }

    Button editBtn, deleteBtn;
    Container btnsContainer;

    private Component makeAlimentModel(Aliment aliment) {

        Container alimentModel = makeModelWithoutButtons(aliment);

        btnsContainer = new Container(new BorderLayout());
        btnsContainer.setUIID("containerButtons");

        editBtn = new Button("Modifier");
        editBtn.setUIID("buttonWhiteCenter");
        editBtn.addActionListener(action -> {
            currentAliment = aliment;
            new Manage(this).show();
        });

        deleteBtn = new Button("Supprimer");
        deleteBtn.setUIID("buttonWhiteCenter");
        deleteBtn.addActionListener(action -> {
            InteractionDialog dlg = new InteractionDialog("Confirmer la suppression");
            dlg.setLayout(new BorderLayout());
            dlg.add(BorderLayout.CENTER, new Label("Voulez vous vraiment supprimer cette aliment ?"));
            Button btnClose = new Button("Annuler");
            btnClose.addActionListener((ee) -> dlg.dispose());
            Button btnConfirm = new Button("Confirmer");
            btnConfirm.addActionListener(actionConf -> {
                int responseCode = AlimentService.getInstance().delete(aliment.getIdAliment());

                if (responseCode == 200) {
                    currentAliment = null;
                    dlg.dispose();
                    alimentModel.remove();
                    this.refreshTheme();
                } else {
                    Dialog.show("Erreur", "Erreur de suppression d'aliment. Code d'erreur : " + responseCode, new Command("Ok"));
                }
            });
            Container btnContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
            btnContainer.addAll(btnClose, btnConfirm);
            dlg.addComponent(BorderLayout.SOUTH, btnContainer);
            dlg.show(800, 800, 0, 0);
        });

        btnsContainer.add(BorderLayout.WEST, editBtn);
        btnsContainer.add(BorderLayout.EAST, deleteBtn);

        alimentModel.add(btnsContainer);

        return alimentModel;
    }

}
