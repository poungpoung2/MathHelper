import java.awt.EventQueue;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextPane;

public class Quiz {
	
	JFrame quiz;// JFrame nammed quiz
	JPanel bottom = new JPanel();
	JLabel img1, img2;// Panel to store display images
	JLabel endMsg;// Label to print end message when the quiz is over
	ArrayList<Question> incorrect = new ArrayList<Question>();// An arrayList to store incorrect questions
	QuestionProcesser qp = new QuestionProcesser();// Create questionprocesser that stores question
	JTextArea textArea;// To show question to the user
	// JTextPane textPane;
	int unit;// Store value of unit
	String question;//
	JTextField AnswerField;// Where the user input the answer
	JLabel showLevel;// Lable to show level of the user
	Question current_q;// Store current question
	QuestionDifficulty t1 = new QuestionDifficulty();
	QuestionDifficulty t2 = new QuestionDifficulty();
	QuestionDifficulty t3 = new QuestionDifficulty();
	QuestionDifficulty t4 = new QuestionDifficulty();
	QuestionDifficulty t5 = new QuestionDifficulty();
	QuestionDifficulty t6 = new QuestionDifficulty();
	Scanner sc=new Scanner(System.in);
	QuestionDifficulty[] questionPackage = { t1, t2, t3, t4, t5, t6 };// An arraylist to store each type question
	int[] levelUp;// The number of question that should be solved to go to another level

	int demote_life = 2, streak = 0, level = 1, turn = 0, up = 0;// Variables to decide to decrease the level, increase
																	// the level
																	// Variables to store level, know how may types of
															// question should be shown
																	// How many question that the user solved.
	boolean isStreak = true;// To check if the player solve the question successively without being wrong
	int current_turn = 0;// Check the current type of question

	String str = "";
	String enter="aa";
	boolean isNext=false;
	/**
	 * To change colour of panel
	 * 
	 * @param hover
	 * @param rand
	 */
	public void changecolor(JPanel hover, Color rand) {
		hover.setBackground(rand);
	}

	/*
	 * Function to visiblize the quiz frame
	 */
	public void setVisible() {
		quiz.setVisible(true);
	}
	public void showAnswer() {
		
	}
	/**
	 * Read file and initialize into each type Arraylist.
	 * 
	 * @param ex1
	 * @param ex2
	 * @param ex3
	 * @param ex4
	 */
	public void setUp(ArrayList<Question> ex1, ArrayList<Question> ex2, ArrayList<Question> ex3,
			ArrayList<Question> ex4) {
		// Put the question according to the difficulty
		for (Question element : ex1) {
			switch (element.dif) {
			case 1:
				t1.dif1.add(element);
				break;
			case 2:
				t1.dif2.add(element);
				break;
			case 3:
				t1.dif3.add(element);
				break;
			case 4:
				t1.dif4.add(element);
				break;
			case 5:
				t1.dif5.add(element);
				break;
			}
		}
		for (Question element : ex2) {
			switch (element.dif) {
			case 1:
				t2.dif1.add(element);
				break;
			case 2:
				t2.dif2.add(element);
				break;
			case 3:
				t2.dif3.add(element);
				break;
			case 4:
				t2.dif4.add(element);
				break;
			case 5:
				t2.dif5.add(element);
				break;
			}
		}
		for (Question element : ex3) {
			switch (element.dif) {
			case 1:
				t3.dif1.add(element);
				break;
			case 2:
				t3.dif2.add(element);
				break;
			case 3:
				t3.dif3.add(element);
				break;
			case 4:
				t3.dif4.add(element);
				break;
			case 5:
				t3.dif5.add(element);
				break;
			}
		}
		for (Question element : ex4) {
			switch (element.dif) {
			case 1:
				t4.dif1.add(element);
				break;
			case 2:
				t4.dif2.add(element);
				break;
			case 3:
				t4.dif3.add(element);
				break;
			case 4:
				t4.dif4.add(element);
				break;
			case 5:
				t4.dif5.add(element);
				break;
			}
		}
	}

