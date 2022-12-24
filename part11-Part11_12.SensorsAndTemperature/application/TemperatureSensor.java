package application;

import java.util.Random;

public class TemperatureSensor implements Sensor {
    private boolean running;

    public TemperatureSensor() {
        this.running = false;
    }

    @Override
    public boolean isOn() {
        return this.running;
    }

    @Override
    public void setOn() {
        this.running = true;
    }

    @Override
    public void setOff() {
        this.running = false;
    }

    @Override
    public int read() {
        if(!this.isOn()) {
            throw new IllegalStateException();
        }

        return new Random().nextInt(61) - 30;
    }
}