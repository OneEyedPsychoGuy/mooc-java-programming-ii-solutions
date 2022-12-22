package application;

public class StandardSensor implements Sensor {
    private int reading;

    public StandardSensor(int reading) {
        this.reading = reading;
    }

    @Override
    public boolean isOn() {
        return true;
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

        return this.reading;
    }
}