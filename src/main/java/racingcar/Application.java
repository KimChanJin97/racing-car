package racingcar;

import racingcar.contoller.RacingCarController;
import racingcar.model.game.Game;

public class Application {
    public static void main(String[] args) {

        RacingCarController controller = new RacingCarController();

        Game game = controller.beforeRace();
        Game doneGame = controller.doRace(game);
        controller.afterRace(doneGame);
    }
}
