package BinarySearchTreeGUI;

public class Question {
	  private String Text;
	  private String[] Answer;
	  private String RightAnswer;
	  private String Explain;

	public Question(String Text, String [] Answer, String RightAnswer, String Explain) {
	    this.Text = Text;
	    this.Answer = Answer;
	    this.RightAnswer = RightAnswer;
	    this.Explain = Explain;
	  }

	public String getText() {
		return Text;
	}

	public void setText(String text) {
		Text = text;
	}

	public String[] getAnswer() {
		return Answer;
	}

	public void setAnswer(String[] answer) {
		Answer = answer;
	}

	public String getRightAnswer() {
		return RightAnswer;
	}

	public void setRightAnswer(String rightAnswer) {
		RightAnswer = rightAnswer;
	}

	public String getExplain() {
		return Explain;
	}

	public void setExplain(String explain) {
		Explain = explain;
	}
	

	  
}
