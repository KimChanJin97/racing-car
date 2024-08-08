package racingcar.model.car;

public interface Strategy {

    Position move(Vehicle vehicle);

    boolean canMove();
}
