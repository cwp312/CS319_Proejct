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

public class BestiaryPanel2 extends JPanel {

	private static final long serialVersionUID = 7858277572864463794L;
	
	static JButton prevPageBtn;
	private JLabel labelBestiary,pane1Image,pane2Image;
	private JTextPane textPane1,textPane2;
	
	/**
	 * This panel lists the information of the monsters on the frame #2
	 */
	public BestiaryPanel2(){
		setBounds(0, 0, 1280, 720);																							
		setLayout(null);	
	
		labelBestiary = new JLabel("Bestiary"); // 'How To Play' Label
		labelBestiary.setHorizontalAlignment(SwingConstants.CENTER);
		labelBestiary.setForeground(new Color(233, 63, 51));
		labelBestiary.setFont(new Font("Chalkduster", Font.BOLD, 50));
		labelBestiary.setBounds((1024/2)-80, 59, 423, 66);
		add(labelBestiary);
		
		textPane1 = new JTextPane();																									
		textPane1.setText("Magmatrum: A stronger, slower version of the slime, the special aspect of "
				+ "this enemy is that it leaves special terrain called Scorched Earth,"
				+ " which will damage the player if the player touches it. Takes 5 hits to take down.\nBehavior Type: AI");
		textPane1.setFont(new Font("Chalkduster", Font.BOLD, 20));
		textPane1.setBorder(null);
		textPane1.setOpaque(false);
		textPane1.setBounds((1024/2)-120, 134, 577, 107);
		add(textPane1);
		
		pane1Image = new JLabel("");
		pane1Image.setBounds(200, 150, 64, 64);
		add(pane1Image);
		
		textPane2 = new JTextPane();																									
		textPane2.setText("Orc: This guy hits harder and he is harder to take down then the Wolf,"
				+ " but as a tradeoff, he moves much slower and has longer interval"
				+ " between movements. Takes around 7 hits to kill.\nBehavior Type: AI");
		textPane2.setFont(new Font("Chalkduster", Font.BOLD, 20));
		textPane2.setBorder(null);
		textPane2.setOpaque(false);
		textPane2.setBounds((1024/2)-120, 255, 577, 107);
		add(textPane2);
		
		pane2Image = new JLabel("");
		pane2Image.setBounds(200, 270, 64, 64);
		add(pane2Image);
		
		prevPageBtn = new JButton();
		prevPageBtn.setFocusPainted(false);
		prevPageBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		prevPageBtn.setIconTextGap(0);
		prevPageBtn.setContentAreaFilled(false);
		prevPageBtn.setBorder(null);
		prevPageBtn.setBounds((1280/2), 600, 58, 58);
		prevPageBtn.addActionListener( new MainMenuListener());
		prevPageBtn.setToolTipText("Click to see next page");
		add(prevPageBtn);
		
		try {
			prevPageBtn.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/backbutton2roll.png")));
			prevPageBtn.setIcon(new ImageIcon(MainFrame.class.getResource("/backbutton2.png")));
			pane1Image.setIcon(new ImageIcon(new SpriteSheet(new ImageLoader().load("monsters")).crop(0, 5)));
			pane2Image.setIcon(new ImageIcon(new SpriteSheet(new ImageLoader().load("monsters")).crop(0, 6)));
			//pane3Image.setIcon(new ImageIcon(new SpriteSheet(new ImageLoader().load("monsters")).crop(0, 3)));
		}catch (NullPointerException e2) {
		}
	}

}
