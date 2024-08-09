package racingcar.model.car;

public interface Vehicle {

    Vehicle move(int distance);

    Vehicle move();

    Name getName();

    Position getPosition();

    Strategy getStrategy();
}
