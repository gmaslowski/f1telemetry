package com.michalsadel.telemetry;

public class RawTelemetryPacket {
    private float time;
    private float lapTime;

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public float getLapTime() {
        return lapTime;
    }

    public void setLapTime(float lapTime) {
        this.lapTime = lapTime;
    }
}
