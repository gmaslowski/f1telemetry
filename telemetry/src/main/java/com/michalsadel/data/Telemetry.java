package com.michalsadel.data;

public class Telemetry {
    private float time;
    private float speed;
    private byte gear;
    private float revs;
    private float fuelInTank;
    private float fuelCapacity;
    private Wheel wheelWear;
    private Wheel wheelTemperature;

    public Wheel getWheelTemperature() {
        return wheelTemperature;
    }

    public void setWheelTemperature(Wheel wheelTemperature) {
        this.wheelTemperature = wheelTemperature;
    }

    public Wheel getWheelWear() {
        return wheelWear;
    }

    public void setWheelWear(Wheel wheelWear) {
        this.wheelWear = wheelWear;
    }

    public float getFuelInTank() {
        return fuelInTank;
    }

    public void setFuelInTank(float fuelInTank) {
        this.fuelInTank = fuelInTank;
    }

    public float getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(float fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public byte getGear() {
        return gear;
    }

    public void setGear(byte gear) {
        this.gear = gear;
    }

    public float getRevs() {
        return revs;
    }

    public void setRevs(float revs) {
        this.revs = revs;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
