package GUI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTable;

import Monsters.Monster;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;
import javax.swing.border.BevelBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.concurrent.Callable;



public class BattleWindow {

	private JFrame frame;
	private BattleManager manager;
	private JLabel prompt; 
	private Random rng;


	private int HEALTH_BAR_WIDTH = 180;
	private int HEALTH_BAR_HEIGHT = 16;
	private int SCREEN_WIDTH = 1200;
	private int SCREEN_HEIGHT = 750;

	int targetIndex;
	int turnTypeIndex; // is this used?
	int playerTurnIndex = 0;
	private JProgressBar[] healthBars = {new JProgressBar(), new JProgressBar(), new JProgressBar(), new JProgressBar(), new JProgressBar(), new JProgressBar()};
	/**
	 * Create the application.
	 */
	public BattleWindow(BattleManager manager) {
		int seed = (int) System.currentTimeMillis() % 1000000000 % 10000;
    	this.rng = new Random(seed);
		this.manager = manager;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		manager.closeBattleWindow(this);
	}
	
	public int getTargetIndex() {
		return targetIndex;
	}

	public void setTargetIndex(int targetIndex) {
		this.targetIndex = targetIndex;
	}

	public int getTurnTypeIndex() {
		return turnTypeIndex;
	}

	public void setTurnTypeIndex(int turnTypeIndex) {
		this.turnTypeIndex = turnTypeIndex;
	}

	public void makeHealthProgressBar(int index, int pos_x, int pos_y) {
		Monster monster;
		if (pos_y < 250) {
			monster = manager.getBattle().getOpposition().getTeam().get(index);
			index = index + 3;
		}
		else 
			monster = manager.getBattle().getMainPlayer().getTeam().get(index);
		
		healthBars[index] = new JProgressBar(0, monster.getMaxHealth());
		healthBars[index].setBounds(pos_x, pos_y, HEALTH_BAR_WIDTH, HEALTH_BAR_HEIGHT);
		healthBars[index].setSize(new Dimension(HEALTH_BAR_WIDTH,HEALTH_BAR_HEIGHT));
		healthBars[index].setValue(monster.getMaxHealth());
		healthBars[index].setString(Integer.toString((monster.getMaxHealth()))+"/"
				+ Integer.toString((monster.getMaxHealth())));
		healthBars[index].setStringPainted(true);
		frame.getContentPane().add(healthBars[index]);
	}
	/*
	public void makeHealthBar(Monster monster, int pos_x, int pos_y) {
		int greenAmount = (int) Math.floor((double) HEALTH_BAR_WIDTH * monster.getCurrentHealth() / monster.getMaxHealth());
		JLabel healthBarGreen = new JLabel("");
		healthBarGreen.setOpaque(true);
		healthBarGreen.setBackground(Color.GREEN);
		healthBarGreen.setBounds(pos_x, pos_y, greenAmount, HEALTH_BAR_HEIGHT);
		frame.getContentPane().add(healthBarGreen);
		
		JLabel healthBarRed = new JLabel("");
		healthBarRed.setBackground(Color.RED);
		healthBarRed.setOpaque(true);
		healthBarRed.setBounds(pos_x+greenAmount, pos_y, HEALTH_BAR_WIDTH-greenAmount, HEALTH_BAR_HEIGHT);
		frame.getContentPane().add(healthBarRed);
	}*/
	
