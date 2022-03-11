import java.awt.EventQueue;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JFrame;
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
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;

public class Home {
	/*
	 * A function that changes the panel to the color
	 */
	public void changecolor(JPanel hover, Color rand) {
		hover.setBackground(rand);
	}

	/**
	 * A function that makes the frame whether visible or invisible
	 * 
	 * @param bool
	 */
	public void setVisible(boolean bool) {
		home.setVisible(bool);
	}

	ArrayList<Question> incorrect;
	private static JFrame home;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArrayList<Question> incorrect = new ArrayList<Question>();// Create a list of incorrect answers
					Home window = new Home(incorrect);// Create a class home named window
					window.home.setVisible(true);// window home window visible
					SwingUtilities.updateComponentTreeUI(home);// Update UI
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Call constructor
	 * 
	 * @param incorrect
	 */
	public Home(ArrayList<Question> incorrect) {
		this.incorrect = incorrect;// Update the incorrect list
		initialize();// Call initialize, which sets up frame
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Create JFrame and setting bounds and exit conditions
		home = new JFrame();
		home.setBounds(100, 100, 1080, 640);
		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		home.getContentPane().setLayout(null);
		home.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create menumbar panel
		JPanel menubar = new JPanel();
		menubar.setBounds(0, 0, 70, 640);
		menubar.setPreferredSize(new Dimension(50, 640));
		menubar.setBackground(new Color(0, 18, 50));
		home.getContentPane().add(menubar);
		menubar.setLayout(null);

		// Create home button panel
		JPanel home_button = new JPanel();
		home_button.setBounds(0, 50, 70, 70);
		home_button.setBackground(new Color(0, 18, 50));
		menubar.add(home_button);
		home_button.setLayout(new BorderLayout(0, 0));

		// Create home_button icon and put it in
		JLabel home_Icon = new JLabel("");
		home_Icon.setIcon(new ImageIcon("./icon/icons8-home 2.png"));
		home_Icon.setHorizontalAlignment(JLabel.CENTER);
		home_Icon.setVerticalAlignment(JLabel.CENTER);
		home_button.add(home_Icon, BorderLayout.CENTER);
		// Add actionListener
		home_button.addMouseListener(new MouseAdapter() {
			@Override
			// If the mouse is dragged on the homebutton
			public void mouseEntered(MouseEvent e) {
				changecolor(home_button, new Color(106, 116, 145));// Change colour

			}

			// If the mouse is dragged out
			public void mouseExited(MouseEvent e) {
				changecolor(home_button, new Color(0, 18, 50));// Change coloyur to nomral
			}
		});
		// Create quiz_button
		JPanel quiz_button = new JPanel();
		quiz_button.setBounds(0, 140, 70, 70);
		quiz_button.setBackground(new Color(0, 18, 50));
		menubar.add(quiz_button);
		quiz_button.setLayout(new BorderLayout(0, 0));
		// Create quiz_button icon and put it into the button
		JLabel quiz_Icon = new JLabel("");
		quiz_Icon.setIcon(new ImageIcon("./icon/icons8-light_on 2.png"));
		quiz_Icon.setHorizontalAlignment(JLabel.CENTER);
		quiz_Icon.setVerticalAlignment(JLabel.CENTER);
		quiz_button.add(quiz_Icon, BorderLayout.CENTER);
		// Add actionListener
		quiz_button.addMouseListener(new MouseAdapter() {

			// If the mouse is dragged onto the button
			public void mouseEntered(MouseEvent e) {
				changecolor(quiz_button, new Color(106, 116, 145));// change colour
			}

			// If the mouse is dragged out
			public void mouseExited(MouseEvent e) {
				changecolor(quiz_button, new Color(0, 18, 50));// change color to normal
			}

			// If the unit button is clicked
			public void mouseClicked(MouseEvent e) {
				// Dispose home frame and create unit frame
				home.dispose();
				Unit unit = new Unit(incorrect);
				unit.setVisible(true);
			}
		});
		// Create a button for incorrect sheet
		JPanel incorrect_button = new JPanel();
		incorrect_button.setBounds(0, 230, 70, 70);
		incorrect_button.setBackground(new Color(0, 18, 50));
		menubar.add(incorrect_button);
		incorrect_button.setLayout(new BorderLayout(0, 0));
		// Add the icon to the button
		JLabel incorrect_Icon = new JLabel("");
		incorrect_Icon.setIcon(new ImageIcon("./icon/icons8-checklist 1.png"));
		incorrect_Icon.setHorizontalAlignment(JLabel.CENTER);
		incorrect_Icon.setVerticalAlignment(JLabel.CENTER);
		incorrect_button.add(incorrect_Icon, BorderLayout.CENTER);
		// Add actionListener

		// Create panel for top
		JPanel top = new JPanel();
		top.setBounds(70, 50, 1010, 240);
		top.setBackground(new Color(204, 204, 204));
		home.getContentPane().add(top);
		top.setLayout(null);
		// Create title Label
		JLabel title = new JLabel("Math Helper V.1.0");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.WHITE);
		title.setBackground(Color.YELLOW);
		title.setBounds(0, 95, 1010, 58);
		title.setFont(new Font("Tahoma", Font.PLAIN, 52));
		top.add(title, BorderLayout.CENTER);
		// Create a imageIcon for the main screen
		ImageIcon math_home = new ImageIcon("./image/home_image.jpg");
		// Create label of homeLabel
		JLabel home_label = new JLabel();
		home_label.setIcon(math_home);
		home_label.setPreferredSize(new Dimension(1030, 240));
		home_label.setBounds(0, 0, 1010, 240);
		top.add(home_label, BorderLayout.CENTER);
		// Create a bottom panel
		JPanel bottom = new JPanel();
		bottom.setBounds(70, 290, 1010, 350);
		bottom.setBackground(new Color(32, 47, 90));
		home.getContentPane().add(bottom);
		bottom.setLayout(null);
		// Create a welcome label
		JLabel welcome = new JLabel("Welcome to Math Helper!");
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setForeground(Color.WHITE);
		welcome.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		welcome.setBounds(0, 0, 1010, 61);
		bottom.add(welcome);
		// Create a intro label
		JLabel intro = new JLabel(
				"This program is designed to help you to improve your math skills. There are 2 modes: ");
		intro.setHorizontalAlignment(SwingConstants.CENTER);
		intro.setForeground(Color.WHITE);
		intro.setBounds(0, 55, 1010, 39);
		bottom.add(intro);

