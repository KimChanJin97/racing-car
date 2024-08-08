package racingcar.model.car;

import static java.lang.Boolean.*;

import camp.nextstep.edu.missionutils.Randoms;

public class Random implements Strategy {

    private static final int START_INCLUSIVE = 0;
    private static final int END_INCLUSIVE = 9;
    private static final int MOVABLE_NUMBER = 4;
    private static final int MOVE_DISTANCE = 1;

    @Override
    public Position move(Vehicle vehicle) {
        int value = vehicle.getPosition().getValue();
        if (canMove()) {
            return new Position(value + MOVE_DISTANCE);
        }
        return new Position(value);
    }

    @Override
    public boolean canMove() {
        int random = Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
        if (random >= MOVABLE_NUMBER) {
            return TRUE;
        }
        return FALSE;
    }
}
