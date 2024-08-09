package racingcar.model.game;

public class GameCount {

    private final int value;

    public GameCount() {
        this.value = 0;
    }

    public GameCount(int value) {
        this.value = value;
    }

    public GameCount(String gameCount) {
        this.value = Integer.parseInt(gameCount);
    }

    public GameCount decrease() {
        return new GameCount(this.value - 1);
    }

    public int getValue() {
        return this.value;
    }
}
