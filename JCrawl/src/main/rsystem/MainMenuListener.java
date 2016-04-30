package main.rsystem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuListener implements ActionListener {

	/**
	 * List of behaviors for each button is listed here
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==MainMenuPanel.btnCredits){
			MainFrame.mainMenuPanel.setVisible(false);
			MainFrame.creditsPanel.setVisible(true);
			MainFrame.howto.setVisible(false);
			MainFrame.bestiary.setVisible(false);
			MainFrame.options.setVisible(false);
			MainFrame.start.setVisible(false);
		}
		else if(e.getSource()==MainMenuPanel.btnHowToPlay){
			MainFrame.mainMenuPanel.setVisible(false);
			MainFrame.creditsPanel.setVisible(false);
			MainFrame.howto.setVisible(true);
			MainFrame.bestiary.setVisible(false);
			MainFrame.options.setVisible(false);	
			MainFrame.start.setVisible(false);		
		}
		else if(e.getSource()==MainMenuPanel.btnBestiary){
			MainFrame.mainMenuPanel.setVisible(false);
			MainFrame.creditsPanel.setVisible(false);
			MainFrame.howto.setVisible(false);
			MainFrame.bestiary.setVisible(true);
			MainFrame.options.setVisible(false);
			MainFrame.start.setVisible(false);
		}
		else if(e.getSource()==MainMenuPanel.btnOptions){
			MainFrame.mainMenuPanel.setVisible(false);
			MainFrame.creditsPanel.setVisible(false);
			MainFrame.howto.setVisible(false);
			MainFrame.bestiary.setVisible(false);
			MainFrame.options.setVisible(true);
			MainFrame.start.setVisible(false);
		}
		else if(e.getSource()==MainMenuPanel.btnStart){
			MainFrame.mainMenuPanel.setVisible(true);
			MainFrame.creditsPanel.setVisible(false);
			MainFrame.howto.setVisible(false);
			MainFrame.bestiary.setVisible(false);
			MainFrame.options.setVisible(false);
			MainFrame.start.setVisible(false);
			new Platform();
			MainFrame.frame.setVisible(false);
		}
		else if(e.getSource()== StartPanel.backButton || e.getSource()==HowToPlayPanel.backButton || e.getSource()== BestiaryPanel.backButton || e.getSource()== OptionsPanel.backButton || e.getSource()== CreditsPanel.backButton){
			MainFrame.mainMenuPanel.setVisible(true);
			MainFrame.creditsPanel.setVisible(false);
			MainFrame.howto.setVisible(false);
			MainFrame.bestiary.setVisible(false);
			MainFrame.options.setVisible(false);
			MainFrame.start.setVisible(false);
		}
		else if(e.getSource()==BestiaryPanel.nextPageBtn){
			MainFrame.bestiary.setVisible(false);
			MainFrame.bestiary2.setVisible(true);
		}
		else if(e.getSource()==OptionsPanel.dimensionList){
			int newDimension = OptionsPanel.dimensionList.getSelectedIndex();
			if(newDimension == 0){
				Platform.setWidth(800);
				Platform.setHeight(600+24);
				Platform.setDimType(1);
			}
			else{
				Platform.setWidth(1024);
				Platform.setHeight(768+24);	
				Platform.setDimType(0);
			}
		}
		else if(e.getSource()==BestiaryPanel2.prevPageBtn){
			MainFrame.bestiary.setVisible(true);
			MainFrame.bestiary2.setVisible(false);
		}
	}

}
