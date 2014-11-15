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
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import models.ButtonOutside;
import models.FloorStatus;

/**
 * FXML Controller class
 *
 * @author misrc_000
 */
public class PrototypeStageController implements Initializable {

    private Double movingSpeed = 1.0;// elevator 
    private double tempLen = 0;
    public Timeline elevatorTimeline;
    public Timeline doorTimeline;
    public Timeline waitingTimeline;
    private int timewaiting = 0;
    private boolean doorwait = false;

    /**
     * Initializes the controller class.
     */
    @FXML
    private AnchorPane eleBackground;
    @FXML
    private Button btnSettings;
    @FXML
    private Button btnElev1;
    @FXML
    private Button btnElev2;
    @FXML
    private Button control;
    @FXML
    private Group elevator1;
    @FXML
    private ImageView elevator2;
    @FXML
    private ImageView leftDoor;
    @FXML
    private ImageView rightDoor;

    //button up and down each floor
    //up button
    @FXML
    private Button btnUp1;
    @FXML
    private Button btnUp2;
    @FXML
    private Button btnUp3;
    @FXML
    private Button btnUp4;
    @FXML
    private Button btnUp5;
    @FXML
    private Button btnUp6;
    // down button
    @FXML
    private Button btnDown2;
    @FXML
    private Button btnDown3;
    @FXML
    private Button btnDown4;
    @FXML
    private Button btnDown5;
    @FXML
    private Button btnDown6;
    @FXML
    private Button btnDown7;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

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
    public void closeDoor() {
        doorTimeline = new Timeline();
        doorTimeline = TimelineBuilder.create()
                .keyFrames(new KeyFrame(new Duration(100.0), closeDoorEvent))
                .cycleCount(Timeline.INDEFINITE).build();
        doorTimeline.playFromStart();
    }

    @FXML
    public void openDoor() {
        doorTimeline = new Timeline();
        doorTimeline = TimelineBuilder.create()
                .keyFrames(new KeyFrame(new Duration(100.0), openDoorEvent))
                .cycleCount(Timeline.INDEFINITE).build();
        doorTimeline.playFromStart();
    }

    public void waitDoor(){
        waitingTimeline = new Timeline();
        waitingTimeline = TimelineBuilder.create()
                .keyFrames(new KeyFrame(new Duration(100.0), waitingEvent))
                .cycleCount(Timeline.INDEFINITE).build();
        waitingTimeline.playFromStart();
    }
    @FXML
    public void setValue() {

    }

    public int getFloorPosition(double len) {
        if (len >= 500.0) {
            return 1;
        } else if (len >= 420.0) {
            return 2;
        } else if (len >= 340.0) {
            return 3;
        } else if (len >= 260.0) {
            return 4;
        } else if (len >= 180.0) {
            return 5;
        } else if (len >= 100.0) {
            return 6;
        } else {
            return 7;
        }
    }

    public double getFloorPosition(int to) {
        switch (to) {
            case 1:
                return 500.0;
            case 2:
                return 420.0;
            case 3:
                return 340.0;
            case 4:
                return 260.0;
            case 5:
                return 180.0;
            case 6:
                return 100.0;
            case 7:
                return 20.0;
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

    public void moveElevatorOutside1(int tFloor, boolean tUp) {
        disableOutsideButton(tUp, tFloor);
        if (tFloor == 1 && tFloor == getFloorPosition(tempLen)) {
            enableOutsideButton(true, tFloor);
        } else if (tFloor == 7 && tFloor == getFloorPosition(tempLen)) {
            enableOutsideButton(false, tFloor);
        }
    }


public void moveElevatorInside1(int to) {
        if (to == getFloorPosition(tempLen) || to == getFloorPosition(elevator1.getLayoutY())) {
            Global.controlCabin1.enableButton(to);
        } else {
            if (Global.direct1.equals(directionType.UP)) {
                if (to < getFloorPosition(elevator1.getLayoutY())) {
                    Global.listDown1.add(to);
                } else if (to > getFloorPosition(tempLen)) {
                    Global.listUp1.add(to);
                } else {
                    Global.listUp1.add(getFloorPosition(tempLen));
                    tempLen = getFloorPosition(to);
                }
            } else if (Global.direct1.equals(directionType.DOWN)) {
                if (to > getFloorPosition(elevator1.getLayoutY())) {
                    Global.listUp1.add(to);
                } else if (to < getFloorPosition(tempLen)) {
                    Global.listDown1.add(to);
                } else {
                    Global.listDown1.add(getFloorPosition(tempLen));
                    tempLen = getFloorPosition(to);
                }
            } else {
                elevatorTimeline = new Timeline();
                elevatorTimeline = TimelineBuilder.create()
                        .keyFrames(new KeyFrame(new Duration(11 - Global.elevatorSpeed), elevatorMoveEvent))
                        .cycleCount(Timeline.INDEFINITE).build();
                tempLen = getFloorPosition(to);
                if (tempLen > elevator1.getLayoutY()) {
                    Global.direct1 = directionType.DOWN;
                    elevatorTimeline.playFromStart();
                } else if ((tempLen < elevator1.getLayoutY())) {
                    Global.direct1 = directionType.UP;
                    elevatorTimeline.playFromStart();
                }
            }
        }
    }
    private final EventHandler<ActionEvent> closeDoorEvent = new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            if (leftDoor.getFitWidth() != 26) {
                leftDoor.setFitWidth(leftDoor.getFitWidth() + 1);
                rightDoor.setFitWidth(rightDoor.getFitWidth() + 1);
                rightDoor.setX(rightDoor.getX() - 1);
            } else {                
                doorTimeline.stop();
            }
        }
    };
    
