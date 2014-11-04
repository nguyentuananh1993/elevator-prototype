/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author misrc_000
 */
public class PrototypeStageController implements Initializable {

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML Button btnSettings;
    @FXML Button btnElev1;
    @FXML Button btnElev2;
    @FXML Button control;
    
    @FXML public void settingsAction(ActionEvent event) throws IOException{
        SettingsPanelController settingsPanel;
        final Stage dialog = new Stage();
        Stage settingsStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner((Stage)((Node)event.getSource()).getScene().getWindow());
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("/views/SettingsPanel.fxml"));
        dialog.setTitle("Settings");
        dialog.setResizable(false);
        dialog.getIcons().add(new Image(getClass().getResourceAsStream("/css/picture/icon.png")));
        Scene dialogScene = new Scene(root);
        dialog.setScene(dialogScene);
        dialog.show();
    }
}
