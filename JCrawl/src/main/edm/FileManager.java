package main.edm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import main.ExternalData;

public class FileManager {
	private Scanner file;
	private Scanner parser;
	private ExternalData data = new ExternalData();

	private boolean player = false, entity_AI = false, entity_st = false, entity_pt = false;
	private int dataPassCounter = 0, dataIndice = 0;

	/**
	 * 
	 * @param URL
	 *            URL to the file to be read
	 */
	public void getFile(String URL) {
		try {
			file = new Scanner(new File(URL));
		} catch (FileNotFoundException e) {
			// TODO(Cheol Woo) Error Logging code here
			e.printStackTrace();
		}
		data.setTag(new ArrayList<String>());
		data.setData(new ArrayList<String>());
	}

	/**
	 * 
	 */
	public ExternalData parseFile() {
		boolean levelFlag = false;
		boolean entityFlag = false;
		while (file.hasNextLine()) {
			String line = file.nextLine();
			if (!line.isEmpty()) {
				parser = new Scanner(line);

				parser.useDelimiter("//s+,//s+");
				// In regular expression this is [" "*","" "*]
				String newLine = parser.next();

				if (newLine.equals("[layout]")) {
					levelFlag = true;
					entityFlag = false;
				} else if (newLine.equals("[entity]")) {
					levelFlag = false;
					entityFlag = true;
				} else {
					if (levelFlag) {
						parseLevel(newLine);
					}
					if (entityFlag) {
						parseEntity(newLine);
					}
				}
			}
		}

		return data;
	}

	private void parseLevel(String line) {
		// Level needs to be 16 by 12
		if (data.getTag().isEmpty()) {
			data.getTag().add("level");
		}

		if (data.getData().isEmpty()) {
			data.getData().add(line);
		} else {
			String temp = data.getData().get(0);
			temp = temp + "," + line;

			data.getData().set(0, temp);
		}
	}

	private void parseEntity(String line) {
		dataPassCounter = 0;
		
		Scanner s = new Scanner(line);
		s.useDelimiter(",");
		while (s.hasNext()) {
			String newLine = s.next();
			// TODO fill the rest of the cases

			if (player) {
				parsePlayer(newLine);
			} else if(entity_AI) {
				parseEntityAI(newLine);
			} else if(entity_st) {
				parseEntityStationary(newLine);
			} else if(entity_pt) {
				parseEntityPatrol(newLine);
			}

			if (newLine.equals("p_") && player == false) {
				data.getTag().add("Player");
				player = true;
				entity_AI = false;
				entity_st = false;
				entity_pt = false;
			} else if(newLine.equals("AI") && entity_AI == false) {
				data.getTag().add("AI");
				player = false;
				entity_AI = true;
				entity_st = false;
				entity_pt = false;
			} else if(newLine.equals("stationary") && entity_st == false) {
				data.getTag().add("stationary");
				player = false;
				entity_AI = false;
				entity_st = true;
				entity_pt = false;
			} else if(newLine.equals("patrol") && entity_pt == false) {
				data.getTag().add("patrol");
				player = false;
				entity_AI = false;
				entity_st = false;
				entity_pt = true;
			} 
			
		}
		s.close();
	}

	private void parsePlayer(String line) {
		if (dataPassCounter == 0) {
			addToData(line);
			dataIndice++;
			dataPassCounter++;
		} else if (dataPassCounter < 2) {
			concatToData(line, dataIndice);
			if (dataPassCounter >= 2) {
				dataPassCounter = 0;
				player = false;
				return;
			}
			dataPassCounter++;
		}
	}
	
	private void parseEntityAI(String line) {
		if (dataPassCounter == 0) {
			addToData(line);
			dataIndice++;
			dataPassCounter++;
		} else if(dataPassCounter <= 4) {
			concatToData(line, dataIndice);
			if (dataPassCounter >= 4) {
				dataPassCounter = 0;
				entity_AI = false;
				return;
			}
			dataPassCounter++;
		}
	}
	
	private void parseEntityStationary(String line) {
		if (dataPassCounter == 0) {
			addToData(line);
			dataIndice++;
			dataPassCounter++;
		} else if(dataPassCounter <= 5) {
			concatToData(line, dataIndice);
			if (dataPassCounter >= 5) {
				dataPassCounter = 0;
				entity_st = false;
				return;
			}
			dataPassCounter++;
		}
	}
	
	private void parseEntityPatrol(String line) {
		if (dataPassCounter == 0) {
			addToData(line);
			dataIndice++;
			dataPassCounter++;
		} else if(dataPassCounter <= 7) {
			concatToData(line, dataIndice);
			if (dataPassCounter >= 7) {
				dataPassCounter = 0;
				entity_pt = false;
				return;
			}
			dataPassCounter++;
		}
	}

	/*
	 * Adds new element to data array list of ExternalData
	 */
	private void addToData(String line) {
		data.getData().add(line);
	}

	/*
	 * Concats a string to data array list element of ExternalData
	 */
	private void concatToData(String line, int dataIndice) {
		String temp = data.getData().get(dataIndice);
		temp = temp + "," + line;
		data.getData().set(dataIndice, temp);
		dataPassCounter++;
	}
}
