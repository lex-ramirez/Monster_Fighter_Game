package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Font;
import GameEnvironmentElements.*;
import Monsters.Monster;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextArea;

public class StarterWindow {

	private JFrame frame;
	private ArrayList<Monster> team = new ArrayList<Monster>();
	private PlayerDirectory playerdir = new PlayerDirectory();

	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StarterWindow window = new StarterWindow();
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
	public StarterWindow() {
		initialize();
		frame.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//Initializes starters
		playerdir.chooseAStarter();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.activeCaptionBorder);
		frame.setBounds(100, 100, 677, 399);
		frame.getContentPane().setLayout(null);
		
		JLabel lblChooseAStarter = new JLabel("Choose a Starter!");
		lblChooseAStarter.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblChooseAStarter.setBounds(255, 11, 231, 27);
		frame.getContentPane().add(lblChooseAStarter);
		
		JButton starter1 = new JButton("New button");
		starter1.setBounds(10, 55, 189, 126);
		frame.getContentPane().add(starter1);
		starter1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(playerdir.getStarter(0).toString());
				
			}
		});
		
		JButton backButton = new JButton("BACK");
		backButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		backButton.setBackground(Color.GRAY);
		backButton.setBounds(10, 326, 89, 23);
		frame.getContentPane().add(backButton);
		
		JButton starter1_1 = new JButton("New button");
		starter1_1.setBounds(235, 55, 189, 126);
		frame.getContentPane().add(starter1_1);
		
		JButton starter1_2 = new JButton("New button");
		starter1_2.setBounds(462, 55, 189, 126);
		frame.getContentPane().add(starter1_2);
		
		JButton starter1_1_1 = new JButton("New button");
		starter1_1_1.setBounds(94, 192, 189, 126);
		frame.getContentPane().add(starter1_1_1);
		
		JButton starter1_1_2 = new JButton("New button");
		starter1_1_2.setBounds(369, 192, 189, 126);
		frame.getContentPane().add(starter1_1_2);
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SetupScreen nextScreen = new SetupScreen();
			}
		});
		
		/**JTextArea starter1Text = new JTextArea();
		starter1Text.setBackground(SystemColor.activeCaptionBorder);
		starter1Text.setFont(new Font("Monospaced", Font.BOLD, 13));
		starter1Text.setWrapStyleWord(true);
		starter1Text.setLineWrap(true);
		starter1Text.setBounds(0, 204, 210, 111);
		frame.getContentPane().add(starter1Text);
		
		starter1Text.setText("St John: Healer\n" + playerdir.getStarter(0).getDescription());
		
		JTextArea starter2Text = new JTextArea();
		starter2Text.setWrapStyleWord(true);
		starter2Text.setText("St John: Healer\n<dynamic>");
		starter2Text.setLineWrap(true);
		starter2Text.setFont(new Font("Monospaced", Font.BOLD, 13));
		starter2Text.setBackground(SystemColor.activeCaptionBorder);
		starter2Text.setBounds(220, 202, 210, 147);
		frame.getContentPane().add(starter2Text);
		
		starter2Text.setText("Robin Hood: Archer\n" + playerdir.getStarter(1).getDescription());
		
		JTextArea starter3Text = new JTextArea();
		starter3Text.setWrapStyleWord(true);
		starter3Text.setText("St John: Healer\n<dynamic>");
		starter3Text.setLineWrap(true);
		starter3Text.setFont(new Font("Monospaced", Font.BOLD, 13));
		starter3Text.setBackground(SystemColor.activeCaptionBorder);
		starter3Text.setBounds(449, 202, 212, 113);
		frame.getContentPane().add(starter3Text);
		
		starter3Text.setText("Toto: Tortoise\n" + playerdir.getStarter(5).getDescription());
		*/
	}
}
