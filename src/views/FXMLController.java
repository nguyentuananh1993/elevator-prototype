/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author misrc_000
 */
public class FXMLController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private ImageView logo;
    @FXML private Button start;
    @FXML private RadioButton random;
    @FXML private RadioButton control;
    @FXML private Label check;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup group = new ToggleGroup();
        logo.setImage(new Image("/css/picture/Octocat.png"));
        random.setSelected(true);
        // TODO
        random.setToggleGroup(group);
        control.setToggleGroup(group);
    }    
    
    @FXML private void startAction(){
        if(random.isSelected()){
            check.setText("random");
        }else{
            check.setText("control");
        }
    }
}
