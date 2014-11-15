/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author misrc_000
 */
public class ButtonOutside {
    private int floor;
    private boolean up;
    
    public ButtonOutside(){
        this.floor = 0;
        this.up = false;
    }
    
    public ButtonOutside(int tFloor, boolean tUp){
        this.floor = tFloor;
        this.up = tUp;
    }
    public int getFloor(){
        return this.floor;
    }
    
    public boolean getUp(){
        return this.up;
    }
    public void setUp(boolean tUp){
        this.up = tUp;
    }
    public void setFloor(int tFloor){
        this.floor = tFloor;
    }
    
}
