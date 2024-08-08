package racingcar.model.game.exception;

import racingcar.exception.ExceptionType;
import racingcar.exception.Status;

public enum GameExceptionType implements ExceptionType {

    GAME_COUNT_MUST_OVER_ZERO(Status.BAD_REQUEST, 2001, "시도할 횟수는 0 이상이어야 합니다.");

    private final Status status;
    private final int exceptionCode;
    private final String message;

    GameExceptionType(Status status, int exceptionCode, String message) {
        this.status = status;
        this.exceptionCode = exceptionCode;
        this.message = message;
    }


    @Override
    public Status status() {
        return status;
    }

    @Override
    public int exceptionCode() {
        return exceptionCode;
    }

    @Override
    public String message() {
        return message;
    }
}
