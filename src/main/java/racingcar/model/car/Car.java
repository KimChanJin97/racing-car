package racingcar.model.car;

import java.util.Objects;

public class Car implements Vehicle {

    private final Name name;
    private final Position position;
    private final Strategy strategy;

    public Car(final Name name, final Position position, final Strategy strategy) {
        this.name = name;
        this.position = position;
        this.strategy = strategy;
    }

    @Override
    public Name getName() {
        return this.name;
    }

    @Override
    public Position getPosition() {
        return this.position;
    }

    @Override
    public Strategy getStrategy() {
        return this.strategy;
    }

    @Override
    public Vehicle move(final int distance) {
        Name name = new Name(getName().getValue());
        Position position = new Position(getPosition().getValue() + distance);
        Strategy strategy = getStrategy();
        return new Car(name, position, strategy);
    }

    @Override
    public Vehicle move() {
        return move(0);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return Objects.equals(getName(), car.getName()) && Objects.equals(getPosition(), car.getPosition());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPosition());
    }
}
