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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author misrc_000
 */
public class ControlCabinController implements Initializable {

    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button six;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button night;
    @FXML
    private Button ten;
    @FXML
    private Button btnCallOutside;
    @FXML
    private Button btnEmergency;
    @FXML
    private Button btnHoldDoor;
    @FXML
    private Button btnCloseDoor;
    @FXML
    private ImageView icon;

    @FXML
    private void oneAction() {
        disableButton(1);
        Global.prototypeStage.moveElevator1(1);
    }

    @FXML
    private void twoAction() {
        disableButton(2);
        Global.prototypeStage.moveElevator1(2);
    }

    @FXML
    private void threeAction() {
        disableButton(3);
        Global.prototypeStage.moveElevator1(3);
    }

    @FXML
    private void fourAction() {
        disableButton(4);
        Global.prototypeStage.moveElevator1(4);
    }

    @FXML
    private void fiveAction() {
        disableButton(5);
        Global.prototypeStage.moveElevator1(5);
    }

    @FXML
    private void sixAction() {
        disableButton(6);
        Global.prototypeStage.moveElevator1(6);
    }

    @FXML
    private void sevenAction() {
        disableButton(7);
        Global.prototypeStage.moveElevator1(7);
    }

    public void disableButton(int i) {
        switch (i) {
            case 1:
                one.setDisable(true);
                break;
            case 2:
                two.setDisable(true);
                break;
            case 3:
                three.setDisable(true);
                break;
            case 4:
                four.setDisable(true);
                break;
            case 5:
                five.setDisable(true);
                break;
            case 6:
                six.setDisable(true);
                break;
            case 7:
                seven.setDisable(true);
                break;
        }
    }

    public void enableButton(int i) {
        switch (i) {
            case 1:
                one.setDisable(false);
                break;
            case 2:
                two.setDisable(false);
                break;
            case 3:
                three.setDisable(false);
                break;
            case 4:
                four.setDisable(false);
                break;
            case 5:
                five.setDisable(false);
                break;
            case 6:
                six.setDisable(false);
                break;
            case 7:
                seven.setDisable(false);
                break;
        }
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        icon.setImage(new Image("/css/picture/Octocat.png"));
    }

}
