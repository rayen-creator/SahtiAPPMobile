/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sahtiMobile.entities;

/**
 *
 * @author Akrimi
 */
public class Reclamations {

    private int id;
    private String numReclamation;
    private String titre;   
    private String type;
     private String message;
    private String image;
    private boolean cloturer;

    public Reclamations(int id, String numReclamation, String titre, String message, String type, String image, boolean cloturer) {
        this.id = id;
        this.numReclamation = numReclamation;
        this.titre = titre;
        
        this.type = type;
        this.message = message;
        this.image = image;
        this.cloturer = cloturer;
    }

    public Reclamations(int id, String numReclamation, String titre, String type, String message) {
        this.id = id;
        this.numReclamation = numReclamation;
        this.titre = titre;        
        this.type = type;
        this.message = message;
    }

    public Reclamations(String numReclamation, String titre, String type, String message) {
        this.numReclamation = numReclamation;
        this.titre = titre;
        this.type = type;
        this.message = message;
    }

    public Reclamations(String numReclamation, String titre) {
        this.numReclamation = numReclamation;
        this.titre = titre;
    }

    public Reclamations() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumReclamation() {
        return numReclamation;
    }

    public void setNumReclamation(String numReclamation) {
        this.numReclamation = numReclamation;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isCloturer() {
        return cloturer;
    }

    public void setCloturer(boolean cloturer) {
        this.cloturer = cloturer;
    }

    @Override
    public String toString() {
        return "Reclamations{" + "id=" + id + ", numReclamation=" + numReclamation + ", titre=" + titre + ", type=" + type + ", message=" + message + ", image=" + image + ", cloturer=" + cloturer + '}';
    }

  

}
