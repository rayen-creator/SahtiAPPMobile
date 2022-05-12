/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author abdou
 */
public class Homeformee extends Form{
Form current;
    public Homeformee() {
        //current=this; //Back 
        setTitle("Home");
        setLayout(BoxLayout.y());
        
        add(new Label("Choose an option"));
        Button btnAddTask = new Button("Add Programme entraineur");
        Button btnListTasks = new Button("List programme entraineur");
        
        btnAddTask.addActionListener(e-> new addprogrammeentraineurform(current).show());
        btnListTasks.addActionListener(e-> new listprogrammeentraineurform(current).show());
        addAll(btnAddTask,btnListTasks);
        
        
    }
    
    
}
