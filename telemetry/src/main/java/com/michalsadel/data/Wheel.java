package com.michalsadel.data;

public class Wheel {
    private short rearLeft;
    private short rearRight;
    private short frontLeft;
    private short frontRight;

    public Wheel() {
    }

    public Wheel(short rearLeft, short rearRight, short frontLeft, short frontRight) {
        this.rearLeft = rearLeft;
        this.rearRight = rearRight;
        this.frontLeft = frontLeft;
        this.frontRight = frontRight;
    }

    public short getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(short rearLeft) {
        this.rearLeft = rearLeft;
    }

    public short getRearRight() {
        return rearRight;
    }

    public void setRearRight(short rearRight) {
        this.rearRight = rearRight;
    }

    public short getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(short frontLeft) {
        this.frontLeft = frontLeft;
    }

    public short getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(short frontRight) {
        this.frontRight = frontRight;
    }
}
