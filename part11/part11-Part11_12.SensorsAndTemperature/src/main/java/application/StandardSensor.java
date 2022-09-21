package application;

public class StandardSensor implements Sensor {
    private boolean running;
    private int number;

    public StandardSensor(int number) {
        this.running = true;
        this.number = number;
    }

    @Override
    public boolean isOn() {
        return this.running;
    }

    @Override
    public void setOn() {}

    @Override
    public void setOff() {}

    @Override
    public int read() {
        if(!this.isOn()) {
            throw new IllegalStateException("Cannot perform read() method when sensor is off!");
        }

        return this.number;
    }
}