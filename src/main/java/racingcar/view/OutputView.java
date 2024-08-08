package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.car.Vehicle;
import racingcar.model.game.Game;

public class OutputView {

    private static final String VEHICLE_NAME_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String GAME_TRY_MESSAGE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "\n실행 결과";
    private static final String WINNER_MESSAGE = "최종 우승자 : ";

    private static final String COLON = " : ";
    private static final String HYPHEN = "-";

    private OutputView() {

    }

    public static void outputVehicleNameMessage() {
        System.out.println(VEHICLE_NAME_MESSAGE);
    }

    public static void outputGameTryMessage() {
        System.out.println(GAME_TRY_MESSAGE);
    }

    public static void outputResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public static void outputResult(Game game) {
        System.out.println(illustrateAllVehicle(game) + "\n");
    }

    private static String illustrateAllVehicle(Game game) {
        return game.getVehicles().getVehicles().stream()
                .map(vehicle -> illustrateEachVehicle(vehicle))
                .collect(Collectors.joining("\n"));
    }

    private static String illustrateEachVehicle(Vehicle vehicle) {
        String name = vehicle.getName().getValue();
        int position = vehicle.getPosition().getValue();

        return name + COLON + HYPHEN.repeat(position);
    }

    public static void outputWinnerMessage() {
        System.out.print(WINNER_MESSAGE);
    }

    public static void outputWinner(Game game) {
        Vehicle winner = game.getWinner();
        List<Vehicle> winners = game.getWinners(winner);

        StringBuilder sb = new StringBuilder();
        winners.stream().forEach(vehicle -> sb.append(vehicle.getName().getValue()).append(", "));
        System.out.println(sb.toString().substring(0, sb.length() - 2));
    }
}
