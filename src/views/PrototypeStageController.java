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
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TimelineBuilder;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import sun.plugin.javascript.navig.Anchor;

/**
 * FXML Controller class
 *
 * @author misrc_000
 */
public class PrototypeStageController implements Initializable {
    private final int FLOOR_LENGTH = 80;
    private final DoubleProperty posY = new SimpleDoubleProperty();
    private Double movingSpeed = 1.0;
    private int i = 0;
    private int tempFloorLen =0;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        posY.set(elevator1.getY());
        elevator1.yProperty().bind(posY);
        
    }    
    @FXML AnchorPane eleBackground;
    @FXML Button btnSettings;
    @FXML Button btnElev1;
    @FXML Button btnElev2;
    @FXML Button control;
    @FXML ImageView elevator1;
    @FXML ImageView elevator2;
    @FXML public void elevatorActionOne(ActionEvent event) throws IOException{
        final Stage dialog = new Stage();
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner((Stage)((Node)event.getSource()).getScene().getWindow());
        Parent root = FXMLLoader.load(getClass().getResource("/views/ControlCabin.fxml"));
        dialog.setTitle("Elevator 1");
        dialog.setResizable(false);
        dialog.getIcons().add(new Image(getClass().getResourceAsStream("/css/picture/icon.png")));
        Scene dialogScene = new Scene(root);
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setScene(dialogScene);
        dialog.setX(primaryStage.getX()-216);
        dialog.setY(primaryStage.getY());
        dialog.show();
    }
        @FXML public void elevatorActionTwo(ActionEvent event) throws IOException{
        final Stage dialog = new Stage();
        Stage primaryStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner((Stage)((Node)event.getSource()).getScene().getWindow());
        Parent root = FXMLLoader.load(getClass().getResource("/views/ControlCabin.fxml"));
        dialog.setTitle("Elevator 2");
        dialog.setResizable(false);
        dialog.getIcons().add(new Image(getClass().getResourceAsStream("/css/picture/icon.png")));
        Scene dialogScene = new Scene(root);
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setScene(dialogScene);
        dialog.setX(primaryStage.getX()-216);
        dialog.setY(primaryStage.getY());
        dialog.show();
    }
    @FXML public void settingsAction(ActionEvent event) throws IOException{
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner((Stage)((Node)event.getSource()).getScene().getWindow());
        Parent root = FXMLLoader.load(getClass().getResource("/views/SettingsPanel.fxml"));
        dialog.setTitle("Settings");
        dialog.setResizable(false);
        dialog.getIcons().add(new Image(getClass().getResourceAsStream("/css/picture/icon.png")));
        dialog.initStyle(StageStyle.UTILITY);
        Scene dialogScene = new Scene(root);
        dialog.setScene(dialogScene);
        dialog.show();
    }
    public void deactiveElevator1(){
        btnElev1.setDisable(true);
    }
    public void deactiveElevator2(){
        btnElev2.setDisable(true);
    }
    public void activeElevator1(){
        btnElev1.setDisable(false);
    }
    public void activeElevator2(){
        btnElev2.setDisable(false); 
    }
    public void changeState(){
        if(Global.isActiveElevator1)
            activeElevator1();
        else deactiveElevator1();
        if(Global.isActiveElevator2)
            activeElevator2();
        else deactiveElevator2();
    }
    @FXML private void moveDown(){
        movingSpeed= 1.0;
        if(posY.get()+1 < FLOOR_LENGTH*6){
            timeline.playFromStart();
            Global.moveUpElevator1 = false;
            tempFloorLen = 80;
            
        }
    }
       @FXML private void moveUp(){
        movingSpeed= 1.0;
        if(posY.get() - FLOOR_LENGTH >= 0){
            timeline.playFromStart();
            Global.moveUpElevator1 = true;
            tempFloorLen = 80;
            
        }
    }
    @FXML private void setValue(){
        posY.set(0.0);
    }
    
    public void moveElevator1(int to){
        
    }
    private final EventHandler<ActionEvent> pulseEvent = new EventHandler<ActionEvent>() {
		@Override
		public void handle(final ActionEvent evt) {
                        checkEndOfPulse(tempFloorLen);
			double y = Global.moveUpElevator1 ? -movingSpeed : movingSpeed;
                        posY.set(posY.get() + y);
                        System.out.println(posY.getValue());
		}
	};
    private final Timeline timeline = TimelineBuilder.create()
			.keyFrames(new KeyFrame(new Duration(10.0), pulseEvent))
			.cycleCount(Timeline.INDEFINITE).build();
    
    private void checkEndOfPulse(int n){
        i++;
        if(i==n){
            timeline.stop();
            i=0;
            movingSpeed = 1.0;
            System.out.println(posY.getValue());
        }
            
    }
}