    private final EventHandler<ActionEvent> waitingEvent = new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            if(timewaiting!= 20)
                timewaiting++;
            else
            {
                doorwait = false;
                timewaiting = 0;
                waitingTimeline.stop();
                closeDoor();
            }
            
        }
    };
    private final EventHandler<ActionEvent> openDoorEvent = new EventHandler<ActionEvent>() {

        @Override
        public void handle(ActionEvent event) {
            if (leftDoor.getFitWidth() != 1) {
                leftDoor.setFitWidth(leftDoor.getFitWidth() - 1);
                rightDoor.setFitWidth(rightDoor.getFitWidth() - 1);
                rightDoor.setX(rightDoor.getX() + 1);
            } else {
                //doorwait = false;
                doorTimeline.stop();
                waitDoor();
            }
        }
    };
    private final EventHandler<ActionEvent> elevatorMoveEvent = new EventHandler<ActionEvent>() {
        @Override
        public void handle(final ActionEvent evt) {
            //if elevator still run
            if (elevator1.getLayoutY() != tempLen) {
                double y;
                if (Math.abs(elevator1.getLayoutY() - tempLen) <= 30) {
                    y = Global.direct1.equals(directionType.UP) ? -movingSpeed / 4 : movingSpeed / 4;
                } else if (Math.abs(elevator1.getLayoutY() - tempLen) <= 15) {
                    y = Global.direct1.equals(directionType.UP) ? -movingSpeed / 8 : movingSpeed / 8;
                } else {
                    y = Global.direct1.equals(directionType.UP) ? -movingSpeed : movingSpeed;
                }
                if (!doorwait) {
                    elevator1.setLayoutY(elevator1.getLayoutY() + y);
                }
                System.out.println(elevator1.getLayoutY());
            } else {
                elevatorTimeline.stop();

                enableOutsideButton(Global.direct1 == directionType.UP ? false : true, getFloorPosition(tempLen));
                doorwait = true;
                openDoor();

                // closeDoor();
                if (Global.controlCabin1 != null) {
                    Global.controlCabin1.enableButton(getFloorPosition(tempLen));
                }
                if (Global.direct1.equals(directionType.UP)) {
                    if (checkListUp(getFloorPosition(tempLen))) {
                        Global.direct1 = directionType.STANDBY;
                        moveElevatorInside1(searchNearUp(getFloorPosition(tempLen)));
                    } else if (checkListDown(getFloorPosition(tempLen))) {
                        Global.direct1 = directionType.STANDBY;
                        moveElevatorInside1(searchNearDown(getFloorPosition(tempLen)));
                    } else {
                        Global.direct1 = directionType.STANDBY;
                    }
                } else if (Global.direct1.equals(directionType.DOWN)) {
                    if (checkListDown(getFloorPosition(tempLen))) {
                        Global.direct1 = directionType.STANDBY;
                        moveElevatorInside1(searchNearDown(getFloorPosition(tempLen)));
                    } else if (checkListUp(getFloorPosition(tempLen))) {
                        Global.direct1 = directionType.STANDBY;
                        moveElevatorInside1(searchNearUp(getFloorPosition(tempLen)));
                    } else {
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

    public void enableOutsideButton(boolean up, int floor) {
        if (!up) {
            switch (floor) {
                case 2:
                    btnDown2.setDisable(false);
                    break;
                case 3:
                    btnDown3.setDisable(false);
                    break;
                case 4:
                    btnDown4.setDisable(false);
                    break;
                case 5:
                    btnDown5.setDisable(false);
                    break;
                case 6:
                    btnDown6.setDisable(false);
                    break;
                case 7:
                    btnDown7.setDisable(false);
                    break;
            }
        } else {
            switch (floor) {
                case 1:
                    btnUp1.setDisable(false);
                    break;
                case 2:
                    btnUp2.setDisable(false);
                    break;
                case 3:
                    btnUp3.setDisable(false);
                    break;
                case 4:
                    btnUp4.setDisable(false);
                    break;
                case 5:
                    btnUp5.setDisable(false);
                    break;
                case 6:
                    btnUp6.setDisable(false);
                    break;

            }
        }

    }

    @FXML
    void actionUp1() {
        moveElevatorOutside1(1, true);
    }

    @FXML
    void actionUp2() {
        moveElevatorOutside1(2, true);
    }

    @FXML
    void actionUp3() {
        moveElevatorOutside1(3, true);
    }

    @FXML
    void actionUp4() {
        moveElevatorOutside1(4, true);
    }

    @FXML
    void actionUp5() {
        moveElevatorOutside1(5, true);
    }

    @FXML
    void actionUp6() {
        moveElevatorOutside1(6, true);
    }

    @FXML
    void actionDown2() {
        moveElevatorOutside1(2, false);
    }

    @FXML
    void actionDown3() {
        moveElevatorOutside1(3, false);
    }

    @FXML
    void actionDown4() {
        moveElevatorOutside1(4, false);
    }

    @FXML
    void actionDown5() {
        moveElevatorOutside1(5, false);
    }

    @FXML
    void actionDown6() {
        moveElevatorOutside1(6, false);
    }

    @FXML
    void actionDown7() {
        moveElevatorOutside1(7, false);
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
}
