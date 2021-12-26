package BinarySearchTreeGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;

public class QuizExample  implements ActionListener {
	String [] Question = new String [5];
	
	String [][] Answer = new String [5][4];
	
	String [] Correct = new String [5];
	
	char guess;
	String answer;
	int Index;
	int CorrectAnswer = 0;
	int Total = 5;
	int Result;
	int Time = 10;

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
			Time -= 1;
			seconds_left.setText(String.valueOf(Time));
			if(Time <= 0) {
				displayAnswer();
			}
		}
	});

	public QuizExample() throws FileNotFoundException {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(650,650);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setLayout(null);
		frame.setResizable(false);

		addQuestion();
		addAnswer();
		addCorrect();
		textarea.setBounds(0,50,650,50);
		textarea.setLineWrap(true);
		textarea.setWrapStyleWord(true);
		textarea.setBackground(Color.BLACK);
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
		seconds_left.setText(String.valueOf(Time));

		
		number_right.setBounds(225,225,200,100);
		//number_right.setBackground(new Color(25,25,25));
		number_right.setBackground(Color.WHITE);
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
			textarea.setText(Question[Index]);
			int i = 0;
			for(JLabel label: Labels) {
				label.setText(Answer[Index][i]);
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
			answer= "A";
			if(answer.equals(Correct[Index])) {
				CorrectAnswer += 1 ;
			}
		}
		if(e.getSource() == ButtonB) {
			answer= "B";
			if(answer.equals(Correct[Index])) {
				CorrectAnswer += 1;
			}
		}
		if(e.getSource() == ButtonC) {
			answer= "C";
			if(answer.equals(Correct[Index])) {
				CorrectAnswer += 1;
			}
		}
		if(e.getSource() == ButtonD) {
			answer= "D";
			if(answer.equals(Correct[Index])) {
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

		if(Correct[Index] != "A")
			AnswerA.setForeground(Color.RED);
		if(Correct[Index] != "B")
			AnswerB.setForeground(Color.RED);
		if(Correct[Index] != "C")
			AnswerC.setForeground(Color.RED);
		if(Correct[Index] != "D")
			AnswerD.setForeground(Color.RED);

		Timer pause = new Timer(2000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(JLabel label: Labels) {
					label.setForeground(Color.BLUE);
				}

				answer = " ";
				Time = 10;
				seconds_left.setText(String.valueOf(Time));
				for(JButton button: Buttons) {
					button.setEnabled(true);
				}
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

		Result = (int)((CorrectAnswer/(double) Total) *100);

		textarea.setText("");
		for(JLabel label: Labels) {
			label.setText("");
		}
		
		number_right.setText("("+ CorrectAnswer +"/"+ Total +")");
		percentage.setText(Result + "%");

		frame.add(number_right);
		frame.add(percentage);

	}
	public void addQuestion() throws FileNotFoundException {
		try {
		      int i = 0;
		      File myObj = new File("text/Question.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        Question[i] = data;
		        i += 1;
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	public void addCorrect() throws FileNotFoundException {
		try {
			int i = 0;
			File myObj = new File("text/Correct.txt");
			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				Correct[i] = data;
				i += 1;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	public void addAnswer() throws FileNotFoundException {
		File myObj = new File("text/Answer.txt");
		Scanner myReader = new Scanner(myObj);
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 4; j++) {
				String data = myReader.nextLine();
				Answer[i][j] = data;
			}
		}
		myReader.close();
	}
	public static void main(String[] args) throws FileNotFoundException  {
		
		QuizExample quiz = new QuizExample();
		
	}

}
