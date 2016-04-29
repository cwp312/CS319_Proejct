package main.rsystem;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;

public class OptionsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5104757773723808255L;
	
	private JLabel mainBackground;
	static JButton backButton;
	private JLabel labelOptions;
	
	public OptionsPanel(){
		setBounds(0, 0, 1274, 691);																										// Options Panel Properties
		setLayout(null);
		
		//Title
		labelOptions = new JLabel("Options");																							// Options Label
		labelOptions.setForeground(new Color(233, 63, 51));
		labelOptions.setFont(new Font("Chalkduster", Font.BOLD, 60));
		labelOptions.setHorizontalAlignment(SwingConstants.CENTER);
		labelOptions.setBounds((1024/2)-35, 146, 273, 70);
		add(labelOptions);
		
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
