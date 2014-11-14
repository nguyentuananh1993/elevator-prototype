/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import fundamental.Global;
import fundamental.Global.directionType;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import models.FloorStatus;
import sun.plugin.javascript.navig.Anchor;

/**
 * FXML Controller class
 *
 * @author misrc_000
 */
public class PrototypeStageController implements Initializable {

    private final int FLOOR_LENGTH = 80;
    private final DoubleProperty posY = new SimpleDoubleProperty();
    private Double movingSpeed = 1.0;// elevator 
    private Double mSpeed = 10.0;
    private int i = 0;  // counter of corrupt
    private int tempFloorLen = 0;
    private double tempLen = 0;
    private Timeline timeline;
    private Timeline timelineSum;
    private int flag = 1;
    /**
     * Initializes the controller class.
     */
    @FXML
    AnchorPane eleBackground;
    @FXML
    Button btnSettings;
    @FXML
    Button btnElev1;
    @FXML
    Button btnElev2;
    @FXML
    Button control;
    @FXML
    ImageView elevator1;
    @FXML
    ImageView elevator2;

    //button up and down each floor
    //up button
    @FXML
    Button btnUp1;
    @FXML
    Button btnUp2;
    @FXML
    Button btnUp3;
    @FXML
    Button btnUp4;
    @FXML
    Button btnUp5;
    @FXML
    Button btnUp6;
    // down button
    @FXML
    Button btnDown2;
    @FXML
    Button btnDown3;
    @FXML
    Button btnDown4;
    @FXML
    Button btnDown5;
    @FXML
    Button btnDown6;
    @FXML
    Button btnDown7;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        posY.set(elevator1.getY());
        elevator1.yProperty().bind(posY);
//        timelineSum = new Timeline();
//        timelineSum = TimelineBuilder.create()
//                .keyFrames(new KeyFrame(new Duration(0.5), pulseEventSum))
//                .cycleCount(Timeline.INDEFINITE).build();
//        timelineSum.playFromStart();
    }

    @FXML
    public void elevatorActionOne(ActionEvent event) throws IOException {
        final Stage dialog = new Stage();
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner((Stage) ((Node) event.getSource()).getScene().getWindow());
//        Parent root = FXMLLoader.load(getClass().getResource("/views/ControlCabin.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/ControlCabin.fxml"));
        Parent root = loader.load();
        Global.controlCabin1 = loader.getController();
        dialog.setTitle("Elevator 1");
        dialog.setResizable(false);
        dialog.getIcons().add(new Image(getClass().getResourceAsStream("/css/picture/icon.png")));
        Scene dialogScene = new Scene(root);
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setScene(dialogScene);
        dialog.setX(primaryStage.getX() - 216);
        dialog.setY(primaryStage.getY());
        dialog.show();
    }

    @FXML
    public void elevatorActionTwo(ActionEvent event) throws IOException {
        final Stage dialog = new Stage();
        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner((Stage) ((Node) event.getSource()).getScene().getWindow());
        Parent root = FXMLLoader.load(getClass().getResource("/views/ControlCabin.fxml"));
        dialog.setTitle("Elevator 2");
        dialog.setResizable(false);
        dialog.getIcons().add(new Image(getClass().getResourceAsStream("/css/picture/icon.png")));
        Scene dialogScene = new Scene(root);
        dialog.initStyle(StageStyle.UTILITY);
        dialog.setScene(dialogScene);
        dialog.setX(primaryStage.getX() - 216);
        dialog.setY(primaryStage.getY());
        dialog.show();
    }

    @FXML
    public void settingsAction(ActionEvent event) throws IOException {
        final Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.initOwner((Stage) ((Node) event.getSource()).getScene().getWindow());
        Parent root = FXMLLoader.load(getClass().getResource("/views/SettingsPanel.fxml"));
        dialog.setTitle("Settings");
        dialog.setResizable(false);
        dialog.getIcons().add(new Image(getClass().getResourceAsStream("/css/picture/icon.png")));
        dialog.initStyle(StageStyle.UTILITY);
        Scene dialogScene = new Scene(root);
        dialog.setScene(dialogScene);
        dialog.show();
    }

    public void changeState() {
        if (Global.isActiveElevator1) {
            activeElevator1();
        } else {
            deactiveElevator1();
        }
        if (Global.isActiveElevator2) {
            activeElevator2();
        } else {
            deactiveElevator2();
        }
    }

    @FXML
    public void moveDown() {
        movingSpeed = 1.0;
        if (posY.get() + 1 < FLOOR_LENGTH * 6) {
            timeline.playFromStart();
            Global.direct1 = directionType.DOWN;
            tempFloorLen = 80;

        }
    }

    @FXML
    public void moveUp() {
        movingSpeed = 1.0;
        if (posY.get() - FLOOR_LENGTH >= 0) {
            timeline.playFromStart();
            Global.direct1 = directionType.UP;
            tempFloorLen = 80;

        }
    }

    @FXML
    public void setValue() {
        posY.set(0.0);
    }

    public int getFloorPosition(double len) {
        if (len >= 480.0) {
            return 1;
        } else if (len >= 400.0) {
            return 2;
        } else if (len >= 320.0) {
            return 3;
        } else if (len >= 240.0) {
            return 4;
        } else if (len >= 160.0) {
            return 5;
        } else if (len >= 80.0) {
            return 6;
        } else {
            return 7;
        }
    }

    public double getFloorPosition(int to) {
        switch (to) {
            case 1:
                return 480.0;
            case 2:
                return 400.0;
            case 3:
                return 320.0;
            case 4:
                return 240.0;
            case 5:
                return 160.0;
            case 6:
                return 80.0;
            case 7:
                return 0.0;
        }
        return 0;
    }

    public int memoryFloor(ArrayList<FloorStatus> a) {
        int check = 0;
        for (FloorStatus tmp : a) {
            if (tmp.getMemory()) {
                check = tmp.getFloor();
            }
        }
        return check;
    }

    public void moveElevator1(int to) {
        if (to == getFloorPosition(tempLen) || to == getFloorPosition(posY.get())) {
            Global.controlCabin1.enableButton(to);
        } else {
            if (Global.direct1.equals(directionType.UP)) {
                if (to < getFloorPosition(posY.get())) {
                    Global.listDown1.add(to);
                } else if (to > getFloorPosition(tempLen)) {
                    Global.listUp1.add(to);
                } else {
                    Global.listUp1.add(getFloorPosition(tempLen));
                    tempLen = getFloorPosition(to);
                }
            } else if (Global.direct1.equals(directionType.DOWN)) {
                if (to > getFloorPosition(posY.get())) {
                    Global.listUp1.add(to);
                } else if (to < getFloorPosition(tempLen)) {
                    Global.listDown1.add(to);
                } else {
                    Global.listDown1.add(getFloorPosition(tempLen));
                    tempLen = getFloorPosition(to);
                }
            } else {
                timeline = new Timeline();
                timeline = TimelineBuilder.create()
                        .keyFrames(new KeyFrame(new Duration(11 - Global.elevatorSpeed), pulseEvent))
                        .cycleCount(Timeline.INDEFINITE).build();
                tempLen = getFloorPosition(to);
                if (tempLen > posY.get()) {
                    tempFloorLen = (int) (tempLen - posY.get());
                    Global.direct1 = directionType.DOWN;
                    timeline.playFromStart();
                } else if ((tempLen < posY.get())) {
                    tempFloorLen = (int) (posY.get() - tempLen);
                    Global.direct1 = directionType.UP;
                    timeline.playFromStart();
                }
            }
        }
    }

    private final EventHandler<ActionEvent> pulseEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(final ActionEvent evt) {
            //if elevator still run
            if (posY.get() != tempLen) {
                double y;
                if (Math.abs(posY.get() - tempLen) <= 30) {
                    y = Global.direct1.equals(directionType.UP) ? -movingSpeed / 4 : movingSpeed / 4;
                } else if (Math.abs(posY.get() - tempLen) <= 15) {
                    y = Global.direct1.equals(directionType.UP) ? -movingSpeed / 8 : movingSpeed / 8;
                } else {
                    y = Global.direct1.equals(directionType.UP) ? -movingSpeed : movingSpeed;
                }
                posY.set(posY.get() + y);
                System.out.println(posY.getValue());
            } else {
                timeline.stop();
                Global.controlCabin1.enableButton(getFloorPosition(tempLen));
                if (Global.direct1.equals(directionType.UP)) {
                    if (checkListUp(getFloorPosition(tempLen))) {
                        Global.direct1 = directionType.STANDBY;
                        moveElevator1(searchNearUp(getFloorPosition(tempLen)));
                    } else if (checkListDown(getFloorPosition(tempLen))) {
                        Global.direct1 = directionType.STANDBY;
                        moveElevator1(searchNearDown(getFloorPosition(tempLen)));
                    }else{
                        Global.direct1 = directionType.STANDBY;
                    }
                } else if (Global.direct1.equals(directionType.DOWN)) {
                    if (checkListDown(getFloorPosition(tempLen))) {
                        Global.direct1 = directionType.STANDBY;
                        moveElevator1(searchNearDown(getFloorPosition(tempLen)));
                    }else if(checkListUp(getFloorPosition(tempLen))){
                        Global.direct1 = directionType.STANDBY;
                        moveElevator1(searchNearUp(getFloorPosition(tempLen)));
                    }else{
                        Global.direct1 = directionType.STANDBY;
                    }
                } else {
                    Global.direct1 = directionType.STANDBY;
                }
            }

        }
    };

    public boolean checkListUp(int floor) {
        boolean check = false;
        for (Integer tmp : Global.listUp1) {
            if (tmp > floor) {
                check = true;
                break;
            }
        }
        return check;
    }

    public boolean checkListDown(int floor) {
        boolean check = false;
        for (Integer tmp : Global.listDown1) {
            if (tmp < floor) {
                check = true;
                break;
            }
        }
        return check;
    }

    public int searchNearUp(int floor) {
        Integer near = Global.listUp1.get(0);
        for (Integer tmp : Global.listUp1) {
            if (near < tmp) {
                near = tmp;
            }
        }
        for (Integer tmp : Global.listUp1) {
            if (tmp > floor && tmp < near) {
                near = tmp;
            }
        }
        Global.listUp1.remove(near);
        return near;
    }

    public int searchNearDown(int floor) {
        Integer near = Global.listDown1.get(0);
        for (Integer tmp : Global.listDown1) {
            if (near > tmp) {
                near = tmp;
            }
        }
        for (Integer tmp : Global.listDown1) {
            if (tmp < floor && tmp > near) {
                near = tmp;
            }
        }
        Global.listDown1.remove(near);
        return near;
    }

    @FXML
    public void disableOutsideButton(boolean up, int floor) {
        if (!up) {
            switch (floor) {
                case 2:
                    btnDown2.setDisable(true);
                    break;
                case 3:
                    btnDown3.setDisable(true);
                    break;
                case 4:
                    btnDown4.setDisable(true);
                    break;
                case 5:
                    btnDown5.setDisable(true);
                    break;
                case 6:
                    btnDown6.setDisable(true);
                    break;
                case 7:
                    btnDown7.setDisable(true);
                    break;
            }
        } else {
            switch (floor) {
                case 1:
                    btnUp1.setDisable(true);
                    break;
                case 2:
                    btnUp2.setDisable(true);
                    break;
                case 3:
                    btnUp3.setDisable(true);
                    break;
                case 4:
                    btnUp4.setDisable(true);
                    break;
                case 5:
                    btnUp5.setDisable(true);
                    break;
                case 6:
                    btnUp6.setDisable(true);
                    break;

            }
        }

    }

    @FXML
    void actionUp1() {
    }

    @FXML
    void actionUp2() {
    }

    @FXML
    void actionUp3() {
    }

    @FXML
    void actionUp4() {
    }

    @FXML
    void actionUp5() {
    }

    @FXML
    void actionUp6() {
    }

    @FXML
    void actionDown2() {
    }

    @FXML
    void actionDown3() {
    }

    @FXML
    void actionDown4() {
    }

    @FXML
    void actionDown5() {
    }

    @FXML
    void actionDown6() {
    }

    @FXML
    void actionDown7() {
    }

    @FXML
    public void deactiveElevator1() {
        btnElev1.setDisable(true);
    }

    @FXML
    public void deactiveElevator2() {
        btnElev2.setDisable(true);
    }

    @FXML
    public void activeElevator1() {
        btnElev1.setDisable(false);
    }

    @FXML
    public void activeElevator2() {
        btnElev2.setDisable(false);
    }
