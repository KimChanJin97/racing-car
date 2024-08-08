package racingcar.exception;

public enum ExceptionStatus {

    BAD_REQUEST(Status.BAD_REQUEST, 400);

    private final Status status;
    private final int statusCode;

    ExceptionStatus(Status status, int statusCode) {
        this.status = status;
        this.statusCode = statusCode;
    }
}
