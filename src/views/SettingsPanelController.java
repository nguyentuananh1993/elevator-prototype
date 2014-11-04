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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author misrc_000
 */
public class SettingsPanelController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML private Button btnOk;
    
    private Stage primaryStage;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML private void okAction(){
        primaryStage = (Stage)btnOk.getScene().getWindow();
        primaryStage.close();
    }
    @FXML private void cancelAction(){
        primaryStage = (Stage)btnOk.getScene().getWindow();
        primaryStage.close();
    }
    
}
