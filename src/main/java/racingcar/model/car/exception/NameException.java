package racingcar.model.car.exception;

import racingcar.exception.BaseException;
import racingcar.exception.ExceptionType;

public class NameException extends BaseException {

    public NameException(ExceptionType exceptionType) {
        super(exceptionType);
    }
}
