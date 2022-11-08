import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;

public class FamilyGame implements ActionListener{
	private String[] questions = {"What is the most deady type of bear?", 
									"If you ignore record, wins, and the past 10 years who is the best Football Team?",
									"The sixers will not win UNTIL they do this?", 
									"The only reason the Phillies did not win is because?"
									};
	private String[][] options = {{"Polar", "Black", "Brown", "Kona"},
								{"Patriots", "Cheifs", "Tom Brady", "Jets"},
								{"Fire Glenn", "Trade Embiid", "Win Playoff Games", "Play complete Basketball" },
								{"They weren't good enough", "The Astros scored more runs", "The Astros are dirty rotten swindlers", "Pitching"}
								};
	private char[] answers = {'D', 'D', 'A', 'C'};
	private char guess;
	private char answer;
	private int index;
	private int cGuesses = 0;
	private double totQuestions = questions.length;
	private double result;
	private int secs =10;
	
	private JFrame frame = new JFrame();
	private JTextField tField = new JTextField();
	private JTextField correct = new JTextField();
	private JTextField percent = new JTextField();
	private JTextArea tArea = new JTextArea();
	private JButton buttonA = new JButton();
	private JButton buttonB = new JButton();
	private JButton buttonC = new JButton();
	private JButton buttonD = new JButton();
	private JLabel labelA = new JLabel();
	private JLabel labelB = new JLabel();
	private JLabel labelC = new JLabel();
	private JLabel labelD = new JLabel();
	private JLabel labelTime = new JLabel();
	private JLabel labelSec = new JLabel();
	private Font greenish = new Font("MV Boli", Font.BOLD, 35);
	private Timer timer = new Timer(1000, new ActionListener(){
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			secs--;
			labelSec.setText(Integer.toString(secs));
			if(secs<=0) {
				correctAnswer();				
			}
			
		}
	});
	
	

	
	
	
	public FamilyGame() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1250, 650);
		frame.getContentPane().setBackground(new Color(0, 200, 0));
		frame.setLayout(null);
		frame.setResizable(false);
		
		tField.setBounds(0, 10, 1250, 50);
		tField.setBackground(new Color(0, 200, 0));
		tField.setFont(new Font("Arial", Font.BOLD, 35));
		tField.setForeground(Color.BLACK);
		tField.setBorder(BorderFactory.createBevelBorder(2));
		tField.setHorizontalAlignment(JTextField.CENTER);
		tField.setEditable(false);
		
		tArea.setBounds(0, 60, 1200, 100);
		tArea.setLineWrap(true);
		tArea.setWrapStyleWord(true);
		tArea.setBackground(new Color(0, 200, 0));
		tArea.setForeground(Color.BLACK);
		tArea.setFont(new Font("MV Boli", Font.BOLD, 30));
//		tArea.setBorder(BorderFactory.createBevelBorder(1));
		tArea.setEditable(false);
		tArea.setText("Question");
		
		buttonA.setBounds(0, 195, 60, 50);
		buttonB.setBounds(0, 295, 60, 50);
		buttonC.setBounds(0, 395, 60, 50);
		buttonD.setBounds(0, 495, 60, 50);
		
		buttonA.setText("A");
		buttonA.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttonA.setForeground(new Color(30, 200, 30));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		
		
		buttonB.setText("B");
		buttonB.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttonB.setForeground(new Color(30, 200, 30));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		
		buttonC.setText("C");
		buttonC.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttonC.setForeground(new Color(30, 200, 30));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		
		buttonD.setText("D");
		buttonD.setFont(new Font("MV Boli", Font.BOLD, 35));
		buttonD.setForeground(new Color(30, 200, 30));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		
		labelA.setBounds(80, 195, 1000, 50);
		labelB.setBounds(80, 295, 1000, 50);
		labelC.setBounds(80, 395, 1000, 50);
		labelD.setBounds(80, 495, 1000, 50);
		
		labelA.setForeground(Color.BLACK);
		labelA.setFont(greenish);
		
		labelB.setForeground(Color.BLACK);
		labelB.setFont(greenish);
		
		labelC.setForeground(Color.BLACK);
		labelC.setFont(greenish);
		
		labelD.setForeground(Color.BLACK);
		labelD.setFont(greenish);
		
		labelSec.setBounds(1160, 555, 80, 60);
		labelSec.setBackground(new Color(0, 200, 0));
		labelSec.setForeground(Color.BLACK);
		labelSec.setFont(greenish);
		labelSec.setHorizontalAlignment(JTextField.CENTER);
