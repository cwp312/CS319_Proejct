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

public class BestiaryPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6984584673975083149L;
	
	private JLabel mainBackground;
	static JButton backButton;
	private JLabel labelBestiary;
	private JTextPane textPane1;
	
	public BestiaryPanel(){
		setBounds(0, 0, 1280, 720);																							
		setLayout(null);	
		
		// Title
		labelBestiary = new JLabel("Bestiary"); // 'How To Play' Label
		labelBestiary.setHorizontalAlignment(SwingConstants.CENTER);
		labelBestiary.setForeground(new Color(233, 63, 51));
		labelBestiary.setFont(new Font("Chalkduster", Font.BOLD, 50));
		labelBestiary.setBounds((1024/2)-66, 59, 423, 66);
		add(labelBestiary);
		
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
			//mainBackground.setIcon(new ImageIcon(MainFrame.class.getResource("/Background/mainbackground1.jpg")));
		}catch (NullPointerException e2) {
		}
	}
}
