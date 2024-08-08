package racingcar.model.game.exception;

import racingcar.exception.BaseException;
import racingcar.exception.ExceptionType;

public class GameException extends BaseException {

    public GameException(ExceptionType exceptionType) {
        super(exceptionType);
    }
}
