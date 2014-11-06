/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fundamental;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import views.PrototypeStageController;

/**
 *
 * @author misrc_000
 */
public class Global {
    public static Boolean isRandom = true;
    public static Boolean isActiveElevator1 = true;
    public static Boolean isActiveElevator2 = true;
    public static Integer randomPersonInSecond = 1;
    public static Integer maxWeight = 10;
    public static Integer maxPeopleInFloor = 5;
    public static Integer personWeightAverange = 50;
    public static Boolean moveUpElevator1 = false;
    public static Boolean moveUpElevator2 = false;
    public static double movingSpeed = 10;
    
    public static PrototypeStageController prototypeStage;
}
