package pragmatists.tdd.displayer;

public class TennisGame {

	private Score leftScore = new Score();
	private Score rightScore = new Score();

	public TennisGame() {
		leftScore.setOther(rightScore);
		rightScore.setOther(leftScore);
	}

	public String getScoreAsString() {
		if (leftScore.isDeuce()) {
			return "deuce";
		}
		return leftScore.scoreAsString() + " " + rightScore.scoreAsString();
	}

	public void left() {
		leftScore.scored();
	}

	public void right() {
		rightScore.scored();
	}

}