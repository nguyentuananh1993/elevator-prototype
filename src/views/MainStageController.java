/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import fundamental.Global;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author misrc_000
 */
public class MainStageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML private ImageView logo;
    @FXML private Button start;
    @FXML private RadioButton random;
    @FXML private RadioButton control;
    private Stage primaryStage;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ToggleGroup group = new ToggleGroup();
        random.setToggleGroup(group);
        control.setToggleGroup(group);
        logo.setImage(new Image("/css/picture/Octocat.png"));
        random.setSelected(true);
        // TODO
        
    }    

    @FXML private void startAction(ActionEvent event) throws IOException{
        Global.isRandom = random.isSelected();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/PrototypeStage.fxml"));
        Parent root = loader.load();
        Global.prototypeStage = loader.getController();
        Scene scene = new Scene(root);
        Stage stageApp = (Stage)((Node)event.getSource()).getScene().getWindow();
        stageApp.setScene(scene);
        stageApp.show();
    }
}