	public void setUp(ArrayList<Question> ex1, ArrayList<Question> ex2, ArrayList<Question> ex3) {
		for (Question element : ex1) {
			switch (element.dif) {
			case 1:
				t1.dif1.add(element);
				break;
			case 2:
				t1.dif2.add(element);
				break;
			case 3:
				t1.dif3.add(element);
				break;
			case 4:
				t1.dif4.add(element);
				break;
			case 5:
				t1.dif5.add(element);
				break;
			}
		}
		for (Question element : ex2) {
			switch (element.dif) {
			case 1:
				t2.dif1.add(element);
				break;
			case 2:
				t2.dif2.add(element);
				break;
			case 3:
				t2.dif3.add(element);
				break;
			case 4:
				t2.dif4.add(element);
				break;
			case 5:
				t2.dif5.add(element);
				break;
			}
		}
		for (Question element : ex3) {
			switch (element.dif) {
			case 1:
				t3.dif1.add(element);
				break;
			case 2:
				t3.dif2.add(element);
				break;
			case 3:
				t3.dif3.add(element);
				break;
			case 4:
				t3.dif4.add(element);
				break;
			case 5:
				t3.dif5.add(element);
				break;
			}
		}

	}

	/*
	 * Read file and initialize into each type Arraylist.
	 */
	public void setUp(ArrayList<Question> ex1) {
		for (Question element : ex1) {
			switch (element.dif) {
			case 1:
				t1.dif1.add(element);
				break;
			case 2:
				t1.dif2.add(element);
				break;
			case 3:
				t1.dif3.add(element);
				break;
			case 4:
				t1.dif4.add(element);
				break;
			case 5:
				t1.dif5.add(element);
				break;
			}
		}

	}

	/**
	 * Read file and initialize into each type Arraylist.
	 * 
	 * @param ex1
	 * @param ex2
	 * @param ex3
	 * @param ex4
	 * @param ex5
	 * @param ex6
	 */
	public void setUp(ArrayList<Question> ex1, ArrayList<Question> ex2, ArrayList<Question> ex3,
			ArrayList<Question> ex4, ArrayList<Question> ex5, ArrayList<Question> ex6) {
		for (Question element : ex1) {
			switch (element.dif) {
			case 1:
				t1.dif1.add(element);
				break;
			case 2:
				t1.dif2.add(element);
				break;
			case 3:
				t1.dif3.add(element);
				break;
			case 4:
				t1.dif4.add(element);
				break;
			case 5:
				t1.dif5.add(element);
				break;
			}
		}
		for (Question element : ex2) {
			switch (element.dif) {
			case 1:
				t2.dif1.add(element);
				break;
			case 2:
				t2.dif2.add(element);
				break;
			case 3:
				t2.dif3.add(element);
				break;
			case 4:
				t2.dif4.add(element);
				break;
			case 5:
				t2.dif5.add(element);
				break;
			}
		}
		for (Question element : ex3) {
			switch (element.dif) {
			case 1:
				t3.dif1.add(element);
				break;
			case 2:
				t3.dif2.add(element);
				break;
			case 3:
				t3.dif3.add(element);
				break;
			case 4:
				t3.dif4.add(element);
				break;
			case 5:
				t3.dif5.add(element);
				break;
			}
		}
		for (Question element : ex4) {
			switch (element.dif) {
			case 1:
				t4.dif1.add(element);
				break;
			case 2:
				t4.dif2.add(element);
				break;
			case 3:
				t4.dif3.add(element);
				break;
			case 4:
				t4.dif4.add(element);
				break;
			case 5:
				t4.dif5.add(element);
				break;
			}
		}
		for (Question element : ex5) {
			switch (element.dif) {
			case 1:
				t5.dif1.add(element);
				break;
			case 2:
				t5.dif2.add(element);
				break;
			case 3:
				t5.dif3.add(element);
				break;
			case 4:
				t5.dif4.add(element);
				break;
			case 5:
				t5.dif5.add(element);
				break;
			}
		}
		for (Question element : ex6) {
			switch (element.dif) {
			case 1:
				t6.dif1.add(element);
				break;
			case 2:
				t6.dif2.add(element);
				break;
			case 3:
				t6.dif3.add(element);
				break;
			case 4:
				t6.dif4.add(element);
				break;
			case 5:
				t6.dif5.add(element);
				break;
			}
		}
	}

