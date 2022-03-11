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

import javax.swing.JButton;
import java.awt.Font;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JTextPane;

public class IncorrectSheet {
	//Settings
	JFrame incorrectSheet;
	JPanel bottom = new JPanel();
	JLabel img1, img2;//Label to display image
	JLabel endMsg;//Label to display end message
	ArrayList<Question> incorrect = new ArrayList<Question>();//ArrayList to store incorrect answers
	JTextArea textArea;//TextArea to show question
	int index;//Index of current_question
	int cnt = 0, solved = 0;//To count number of wrong question and question solved
	JTextField AnswerField;//TextField to get user input
	JLabel showQuestionLeft;//Label to show how many question is left
	Question current_q;//Current question that is shown

	String str = "";
	//Change the color of the given panel
	public void changecolor(JPanel hover, Color rand) {
		hover.setBackground(rand);
	}
	//Make incorrectSheet panel visible
	public void setVisible() {
		incorrectSheet.setVisible(true);
	}
	//A function called when the question is done
	public void end() {
		textArea.setText("");//Set the textArea empty
		String msg = "";//Msg that will be printed
		if (cnt == 0) {
			msg = "You got nothing wrong. Well done!";//if there were no wrong questions in the inputlist
		} else {
			msg = "Nice Job for Finishing the IncorrectSheet!";//If there were wrong questions
		}
		JLabel endMsg = new JLabel(msg);//Label to display engMsg
		//Settings
		endMsg.setHorizontalAlignment(SwingConstants.CENTER);
		endMsg.setForeground(Color.WHITE);
		endMsg.setBounds(70, 70, 1260, 75);
		endMsg.setHorizontalAlignment(SwingConstants.CENTER);
		endMsg.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		endMsg.setForeground(Color.WHITE);
		bottom.add(endMsg);//Add to bottom panel
		//CongratsLeft display settings
		JLabel congratsLeft = new JLabel("");
		congratsLeft.setIcon(new ImageIcon("./icon/congrats.png"));
		congratsLeft.setBounds(40, 100, 75, 75);
		//CongatsRight display settings
		JLabel congratsRight = new JLabel("");
		congratsRight.setIcon(new ImageIcon("./icon/congrats2.png"));
		congratsRight.setBounds(1285, 100, 75, 75);
		bottom.add(congratsLeft);//Add congratsLeft to the bottom
		bottom.add(congratsRight);//Add congratsRight
	}
	//A method called to giveQuestion randomly
	public void giveQuestion() {
		Random ran = new Random();
		int size = incorrect.size();//Get size of list
		if (size > 0) {//If there is more than one question left
			index = ran.nextInt(size);//Choose index randomly in range of size
			current_q = incorrect.get(index);//Choose question
			str = current_q.q;//Set string the question of current q
			textArea.setText(str);//Put it into textArea
			SwingUtilities.updateComponentTreeUI(incorrectSheet);//Update Frame
			if (!current_q.image1_i.equals("-1") || !current_q.image2_i.equals("-1")) {
				display();//call display fuction to display image
			}
		} else {//If the list is empty
			end();//Call end
		}
	}
	//A method called to display image into the screan
	public void display() {
		int w1 = 0, w2 = 0, h1 = 0, h2 = 0;//Width, Height of img1 and img2
		ImageIcon imgIcon1 = new ImageIcon();//Create imgIcon for img1
		ImageIcon imgIcon2 = new ImageIcon();//Create imgIcon for img2
		String fileName = "";//String for fileName
		String f = "./Math_image/";//String for file location
		if (!current_q.image1_i.equals("-1")) {//If image1 index is not 0
			fileName = f + current_q.image1_i + ".png";//Get the file location
			imgIcon1 = new ImageIcon(fileName);//Create the following image
			w1 = imgIcon1.getIconWidth();//Get width
			h1 = imgIcon1.getIconHeight();//Get height
		}
		if (!current_q.image2_i.equals("-1")) {//If image2 index is not 0
			fileName = f + current_q.image2_i + ".png";//Get the file location
			imgIcon2 = new ImageIcon(fileName);//Create the following image
			w2 = imgIcon2.getIconWidth();//Get width
			h2 = imgIcon2.getIconHeight();//Get height
		}
		if (w2 == 0) {//If img2 does not exist
			int margin_x = (1400 - w1) / 2;//Get margin of x 
			img1.setIcon(imgIcon1);//Set img1 icon to the first image
			//Setting to set it into the middle of screen
			img1.setBounds(margin_x, 150, w1, h1);
			img1.setVisible(true);
		} else {//If img2 exists
			int margin_x = (1400 - w1 - w2) / 3;//Get margin of x
			//Setting to set boundaries of img1 and img2 in the middle
			img1.setBounds(margin_x, 150, w1, h1);
			img1.setIcon(imgIcon1);
			img2.setBounds(1400 - margin_x - w2, 150, w2, h2);
			img2.setIcon(imgIcon2);
		}
		SwingUtilities.updateComponentTreeUI(incorrectSheet);//Update frame
	}
	//Constructor of program
	public IncorrectSheet(ArrayList<Question> incorrect) {
		this.incorrect = incorrect;//Get incorrect list
		initialize();//Initialize frame
		cnt = incorrect.size();//Get the size of frame
		String questionLeft = "Question: " + solved + "/" + cnt;//Set string how many question are solved & left
		showQuestionLeft.setText(questionLeft);//Display it
		giveQuestion();//give question
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		//Create new JFrame and settings
		incorrectSheet = new JFrame();
		incorrectSheet.setBounds(100, 100, 1400, 830);
		incorrectSheet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		incorrectSheet.getContentPane().setLayout(null);
		incorrectSheet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Create menubar
		JPanel menubar = new JPanel();
		menubar.setBounds(0, 0, 70, 50);
		menubar.setPreferredSize(new Dimension(50, 640));
		menubar.setBackground(new Color(0, 18, 50));
		incorrectSheet.getContentPane().add(menubar);
		menubar.setLayout(null);
		//Settings for bottom panel
		bottom.setBounds(0, 50, 1400, 780);
		bottom.setBackground(new Color(32, 47, 90));
		incorrectSheet.getContentPane().add(bottom);
		bottom.setLayout(null);
		//Setting for AnswerFile where user input is drawn from
		AnswerField = new JTextField();
		AnswerField.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		AnswerField.setCaretColor(Color.WHITE);
		AnswerField.setForeground(Color.WHITE);
		AnswerField.setBackground(new Color(106, 116, 145));
		AnswerField.setBounds(390, 650, 620, 75);
		bottom.add(AnswerField);//Add to bottom
		AnswerField.setColumns(10);
		
		//Setting for textArea where question is shown
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
		
		//Create button to go back to home
		JPanel goBackbutton = new JPanel();
		goBackbutton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home home = new Home(incorrect);
				home.setVisible(true);
				incorrectSheet.dispose();
			}
		});
		goBackbutton.setBounds(190, 650, 75, 75);
		goBackbutton.setBackground(new Color(32, 47, 90));
		bottom.add(goBackbutton);
		goBackbutton.setLayout(new BorderLayout(0, 0));
		//Create icon for goback button
		JLabel goBack_icon = new JLabel("");
		goBack_icon.setIcon(new ImageIcon("./icon/goBack_icon.png"));
		goBackbutton.add(goBack_icon, BorderLayout.CENTER);

		//Create label to show correct answer
		JLabel correctAnswer = new JLabel("");
		correctAnswer.setIcon(new ImageIcon("./icon/correct.png"));
		correctAnswer.setBounds(40, 0, 75, 75);
		correctAnswer.setVisible(false);
		bottom.add(correctAnswer);
		//Create label to show wrong answer
		JLabel wrongAnswer = new JLabel("");
		wrongAnswer.setIcon(new ImageIcon("./icon/incorrect.png"));
		wrongAnswer.setBounds(40, 0, 75, 75);
		wrongAnswer.setVisible(false);
		bottom.add(wrongAnswer);
		//
		JPanel Inputbutton = new JPanel();
		//Create a panel for nextQuestion
		JPanel nextQuestion = new JPanel();
		//Add actionListner
		nextQuestion.addMouseListener(new MouseAdapter() {
			//If the mouse is clicked
			public void mouseClicked(MouseEvent e) {
				AnswerField.setEditable(true);
				//Hide the answer responses
				correctAnswer.setVisible(false);
				wrongAnswer.setVisible(false);
				//Show inputButton
				Inputbutton.setVisible(true);
				//Hide nextQuestion button
				nextQuestion.setVisible(false);
				img1.setVisible(false);
				img2.setVisible(false);
				//Set up the answerField to blank
				AnswerField.setText("");
				SwingUtilities.updateComponentTreeUI(incorrectSheet);
				//give another question
				giveQuestion();
			}
		});
		//Settings for nextQuestion
		nextQuestion.setBackground(new Color(32, 47, 90));
		nextQuestion.setBounds(1135, 650, 75, 75);
		bottom.add(nextQuestion);
		nextQuestion.setLayout(new BorderLayout(0, 0));
		nextQuestion.setVisible(false);
		//Create label for getNextQuestion
		JLabel getNextQuestion = new JLabel("");
		getNextQuestion.setIcon(new ImageIcon("./icon/nextQuestion_icon.png"));
		nextQuestion.add(getNextQuestion, BorderLayout.CENTER);
		nextQuestion.setVisible(false);
		//Add actionLinster for input_button
		Inputbutton.addMouseListener(new MouseAdapter() {
			//If it is clicked
			public void mouseClicked(MouseEvent e) {
				AnswerField.setEditable(false);
				Inputbutton.setVisible(false);//Hide inputbutton
				nextQuestion.setVisible(true);//Show nextQuestion button
				String user_ans = AnswerField.getText();//Get the answer user inputted
				if (cnt != 0) {//If there is wrong response
					if (current_q.answer_check(user_ans)) {//If the answer is correct
						correctAnswer.setVisible(true);//Show answer is correct
						solved++;//Increase solve
						incorrect.remove(index);//Remove the wrong response
					} else {
						wrongAnswer.setVisible(true);//Show that the answer is wrong
					}
					String questionLeft = "Question: " + solved + "/" + cnt;//Change showQuestionLeft
					showQuestionLeft.setText(questionLeft);
					SwingUtilities.updateComponentTreeUI(incorrectSheet);//Update Frame
				}
			}
		});
		//Settings for inputButton
		Inputbutton.setBackground(new Color(32, 47, 90));
		Inputbutton.setBounds(1135, 650, 75, 75);
		bottom.add(Inputbutton);
		Inputbutton.setLayout(new BorderLayout(0, 0));
		
		//Settings for answerInput
		JLabel answerInput = new JLabel("");
		answerInput.setIcon(new ImageIcon("./icon/enter.png"));
		Inputbutton.add(answerInput, BorderLayout.CENTER);
		//Settings for showQuestionLeft
		showQuestionLeft = new JLabel("Level 1: 0/0");
		showQuestionLeft.setHorizontalAlignment(SwingConstants.CENTER);
		showQuestionLeft.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		showQuestionLeft.setForeground(Color.WHITE);
		showQuestionLeft.setBounds(390, 615, 620, 33);
		bottom.add(showQuestionLeft);//Add to bottom panel
		//Initialize img1 and img2 
		img1 = new JLabel();
		img2 = new JLabel();
		//Add them to bottom panel
		bottom.add(img1);
		bottom.add(img2);

		//Setting for header
		JPanel header = new JPanel();
		header.setBounds(70, 0, 1330, 50);
		incorrectSheet.getContentPane().add(header);
		header.setBackground(Color.WHITE);
		header.setLayout(new BorderLayout(0, 0));
		//Setting for quit_button
		JPanel quit_button = new JPanel();
		quit_button.setBackground(Color.WHITE);
		quit_button.setPreferredSize(new Dimension(50, 50));
		header.add(quit_button, BorderLayout.EAST);
		quit_button.setLayout(new BorderLayout(0, 0));
		//Create icon for quit_button
		JLabel quit_icon = new JLabel("");
		quit_icon.setIcon(new ImageIcon("./icon/close_black.png"));
		quit_icon.setHorizontalAlignment(JLabel.CENTER);
		quit_icon.setVerticalAlignment(JLabel.CENTER);
		quit_button.add(quit_icon, BorderLayout.CENTER);
		quit_button.addMouseListener(new MouseAdapter() {
			//If the mouse is dragged on
			public void mouseEntered(MouseEvent e) {
				changecolor(quit_button, new Color(0, 18, 50));//Change the color
				quit_icon.setIcon(new ImageIcon("./icon/close_white.png"));//Change the icon 
				SwingUtilities.updateComponentTreeUI(incorrectSheet);//Update thread
			}
			//If the mouse is dragged out
			public void mouseExited(MouseEvent e) {
				changecolor(quit_button, new Color(255, 255, 255));//Change color
				quit_icon.setIcon(new ImageIcon("./icon/close_black.png"));//Change icon back
				SwingUtilities.updateComponentTreeUI(incorrectSheet);//Update the thread
			}
			//If the mouse is clicked
			public void mouseClicked(MouseEvent e) {
				System.exit(0);//Quit program
			}
		});
		//Setting for incorrect Sheet
		incorrectSheet.setResizable(false);//Cannot change size
		incorrectSheet.setUndecorated(true);
		incorrectSheet.setLocationRelativeTo(null);//Displayed in the middle
	}
}
