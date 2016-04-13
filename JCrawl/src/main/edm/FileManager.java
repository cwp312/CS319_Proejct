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

	/**
	 * 
	 * @param URL
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
						System.out.println("parselevel");
						parseLevel(newLine);
					}
					if (entityFlag) {
						parseEntity(newLine);
					}
				}
			}
		}

		System.out.println(data.getData().get(0));

		return data;
	}

	private void parseLevel(String line) {
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

	}
}
