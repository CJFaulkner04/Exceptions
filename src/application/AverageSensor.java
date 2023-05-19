package application;


import java.util.ArrayList;
import java.util.List;


public class AverageSensor implements Sensor {

    private List<Sensor> list;
    private List<Integer> readings;

    public AverageSensor() {
        list = new ArrayList<>();
        readings = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        list.add(toAdd);
    }

    @Override
    public boolean isOn() {
        for (Sensor s : list) {
            if (!s.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setOn() {
        for (Sensor s : list) {
            s.setOn();
        }
    }

    @Override
    public void setOff() {
        if (!list.isEmpty()) {
            list.get(0).setOff();
        }
    }

    @Override
    public int read() {
        int average = list.stream()
                .mapToInt(value -> value.read())
                .sum() / list.size();

        readings.add(average);
        return average;
    }

    public List<Integer> readings() {
        return readings;
    }

    public static void main(String[] args) {
        Sensor kumpula = new TemperatureSensor();
        Sensor kaisaniemi = new TemperatureSensor();
        Sensor helsinkiVantaaAirport = new TemperatureSensor();

        AverageSensor helsinkiRegion = new AverageSensor();
        helsinkiRegion.addSensor(kumpula);
        helsinkiRegion.addSensor(kaisaniemi);
        helsinkiRegion.addSensor(helsinkiVantaaAirport);

        helsinkiRegion.setOn();
        System.out.println("temperature in Helsinki region " + helsinkiRegion.read() + " degrees Celsius");
        System.out.println("temperature in Helsinki region " + helsinkiRegion.read() + " degrees Celsius");
        System.out.println("temperature in Helsinki region " + helsinkiRegion.read() + " degrees Celsius");

        System.out.println("readings: " + helsinkiRegion.readings());
    }
}
