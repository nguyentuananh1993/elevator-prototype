/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author misrc_000
 */
public class ControlCabinController implements Initializable {
    @FXML private Button one;
    @FXML private Button two;
    @FXML private Button three;
    @FXML private Button four;
    @FXML private Button five;
    @FXML private Button six;
    @FXML private Button seven;
    @FXML private Button eight;
    @FXML private Button night;
    @FXML private Button ten;
    @FXML private Button btnCallOutside;
    @FXML private Button btnEmergency;
    @FXML private Button btnHoldDoor;
    @FXML private Button btnCloseDoor;
    @FXML private ImageView icon;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        icon.setImage(new Image("/css/picture/Octocat.png"));
    }    
    
}