package racingcar.model.game;

import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import racingcar.model.car.Vehicle;

public class Game {

    private final Vehicles vehicles;
    private final GameCount gameCount;

    public Game(Vehicles vehicles, GameCount gameCount) {
        this.vehicles = vehicles;
        this.gameCount = gameCount;
    }

    public Vehicles getVehicles() {
        return vehicles;
    }

    public GameCount getGameCount() {
        return gameCount;
    }

    public Vehicle getWinner() {
        List<Vehicle> vehicles = this.vehicles.getVehicles();
        return vehicles.stream()
                .max(Comparator.comparing(vehicle -> vehicle.getPosition().getValue()))
                .orElseThrow(NoSuchElementException::new);
    }

    public List<Vehicle> getWinners(Vehicle winner) {
        List<Vehicle> vehicles = this.vehicles.getVehicles();
        return vehicles.stream()
                .filter(vehicle -> vehicle.getPosition().equals(winner.getPosition()))
                .collect(Collectors.toList());
    }
}
