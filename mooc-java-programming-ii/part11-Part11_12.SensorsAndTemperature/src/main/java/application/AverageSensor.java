package application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AverageSensor implements Sensor {
    private List<Sensor> sensorList;
    private List<Integer> readings;

    public AverageSensor() {
        sensorList = new ArrayList<>();
        readings = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        sensorList.add(toAdd);
    }

    @Override
    public boolean isOn() {
        return sensorList.stream()
                .anyMatch(Sensor::isOn);
    }

    @Override
    public void setOn() {
        sensorList.forEach(Sensor::setOn);
    }

    @Override
    public void setOff() {
        sensorList.forEach(Sensor::setOff);
    }

    @Override
    public int read() {
        if (!isOn() || sensorList.isEmpty()) {
            throw new IllegalStateException();
        }

        int reading = (int) sensorList.stream()
                .mapToInt(Sensor::read)
                .average()
                .getAsDouble();

        readings.add(reading);
        return reading;
    }

    public List<Integer> readings() {
        return readings;
    }
}