	/**
	 * Fuction to check when the question is over
	 * 
	 * @return
	 */
	public boolean isOver() {
		if (level == 6)// If level is 6, which means the user complete all the levels
			return true;// Quiz is over
		for (int i = 0; i < turn; i++) {// Go through each type of question
			if (questionPackage[i].giveSize(level) != 0)// If there is question left to the following level
				return false;// Quiz is not over
		}
		return true;// If all arraylist is empty, the quiz is over
	}

	/**
	 * A fuction called when the quiz is over
	 */
	public void end() {
		textArea.setText("");// Set a textArea to blank
		JLabel endMsg = new JLabel("Nice Job for Finishing the quiz for this unit!");// Set the endMessage, showing the
																						// quiz is over
		// Settings for textArea
		endMsg.setHorizontalAlignment(SwingConstants.CENTER);
		endMsg.setForeground(Color.WHITE);
		endMsg.setBounds(70, 70, 1260, 75);
		endMsg.setHorizontalAlignment(SwingConstants.CENTER);
		endMsg.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		endMsg.setForeground(Color.WHITE);
		bottom.add(endMsg);// Add to bottom panel
		// Create lvlMsg to show the level
		JLabel lvlMsg = new JLabel("Your Level: " + (level - 1));
		// Settings for lvlMsg (Center alignment, font, colour, location)
		lvlMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lvlMsg.setForeground(Color.WHITE);
		lvlMsg.setBounds(70, 145, 1260, 75);
		lvlMsg.setHorizontalAlignment(SwingConstants.CENTER);
		lvlMsg.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lvlMsg.setForeground(Color.WHITE);
		bottom.add(lvlMsg);// Add it to panel
		String advice = "";// Create a string variable
		switch (level) {
		// If the level that the user ends is 1~2
		case 1:
		case 2:
			advice += "You should learn this unit again for better understanding";// Advice the user to re-learn the
																					// lesson
			break;
		// If the level that the user ends is 3
		case 3:
			advice += "You should review this unit for better understanding";// Advice the user to review the unit
			break;
		// If the level that the user ends is 4
		case 4:
			advice += "You can improve your score by trying some more pratice";// Advice the user to try some practice
																				// questions
			break;
		// If the level that the user ends is 5
		case 5:
			advice += "You can reach mastery by trying hard and complicated practice question";// Advice the user to try
																								// some challenging
																								// question
			break;
		// If the level that the user ends is 6
		case 6:
			advice += "You are the master of this unit!";// Advice the user that he/she mastered the unit
			break;
		}
		// Create giveAdice level and set advice as a display text
		JLabel giveAdvice = new JLabel(advice);
		// Settings for giveAdvice
		giveAdvice.setHorizontalAlignment(SwingConstants.CENTER);
		giveAdvice.setForeground(Color.WHITE);
		giveAdvice.setBounds(70, 220, 1260, 75);
		giveAdvice.setHorizontalAlignment(SwingConstants.CENTER);
		giveAdvice.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		giveAdvice.setForeground(Color.WHITE);
		bottom.add(giveAdvice);// Add it to the bottom
		// Add icon that is shown in the left side of the panel
		JLabel congratsLeft = new JLabel("");
		congratsLeft.setIcon(new ImageIcon("./icon/congrats.png"));
		congratsLeft.setBounds(40, 100, 75, 75);
		// Add icon that is shown in the right side of the panel
		JLabel congratsRight = new JLabel("");
		congratsRight.setIcon(new ImageIcon("./icon/congrats2.png"));
		congratsRight.setBounds(1285, 100, 75, 75);
		bottom.add(congratsLeft);
		bottom.add(congratsRight);
	}

