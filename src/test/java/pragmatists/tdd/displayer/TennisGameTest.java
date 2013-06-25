package pragmatists.tdd.displayer;


import org.fest.assertions.Assertions;
import org.junit.Test;

public class TennisGameTest {

	TennisGame game = new TennisGame();

	@Test
	public void shouldBe0_0AtStart() throws Exception {
		Assertions.assertThat(game.getScoreAsString()).isEqualTo("0 0");
	}

	@Test
	public void shouldBe15_0AfterPointScored() throws Exception {

		game.left();

		Assertions.assertThat(game.getScoreAsString()).isEqualTo("15 0");
	}

	@Test
	public void shouldBe30_0AfterPointScored() throws Exception {

		game.left();
		game.left();

		Assertions.assertThat(game.getScoreAsString()).isEqualTo("30 0");
	}

	@Test
	public void shouldBe0_15AfterRightScored() throws Exception {

		game.right();

		Assertions.assertThat(game.getScoreAsString()).isEqualTo("0 15");
	}

	@Test
	public void shouldBe0_40AfterRightScored3() throws Exception {

		rightScored(3);

		Assertions.assertThat(game.getScoreAsString()).isEqualTo("0 40");
	}

	@Test
	public void shouldBeDeuceWhenBothScored3Points() throws Exception {

		rightScored(3);
		leftScored(3);

		Assertions.assertThat(game.getScoreAsString()).isEqualTo("deuce");
	}

	@Test
	public void shouldBeDeuceWhenBothScored4Points() throws Exception {

		rightScored(4);
		leftScored(4);

		Assertions.assertThat(game.getScoreAsString()).isEqualTo("deuce");
	}

	@Test
	public void shouldBeLeftAdvantageAfterHeScoredOneMore() throws Exception {

		leftScored(4);
		rightScored(3);

		Assertions.assertThat(game.getScoreAsString()).isEqualTo("A  ");
	}

	@Test
	public void shouldBeRightAdvantageAfterHeScoredOneMore() throws Exception {

		rightScored(4);
		leftScored(3);

		Assertions.assertThat(game.getScoreAsString()).isEqualTo("  A");
	}

	@Test
	public void shouldWinWhenScored4() throws Exception {

		rightScored(4);
		leftScored(2);

		Assertions.assertThat(game.getScoreAsString()).isEqualTo("  W");
	}

	@Test
	public void shouldWinWhenScoredTwoOverAdvantage() throws Exception {

		rightScored(5);
		leftScored(3);

		Assertions.assertThat(game.getScoreAsString()).isEqualTo("  W");
	}

	private void leftScored(int howMany) {
		for (int i = 0; i < howMany; i++) {
			game.left();
		}
	}

	private void rightScored(int howMany) {
		for (int i = 0; i < howMany; i++) {
			game.right();
		}
	}

}
