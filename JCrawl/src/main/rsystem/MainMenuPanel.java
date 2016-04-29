package main.rsystem;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MainMenuPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2326340435914765337L;
	static JButton btnStart, btnHowToPlay, btnBestiary, btnOptions, btnCredits;
	JLabel mainBackground;
	
	public MainMenuPanel(){
		setBounds(0, 0, 1274, 691);																							
		setLayout(null);
		
		// Start Button
		btnStart = new JButton("Start");																					
		btnStart.setFocusPainted(false);
		btnStart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStart.setHorizontalTextPosition(SwingConstants.CENTER);
		btnStart.setFont(new Font("Chalkduster", Font.BOLD, 37));
		btnStart.setForeground(Color.WHITE);
		btnStart.setContentAreaFilled(false);
		btnStart.setBorder(null);
		btnStart.setBounds(500, 100, 225, 80);
		btnStart.addActionListener(new MainMenuListener());
		btnStart.setToolTipText("Start playing!");
		add(btnStart);
		
		// How To Play Button
		btnHowToPlay = new JButton("How to Play");																			
		btnHowToPlay.setFocusPainted(false);
		btnHowToPlay.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHowToPlay.setHorizontalTextPosition(SwingConstants.CENTER);
		btnHowToPlay.setFont(new Font("Chalkduster", Font.BOLD, 27));
		btnHowToPlay.setForeground(Color.WHITE);
		btnHowToPlay.setContentAreaFilled(false);
		btnHowToPlay.setBorder(null);
		btnHowToPlay.setBounds(500, 200, 225, 80);
		btnHowToPlay.addActionListener( new MainMenuListener());
		btnHowToPlay.setToolTipText("Learn how to play!");
		add(btnHowToPlay);
		
		// Bestiary Button
		btnBestiary = new JButton("Bestiary");																			
		btnBestiary.setFocusPainted(false);
		btnBestiary.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBestiary.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBestiary.setFont(new Font("Chalkduster", Font.BOLD, 32));
		btnBestiary.setForeground(Color.WHITE);
		btnBestiary.setContentAreaFilled(false);
		btnBestiary.setBorder(null);
		btnBestiary.setBounds(500, 300, 225, 80);
		btnBestiary.addActionListener( new MainMenuListener());
		btnBestiary.setToolTipText("Learn enemies!");
		add(btnBestiary);
		
		// Options Button
		btnOptions = new JButton("Options");																				
		btnOptions.setFocusPainted(false);
		btnOptions.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOptions.setHorizontalTextPosition(SwingConstants.CENTER);
		btnOptions.setFont(new Font("Chalkduster", Font.BOLD, 32));
		btnOptions.setForeground(Color.WHITE);
		btnOptions.setContentAreaFilled(false);
		btnOptions.setBorder(null);
		btnOptions.setBounds(500, 400, 225, 80);
		btnOptions.addActionListener( new MainMenuListener());
		btnOptions.setToolTipText("Set the options of game!");
		add(btnOptions);
		
		// Credits Button
		btnCredits = new JButton("Credits");																				
		btnCredits.setFocusPainted(false);
		btnCredits.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCredits.setHorizontalTextPosition(SwingConstants.CENTER);
		btnCredits.setFont(new Font("Chalkduster", Font.BOLD, 32));
		btnCredits.setForeground(Color.WHITE);
		btnCredits.setContentAreaFilled(false);
		btnCredits.setBorder(null);
		btnCredits.setBounds(500, 500, 225, 80);
		btnCredits.addActionListener( new MainMenuListener());
		btnCredits.setToolTipText("Look who we are!");
		add(btnCredits);
		
		// Background Image
		mainBackground = new JLabel("");																					
		mainBackground.setBounds(0, 0, 1274, 691);
		add(mainBackground);
		
		try {																												
			btnStart.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/button1roll.png")));		 
			btnStart.setIcon(new ImageIcon(MainFrame.class.getResource("/button1.png")));					
			btnHowToPlay.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/button1roll.png")));	
			btnHowToPlay.setIcon(new ImageIcon(MainFrame.class.getResource("/button1.png")));				
			btnOptions.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/button1roll.png")));		
			btnOptions.setIcon(new ImageIcon(MainFrame.class.getResource("/button1.png")));					
			btnBestiary.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/button1roll.png")));		
			btnBestiary.setIcon(new ImageIcon(MainFrame.class.getResource("/button1.png")));				 
			btnCredits.setRolloverIcon(new ImageIcon(MainFrame.class.getResource("/button1roll.png")));		
			btnCredits.setIcon(new ImageIcon(MainFrame.class.getResource("/button1.png")));		
			//mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground1.jpg")));	
		}catch (NullPointerException e2) {
		}
	}
	

}