	/**
	 * This is a function that process level of the quiz
	 * 
	 * @param isCorrect
	 */
	public void processLevel(boolean isCorrect) {
		// If the user gets the correct answer
		if (isCorrect) {
			up++;// Increase up
			streak++;// Increase streak
			if (levelUp[level - 1] == up) {// If the user gets enough questions correct to move to the new level
				isStreak = true;// Set isStreak true
				level++;// Increase level
				up = 0;// Set up 0
				String levelmsg = "Level " + level + ": " + 0 + "/" + levelUp[level - 1];// Set levelMsg
				showLevel.setText(levelmsg);// Modify showLevel
				SwingUtilities.updateComponentTreeUI(quiz);// Update frame
			}
			// If the user gets the half of the requirements without getting any question
			// wrong
			else if (isStreak && streak == ((int) levelUp[level - 1] / 2) + 1) {
				if (level == 4) {// If the level is 4
					level++;// Increase the level, so that the user try the hardest level
					String levelmsg = "Level " + level + ": " + 0 + "/" + levelUp[level - 1];// Set levelMsg
					streak = 0;// Set streak to 0
					showLevel.setText(levelmsg);// Modify showLevel
					SwingUtilities.updateComponentTreeUI(quiz);// Update frame
				} else {
					level += 2;// Increase two levels
					streak = 0;// Set streak to 0
					String levelmsg = "Level " + level + ": " + 0 + "/" + levelUp[level - 1];// Set levelMsg
					showLevel.setText(levelmsg);// Modify showLevel
					SwingUtilities.updateComponentTreeUI(quiz);// Update frame
				}
				up = 0;// Set up 0
			}
		}
		// If the user get the wrong question
		else {
			incorrect.add(current_q);// Add the incorrect question to incorrect for incorrect sheet
			isStreak = false;// Set isStreak to 0
			if (up == 0) {// If up is 0
				if (level != 1)// If level is not 0
					demote_life--;// Decrease demote_life

				if (demote_life == 0) {// If demote_life is 0
					level--;// Decrease level
					streak = 0;// Set streak to 0
					demote_life = 2;// Reset demote_life to 2
					isStreak = true;// Set isStreak to true
					up = ((int) levelUp[level - 1] / 2) + 1;// Set up new up
					String levelmsg = "Level " + level + ": " + up + "/" + levelUp[level - 1];// Set up levelMsg
					showLevel.setText(levelmsg);// Modify showLevel
					SwingUtilities.updateComponentTreeUI(quiz);// Update frame
				}
			} else
				up--;// Decrease up

		}
	}

	/**
	 * A function that gives questions randomly
	 */
	public void giveQuestion() {
		Random ran = new Random();
		if (isOver()) {// If the quiz is over
			end();// Call end
		}
		int size = questionPackage[current_turn].giveSize(level);// Set up the range of index that can be randomly
																	// picked up
		// If there is question in the following type of question
		if (size > 0) {
			int index = ran.nextInt(size);// randomly pick one index
			current_q = questionPackage[current_turn].giveElement(level, index);// Use the index and get current
																				// question
			str = current_q.q;// Set str to question of the current question
			textArea.setText(str);// set textArea to str
			SwingUtilities.updateComponentTreeUI(quiz);// Update frame
			// If the current question had images
			if (!current_q.image1_i.equals("-1") || !current_q.image2_i.equals("-1")) {
				display();// Call display
			}
			current_turn = (current_turn + 1) % turn;// Increase turn
		}
		// If the following type of question is empty
		else {
			current_turn = (current_turn + 1) % turn;// Increase turn
			giveQuestion();// Call giveQuestion
		}
	}