//
//    
//    public void externalMovingAction(int to) {
//        if (Global.elevatorUpward1) {
//            if (posY.get() > getFloorPosition(to) && getFloorPosition(to) > tempLen) {
//                if (memoryFloor(Global.gotoElevator1) == 0) {
//                    Global.gotoElevator1.add(new FloorStatus(getFloorPosition(tempLen),true,true));
//                    tempLen = getFloorPosition(to);
//                } else {
//                    Global.gotoElevator1.add(new FloorStatus(getFloorPosition(tempLen), true));
//                    tempLen = getFloorPosition(to);
//                }
//            } else {
//                Global.gotoElevator1.add(new FloorStatus(to, true));
//            }
//        } else {
//            if (posY.get() < getFloorPosition(to) && getFloorPosition(to) < tempLen) {
//                if (memoryFloor(Global.gotoElevator1) == 0) {
//                    Global.gotoElevator1.add(new FloorStatus(getFloorPosition(tempLen),false,true));
//                    tempLen = getFloorPosition(to);
//                } else {
//                    Global.gotoElevator1.add(new FloorStatus(getFloorPosition(tempLen), false));
//                    tempLen = getFloorPosition(to);
//                }
//            } else {
//                Global.gotoElevator1.add(new FloorStatus(to, false));
//            }
//        }
//        //Global.gotoElevator1.add(new FloorStatus(to, true));

}
