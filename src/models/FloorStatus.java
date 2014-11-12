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
public class FloorStatus {

    private int floor;
    private boolean upward;

    public FloorStatus(int tFloor, boolean tUpward) {
        this.floor = tFloor;
        this.upward = tUpward;
    }

    public void setFloor(int tFloor) {
        this.floor = tFloor;
    }

    public int getFloor() {
        return this.floor;
    }

    public void setUpward(boolean tUpward) {
        this.upward = tUpward;
    }

    public boolean getUpward() {
        return this.upward;
    }
}
