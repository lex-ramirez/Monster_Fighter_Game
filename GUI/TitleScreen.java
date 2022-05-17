package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import GameEnvironmentElements.GameEnvironment;
import GameEnvironmentElements.MainGame;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;

public class TitleScreen {

	private JFrame frame;
	private MainGame gameEnvironment;

	/**
	 * Launch the application.
	 */
	/**public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TitleScreen window = new TitleScreen();
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
	public TitleScreen() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 677, 399);
		frame.getContentPane().setBackground(SystemColor.activeCaptionBorder);
		frame.getContentPane().setLayout(null);
		
		JButton startButton = new JButton("Start game");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SetupScreen nextScreen = new SetupScreen();
				frame.dispose();
			}
		});
		startButton.setBackground(Color.GRAY);
		startButton.setBounds(255, 153, 110, 31);
		frame.getContentPane().add(startButton);
		
		JLabel titleSequence = new JLabel("Monster Fighter");
		titleSequence.setFont(new Font("Tahoma", Font.BOLD, 25));
		titleSequence.setBounds(215, 85, 205, 66);
		frame.getContentPane().add(titleSequence);
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setBackground(Color.GRAY);
		btnHelp.setBounds(255, 195, 110, 31);
		frame.getContentPane().add(btnHelp);
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		JButton btnAboutUs = new JButton("About us");
		btnAboutUs.setBackground(Color.GRAY);
		btnAboutUs.setBounds(255, 237, 110, 31);
		frame.getContentPane().add(btnAboutUs);
		
	}
}
