/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import views.MainStageController;

/**
 *
 * @author misrc_000
 */
public class Main extends Application {
    
    private MainStageController mainPanel;
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader mainLoader = new FXMLLoader();
        Parent root = mainLoader.load(getClass().getResource("/views/MainStage.fxml"));

        Scene scene = new Scene(root);
        stage.setResizable(false);
        stage.setTitle("Elevator's Prototype");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/css/picture/icon.png")));
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
