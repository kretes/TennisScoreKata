package kretes.tdd;

import java.util.HashMap;
import java.util.Map;

public class Score {
	private static final String NO_SCORE = " ";
	private static final String WON = "W";
	private static final String ADVANTAGE = "A";
	private int score;
	private Score otherScore;
	public static final Map<Integer, String> scores = new HashMap<Integer, String>() {
		{
			put(0, "0");
			put(1, "15");
			put(2, "30");
			put(3, "40");
		}
	};

	public Score() {
	}

	public int getLeft() {
		return score;
	}

	public void scored() {
		this.score++;
	}

	String scoreAsString() {
		if (won())
			return WON;
		if (haveAdvantage())
			return ADVANTAGE;
		if (otherScore.won() || otherScore.haveAdvantage())
			return NO_SCORE;
		return Score.scores.get(score);
	}

	private boolean haveAdvantage() {
		return score > otherScore.score && score >= 4;
	}

	boolean isDeuce() {
		return score == otherScore.score && score >= 3;
	}

	boolean won() {
		return score >= 4 && score - otherScore.score >= 2;
	}

	public void setOther(Score otherScore) {
		this.otherScore = otherScore;
	}
}