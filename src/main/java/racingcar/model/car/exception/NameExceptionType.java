package racingcar.model.car.exception;

import racingcar.exception.ExceptionType;
import racingcar.exception.Status;

public enum NameExceptionType implements ExceptionType {

    VEHICLE_MUST_MORE_THAN_ONE(Status.BAD_REQUEST, 1000, "1개의 차로는 경주를 할 수 없습니다."),
    VEHICLE_NAME_MUST_NOT_BLANK(Status.BAD_REQUEST, 1001, "차 이름이 공백 문자일 수 없습니다."),
    VEHICLE_NAME_MUST_LETTER(Status.BAD_REQUEST, 1002, "차 이름은 숫자을 포함할 수 없습니다."),
    SPLIT_REGEX_MUST_COMMA(Status.BAD_REQUEST, 1003, "이름을 구분하기 위해 쉼표를 사용해야 합니다."),
    ;

    private final Status status;
    private final int exceptionCode;
    private final String message;

    NameExceptionType(Status status, int exceptionCode, String message) {
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
