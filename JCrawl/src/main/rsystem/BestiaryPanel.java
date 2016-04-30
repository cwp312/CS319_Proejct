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

public class BestiaryPanel extends JPanel {

	private static final long serialVersionUID = -6984584673975083149L;
	
	static JButton backButton,nextPageBtn;
	private JLabel labelBestiary,pane1Image,pane2Image,pane3Image,pane4Image;
	private JTextPane textPane1,textPane2,textPane3,textPane4;
	
	/**
	 * This panel lists the information of the monsters on the frame
	 */
	public BestiaryPanel(){
		setBounds(0, 0, 1280, 720);																							
		setLayout(null);	
	
		labelBestiary = new JLabel("Bestiary"); // 'How To Play' Label
		labelBestiary.setHorizontalAlignment(SwingConstants.CENTER);
		labelBestiary.setForeground(new Color(233, 63, 51));
		labelBestiary.setFont(new Font("Chalkduster", Font.BOLD, 50));
		labelBestiary.setBounds((1024/2)-80, 59, 423, 66);
		add(labelBestiary);
		
		textPane1 = new JTextPane();																									
		textPane1.setText("Slime: Weak enemy that moves randomly, the player will be able to take "
				+ "it down with three hits.\nBehavior Type: AI");
		textPane1.setFont(new Font("Chalkduster", Font.BOLD, 20));
		textPane1.setBorder(null);
		textPane1.setOpaque(false);
		textPane1.setBounds((1024/2)-120, 134, 577, 107);
		add(textPane1);
		
		pane1Image = new JLabel("");
		pane1Image.setBounds(200, 142, 64, 64);
		add(pane1Image);
		
		textPane2 = new JTextPane();																									
		textPane2.setText("Wolf: Slightly stronger counterpart of Slime, it will move "
				+ "faster and deal more damage, but it will still go down with "
				+ "two hits from the player's attack.\nBehavior Type: AI");
		textPane2.setFont(new Font("Chalkduster", Font.BOLD, 20));
		textPane2.setBorder(null);
		textPane2.setOpaque(false);
		textPane2.setBounds((1024/2)-120, 242, 577, 107);
		add(textPane2);
		
		pane2Image = new JLabel("");
		pane2Image.setBounds(200, 260, 64, 64);
		add(pane2Image);
		
		textPane3 = new JTextPane();																									
		textPane3.setText("Skeleton Archer: Stationary enemy that shoots arrows from a distance,"
				+ " takes three hits to take down.\nBehavior Type: Stationary");
		textPane3.setFont(new Font("Chalkduster", Font.BOLD, 20));
		textPane3.setBorder(null);
		textPane3.setOpaque(false);
		textPane3.setBounds((1024/2)-120, 370, 577, 107);
		add(textPane3);
		
		pane3Image = new JLabel("");
		pane3Image.setBounds(200, 380, 64, 64);
		add(pane3Image);
		
		textPane4 = new JTextPane();																									
		textPane4.setText("Goblin: This enemy is just like slime but it moves constantly in a destined patrol"
				+ " route. Takes three hits to kill.\nBehavior Type: Patrol");
		textPane4.setFont(new Font("Chalkduster", Font.BOLD, 20));
		textPane4.setBorder(null);
		textPane4.setOpaque(false);
		textPane4.setBounds((1024/2)-120, 480, 577, 107);
		add(textPane4);
		
		pane4Image = new JLabel("");
		pane4Image.setBounds(200, 490, 64, 64);
		add(pane4Image);
		
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
		
		nextPageBtn = new JButton();
		nextPageBtn.setFocusPainted(false);
		nextPageBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		nextPageBtn.setIconTextGap(0);
		nextPageBtn.setContentAreaFilled(false);
		nextPageBtn.setBorder(null);
		nextPageBtn.setBounds((1280/2), 600, 58, 58);
		nextPageBtn.addActionListener( new MainMenuListener());
		nextPageBtn.setToolTipText("Click to see next page");
		add(nextPageBtn);
		
		try {
			backButton.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/backbuttonroll.png")));
			backButton.setIcon(new ImageIcon(MainFrame.class.getResource("/backbutton.png")));
			nextPageBtn.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/nextbutton2roll.png")));
			nextPageBtn.setIcon(new ImageIcon(MainFrame.class.getResource("/nextbutton2.png")));
			pane1Image.setIcon(new ImageIcon(new SpriteSheet(new ImageLoader().load("monsters")).crop(0, 1)));
			pane2Image.setIcon(new ImageIcon(new SpriteSheet(new ImageLoader().load("monsters")).crop(0, 2)));
			pane3Image.setIcon(new ImageIcon(new SpriteSheet(new ImageLoader().load("monsters")).crop(0, 3)));
			pane4Image.setIcon(new ImageIcon(new SpriteSheet(new ImageLoader().load("monsters")).crop(0, 4)));
		}catch (NullPointerException e2) {
		}
	}
}
