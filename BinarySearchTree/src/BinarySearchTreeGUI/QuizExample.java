package BinarySearchTreeGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class QuizExample  implements ActionListener {
	String[] questions = 	{
			"Which company created Java?",
			"Which year was Java created?",
			"What was Java originally called?",
			"Who is credited with creating Java?"
	};
	String[][] options = 	{
			{"Sun Microsystems","Starbucks","Microsoft","Alphabet"},
			{"1989","1996","1972","1492"},
			{"Apple","Latte","Oak","Koffing"},
			{"Steve Jobs","Bill Gates","James Gosling","Mark Zuckerburg"}
	};
	char[] answers = 		{
			'A',
			'B',
			'C',
			'C'
	};
	char guess;
	char answer;
	int Index;
	int CorrectAnswer =0;
	int Total = questions.length;
	int result;
	int time =10;

	JFrame frame = new JFrame();
	
	JTextArea textarea = new JTextArea();
	
	JButton ButtonA = new JButton("A"), ButtonB = new JButton("B"), 
			ButtonC = new JButton("C"), ButtonD = new JButton("D");
	
	JButton Buttons[] = {ButtonA, ButtonB, ButtonC, ButtonD};
	
	
	JLabel AnswerA = new JLabel(), AnswerB = new JLabel(), AnswerC = new JLabel(), AnswerD = new JLabel();
	JLabel Labels[] = {AnswerA, AnswerB, AnswerC, AnswerD};
	
	JLabel seconds_left = new JLabel();
	JTextField number_right = new JTextField();
	JTextField percentage = new JTextField();

	Timer timer = new Timer(1000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			time -= 1;
			seconds_left.setText(String.valueOf(time));
			if(time <= 0) {
				displayAnswer();
			}
		}
	});

	public QuizExample() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,650);
		frame.getContentPane().setBackground(new Color(50,50,50));
		frame.setLayout(null);
		frame.setResizable(false);


		textarea.setBounds(0,50,650,50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(new Color(25,25,25));
		textarea.setForeground(new Color(25,255,0));
		textarea.setFont(new Font("MV Boli",Font.BOLD,25));
		textarea.setBorder(BorderFactory.createBevelBorder(1));
		textarea.setEditable(false);
		
		int X_Button = 0, Y_Button = 100;
		int WIDTH_Button = 100, HEIGHT_Button = 100;
		for(JButton button : Buttons) {
			button.setBounds(X_Button, Y_Button, WIDTH_Button, HEIGHT_Button);
			button.setFont(new Font("MV Boli",Font.BOLD,35));
			button.setFocusable(false);
			button.addActionListener(this);
			Y_Button += 100;
			frame.add(button);
		}

		int X_Label = 125, Y_Label = 100;
		int WIDTH_Label = 500, HEIGHT_Label = 100;
		for(JLabel label: Labels) {
			label.setBounds(X_Label, Y_Label, WIDTH_Label, HEIGHT_Label);
			label.setBackground(new Color(50,50,50));
			label.setForeground(new Color(25,255,0));
			label.setFont(new Font("MV Boli",Font.PLAIN,35));
			Y_Label += 100;
			frame.add(label);
		}
		
		seconds_left.setBounds(535,510,100,100);
		seconds_left.setBackground(new Color(25,25,25));
		seconds_left.setForeground(new Color(255,0,0));
		seconds_left.setFont(new Font("Ink Free",Font.BOLD,60));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(time));

		
		number_right.setBounds(225,225,200,100);
		number_right.setBackground(new Color(25,25,25));
		number_right.setForeground(new Color(25,255,0));
		number_right.setFont(new Font("Ink Free",Font.BOLD,50));
		number_right.setBorder(BorderFactory.createBevelBorder(1));
		number_right.setHorizontalAlignment(JTextField.CENTER);
		number_right.setEditable(false);

		percentage.setBounds(225,325,200,100);
		percentage.setBackground(new Color(25,25,25));
		percentage.setForeground(new Color(25,255,0));
		percentage.setFont(new Font("Ink Free",Font.BOLD,50));
		percentage.setBorder(BorderFactory.createBevelBorder(1));
		percentage.setHorizontalAlignment(JTextField.CENTER);
		percentage.setEditable(false);

		frame.add(seconds_left);
		
		frame.add(textarea);
		frame.setVisible(true);

		nextQuestion();
	}
	public void nextQuestion() {

		if(Index >= Total) {
			results();
		}
		else {
			textarea.setText(questions[Index]);
			int i = 0;
			for(JLabel label: Labels) {
				label.setText(options[Index][i]);
				i += 1;
			}
			
			timer.start();
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		for(JButton button: Buttons) {
			button.setEnabled(false);
		}
		if(e.getSource()== ButtonA) {
			answer= 'A';
			if(answer == answers[Index]) {
				CorrectAnswer += 1 ;
			}
		}
		if(e.getSource() == ButtonB) {
			answer= 'B';
			if(answer == answers[Index]) {
				CorrectAnswer += 1;
			}
		}
		if(e.getSource() == ButtonC) {
			answer= 'C';
			if(answer == answers[Index]) {
				CorrectAnswer += 1;
			}
		}
		if(e.getSource() == ButtonD) {
			answer= 'D';
			if(answer == answers[Index]) {
				CorrectAnswer += 1;
			}
		}
		displayAnswer();
	}
	public void displayAnswer() {

		timer.stop();

		ButtonA.setEnabled(false);
		ButtonB.setEnabled(false);
		ButtonC.setEnabled(false);
		ButtonD.setEnabled(false);

		if(answers[Index] != 'A')
			AnswerA.setForeground(new Color(255,0,0));
		if(answers[Index] != 'B')
			AnswerB.setForeground(new Color(255,0,0));
		if(answers[Index] != 'C')
			AnswerC.setForeground(new Color(255,0,0));
		if(answers[Index] != 'D')
			AnswerD.setForeground(new Color(255,0,0));

		Timer pause = new Timer(2000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(JLabel label: Labels) {
					label.setForeground(new Color(25,255,0));
				}

				answer = ' ';
				time = 10;
				seconds_left.setText(String.valueOf(time));
				ButtonA.setEnabled(true);
				ButtonB.setEnabled(true);
				ButtonC.setEnabled(true);
				ButtonD.setEnabled(true);
				Index += 1;
				nextQuestion();
			}
		});
		pause.setRepeats(false);
		pause.start();
	}
	public void results(){
		
		for(JButton button: Buttons) {
			button.setEnabled(false);
		}

		result = (int)((CorrectAnswer/(double) Total)*100);

		textarea.setText("");
		for(JLabel label: Labels) {
			label.setText("");
		}
		
		number_right.setText("("+ CorrectAnswer +"/"+ Total +")");
		percentage.setText(result+"%");

		frame.add(number_right);
		frame.add(percentage);

	}
	public static void main(String[] args) {

		QuizExample quiz = new QuizExample();
	}

}
