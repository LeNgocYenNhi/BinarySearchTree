package BinarySearchTreeGUI;

import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.MatteBorder;

public class Quiz implements ActionListener{
	String [] Question = new String [3];
	
	String [][] Answers = new String [3][4];
	
	char [] Correct = new char [3];
	
	char Answer;
	int Index;
	int CorrectAnswer = 0;
	int Time = 30;
	
	int CurrentQuestion = 1;

	JFrame frame = new JFrame();
	
	JLabel TitleText = new JLabel("Binary Search Tree Quiz"), TimeLeft = new JLabel("Time Left"),
			QuestionLabel = new JLabel(), IndexQuestion = new JLabel(), Seconds = new JLabel();
	
	JLabel [] Labels = {TitleText, TimeLeft, QuestionLabel, IndexQuestion, Seconds};
	
	JButton AnswerA = new JButton(), AnswerB = new JButton(), AnswerC = new JButton(), AnswerD = new JButton();
	JButton Buttons[] = {AnswerA, AnswerB, AnswerC, AnswerD};

	Timer timer = new Timer(1000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			Time -= 1;
			Seconds.setText(String.valueOf(Time));
			if(Time <= 0) {		//Het thoi gian thi tu dua ra dap an va chuyen sang cau tiep theo
				Answer();
			}
		}
	});

	public Quiz() throws FileNotFoundException {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(740, 590);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setLayout(null);
		frame.setLocationRelativeTo(null);
		
		addQuestion();
		addAnswer();
		addCorrect();
		
		TitleText.setBounds(15, 20, 400, 50);
		TitleText.setFont(new Font("Microsoft New Tai Lue", Font.BOLD, 25));
		TitleText.setBackground(Color.WHITE);
	
		TimeLeft.setBounds(450, 20, 200, 50);
		TimeLeft.setBackground(new Color(204,229,255,255));
		TimeLeft.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 18));
		
		QuestionLabel.setBounds(15, 90, 700, 120);
		QuestionLabel.setBorder(new MatteBorder(1, 0, 0, 0, Color.BLACK));
		QuestionLabel.setBackground(Color.WHITE);
		QuestionLabel.setForeground(Color.BLACK);
		QuestionLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 25));
		
		int X_Label = 90, Y_Label = 220;
		int WIDTH_Label = 500, HEIGHT_Label = 50;
		for(JButton button: Buttons) {
			button.setBounds(X_Label, Y_Label, WIDTH_Label, HEIGHT_Label);
			button.setOpaque(true);
			button.setBackground(new Color(240,248,255,255));
			button.setForeground(Color.BLACK);
			button.setFont(new Font("Yu Gothic UI Semibold",Font.PLAIN,20));
			button.setHorizontalAlignment(SwingConstants.LEFT);
			button.addActionListener(this);
			button.setFocusable(false);
			Y_Label += 70;
			frame.add(button);
		}

		Seconds.setBounds(600, 30, 50, 30);
		Seconds.setBackground(new Color(52,58,64,255));
		Seconds.setForeground(Color.WHITE);
		Seconds.setFont(new Font("Times New Roman",Font.PLAIN,20));
		Seconds.setHorizontalAlignment(JTextField.CENTER);
		Seconds.setText(String.valueOf(Time));
		
		IndexQuestion.setBounds(15, 510, 740, 40);
		IndexQuestion.setBorder(new MatteBorder(1, 0, 0, 0, Color.BLACK));
		IndexQuestion.setFont(new Font("Malgun Gothic",Font.PLAIN,20));
		IndexQuestion.setBackground(Color.WHITE);
		
		for(JLabel label: Labels) {
			label.setOpaque(true);
			frame.add(label);
		}
		frame.setVisible(true);
		Next();
	}
	//Chuyen sang cau hoi tiep theo
	public void Next() {	
		if(Index >= Question.length) {
			Last();
		}
		else {
			QuestionLabel.setText(Question[Index]);
			int i = 0;
			for(JButton button: Buttons) {
				button.setText(Answers[Index][i]);
				i += 1;
			}
			IndexQuestion.setText(CurrentQuestion + " of 3 Questions");
			
			timer.start();
		}
		CurrentQuestion += 1;
	}
	@Override
	public void actionPerformed(ActionEvent e) {

		for(JButton button: Buttons) {
			button.setEnabled(false);
		}
		if(e.getSource()== AnswerA) {
			Answer = 'A';
			if(Answer == (Correct[Index])) {
				CorrectAnswer += 1 ;
			}
		}
		if(e.getSource() == AnswerB) {
			Answer = 'B';
			if(Answer == Correct[Index]) {
				CorrectAnswer += 1;
			}
		}
		if(e.getSource() == AnswerC) {
			Answer = 'C';
			if(Answer == Correct[Index]) {
				CorrectAnswer += 1;
			}
		}
		if(e.getSource() == AnswerD) {
			Answer = 'D';
			if(Answer == Correct[Index]) {
				CorrectAnswer += 1;
			}
		}
		Answer();
	}
	public void Answer() {

		timer.stop();	
		
		//Neu da chon cau tra loi thi khong the chon lai
		for(JButton button: Buttons) {
			button.setEnabled(false);		
		}

		//Dung 2s sau do chuyen sang cau hoi moi 
		Timer ChangeQuestion= new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				for(JButton label: Buttons) {
					label.setForeground(Color.BLACK);
				}

				Answer = ' ';
				Time = 30;
				Seconds.setText(String.valueOf(Time));
				for(JButton button: Buttons) {
					button.setEnabled(true);
				}
				Index += 1;
				Next();
			}
		});
		ChangeQuestion.setRepeats(false);
		ChangeQuestion.start();
	}
	//Giao dien cua ket qua khi thuc hien xong cac cau hoi
	public void Last(){
		
		for(JButton button: Buttons) {
			button.setEnabled(false);
			button.setBackground(Color.WHITE);		//Set button mau trung mau nen
			button.setForeground(Color.WHITE);		//Set chu trong button trung mau nen
			button.setText("");
			button.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));		//Set canh cua button thanh mau trung voi mau nen
		}
		
		String result = "";
		if(CorrectAnswer >= 2){
			result = "Well Done! \r\n" + "Your marks: " + CorrectAnswer;
		}else {
			result = "Oops! \r\n" +" Your marks: " + CorrectAnswer;
		}
		QuestionLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 30));
		QuestionLabel.setHorizontalAlignment(JTextField.CENTER);
		QuestionLabel.setText(result);
		
		Seconds.setText("");
		TimeLeft.setText("");
		IndexQuestion.setText("");

		//Set thanh phan trung voi mau nen
		for(JLabel label: Labels) {
			label.setBackground(Color.WHITE);
		}
		
	}
	public void addQuestion() throws FileNotFoundException {
		try {
		      int i = 0;
		      File file = new File("text/Question.txt");
		      Scanner scan = new Scanner(file);
		      while (scan.hasNextLine()) {
		        String data =scan.nextLine();
		        Question[i] = data;
		        i += 1;
		      }
		      scan.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
	public void addCorrect() throws FileNotFoundException {
		File file = new File("text/Correct.txt");
		try (Scanner myReader = new Scanner(file)) {
			for(int i = 0; i < 3; i++) {
				char c = myReader.next().charAt(0);  
				Correct[i] = c;
			}
		}

	}
	public void addAnswer() throws FileNotFoundException {
		File file = new File("text/Answer.txt");
		Scanner scan = new Scanner(file);
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				String data = scan.nextLine();
				Answers[i][j] = data;
			}
		}
		scan.close();
	}
	public static void main(String[] args) throws FileNotFoundException  {
		Quiz quiz = new Quiz();
	}
	
	
}