package racingcar.view;

import static racingcar.model.car.exception.NameExceptionType.*;
import static racingcar.model.car.exception.NameExceptionType.SPLIT_REGEX_MUST_COMMA;
import static racingcar.model.car.exception.NameExceptionType.VEHICLE_NAME_MUST_LETTER;
import static racingcar.model.game.exception.GameExceptionType.GAME_COUNT_MUST_OVER_ZERO;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import racingcar.model.car.exception.NameException;
import racingcar.model.car.exception.NameExceptionType;
import racingcar.model.game.exception.GameException;

public class InputView {

    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final String COMMA = ",";

    private InputView() {

    }

    public static String inputVehiclesName() {
        String vehiclesName = Console.readLine();

        validateRacers(vehiclesName);
        validateIsBlank(vehiclesName);
        validateIsLetter(vehiclesName);
        validateSplitRegex(vehiclesName);

        return vehiclesName;
    }

    public static String inputGameCount() {
        String gameCount = Console.readLine();
        validateGameCount(gameCount);
        return gameCount;
    }

    private static void validateRacers(String vehiclesName) {
        if (vehiclesName.split(COMMA).length == 1) {
            throw new NameException(VEHICLE_NAME_MUST_LETTER);
        }
    }

    private static void validateIsBlank(String vehiclesName) {
        String[] split = vehiclesName.split(COMMA);
        if (Arrays.stream(split).filter(vehicleName -> vehicleName.trim().isBlank()).findAny().isPresent()) {
            throw new NameException(VEHICLE_NAME_MUST_NOT_BLANK);
        }
    }

    private static void validateIsLetter(String vehiclesName) {
        if (vehiclesName.matches(NUMBER_REGEX)) {
            throw new NameException(VEHICLE_NAME_MUST_LETTER);
        }
    }

    private static void validateSplitRegex(String vehiclesName) {
        if (vehiclesName.split(COMMA).length == 1) {
            throw new NameException(SPLIT_REGEX_MUST_COMMA);
        }
    }

    private static void validateGameCount(String gameCount) {
        if (Integer.parseInt(gameCount) < 0) {
            throw new GameException(GAME_COUNT_MUST_OVER_ZERO);
        }
    }
}
