/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundamental;

import static fundamental.Global.directionType.STANDBY;
import java.util.ArrayList;
import models.ButtonOutside;
import models.FloorStatus;
import views.ControlCabinController;
import views.PrototypeStageController;

/**
 *
 * @author misrc_000
 */
public class Global {
    public enum directionType {UP,DOWN,STANDBY};
    public static Boolean isRandom = true;
    public static Boolean isActiveElevator1 = true;
    public static Boolean isActiveElevator2 = true;
    public static Integer randomPerson = 1;
    public static Integer maxWeight = 10;
    public static Integer maxPeople = 5;
    public static Integer personWeight = 50;
    public static directionType direct1 = directionType.STANDBY;
    public static Boolean elevatorUpWard2 = false;
    public static Double elevatorSpeed = 1.0;
    public static Boolean isMoving1 = false;
    public static Boolean isMoving2 = false;
    public static double toFloor1 = 0; // position of elevator in realtime
    public static int memoryFloor1 = 0;// khi su ly di chuyen bi ngat quang boi 1 tang trung gian
    public static int memoryFloor2 = 0;
    public static ArrayList<Integer> listUp1 = new ArrayList<>();
    public static ArrayList<Integer> listDown1 = new ArrayList<>();
    public static ArrayList<FloorStatus> listUp2 = new ArrayList<>();
    public static ArrayList<FloorStatus> gotoElevator2 = new ArrayList<>();
    public static ArrayList<ButtonOutside> buttonOutside = new ArrayList<>();
    public static PrototypeStageController prototypeStage;
    public static ControlCabinController controlCabin1;
    public static ControlCabinController controlCabin2;
}
