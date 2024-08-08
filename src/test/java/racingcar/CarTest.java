package racingcar;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.model.car.Car;
import racingcar.model.car.Name;
import racingcar.model.car.Position;
import racingcar.model.car.Random;
import racingcar.model.car.Vehicle;
import racingcar.model.game.Game;
import racingcar.model.game.GameCount;
import racingcar.model.game.Vehicles;

public class CarTest {

    @Test
    public void 움직이지_않는다() {
        Car pobi = new Car(new Name("pobi"), new Position(), new Random());
        Assertions.assertThat(pobi.getPosition()).isEqualTo(new Position(0));
    }

    @Test
    public void 움직인다() {
        Car pobi = new Car(new Name("pobi"), new Position(), new Random());
        Car woni = new Car(new Name("woni"), new Position(), new Random());

        Vehicle movedPobi = pobi.move(1);
        Assertions.assertThat(movedPobi.getPosition()).isEqualTo(new Position(1));

        Vehicle movedWoni = woni.move(2);
        Assertions.assertThat(movedWoni.getPosition()).isEqualTo(new Position(2));
    }

    @Test
    public void 이름과_위치가_같다면_같은_자동차이다() {
        Car pobi = new Car(new Name("pobi"), new Position(), new Random());
        Car poby = new Car(new Name("pobi"), new Position(), new Random());
        Assertions.assertThat(pobi).isEqualTo(poby);

        Car woni = new Car(new Name("woni"), new Position(1), new Random());
        Car wony = new Car(new Name("woni"), new Position(1), new Random());
        Assertions.assertThat(woni).isEqualTo(wony);
    }

    @Test
    public void 이름이_같아도_위치가_다르다면_다른_자동차이다() {
        Car pobi = new Car(new Name("pobi"), new Position(), new Random());
        Vehicle movedPobi = pobi.move(1);

        Car poby = new Car(new Name("pobi"), new Position(), new Random());
        Assertions.assertThat(movedPobi).isNotEqualTo(poby);

        Car povi = new Car(new Name("pobi"), new Position(), new Random());
        Vehicle movedPovi = povi.move(1);
        Assertions.assertThat(movedPobi).isEqualTo(movedPovi);
    }

    @Test
    public void 움직이면_승리한다() {
        Car pobi = new Car(new Name("pobi"), new Position(), new Random());
        Car woni = new Car(new Name("woni"), new Position(), new Random());
        Car jun = new Car(new Name("jun"), new Position(), new Random());

        Vehicle movedPobi = pobi.move(1);

        Vehicles vehicles = new Vehicles(List.of(movedPobi, woni, jun));
        GameCount gameCount = new GameCount();
        Game game = new Game(vehicles, gameCount);

        Assertions.assertThat(game.getWinner()).isEqualTo(pobi);
    }

    @Test
    public void 같이_움직이면_같이_승리한다() {
        Car pobi = new Car(new Name("pobi"), new Position(), new Random());
        Car woni = new Car(new Name("woni"), new Position(), new Random());
        Car jun = new Car(new Name("jun"), new Position(), new Random());

        Vehicle movedPobi = pobi.move(1);
        Vehicle movedWoni = woni.move(1);

        Vehicles vehicles = new Vehicles(List.of(movedPobi, movedWoni, jun));
        GameCount gameCount = new GameCount();
        Game game = new Game(vehicles, gameCount);

        Assertions.assertThat(game.getWinners(game.getWinner())).isEqualTo(List.of(movedPobi, movedWoni));
    }
}
