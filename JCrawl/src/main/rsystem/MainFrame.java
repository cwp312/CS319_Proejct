package main.rsystem;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * Main Frame for holding all menu operations
 * @author Mustafa Fidan
 * 
 */
public class MainFrame extends JFrame {

	private static final long serialVersionUID = -2833419457800312091L;
	public static JFrame frame;
	public static JPanel contentPane;
	public static MainMenuPanel mainMenuPanel;
	public static CreditsPanel creditsPanel;
	public static HowToPlayPanel howto;
	public static BestiaryPanel bestiary;
	public static OptionsPanel options;
	public static StartPanel start;
	public static BestiaryPanel2 bestiary2;

	public static boolean gameStart = false;

	public static void main(String[] args) throws IOException {
		frame = new MainFrame();
		frame.setVisible(true);
	}

	/**
	 * Initializes the main menu frame which contains 5 different buttons.
	 * @throws IOException
	 */
	public MainFrame() throws IOException {
		setTitle("JCrawl");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(100, 100, 1280, 720));
		contentPane.setLayout(null);

		mainMenuPanel = new MainMenuPanel();
		creditsPanel = new CreditsPanel();
		howto = new HowToPlayPanel();
		bestiary = new BestiaryPanel();
		options = new OptionsPanel();
		start = new StartPanel();
		bestiary2 = new BestiaryPanel2();

		mainMenuPanel.setVisible(true);
		creditsPanel.setVisible(false);
		howto.setVisible(false);
		bestiary.setVisible(false);
		options.setVisible(false);
		start.setVisible(false);
		bestiary2.setVisible(false);

		setContentPane(contentPane);
		getContentPane().add(mainMenuPanel);
		getContentPane().add(creditsPanel);
		getContentPane().add(howto);
		getContentPane().add(bestiary);
		getContentPane().add(options);
		getContentPane().add(start);
		getContentPane().add(bestiary2);
	}
}
