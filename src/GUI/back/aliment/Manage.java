/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.back.aliment;

import com.codename1.capture.Capture;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.pidevv.sahti.entities.Aliment;
import services.AlimentService;
import utils.Statics;
import java.io.IOException;

/**
 *
 * @author user
 */
public class Manage extends Form {

    Resources theme = UIManager.initFirstTheme("/theme");
    String selectedImage;
    boolean imageEdited = false;

    Aliment currentAliment;

    TextField nomTF;
    TextField typeTF;
    TextField imageTF, caloriesTF,
            descriptionTF;

    Label nomLabel, typeLabel, imageLabel, caloriesLabel, descriptionLabel;

    ImageViewer imageIV;
    Button selectImageButton;

    Button manageButton;

    Form previous;

    public Manage(Form previous) {
        super(ShowAll.currentAliment == null ? "Ajouter" : "Modifier", new BoxLayout(BoxLayout.Y_AXIS));
        this.previous = previous;

        currentAliment = ShowAll.currentAliment;

        addGUIs();
        addActions();

        getToolbar().addMaterialCommandToLeftBar("  ", FontImage.MATERIAL_ARROW_BACK, e -> previous.showBack());
    }

    private void addGUIs() {

        nomLabel = new Label("Name : ");
        nomLabel.setUIID("labelDefault");
        nomTF = new TextField();
        nomTF.setHint("Tapez le name");

        typeLabel = new Label("Type : ");
        typeLabel.setUIID("labelDefault");
        typeTF = new TextField();
        typeTF.setHint("Tapez le type");

        imageLabel = new Label("Image : ");
        imageLabel.setUIID("labelDefault");
        selectImageButton = new Button("Ajouter une image");

        caloriesLabel = new Label("Calories : ");
        caloriesLabel.setUIID("labelDefault");
        caloriesTF = new TextField();
        caloriesTF.setHint("Tapez Calories");

        descriptionLabel = new Label("Description : ");
        descriptionLabel.setUIID("labelDefault");
        descriptionTF = new TextField();
        descriptionTF.setHint("Tapez le description");

        if (currentAliment == null) {

            imageIV = new ImageViewer(theme.getImage("default.jpg").fill(1100, 500));

            manageButton = new Button("Ajouter");
        } else {
            nomTF.setText(currentAliment.getNom());

            descriptionTF.setText(currentAliment.getDescription());

//            if (currentAliment.getImage() != null) {
//                selectedImage = currentAliment.getImage();
//                String url = Statics.ALIMENT_IMAGE_URL + currentAliment.getImage();
//                Image image = URLImage.createToStorage(
//                        EncodedImage.createFromImage(theme.getImage("default.jpg").fill(1100, 500), false),
//                        url,
//                        url,
//                        URLImage.RESIZE_SCALE
//                );
//                imageIV = new ImageViewer(image);
//            } else {
//                imageIV = new ImageViewer(theme.getImage("default.jpg").fill(1100, 500));
//            }
//            imageIV.setFocusable(false);

            manageButton = new Button("Modifier");
        }
        manageButton.setUIID("buttonWhiteCenter");

        Container container = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        container.setUIID("containerRounded");

        container.addAll(
                imageLabel, imageIV,
                selectImageButton,
                nomLabel, nomTF,
                descriptionLabel, descriptionTF,
                caloriesLabel, caloriesTF,
                typeLabel, typeTF,
                manageButton
        );

        this.addAll(container);
    }

    private void addActions() {

        selectImageButton.addActionListener(a -> {
            selectedImage = Capture.capturePhoto(900, -1);
            try {
                imageEdited = true;
                imageIV.setImage(Image.createImage(selectedImage));
            } catch (IOException e) {
                e.printStackTrace();
            }
            selectImageButton.setText("Modifier l'image");
        });

        if (currentAliment == null) {
            manageButton.addActionListener(action -> {
                if (controleDeSaisie()) {
                    int responseCode = AlimentService.getInstance().add(
                            new Aliment(
                                    
                                    nomTF.getText(),
                                    typeTF.getText(),
                                    selectedImage,
                                    (int) Float.parseFloat(caloriesTF.getText()),
                                    descriptionTF.getText()
                            )
                    );
                    if (responseCode == 200) {
                       Dialog.show("Succés", "Aliment Ajoutée", new Command("Ok"));
                        showBackAndRefresh();
                    } else {
                        Dialog.show("Erreur", "Erreur d'ajout d'aliment. Code d'erreur : " + responseCode, new Command("Ok"));
                    }
                }
            });
        } else {
            manageButton.addActionListener(action -> {
                if (controleDeSaisie()) {
                    int responseCode = AlimentService.getInstance().edit(
                            new Aliment(
                                   nomTF.getText(),
                                    typeTF.getText(),
                                    selectedImage,
                                    (int) Float.parseFloat(caloriesTF.getText()),
                                    descriptionTF.getText()
                            ), imageEdited
                    );
                    if (responseCode == 200) {
                        Dialog.show("Succés", "Aliment modifié", new Command("Ok"));
                        showBackAndRefresh();
                    } else {
                        Dialog.show("Erreur", "Erreur de modification Code d'erreur : " + responseCode, new Command("Ok"));
                    }
                }
            });
        }
    }

    private void showBackAndRefresh() {
        ((ShowAll) previous).refresh();
        previous.showBack();
    }

    private boolean controleDeSaisie() {

        if (nomTF.getText().equals("")) {
            Dialog.show("Avertissement", "Veuillez saisir le nom", new Command("Ok"));
            return false;
        }

        if (typeTF.getText().equals("")) {
            Dialog.show("Avertissement", "Veuillez saisir le type", new Command("Ok"));
            return false;
        }

        if (caloriesTF.getText().equals("")) {
            Dialog.show("Avertissement", "Veuillez saisir le etat", new Command("Ok"));
            return false;
        }

        if (descriptionTF.getText().equals("")) {
            Dialog.show("Avertissement", "Veuillez saisir le description", new Command("Ok"));
            return false;
        }

        if (selectedImage == null) {
            Dialog.show("Avertissement", "Veuillez choisir une image", new Command("Ok"));
            return false;
        }

        return true;
    }
}
