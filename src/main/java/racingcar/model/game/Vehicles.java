package racingcar.model.game;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.car.Car;
import racingcar.model.car.Name;
import racingcar.model.car.Position;
import racingcar.model.car.Random;
import racingcar.model.car.Vehicle;

public class Vehicles {

    private static final String SPLIT_REGEX = ",";

    private final List<Vehicle> vehicles;

    public Vehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public Vehicles(String names) {
        vehicles = Arrays.stream(names.split(SPLIT_REGEX))
                .map(name -> new Car(new Name(name), new Position(), new Random()))
                .collect(Collectors.toList());
    }

    public Vehicles compete() {
        return new Vehicles(this.vehicles.stream()
                .map(vehicle -> vehicle.move())
                .collect(Collectors.toList()));
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }
}
