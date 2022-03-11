import java.awt.EventQueue;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;


import javax.swing.JFrame;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;



import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;


public class Unit {
	private JFrame unit;
	public void changecolor (JPanel hover, Color rand) {
		hover.setBackground(rand);
	} 

	QuestionProcesser qp;
	ArrayList<Question>incorrect;
	
	public void setUpQuiz(Quiz quiz) {
		quiz.setVisible();		
		unit.dispose();
	}
	public Unit(ArrayList<Question> incorrect) {
		this.incorrect=incorrect;
		initialize();
	}
	public void setVisible(boolean bool) {
		unit.setVisible(bool);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		unit = new JFrame();
		unit.setBounds(100, 100, 1080, 640);
		unit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		unit.getContentPane().setLayout(null);
		unit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel FrameDrag = new JLabel("");
		FrameDrag.setBounds(0, 0, 1030, 50);
		unit.getContentPane().add(FrameDrag);


		JPanel menubar = new JPanel();
		menubar.setBounds(0, 0, 70, 640);
		menubar.setPreferredSize(new Dimension(50,640));
		menubar.setBackground(new Color(0, 18, 50));
		unit.getContentPane().add(menubar);
		menubar.setLayout(null);

		JPanel home_button = new JPanel();
		home_button.setBounds(0, 50, 70, 70);
		home_button.setBackground(new Color(0, 18, 50));
		menubar.add(home_button);
		home_button.setLayout(new BorderLayout(0, 0));

		JLabel home_Icon = new JLabel("");
		home_Icon.setIcon(new ImageIcon("./icon/icons8-home 2.png"));
		home_Icon.setHorizontalAlignment(JLabel.CENTER);
		home_Icon.setVerticalAlignment(JLabel.CENTER);
		home_button.add(home_Icon, BorderLayout.CENTER);

		home_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changecolor(home_button,new Color(106, 116, 145));
			}
			public void mouseExited(MouseEvent e) {
				changecolor(home_button,new Color(0, 18, 50));
			}
			public void mouseClicked(MouseEvent e) {
				unit.dispose();
				Home home=new Home(incorrect);
				home.setVisible(true);
			}
		});

		JPanel quiz_button = new JPanel();
		quiz_button.setBounds(0, 140, 70, 70);
		quiz_button.setBackground(new Color(0, 18, 50));
		menubar.add(quiz_button);
		quiz_button.setLayout(new BorderLayout(0, 0));

		JLabel quiz_Icon = new JLabel("");
		quiz_Icon.setIcon(new ImageIcon("./icon/icons8-light_on 2.png"));
		quiz_Icon.setHorizontalAlignment(JLabel.CENTER);
		quiz_Icon.setVerticalAlignment(JLabel.CENTER);
		quiz_button.add(quiz_Icon, BorderLayout.CENTER);

		quiz_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changecolor(quiz_button,new Color(106, 116, 145));
			}
			public void mouseExited(MouseEvent e) {
				changecolor(quiz_button,new Color(0, 18, 50));
			}
		});

		JPanel incorrect_button = new JPanel();
		incorrect_button.setBounds(0, 230, 70, 70);
		incorrect_button.setBackground(new Color(0, 18, 50));
		menubar.add(incorrect_button);
		incorrect_button.setLayout(new BorderLayout(0, 0));

		JLabel incorrect_Icon = new JLabel("");
		incorrect_Icon.setIcon(new ImageIcon("./icon/icons8-checklist 1.png"));
		incorrect_Icon.setHorizontalAlignment(JLabel.CENTER);
		incorrect_Icon.setVerticalAlignment(JLabel.CENTER);
		incorrect_button.add(incorrect_Icon, BorderLayout.CENTER);

		incorrect_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changecolor(incorrect_button,new Color(106, 116, 145));
			}
			public void mouseExited(MouseEvent e) {
				changecolor(incorrect_button,new Color(0, 18, 50));
			}
			public void mouseClicked(MouseEvent e) {
				unit.dispose();
				IncorrectSheet incorrectsheet = new IncorrectSheet(incorrect);
				incorrectsheet.setVisible();
			}
		});

		JPanel top = new JPanel();
		top.setBounds(70, 50, 1010, 240);
		top.setBackground(new Color(204, 204, 204));
		unit.getContentPane().add(top);
		top.setLayout(null);

		JLabel title = new JLabel("Math Helper V.1.0");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setBackground(Color.YELLOW);
		title.setBounds(0, 95, 1010, 58);
		title.setFont(new Font("Tahoma", Font.PLAIN, 52));
		top.add(title,BorderLayout.CENTER);
		ImageIcon math_unit=new ImageIcon("./image/home_image.jpg");
		JLabel unit_label = new JLabel("");
		unit_label.setIcon(math_unit);
		unit_label.setPreferredSize(new Dimension(1030, 240));
		unit_label.setBounds(0, 0, 1030, 240);
		top.add(unit_label,BorderLayout.CENTER);

		JPanel bottom = new JPanel();
		bottom.setBounds(70, 290, 1010, 350);
		bottom.setBackground(new Color(32, 47, 90));
		unit.getContentPane().add(bottom);
		bottom.setLayout(null);

		JPanel unit1 = new JPanel();
		unit1.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				Quiz quiz=new Quiz(1, incorrect);
				setUpQuiz(quiz);
			}
		});
		unit1.setBounds(35, 32, 240, 110);
		unit1.setBackground(new Color(106, 116, 145));
		bottom.add(unit1);
		unit1.setLayout(null);

		JLabel unit1_exp = new JLabel("Algebraic Expressions");
		unit1_exp.setForeground(Color.WHITE);
		unit1_exp.setHorizontalAlignment(SwingConstants.CENTER);
		unit1_exp.setBounds(0, 84, 240, 16);
		unit1.add(unit1_exp);

		JLabel unit1_icon = new JLabel("");
		unit1_icon.setBounds(88, 10, 64, 64);
		unit1_icon.setIcon(new ImageIcon("./icon/algebraic.png"));
		unit1.add(unit1_icon);

		JPanel unit2 = new JPanel();
		unit2.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				Quiz quiz=new Quiz(2, incorrect);
				setUpQuiz(quiz);
			}
		});
		unit2.setLayout(null);
		unit2.setBackground(new Color(106, 116, 145));
		unit2.setBounds(385, 32, 240, 110);
		bottom.add(unit2);

		JLabel unit2_icon = new JLabel("");
		unit2_icon.setIcon(new ImageIcon("./icon/inequality.png"));
		unit2_icon.setBounds(88, 10, 64, 64);
		unit2.add(unit2_icon);


		JLabel unit2_exp = new JLabel("Eqautions and Inequalities");
		unit2_exp.setHorizontalAlignment(SwingConstants.CENTER);
		unit2_exp.setForeground(Color.WHITE);
		unit2_exp.setBounds(0, 84, 240, 16);
		unit2.add(unit2_exp);

		JPanel unit3 = new JPanel();
		unit3.setLayout(null);
		unit3.setBackground(new Color(106, 116, 145));
		unit3.setBounds(735, 32, 240, 110);
		bottom.add(unit3);

		unit3.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {
				Quiz quiz=new Quiz(3, incorrect);
				setUpQuiz(quiz);
			}
		});

		JLabel unit3_icon = new JLabel("");
		unit3_icon.setIcon(new ImageIcon("./icon/exponent.png"));
		unit3_icon.setBounds(88, 10, 64, 64);
		unit3.add(unit3_icon);

		JLabel unit3_exp = new JLabel("Exponents");
		unit3_exp.setHorizontalAlignment(SwingConstants.CENTER);
		unit3_exp.setForeground(Color.WHITE);
		unit3_exp.setBounds(0, 84, 240, 16);
		unit3.add(unit3_exp);

		JPanel unit4 = new JPanel();
		unit4.setLayout(null);
		unit4.setBackground(new Color(106, 116, 145));
		unit4.setBounds(35, 208, 240, 110);
		bottom.add(unit4);
		unit4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Quiz quiz=new Quiz(4, incorrect);
				setUpQuiz(quiz);
			}
		});

		JLabel unit4_icon = new JLabel("");
		unit4_icon.setIcon(new ImageIcon("./icon/functions.png"));
		unit4_icon.setBounds(83, 14, 64, 64);
		unit4.add(unit4_icon);

		JLabel unit4_exp = new JLabel("Functions");
		unit4_exp.setHorizontalAlignment(SwingConstants.CENTER);
		unit4_exp.setForeground(Color.WHITE);
		unit4_exp.setBounds(0, 84, 240, 16);
		unit4.add(unit4_exp);
		
		JPanel unit5 = new JPanel();
		unit5.setLayout(null);
		unit5.setBackground(new Color(106, 116, 145));
		unit5.setBounds(385, 208, 240, 110);
		bottom.add(unit5);
		unit5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Quiz quiz=new Quiz(5, incorrect);
				setUpQuiz(quiz);
			}
		});

		JLabel unit5_icon = new JLabel("");
		unit5_icon.setIcon(new ImageIcon("./icon/trigonometry.png"));
		unit5_icon.setBounds(88, 12, 64, 64);
		unit5.add(unit5_icon);

		JLabel unit5_exp = new JLabel("Trigonometry");
		unit5_exp.setHorizontalAlignment(SwingConstants.CENTER);
		unit5_exp.setForeground(Color.WHITE);
		unit5_exp.setBounds(0, 84, 240, 16);
		unit5.add(unit5_exp);

		JPanel unit6 = new JPanel();
		unit6.setLayout(null);
		unit6.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Quiz quiz=new Quiz(6, incorrect);
				setUpQuiz(quiz);
			}
		});
		unit6.setBackground(new Color(106, 116, 145));
		unit6.setBounds(735, 208, 240, 110);
		bottom.add(unit6);

		JLabel unit6_icon = new JLabel("");
		unit6_icon.setIcon(new ImageIcon("./icon/geometry.png"));
		unit6_icon.setBounds(88, 14, 64, 64);
		unit6.add(unit6_icon);

		JLabel unit6_exp = new JLabel("Geometry");
		unit6_exp.setHorizontalAlignment(SwingConstants.CENTER);
		unit6_exp.setForeground(Color.WHITE);
		unit6_exp.setBounds(0, 84, 240, 16);
		unit6.add(unit6_exp);


		JPanel header= new JPanel();
		header.setBounds(70, 0, 1010, 50);
		unit.getContentPane().add(header);
		header.setBackground(Color.WHITE);
		header.setLayout(new BorderLayout(0, 0));

		JPanel quit_button = new JPanel();
		quit_button.setBackground(Color.WHITE);
		quit_button.setPreferredSize(new Dimension(50,50));
		header.add(quit_button,BorderLayout.EAST);
		quit_button.setLayout(new BorderLayout(0, 0));
		JLabel quit_icon = new JLabel("");
		quit_icon.setIcon(new ImageIcon("./icon/close_black.png"));
		quit_icon.setHorizontalAlignment(JLabel.CENTER);
		quit_icon.setVerticalAlignment(JLabel.CENTER);
		quit_button.add(quit_icon, BorderLayout.CENTER);

		quit_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				changecolor(quit_button,new Color(0, 18, 50));
				quit_icon.setIcon(new ImageIcon("./icon/close_white.png"));
				SwingUtilities.updateComponentTreeUI(unit);

			}
			public void mouseExited(MouseEvent e) {
				changecolor(quit_button,new Color(255, 255, 255));
				quit_icon.setIcon(new ImageIcon("./icon/close_black.png"));
				SwingUtilities.updateComponentTreeUI(unit);
			}
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		unit.setResizable(false);
		unit.setUndecorated(true);
		unit.setLocationRelativeTo(null);	
	}
}
