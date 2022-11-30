package davidlong_ict167_week7_lab;

public class Score {
	private String _name;
	private int _score;
	
	public Score(String name, int score) {
		_name = name;
		_score = score;
	}
	
	public Score() {
		_name = "";
		_score = 0;
	}
	
	public String GetName() { return _name; }
	public void	  SetName(String s) { _name = s; };
	
	public int  GetScore() { return _score; }
	public void SetScore(int s) { _score = s; }
}
