package main.rsystem;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class CreditsPanel extends JPanel {

	private static final long serialVersionUID = 674421160023666790L;
	
	JLabel mainBackground;
	static JButton backButton;
	JLabel labelCredits ,labelArda, labelCW, labelFatih, labelMustafa;
	
	/**
	 * This panel prints the credits on the frame
	 */
	public CreditsPanel(){
		
		// Panel Properties
		setBounds(0, 0, 1280, 720);
		setLayout(null);
		
		// Credits Label
		labelCredits = new JLabel("Credits");
		labelCredits.setForeground(new Color(233, 63, 51));
		labelCredits.setFont(new Font("Chalkduster", Font.BOLD, 60));
		labelCredits.setHorizontalAlignment(SwingConstants.CENTER);
		labelCredits.setBounds(500, 80, 273, 50);
		add(labelCredits);
		
		// Name Label
		labelArda = new JLabel("Arda Yucel");
		labelArda.setHorizontalAlignment(SwingConstants.CENTER);
		labelArda.setForeground(new Color(0, 0, 0));
		labelArda.setFont(new Font("Chalkduster", Font.BOLD, 32));
		labelArda.setBounds(450, 210, 368, 50);
		add(labelArda);
		
		// Name Label
		labelCW = new JLabel("Cheol Woo Park");
		labelCW.setHorizontalAlignment(SwingConstants.CENTER);
		labelCW.setForeground(new Color(0, 0, 0));
		labelCW.setFont(new Font("Chalkduster", Font.BOLD, 32));
		labelCW.setBounds(450, 280, 368, 50);
		add(labelCW);
		
		// Name Label
		labelFatih = new JLabel("Fatih Tas");
		labelFatih.setHorizontalAlignment(SwingConstants.CENTER);
		labelFatih.setForeground(new Color(0, 0, 0));
		labelFatih.setFont(new Font("Chalkduster", Font.BOLD, 32));
		labelFatih.setBounds(450, 350, 368, 50);
		add(labelFatih);
		
		// Name Label
		labelMustafa = new JLabel("Mustafa Fidan");
		labelMustafa.setHorizontalAlignment(SwingConstants.CENTER);
		labelMustafa.setForeground(new Color(0, 0, 0));
		labelMustafa.setFont(new Font("Chalkduster", Font.BOLD, 32));
		labelMustafa.setBounds(450, 420, 368, 50);
		add(labelMustafa);
		
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
