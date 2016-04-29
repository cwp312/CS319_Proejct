package main.rsystem;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class StartPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5200101067098057398L;
	
	JLabel mainBackground;
	static JButton backButton;
	
	StartPanel(){
		setBounds(0, 0, 1280, 720);
		setLayout(null);
		
		// Back Button
		backButton = new JButton();
		backButton.setFocusPainted(false);
		backButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		backButton.setIconTextGap(0);
		backButton.setContentAreaFilled(false);
		backButton.setBorder(null);
		backButton.setBounds(1200, 11, 58, 58);
		backButton.addActionListener(new MainMenuListener());
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