	/**
	 * A function to display images to the frame
	 */
	public void display() {
		int w1 = 0, w2 = 0, h1 = 0, h2 = 0;// Create a varaible to store width and height of two images
		ImageIcon imgIcon1 = new ImageIcon();// Create a ImageIcon to store img1
		ImageIcon imgIcon2 = new ImageIcon();// Create a ImageIcon to store img2
		String fileName = "";// String to store fileName
		String f = "./Math_image/";// File location
		if (!current_q.image1_i.equals("-1")) {// If the index of img1 is not -1
			fileName = f + current_q.image1_i + ".png";// Set up file Location
			imgIcon1 = new ImageIcon(fileName);// Get a image from the following location
			w1 = imgIcon1.getIconWidth();// Set up width of imgIcon1
			h1 = imgIcon1.getIconHeight();// Set up width of imgIcon1
		}
		if (!current_q.image2_i.equals("-1")) {// If the index of img2 is not -1
			fileName = f + current_q.image2_i + ".png";// Set up file location
			imgIcon2 = new ImageIcon(fileName);// Get a following image
			w2 = imgIcon2.getIconWidth();// Set up width of imgIcon2
			h2 = imgIcon2.getIconHeight();// Set up height of imgIcon2
		}
		// If w2==0, means there is no img2
		if (w2 == 0) {
			int margin_x = (1400 - w1) / 2;//Calculate the margin of the blank space
			img1.setIcon(imgIcon1);//Set img1 to imgIcon1
			img1.setBounds(margin_x, 150, w1, h1);//Set bounds of img1 to be laid on the center of screen according to marginX
			img1.setVisible(true);//Set img1 visible
		}
		//If img1&img2 both exist
		else {
			int margin_x = (1400 - w1 - w2) / 3;//Calculate the margin of the blank space
			img1.setBounds(margin_x, 150, w1, h1);//Set up bounds of img1 to be laid proportionally
			img1.setIcon(imgIcon1);//Set up img1 to imgIcon1
			img2.setBounds(1400 - margin_x - w2, 150, w2, h2);//Set up bounds of img2 to be laid proportionally
			img2.setIcon(imgIcon2);//Set up img2 to imgIcon1
			img1.setVisible(true);//Set img1 visible
			img2.setVisible(true);//Set img2 visible
		}
		SwingUtilities.updateComponentTreeUI(quiz);//Update frame
	}
	//Constructor
	public Quiz(int unit, ArrayList<Question> incorrect) {
		this.unit = unit;//Get unit 
		this.incorrect = incorrect;//Get incorrect question lists
		//Set up types of questions and questions required to get to the newLevel based on the unit
		switch (unit) {
		case 1:
			setUp(qp.NumberSystem, qp.Expand, qp.Factorize, qp.Simplify);
			levelUp = new int[] { 5, 8, 10, 7, 5 };
			turn = 4;
			break;
		case 2:
			setUp(qp.Equation, qp.Eqa_Application, qp.Inequality);
			levelUp = new int[] { 6, 7, 9, 8, 6 };
			turn = 3;
			break;
		case 3:
			setUp(qp.Exponents);
			levelUp = new int[] { 4, 7, 8, 6, 4 };
			turn = 1;
			break;
		case 4:
			setUp(qp.Linear_f, qp.Quadratic_f, qp.Exponent_f, qp.Hyperbole_f, qp.Trig_f, qp.Coordinate);
			levelUp = new int[] { 4, 8, 8, 6, 1 };
			turn = 6;
			break;
		case 5:
			setUp(qp.Trignometry);
			levelUp = new int[] { 4, 5, 9, 5, 5 };
			turn = 1;
			break;
		case 6:
			turn = 3;
			setUp(qp.Angle, qp.Angle_Geo, qp.Polygons);
			levelUp = new int[] { 5, 9, 8, 7, 5 };
			break;
		}
		initialize();//Initialize frame
		giveQuestion();//Call giveQuestion
	}

	
	/**
	 *  Initialize the contents of the frame.
	 */
	public void initialize() {
		quiz = new JFrame();//Create new frame
		//Settings for frame
		quiz.setBounds(100, 100, 1400, 830);//bounds
		quiz.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//closed the whole frame when it is closed
		quiz.getContentPane().setLayout(null);//Set up frame to null
		JPanel menubar = new JPanel();//Create menubar
		//Setting for menubar
		menubar.setBounds(0, 0, 70, 50);
		menubar.setPreferredSize(new Dimension(50, 640));
		menubar.setBackground(new Color(0, 18, 50));
		menubar.setLayout(null);
		quiz.getContentPane().add(menubar);
		//Setting for bottom
		bottom.setBounds(0, 50, 1400, 780);
		bottom.setBackground(new Color(32, 47, 90));
		quiz.getContentPane().add(bottom);
		bottom.setLayout(null);
		//Set up AnserFiled
		AnswerField = new JTextField();
		AnswerField.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		AnswerField.setCaretColor(Color.WHITE);
		AnswerField.setForeground(Color.WHITE);
		AnswerField.setBackground(new Color(106, 116, 145));
		AnswerField.setBounds(390, 650, 620, 75);
		AnswerField.setColumns(10);
		bottom.add(AnswerField);

		//Setting for textArea
		textArea = new JTextArea(2, 20);
		textArea.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		textArea.setForeground(Color.WHITE);
		textArea.setText(str);
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		textArea.setOpaque(false);
		textArea.setEditable(false);
		textArea.setFocusable(false);
		textArea.setBackground(UIManager.getColor("Label.background"));
		textArea.setBorder(UIManager.getBorder("Label.border"));
		textArea.setBounds(70, 21, 1282, 400);
		bottom.add(textArea);

		//Create a button to go back
		JPanel goBackbutton = new JPanel();
		
		goBackbutton.addMouseListener(new MouseAdapter() {
			@Override
			//If the button is clicked
			public void mouseClicked(MouseEvent e) {
				Unit unit = new Unit(incorrect);//Create new unit
				unit.setVisible(true);//Set unit visible
				quiz.dispose();//Dispose quiz
			}
		});
		//Settings for gobackButton
		goBackbutton.setBounds(190, 650, 75, 75);
		goBackbutton.setBackground(new Color(32, 47, 90));
		goBackbutton.setLayout(new BorderLayout(0, 0));
		bottom.add(goBackbutton);

		//Create a icon for goBkackButton
		JLabel goBack_icon = new JLabel("");
		goBack_icon.setIcon(new ImageIcon(
				"./icon/goBack_icon.png"));
		goBackbutton.add(goBack_icon, BorderLayout.CENTER);//Add the icon to the goBackbutton
		
		JLabel correctAnswer = new JLabel("");//Correct Label to show the checkmark

		correctAnswer.setIcon(
				new ImageIcon("./icon/correct.png"));
		correctAnswer.setBounds(40, 0, 75, 75);
		correctAnswer.setVisible(false);
		bottom.add(correctAnswer);

		JLabel wrongAnswer = new JLabel("");
		wrongAnswer.setIcon(
				new ImageIcon("./icon/incorrect.png"));
		wrongAnswer.setBounds(40, 0, 75, 75);
		wrongAnswer.setVisible(false);
		bottom.add(wrongAnswer);

		JPanel Inputbutton = new JPanel();

		JPanel nextQuestion = new JPanel();
		nextQuestion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AnswerField.setEditable(true);
				correctAnswer.setVisible(false);
				wrongAnswer.setVisible(false);
				Inputbutton.setVisible(true);
				nextQuestion.setVisible(false);
				img1.setVisible(false);
				img2.setVisible(false);
				AnswerField.setText("");
				if (isOver() == true) {
					System.out.print("isOVer");
					end();
				} else {
					SwingUtilities.updateComponentTreeUI(quiz);
					giveQuestion();
				}
			}
		});
		nextQuestion.setBackground(new Color(32, 47, 90));
		nextQuestion.setBounds(1135, 650, 75, 75);
		bottom.add(nextQuestion);
		nextQuestion.setLayout(new BorderLayout(0, 0));
		nextQuestion.setVisible(false);

		JLabel getNextQuestion = new JLabel("");
		getNextQuestion.setIcon(new ImageIcon(
				"./icon/nextQuestion_icon.png"));
		nextQuestion.add(getNextQuestion, BorderLayout.CENTER);

		nextQuestion.setVisible(false);

		Inputbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AnswerField.setEditable(false);
				Inputbutton.setVisible(false);
				nextQuestion.setVisible(true);
				String user_ans = AnswerField.getText();
				int current_up = 0;
				if (current_q.answer_check(user_ans)) {
					correctAnswer.setVisible(true);
					processLevel(true);
				} else {
					wrongAnswer.setVisible(true);
					processLevel(false);
				}
				String levelmsg = "Level " + level + ": " + up + "/" + levelUp[level - 1];
				showLevel.setText(levelmsg);
				SwingUtilities.updateComponentTreeUI(quiz);
			}
		});
		Inputbutton.setBackground(new Color(32, 47, 90));
		Inputbutton.setBounds(1135, 650, 75, 75);
		bottom.add(Inputbutton);
		Inputbutton.setLayout(new BorderLayout(0, 0));

		JLabel answerInput = new JLabel("New label");
		answerInput.setIcon(
				new ImageIcon("./icon/enter.png"));
		Inputbutton.add(answerInput, BorderLayout.CENTER);

		showLevel = new JLabel("Level 1: 0/" + levelUp[0]);
		showLevel.setHorizontalAlignment(SwingConstants.CENTER);
		showLevel.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		showLevel.setForeground(Color.WHITE);
		showLevel.setBounds(390, 615, 620, 33);
		bottom.add(showLevel);
		img1 = new JLabel();
		img2 = new JLabel();
		bottom.add(img1);
		bottom.add(img2);

		JPanel header = new JPanel();
		header.setBounds(70, 0, 1330, 50);
		quiz.getContentPane().add(header);
		header.setBackground(Color.WHITE);
		header.setLayout(new BorderLayout(0, 0));

		JPanel quit_button = new JPanel();
		quit_button.setBackground(Color.WHITE);
		quit_button.setPreferredSize(new Dimension(50, 50));
		header.add(quit_button, BorderLayout.EAST);
		quit_button.setLayout(new BorderLayout(0, 0));
		JLabel quit_icon = new JLabel("");
		quit_icon.setIcon(new ImageIcon(
				"./icon/close_black.png"));
		quit_icon.setHorizontalAlignment(JLabel.CENTER);
		quit_icon.setVerticalAlignment(JLabel.CENTER);
		quit_button.add(quit_icon, BorderLayout.CENTER);
		quit_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changecolor(quit_button, new Color(0, 18, 50));
				quit_icon.setIcon(new ImageIcon(
						"./icon/close_white.png"));
				SwingUtilities.updateComponentTreeUI(quiz);

			}

			public void mouseExited(MouseEvent e) {
				changecolor(quit_button, new Color(255, 255, 255));
				quit_icon.setIcon(new ImageIcon(
						"./icon/close_black.png"));
				SwingUtilities.updateComponentTreeUI(quiz);
			}

			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		quiz.setResizable(false);
		quiz.setUndecorated(true);
		quiz.setLocationRelativeTo(null);
	}
}
