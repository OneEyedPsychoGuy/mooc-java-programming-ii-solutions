package application;

import java.util.List;
import java.util.ArrayList;

public class AverageSensor implements Sensor {
    private List<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
    }

    public List<Integer> readings() {
        return this.readings;
    }

    @Override
    public boolean isOn() {
        for(Sensor sensor : this.sensors) {
            if(!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setOn() {
        this.sensors.forEach(Sensor::setOn);
    }

    @Override
    public void setOff() {
        this.sensors.forEach(Sensor::setOff);
    }

    @Override
    public int read() {
        if(this.sensors.isEmpty() || !this.isOn()) {
            throw new IllegalStateException();
        }

        int average = (int) this.sensors.stream().mapToInt(s -> s.read()).average().getAsDouble();
        this.readings.add(average);
        return average;
    }
}