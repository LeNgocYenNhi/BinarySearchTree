package BinarySearchTreeGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz implements ActionListener {
	
	List<Question> ListQuestion;
	int Index;
	String justAnswer;
	JFrame frame;
	String Question = "";
	String [] Answer;
	String Correct = "";
	String ExplainText = "";
	JLabel QuestionLabel = new JLabel();
	JPanel answersPanel = new JPanel();
	JButton submitButton = new JButton();
	
	JLabel ExplainLabel = new JLabel();

	public Quiz(List<Question> ListQuestion) {
		this.ListQuestion = ListQuestion;
		this.Index = 0;
		this.justAnswer = " ";

		this.frame = new JFrame();
	}

	public void ProgramQuiz() {
		displayQuiz(ListQuestion.get(Index));
	}
	private void displayQuiz(Question quiz) {
		
		frame.setTitle("Quiz Binary Search Tree");
		frame.setSize(800, 300);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		QuestionLabel.setText(Question);
		
		JLabel QuestionLabel = new JLabel();
		JPanel answersPanel = new JPanel();
		JButton submitButton = new JButton();
		JLabel ExplainLabel = new JLabel();
		
		
		QuestionLabel.setBounds(5, 5, 700, 50);
		QuestionLabel.setOpaque(true);
		QuestionLabel.setBackground(Color.RED);
		answersPanel.setBounds(5, 60, 700, 100);
		answersPanel.setBackground(Color.BLUE);
		
		ExplainLabel.setBounds(5, 180, 700, 100);
		ExplainLabel.setText(ExplainText);
		submitButton.setBounds(50, 200, 100, 50);
		
		submitButton.setBackground(Color.GREEN);
		

		
		QuestionLabel.setText(quiz.getText());


		String[] ListAnswer = quiz.getAnswer();
		ButtonGroup _AnswerGroup = new ButtonGroup();
		JRadioButton[] _AnswerRadio = new JRadioButton[ListAnswer.length];
		for (int i = 0; i < ListAnswer.length; i++) {
			_AnswerRadio[i] = new JRadioButton(ListAnswer[i]);
			_AnswerRadio[i].setText(ListAnswer[i]);
			_AnswerRadio[i].addActionListener(this);
			_AnswerGroup.add(_AnswerRadio[i]);
			answersPanel.add(_AnswerRadio[i]);
		}

		answersPanel.setLayout(new GridLayout(4, 1));
		
		submitButton.setText("Submit");
		submitButton.setActionCommand("actionSubmit");
		submitButton.addActionListener(this);
		submitButton.setEnabled(true);

		// Load panels, add them to to frame
		
		frame.add(submitButton);

		frame.add(QuestionLabel);
		frame.add(answersPanel);
		frame.add(ExplainLabel);
		//frame.add(mainPanel);
		
	}

	public void actionPerformed(ActionEvent event) {
		if (event.getActionCommand().equals("actionSubmit")) {
			eventSubmit(event);
		} else {
			handleSelection(event);
		}
	}

	private void eventSubmit(ActionEvent event) {
		frame.dispose();
		frame = new JFrame();
		testCorrectAnswer();
		
		nextQuestion();

	}

	
	private void testCorrectAnswer() {
		if (justAnswer.equals(ListQuestion.get(Index).getRightAnswer())) {
			ExplainText = "Yes";
		}
		else {
			ExplainText = "No";
		}
		ExplainLabel.setText(ExplainText);
	}
	private void nextQuestion() {
		Index += 1;
		displayQuiz(ListQuestion.get(Index));
	}

	private void handleSelection(ActionEvent event) {
		justAnswer = event.getActionCommand();
	}


	public static List<Question> dataProcess() throws FileNotFoundException { 

		File QuestionsFile = new File("text/Question.txt");
		File AnswerFile = new File("text/Answer.txt");
		File CorrectFile = new File("text/Correct.txt");
		File ExplainFile = new File("text/Explain.txt");
		
		List<Question> questions = new ArrayList<>();
		try (Scanner questionsReader = new Scanner(QuestionsFile)) {
			try (Scanner answersReader = new Scanner(AnswerFile)) {
				try (Scanner rightAnswerReader = new Scanner(CorrectFile)) {
					try (Scanner explainReader = new Scanner(ExplainFile)) {
						while (questionsReader.hasNextLine()) {
							String text = questionsReader.nextLine();
							String[] answers = new String[4];
							for (int i = 0; i < 4; i++) {
								answers[i] = answersReader.nextLine();
							}
							String rightAnswer = rightAnswerReader.nextLine();
							String explain = explainReader.nextLine();

							questions.add(new Question(text, answers, rightAnswer, explain));
						}
					}
				}
			}
		}
		return questions;
	}

	public static void main(String[] args) throws FileNotFoundException {
		List<Question> Quiz = dataProcess();
		Quiz dis = new Quiz(Quiz);
		dis.ProgramQuiz();
	}

}