//		labelSec.setBorder(BorderFactory.createBevelBorder(1));
		labelSec.setText(Integer.toString(secs));
		labelSec.setFocusable(false);
		labelSec.setOpaque(true);
		
		labelTime.setBounds(1100, 525, 85, 25);
		labelTime.setBackground(new Color(0, 200, 0));
		labelTime.setForeground(Color.BLACK);
		labelTime.setFont(new Font("MV Boli", Font.BOLD, 20));
		labelTime.setHorizontalAlignment(JTextField.CENTER);
		labelTime.setText("Timer :");
		labelTime.setFocusable(false);
		
		correct.setBounds(325, 225, 600, 100);
		correct.setBackground(new Color(0, 200, 0));
		correct.setForeground(Color.BLACK);
		correct.setFont(greenish);
		correct.setBorder(BorderFactory.createBevelBorder(2));
		correct.setHorizontalAlignment(JTextField.CENTER);
		correct.setEditable(false);
		
		percent.setBounds(325, 325, 600, 100);
		percent.setBackground(new Color(0, 200, 0));
		percent.setForeground(Color.BLACK);
		percent.setFont(greenish);
		percent.setBorder(BorderFactory.createBevelBorder(2));
		percent.setHorizontalAlignment(JTextField.CENTER);
		percent.setEditable(false);
		
		
//		frame.add(percent);
//		frame.add(correct);
		frame.add(labelTime);
		frame.add(labelSec);
		frame.add(labelA);
		frame.add(labelB);
		frame.add(labelC);
		frame.add(labelD);
		frame.add(buttonD);
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
		frame.add(tArea);
		frame.add(tField);
		frame.setVisible(true);
		
		nextQuestion();
		

	}
	public void nextQuestion() {
		if (index>= totQuestions) {
			results();
		}else {
			tField.setText("Question " + index+1);
			tArea.setText(questions[index]);
			labelA.setText(options[index][0]);
			labelB.setText(options[index][1]);
			labelC.setText(options[index][2]);
			labelD.setText(options[index][3]);
			timer.start();
		}
		
	}
	public void correctAnswer() {
		timer.stop();
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(answers[index] != 'A') {
			labelA.setForeground(new Color(0, 200, 0));
		}
		if(answers[index] != 'B') {
			labelB.setForeground(new Color(0, 200, 0));
		}
		if(answers[index] != 'C') {
			labelC.setForeground(new Color(0, 200, 0));
		}
		if(answers[index] != 'D') {
			labelD.setForeground(new Color(0, 200, 0));
		}
		
		Timer pause = new Timer(2000, new ActionListener(){
			
			@Override
			public void actionPerformed(ActionEvent e) {
				labelA.setForeground(Color.BLACK);
				labelB.setForeground(Color.BLACK);
				labelC.setForeground(Color.BLACK);
				labelD.setForeground(Color.BLACK);
				
				answer = ' ';
				secs =10;
				labelSec.setText(Integer.toString(secs));
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				index ++;
				nextQuestion();
			}
		});
		pause.setRepeats(false);
		pause.start();
	}
	public void results() {
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		result = ((cGuesses/ totQuestions)*100);
		tField.setText("Results!");
		tArea.setText("");
		labelA.setText("");
		labelB.setText("");
		labelC.setText("");
		labelD.setText("");
		DecimalFormat df = new DecimalFormat("#.##");
		correct.setText(cGuesses + " / " + df.format(totQuestions));
		percent.setText(df.format(result) + "%");
		frame.add(percent);
		frame.add(correct);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(e.getSource()==buttonA) {
			answer = 'A';
			if(answer == answers[index]) {
				cGuesses ++;
			}
		}
		if(e.getSource()==buttonB) {
			answer = 'B';
			if(answer == answers[index]) {
				cGuesses ++;
			}
		}
		if(e.getSource()==buttonC) {
			answer = 'C';
			if(answer == answers[index]) {
				cGuesses ++;
			}
		}
		if(e.getSource()==buttonD) {
			answer = 'D';
			if(answer == answers[index]) {
				cGuesses ++;
			}
		}
		correctAnswer();
	}

}
