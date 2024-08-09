package racingcar.exception;

public interface ExceptionType {

    Status status();

    int exceptionCode();

    String message();
}
