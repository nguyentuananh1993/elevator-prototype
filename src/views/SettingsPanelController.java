/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import fundamental.Global;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
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
    @FXML private RadioButton isRandom;
    @FXML private RadioButton isControlled;
    @FXML private CheckBox elev1;
    @FXML private CheckBox elev2;
    @FXML private TextField randomPerson;
    @FXML private TextField maxWeight;
    @FXML private TextField maxPeople;
    @FXML private TextField personAverange;
    private Stage primaryStage;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
// set controller using random or by user
        ToggleGroup group = new ToggleGroup();
        isRandom.setToggleGroup(group);
        isControlled.setToggleGroup(group);
        if(Global.isRandom)
            isRandom.setSelected(true);
        else isControlled.setSelected(true);
        
// set controller elevator de-active
        if(!Global.isActiveElevator1)
            elev1.setSelected(true);
        else elev1.setSelected(false);
        if(!Global.isActiveElevator2)
            elev2.setSelected(true);
        else elev2.setSelected(false);
        
// set system info:
        randomPerson.setText(Global.randomPersonInSecond.toString());
        maxWeight.setText(Global.maxWeight.toString());
        maxPeople.setText(Global.maxPeopleInFloor.toString());
        personAverange.setText(Global.personWeightAverange.toString());
    }    
    
    @FXML private void okAction(){
        primaryStage = (Stage)btnOk.getScene().getWindow();
        Global.randomPersonInSecond = Integer.parseInt(randomPerson.getText());
        Global.maxWeight = Integer.parseInt(maxWeight.getText());
        Global.maxPeopleInFloor = Integer.parseInt(maxPeople.getText());
        Global.personWeightAverange = Integer.parseInt(personAverange.getText());
        Global.isActiveElevator1 = !elev1.isSelected();
        Global.isActiveElevator2 = !elev2.isSelected();
        Global.isRandom = isRandom.isSelected();
        Global.prototypeStage.changeState();
        primaryStage.close();
    }
    @FXML private void cancelAction(){
        primaryStage = (Stage)btnOk.getScene().getWindow();
        primaryStage.close();
    }
    
}
