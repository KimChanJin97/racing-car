package racingcar.contoller;

import racingcar.model.game.Game;
import racingcar.model.game.GameCount;
import racingcar.model.game.Vehicles;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingCarController {

    public Game beforeRace() {
        OutputView.outputVehicleNameMessage(); // 경주할 자동차 이름을 입력하세요
        String names = InputView.inputVehiclesName();

        OutputView.outputGameTryMessage(); // 시도할 회수는 몇회인가요
        String count = InputView.inputGameCount();

        OutputView.outputResultMessage(); // 실행결과

        return new Game(new Vehicles(names), new GameCount(count));
    }

    public Game doRace(Game game) {
        while (game.getGameCount().getValue() > 0) {
            Vehicles vehicles = game.getVehicles().compete();
            GameCount gameCount = game.getGameCount().decrease();
            Game newGame = new Game(vehicles, gameCount);

            OutputView.outputResult(newGame); // pobi : ---

            return doRace(newGame);
        }
        return game;
    }

    public void afterRace(Game doneGame) {
        OutputView.outputWinnerMessage();
        OutputView.outputWinner(doneGame);
    }
}