		// Create an incorrect_sheet icon
		JLabel incorrect_icon = new JLabel("");
		incorrect_icon.setIcon(new ImageIcon("./icon/icons8-checklist 2.png"));
		incorrect_icon.setBounds(704, 134, 75, 75);
		incorrect_icon.addAncestorListener(null);
		incorrect_icon.addMouseListener(new MouseAdapter() {
			// If the mouse is on the button
			// if the button is clicked
			public void mouseClicked(MouseEvent e) {
				// Dispose home frame and create incorrectsheet
				home.dispose();
				IncorrectSheet incorrectsheet = new IncorrectSheet(incorrect);
				incorrectsheet.setVisible();
			}
		});
		bottom.add(incorrect_icon);// Add it to the bottom panel
		// Create an quiz icon
		JLabel quiz_icon = new JLabel("");
		quiz_icon.setBounds(234, 134, 75, 75);
		quiz_icon.setIcon(new ImageIcon("./icon/icons8-light_on 1.png"));
		quiz_icon.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				// Dispose home frame and create incorrectsheet
				home.dispose();
				Unit unit = new Unit(incorrect);
				unit.setVisible(true);
			}
		});
		bottom.add(quiz_icon);

		// Create a quiz_name label
		JLabel quiz_name = new JLabel("Unit Quiz");
		quiz_name.setHorizontalAlignment(SwingConstants.CENTER);
		quiz_name.setForeground(Color.WHITE);
		quiz_name.setBounds(244, 221, 61, 16);
		bottom.add(quiz_name);// Add it to the bottom panel
		// Create a incorrect sheet label
		JLabel incorrect_name = new JLabel("Incorrect Sheet");
		incorrect_name.setHorizontalAlignment(SwingConstants.CENTER);
		incorrect_name.setForeground(Color.WHITE);
		incorrect_name.setBounds(696, 221, 97, 16);
		bottom.add(incorrect_name);// Add it to the bottom panel
		// Create a label for contact info
		JLabel lblPleaseEmailTo = new JLabel(
				"Please email to Tkim@tcs.on.ca if you find any errors or have any suggestions");
		lblPleaseEmailTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEmailTo.setForeground(Color.WHITE);
		lblPleaseEmailTo.setBounds(0, 267, 1010, 39);
		bottom.add(lblPleaseEmailTo);

		// Create a header
		JPanel header = new JPanel();
		header.setBounds(70, 0, 1010, 50);
		home.getContentPane().add(header);
		header.setBackground(Color.WHITE);
		header.setLayout(new BorderLayout(0, 0));

		// Create a quit_button that can close the program
		JPanel quit_button = new JPanel();
		quit_button.setBackground(Color.WHITE);
		quit_button.setPreferredSize(new Dimension(50, 50));
		header.add(quit_button, BorderLayout.EAST);
		quit_button.setLayout(new BorderLayout(0, 0));
		// Create quit_icon and add to the quit_button
		JLabel quit_icon = new JLabel("");
		quit_icon.setIcon(new ImageIcon("./icon/close_black.png"));
		quit_icon.setHorizontalAlignment(JLabel.CENTER);
		quit_icon.setVerticalAlignment(JLabel.CENTER);
		quit_button.add(quit_icon, BorderLayout.CENTER);
		// Add actionListener
		quit_button.addMouseListener(new MouseAdapter() {
			// If the mouse is dragged on
			public void mouseEntered(MouseEvent e) {
				changecolor(quit_button, new Color(0, 18, 50));// Change the color
				quit_icon.setIcon(new ImageIcon("./icon/close_white.png"));// Change the icon
				SwingUtilities.updateComponentTreeUI(home);// Update thread
			}

			// If the mouse is dragged out
			public void mouseExited(MouseEvent e) {
				changecolor(quit_button, new Color(255, 255, 255));// Change color
				quit_icon.setIcon(new ImageIcon("./icon/close_black.png"));// Change icon back
				SwingUtilities.updateComponentTreeUI(home);// Update the thread
			}

			// If the mouse is clicked
			public void mouseClicked(MouseEvent e) {
				System.exit(0);// Quit program
			}
		});
		// Settings
		home.setResizable(false);// Cannot change size
		home.setUndecorated(true);// Don't show basic tabs
		home.setLocationRelativeTo(null);// Make to be open at the center of the screen
	}
}
