package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import GameEnvironmentElements.GameEnvironment;
import GameEnvironmentElements.MainGame;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;

public class SetupScreen {

	private JFrame frame;
	private MainGame gameEnvironment;
	private JTextField textField;
	private String playerName = "a";
	private int dayLimit = 15;
	private String difficulty = "a";

	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupScreen window = new SetupScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SetupScreen() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaptionBorder);
		frame.setBounds(100, 100, 677, 399);
		frame.getContentPane().setLayout(null);
		
		JLabel introLabel = new JLabel("Welcome to Monster Fighter!");
		introLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		introLabel.setBounds(10, 11, 231, 27);
		frame.getContentPane().add(introLabel);
		
		JLabel enterNameLabel = new JLabel("Please enter your name:");
		enterNameLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		enterNameLabel.setBounds(10, 49, 231, 27);
		frame.getContentPane().add(enterNameLabel);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setBounds(304, 53, 231, 23);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel nameLabel = new JLabel();
		nameLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		nameLabel.setBounds(304, 84, 231, 23);
		frame.getContentPane().add(nameLabel);
		
		///Enters the name into the label from text field
		JButton EnterButton = new JButton("ENTER");
		EnterButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		EnterButton.setBackground(Color.GRAY);
		EnterButton.setBounds(545, 52, 89, 23);
		frame.getContentPane().add(EnterButton);
		EnterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				playerName = textField.getText();
				
				if (Pattern.matches("[a-zA-Z]{3,16}", playerName)) {
					nameLabel.setText("Your name: " + playerName);
				}
				else {
					nameLabel.setText("Invalid Name! Try again.");
					playerName = "a";
				}

			}
		});
		
		
		JButton backButton = new JButton("BACK");
		backButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		backButton.setBackground(Color.GRAY);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				TitleScreen previousWindow = new TitleScreen();
			}
		});
		backButton.setBounds(10, 326, 89, 23);
		frame.getContentPane().add(backButton);
		
		JLabel lblHowManyDays = new JLabel("How many days should the game last?");
		lblHowManyDays.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHowManyDays.setBounds(10, 132, 261, 27);
		frame.getContentPane().add(lblHowManyDays);
		
		JSlider slider = new JSlider();
		slider.setBackground(Color.LIGHT_GRAY);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(1);
		slider.setMinimum(5);
		slider.setMaximum(15);
		slider.setBounds(304, 120, 231, 55);
		frame.getContentPane().add(slider);
		
		JLabel dayLabel = new JLabel();
		dayLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		dayLabel.setBounds(304, 186, 231, 23);
		frame.getContentPane().add(dayLabel);
		dayLabel.setText("You have selected: " + dayLimit + " days");
		
		
		JButton EnterButton_1 = new JButton("ENTER");
		EnterButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		EnterButton_1.setBackground(Color.GRAY);
		EnterButton_1.setBounds(545, 134, 89, 23);
		frame.getContentPane().add(EnterButton_1);
		
		//
		EnterButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dayLimit = slider.getValue();
				dayLabel.setText("You have selected: " + dayLimit + " days");
				
			}
		});
		
		JLabel lblChooseADifficulty = new JLabel("Choose a difficulty:");
		lblChooseADifficulty.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblChooseADifficulty.setBounds(10, 227, 261, 27);
		frame.getContentPane().add(lblChooseADifficulty);
		
		JLabel diffLabel = new JLabel();
		diffLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		diffLabel.setBounds(341, 264, 231, 23);
		frame.getContentPane().add(diffLabel);
		
		JButton easyBtn = new JButton("Easy");
		easyBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		easyBtn.setBackground(Color.GRAY);
		easyBtn.setBounds(281, 230, 89, 23);
		frame.getContentPane().add(easyBtn);
		//
		easyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				difficulty = "Easy";
				diffLabel.setText("You have chosen: " + difficulty);
				
				
			}
		});
		
		JButton btnMedium = new JButton("Medium");
		btnMedium.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMedium.setBackground(Color.GRAY);
		btnMedium.setBounds(380, 230, 101, 24);
		frame.getContentPane().add(btnMedium);
		//
		btnMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				difficulty = "Medium";
				diffLabel.setText("You have chosen: " + difficulty);
				
				
			}
		});
		
		JButton btnHard = new JButton("Hard");
		btnHard.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHard.setBackground(Color.GRAY);
		btnHard.setBounds(491, 231, 89, 23);
		frame.getContentPane().add(btnHard);
		//
		btnHard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				difficulty = "Hard";
				diffLabel.setText("You have chosen: " + difficulty);
				
			}
		});
		
		JLabel errorLabel = new JLabel();
		errorLabel.setForeground(Color.RED);
		errorLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		errorLabel.setBounds(247, 331, 305, 18);
		frame.getContentPane().add(errorLabel);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNext.setBackground(Color.GRAY);
		btnNext.setBounds(562, 327, 89, 23);
		frame.getContentPane().add(btnNext);
		
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//NEXT PAGE
				if (playerName != "a" && difficulty != "a") {
					StarterWindow chooseStarter = new StarterWindow();
					frame.dispose();
				}
				
				else {
					errorLabel.setText("Can't progress, please fill in everything");
				}
				
			}
		});
		
		
		
		
		
		
		
		
		
	}
}
