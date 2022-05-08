package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class gameSetup {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameSetup window = new gameSetup();
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
	public gameSetup() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 620, 356);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel namePromptLabel = new JLabel("Input your character's name:");
		//String name = null; // An idea that doesn't work
		namePromptLabel.setBounds(42, 33, 244, 16);
		frame.getContentPane().add(namePromptLabel);

		textField = new JTextField();
		textField.setBounds(234, 28, 261, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);

		JLabel daysPromptLabel = new JLabel("How many days would you like the game to last?");
		daysPromptLabel.setBounds(42, 107, 315, 16);
		frame.getContentPane().add(daysPromptLabel);

		JSlider daySlider = new JSlider();
		daySlider.setMajorTickSpacing(1);
		daySlider.setSnapToTicks(true);
		daySlider.setPaintLabels(true);
		daySlider.setPaintTicks(true);
		daySlider.setMaximum(15);
		daySlider.setMinimum(10);
		daySlider.setBounds(369, 96, 210, 46);
		frame.getContentPane().add(daySlider);

		JLabel nameErrorLabel = new JLabel();
		nameErrorLabel.setForeground(Color.RED);
		String errorText = "Name must be 3-15 characters long with no special characters";
		nameErrorLabel.setFont(new Font("Kohinoor Gujarati", Font.ITALIC, 9));
		nameErrorLabel.setBounds(279, 61, 261, 16);
		frame.getContentPane().add(nameErrorLabel);

		JLabel difficultyLabel = new JLabel("Select your difficulty:");
		difficultyLabel.setBounds(42, 190, 146, 16);
		frame.getContentPane().add(difficultyLabel);

		JComboBox difficultyDropDown = new JComboBox();
		difficultyDropDown.setModel(new DefaultComboBoxModel(new String[] { "Beginner", "Normal", "Expert" }));
		difficultyDropDown.setBounds(269, 186, 123, 27);
		frame.getContentPane().add(difficultyDropDown);

		JButton advanceButtton = new JButton("Let's go!");
		advanceButtton.setBounds(439, 272, 117, 29);
		frame.getContentPane().add(advanceButtton);

		JButton goBackButton = new JButton("Go back");
		goBackButton.setBounds(42, 272, 117, 29);
		frame.getContentPane().add(goBackButton);

		JButton nameConfirmButton = new JButton("Confirm");
		nameConfirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!Pattern.matches("[a-zA-Z]{3,16}", textField.getText())) {
					nameErrorLabel.setText(errorText);
				} else {
					nameErrorLabel.setText("");
					//name = textField.getText(); // How do we ensure that the player enters a valid name? i.e
				} // can't progress with an invalid name if this inner function
			} // doesn't let me change anything?
		});
		nameConfirmButton.setBounds(497, 28, 117, 29);
		frame.getContentPane().add(nameConfirmButton);
	}
}
