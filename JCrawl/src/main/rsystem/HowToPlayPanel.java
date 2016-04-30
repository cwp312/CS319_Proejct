package main.rsystem;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import main.ImageLoader;
import main.SpriteSheet;

public class HowToPlayPanel extends JPanel{

	private static final long serialVersionUID = 7669662418642801541L;

	static JButton backButton;
	private JLabel labelHowToPlay,pane1Image;
	private JTextPane textPane1;
	
	/**
	 * This panel prints the instructions on the frame
	 */
	public HowToPlayPanel(){
	
		setBounds(0, 0, 1280, 720);																							
		setLayout(null);	
		
		// Title
		labelHowToPlay = new JLabel("How To Play?"); // 'How To Play' Label
		labelHowToPlay.setHorizontalAlignment(SwingConstants.CENTER);
		labelHowToPlay.setForeground(new Color(233, 63, 51));
		labelHowToPlay.setFont(new Font("Chalkduster", Font.BOLD, 50));
		labelHowToPlay.setBounds((1024/2)-66, 59, 423, 66);
		add(labelHowToPlay);
		
		textPane1 = new JTextPane();																									// Text Pane 1
		textPane1.setText("JCrawl is a top down 2d adventure game, with the emphasis placed on extendibility and user level design. "
				+ "The aim of the game is to complete all levels by defeating every other monsters"
				+ " existing in the level.\nThe player has been shown on the left "
				+ "and has 8 lives(health), if the player loses all lives, the game will end with \"Game Over\" screen."
				+ " If the user manages to finish the game with lives, the game will be completed with a success."
				+ " -User can control player with either \"WASD\" or \"arrow keys\".\n-User can fire projectile"
				+ " to the direction of the player by"
				+ " pressing \"Space\".\n-\"ESC\" button allows player to pause the game.");
		textPane1.setFont(new Font("Chalkduster", Font.BOLD, 20));
		textPane1.setBorder(null);
		textPane1.setOpaque(false);
		textPane1.setBounds((1024/2)-120, 200, 577, 500);
		add(textPane1);
		
		pane1Image = new JLabel("");
		pane1Image.setBounds(200, 300, 64, 64);
		add(pane1Image);
		
		
		backButton = new JButton();
		backButton.setFocusPainted(false);
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButton.setIconTextGap(0);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(null);
		backButton.setBounds(1200, 11, 58, 58);
		backButton.addActionListener( new MainMenuListener());
		backButton.setToolTipText("Click to go back Main Menu");
		add(backButton);
		
		try {
			backButton.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/backbuttonroll.png")));
			backButton.setIcon(new ImageIcon(MainFrame.class.getResource("/backbutton.png")));
			pane1Image.setIcon(new ImageIcon(new SpriteSheet(new ImageLoader().load("monsters")).crop(0, 0)));
			//mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground1.jpg")));
		}catch (NullPointerException e2) {
		}
	
	}

}