	public void placeMonster(Monster monster, int pos_x, int pos_y, int index) {
		JLabel monsterImage = new JLabel("");
		monsterImage.setIcon(new ImageIcon(BattleWindow.class.getResource("/Desktop/SENG201/Images/"	//Maybe should have the whole filepath in the monster class
				+ monster.getDrawingId())));;
		JLabel monsterLabel = new JLabel("<html>" + monster.getName() 
			+ "<br/><br/><br/>Base Attack: " + monster.getAttackDamage() +" damage<br/>"
			+ "<br/>Special Ability: " + monster.getSpecialAbilityDescription() + "</html>"); 	
		
		JButton border = new JButton("");
		border.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		border.setBounds(pos_x-5, pos_y-5, 385, 160);
		border.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				border.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
				setTargetIndex(index);
			}
			public void mouseReleased(MouseEvent e) {
				border.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
				if (playerTurnIndex < manager.getBattle().getMainPlayer().getTeam().size()) {
					if (turnTypeIndex == 0)
						manager.getBattle().playerBaseAttack(playerTurnIndex, getTargetIndex());
					else
						manager.getBattle().playerSpecialAttack(playerTurnIndex, getTargetIndex()); // Add a check for whether the special has been done
					playerTurnIndex++;																//i.e. for like whether
					healthBars[getTargetIndex()+3].setValue(manager.getBattle().getOpposition().getTeam().get(getTargetIndex()).getCurrentHealth());
					healthBars[getTargetIndex()+3].setString(Integer.toString((manager.getBattle().getOpposition().getTeam().get(getTargetIndex())
							.getCurrentHealth()))+"/"+manager.getBattle().getOpposition().getTeam().get(getTargetIndex()).getMaxHealth());
					healthBars[getTargetIndex()+3].setStringPainted(true);
				}	
				if (playerTurnIndex == manager.getBattle().getMainPlayer().getTeam().size()) {
					playerTurnIndex = 0;
					manager.getBattle().aiTakesTurn(rng);
					for (int i = 0; i< manager.getBattle().getMainPlayer().getTeam().size();i++) {
						healthBars[i].setValue(manager.getBattle().getMainPlayer().getTeam().get(i).getCurrentHealth());
						healthBars[i].setString(Integer.toString((manager.getBattle().getMainPlayer().getTeam().get(i)
								.getCurrentHealth()))+"/"+manager.getBattle().getMainPlayer().getTeam().get(i).getMaxHealth());; //changed to string bit from monster to manager..
						healthBars[i].setStringPainted(true);
					}
					manager.getBattle().undoLingeringSpecials();
					manager.getBattle().executeLingeringSpecials();
					System.out.println(manager.getBattle().displayBattleState());
				}
				prompt.setText("What would you like "+ manager.getBattle().getMainPlayer().getTeam().get(playerTurnIndex).getName()
						+ " to do?");
			}
		});
		frame.getContentPane().add(border);
		
		//Changed from makeHealthBar
		makeHealthProgressBar(index, pos_x + 130, pos_y + 17);
		
		//monsterImage.setContentAreaFilled(false);
		monsterImage.setOpaque(false);
		monsterImage.setBorder(null);
		monsterImage.setBounds(pos_x, pos_y, 120, 120);
		frame.getContentPane().add(monsterImage);
		
		monsterLabel.setBounds(pos_x+130, pos_y, 250, 180);
		monsterLabel.setVerticalAlignment(SwingConstants.TOP);
		frame.getContentPane().add(monsterLabel);
		
		//return healthCounter;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, SCREEN_WIDTH, SCREEN_HEIGHT);		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		prompt = new JLabel("What would you like "+ manager.getBattle().getMainPlayer().getTeam().get(playerTurnIndex).getName()
				+ " to do?");
		prompt.setBounds(100, 475, 735, 16);
		frame.getContentPane().add(prompt);
		
		JLabel[] healthCounters = {new JLabel(""), new JLabel(""), new JLabel(""), new JLabel(""), new JLabel(""), new JLabel("")};
		
		//Opposition monster slots
		if (manager.getBattle().getOpposition().getTeam().size() > 0) {
			Monster monster = manager.getBattle().getOpposition().getTeam().get(0);
			placeMonster(monster, 15, 64, 0);
		}
		if (manager.getBattle().getOpposition().getTeam().size() > 1) {
			Monster monster = manager.getBattle().getOpposition().getTeam().get(1);
			placeMonster(monster, 415, 64, 1);
		}
		if (manager.getBattle().getOpposition().getTeam().size() > 2) {
			Monster monster = manager.getBattle().getOpposition().getTeam().get(2);
			placeMonster(monster, 815, 64, 2);
		}
		
		//Player monsters
		if (manager.getBattle().getMainPlayer().getTeam().size() > 0) {
			Monster monster = manager.getBattle().getMainPlayer().getTeam().get(0);
			placeMonster(monster, 15, 300, 0);
		}
		if (manager.getBattle().getMainPlayer().getTeam().size() > 1) {
			Monster monster = manager.getBattle().getMainPlayer().getTeam().get(1);
			placeMonster(monster, 415, 300, 1);
		}
		if (manager.getBattle().getMainPlayer().getTeam().size() > 2) {
			Monster monster = manager.getBattle().getMainPlayer().getTeam().get(2);
			placeMonster(monster, 815, 300, 2);
		}
				
		JButton baseAttackButton = new JButton("Base Attack");
		baseAttackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setTurnTypeIndex(0);/*
				manager.getBattle().playerBaseAttack(playerTurnIndex, targetIndex);
				manager.getBattle().displayBattleState(); */
			}
		});
		baseAttackButton.setBounds(100, 550, 200, 100);
		frame.getContentPane().add(baseAttackButton);
		
		JButton SpecialAbilityButton = new JButton("Special Attack");
		SpecialAbilityButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//AI (archer) special attack only works on one person, not the whole team
				setTurnTypeIndex(1);
				if (manager.getBattle().getMainPlayer().getTeam().get(playerTurnIndex).isTeamWideSpecial()) {
					if (playerTurnIndex < manager.getBattle().getMainPlayer().getTeam().size()) {
						manager.getBattle().playerSpecialAttack(playerTurnIndex, getTargetIndex());
						for (int i = 0; i < manager.getBattle().getOpposition().getTeam().size(); i++) {
							Monster targetMonster = manager.getBattle().getOpposition().getTeam().get(i);
							healthBars[i+3].setValue(targetMonster.getCurrentHealth());
							healthBars[i+3].setString(Integer.toString((targetMonster.getCurrentHealth()))
									+"/"+ targetMonster.getMaxHealth()); //changed to string bit from monster to manager..
							healthBars[i+3].setStringPainted(true);
						}
						playerTurnIndex++;
						prompt.setText("What would you like "+ manager.getBattle().getMainPlayer().getTeam().get(playerTurnIndex).getName()
								+ " to do?");
					}
					else {
						manager.getBattle().playerSpecialAttack(playerTurnIndex, getTargetIndex());
						//Set the health bar appropriately
						Monster targetMonster = manager.getBattle().getOpposition().getTeam().get(targetIndex);
						healthBars[getTargetIndex()].setValue(targetMonster.getCurrentHealth());
						healthBars[getTargetIndex()].setString(Integer.toString((targetMonster.getCurrentHealth()))
								+"/"+ targetMonster.getMaxHealth()); //changed to string bit from monster to manager..
						healthBars[getTargetIndex()].setStringPainted(true);
						
						playerTurnIndex = 0;
						prompt.setText("What would you like "+ manager.getBattle().getMainPlayer().getTeam().get(playerTurnIndex).getName()
								+ " to do?");
						manager.getBattle().aiTakesTurn(rng);
						for (int i = 0; i< manager.getBattle().getMainPlayer().getTeam().size();i++) {
							//Not sure i trust this
							healthBars[i].setValue(manager.getBattle().getMainPlayer().getTeam().get(i).getCurrentHealth());
							healthBars[i].setString(Integer.toString((manager.getBattle().getMainPlayer().getTeam().get(i).getCurrentHealth()))
									+"/"+manager.getBattle().getMainPlayer().getTeam().get(i).getMaxHealth()); //changed to string bit from monster to manager..
							healthBars[i].setStringPainted(true);
							//
						}
						manager.getBattle().undoLingeringSpecials();
						manager.getBattle().executeLingeringSpecials();
						System.out.println(manager.getBattle().displayBattleState());
					}
				}
			}
		});
		SpecialAbilityButton.setBounds(500, 550, 200, 100);
		frame.getContentPane().add(SpecialAbilityButton);
		
		JButton inventoryButton = new JButton("Open Inventory");
		inventoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchInventory(playerTurnIndex);
			}
		});
		inventoryButton.setBounds(900, 550, 200, 100);
		frame.getContentPane().add(inventoryButton);
		
		
		//https://stackoverflow.com/questions/5654208/making-a-jbutton-invisible-but-clickable
		ImageIcon pauseImage = new ImageIcon(BattleWindow.class.getResource("/Desktop/SENG201/Images/PauseIcon.png"));
		JButton pauseButton = new JButton(pauseImage);
		pauseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				manager.launchPauseWindow();
			}
		});
		//https://www.javacodexamples.com/examples/making-image-button-look-pressed-clicked-in-swing
		pauseButton.setContentAreaFilled(false);
		pauseButton.setOpaque(false);
		pauseButton.setBorder(null);
		pauseButton.setBounds(SCREEN_WIDTH-50, 20, 29, 29);
		frame.getContentPane().add(pauseButton);
		
		JLabel rivalTeamLabel = new JLabel("Rival team:");	//Change to actual enemy's name
		rivalTeamLabel.setBounds(15, 30, 100, 16);
		frame.getContentPane().add(rivalTeamLabel);
		
		JLabel myTeamLabel = new JLabel("My team:");
		myTeamLabel.setBounds(15, 270, 100, 16);
		frame.getContentPane().add(myTeamLabel);
		
		JLabel battleInstruction = new JLabel("");
		battleInstruction.setVerticalAlignment(SwingConstants.TOP);
		battleInstruction.setBounds(53, 447, 784, 73);
		frame.getContentPane().add(battleInstruction);

	
	}
}
